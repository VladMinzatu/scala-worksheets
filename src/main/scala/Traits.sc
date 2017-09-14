trait User{
  def isLoggedIn: Boolean
}

class LoggedInUser extends User {

  override def isLoggedIn: Boolean = true
}

// traits can have abstract fields
trait Vehicle{
  val brand: String
}

class Car(val brand: String) extends Vehicle
class Motorcycle(val brand: String) extends Vehicle

new Car("BMW")
new Car("Mercedes-Benz")
new Motorcycle("BMW")