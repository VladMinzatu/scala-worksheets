trait A{
  val name: String
  override def toString = name
}

class B extends A{
  val name: String = "B"
}

trait C extends A

class D extends A with C{
  val name = "bla"
}

new D
new B