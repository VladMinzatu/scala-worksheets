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
