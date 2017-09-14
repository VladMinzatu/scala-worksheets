/** The root of the collections hierarchy is the Traversable trait
  */
val t = Traversable(1,2,3,4,5)

// Traversable methods are overridden in subclasses to return the same type
// This is the "uniform return type principle"

// the only abstract operation is foreach
t.foreach(x => print(s"$x "))

// Traversable also implements:

// Addition methods
t ++ Traversable(6,7,8)

// Map methods:
t.map(x => x*x)

t.flatMap(x => Traversable(x,x))

t.collect{case x if x > 2 => x.toString}

// Conversion methods:
t.toArray
t.toSet

// size info
t.size
t.hasDefiniteSize

// element retrieval methods
t.head
t.last
t.headOption
t.find(_ == 3)

// sub-collection retrieval methods
t.tail
t.init
t.slice(1,3)
t.take(2)
t.filter(x => x % 2 == 0)

// sub-division methods
t.span(x => x % 2 != 0)
t.partition(x => x % 2 == 0)
t.groupBy(x => x % 2 != 0)

// element test methods
t.forall(x => x % 2 == 0)
t.exists(x => x % 2 == 0)
t.count(x => x % 2 == 0)

// fold methods
t.fold(0)(_+_)
t.foldLeft(0)(_+_)
t.foldRight(0)(_+_)
t.reduce(_+_)

// specific fold methods
t.sum
t.product
t.max
t.min

// string methods
t.mkString(":")
t.stringPrefix

/** Trait Iterable extends Traversable and implements foreach
  * in terms of its own abstract method: iterator
  *
  * Iterable also adds the following methods:
  */

// iterator methods
val i = Iterable(1,2,3,4,5)
val gi = i grouped 3
gi.next
gi.next

val si = i sliding 3
si.next
si.next
si.next

// subcollections
i.takeRight(2)
i.dropRight(2)

// zippers
i zip (11 to 15)

/** Below Iterable in the hierarchy, we have Seq, Set and Map
  *
  * Let's start with Seq. Sequences are types of Iterables that have a
  * length and whose elements have an index, starting from 0.
  * Its methods include:
  */
val seq = Seq(1,2,3,4,5,6,7,8,9,10)

seq.indexOf(4)
seq.indexWhere(_ % 2 == 0)
seq.lastIndexWhere(_ % 2 == 0)

// addition methods (return new sequences)
seq :+ 11
0 +: seq

// updates
seq patch (1, Seq(1,1), 2)

// sorting
seq.sorted
seq sortWith((a,b) => a > b)

// multiset methods
seq intersect Seq(8, 9)

seq ++ Seq(11, 12)
seq union Seq(11, 12)

Seq(2,3,2,4,2).distinct

/** On to Sets next. Sets are iterables that don't contain duplicates
  */

// Test methods
val set = Set(1,2,3,4,5)
set.contains(4)
set(2) // same as contains

// addition and removal methods
set + 10
set ++ Seq(10,100)

set - 5
set -- List(1,2)

// set operations
set intersect Set(1,2)
set & Set(1,2)

set union Set(6)
set | Set(6)

set diff Set(1,2)
set &~ Set(1,2)

// mutable sets offer the more efficient:
val mSet = scala.collection.mutable.Set(1,2,3)
mSet += 4
mSet -= 1

/** Maps are Iterables containing key-value pairs
  */
val map = Map("a" -> 1, "b" -> 2) // same as Map(("a",1), ("b",2))

// Operations are similar to those for sets.

// subcollection methods:
map.keys  // returns an iterable
map.keySet // returns a set

map.values

// transformation methods:
map.filterKeys(_ == "a")
map.mapValues(x => x * x)

// Mutable Maps support updates:
val mMap = scala.collection.mutable.Map("a" -> 1, "b" -> 2)
mMap += ("c" -> 3)
mMap += ("d" -> 4, "e" -> 5)

/** Arrays are a special kind of collection in Scala. They are mutable!
  * They correspond 1-to-1 to Java arrays, but they are generic and
  * compatible with Seq[T]
  */
val arr = Array(1,2,3,4,5)
arr(1) = 20
arr
