package passwordgeneration

trait Hacker {
  def generatePasswords(charSet: CharSet, minLength: Int, maxLength: Int): Stream[String]
}

/**
 * Travis + HackerMan = TrhackerMan
 */
object TrhackerMan extends Hacker {
  // Needs to contain Jackson
  // Maybe birth year 1991/91 & maybe other chars
  override def generatePasswords(charSet: CharSet = Trascii, minLength: Int = 6, maxLength: Int = 15): Stream[String] = {
    val name = "Jackson"
    val namePermutations = name #:: name.toLowerCase #:: name.toUpperCase #:: Stream.empty
    val birthYear = "1991" #:: "91" #:: Stream.empty
//    val parts: Stream[String] = namePermutations ++ birthYear ++ Trascii.asList.map(_.toString)
    val charStream = Trascii.asList.map(_.toString).toStream
    def generateNextPasswords(currentPassword: String): Stream[String] = {
      if (currentPassword.length == maxLength) {
        currentPassword #:: Stream.empty
      }
      else if (currentPassword.length > maxLength) {
        Stream.empty
      }
      else {
        currentPassword #:: charStream.flatMap(char => generateNextPasswords(currentPassword ++ char))
      }
    }
    generateNextPasswords(name)
  }
}