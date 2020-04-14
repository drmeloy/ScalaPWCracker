package passwordgeneration

trait Hacker {
  def generatePasswords(charSet: CharSet, minLength: Int, maxLength: Int): List[String]
}

object HackerMan extends Hacker {
  override def generatePasswords(charSet: CharSet, minLength: Int, maxLength: Int): List[String] = ???
}
