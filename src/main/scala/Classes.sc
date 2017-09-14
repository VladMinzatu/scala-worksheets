// class definitions can be as simple as:

class Person

val p = new Person

// adding a constructor
class Person2(val name: String){ // primary constructor in the class signature

  override def toString: String = name
}

val p2 = new Person2("Vlad")


// Parameters can have default values
class Person3(val name: String = "Anonymous", val job: String = "developer"){

  override def toString: String = s"$name ($job)"
}

new Person3("Vlad")


// Members are public by default. They can be made private like this:
class Person4(private var _name: String){

  def name = _name
  def name_= (newName: String): Unit = {
    if(newName.length > 3) _name = newName
  }

  override def toString: String = _name
}

val p4 = new Person4("Vlad")
p4.name = "bla"
p4.name = "VladM"

// Members without val/var are private
class Person5(name: String)

val p5 = new Person5("Vlad")
// p5.name