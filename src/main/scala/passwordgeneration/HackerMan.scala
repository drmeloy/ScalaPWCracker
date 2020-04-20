package passwordgeneration

trait Hacker {
  def generatePasswords(charSet: CharSet, minLength: Int, maxLength: Int): List[String]
}

trait HackerMan extends Hacker {
  override def generatePasswords(charSet: CharSet, minLength: Int, maxLength: Int): List[String] = ???
}

/**
 * Travis + HackerMan = TrhackerMan
 */
object TrhackerMan extends HackerMan {
  // Needs to contain Jackson
}