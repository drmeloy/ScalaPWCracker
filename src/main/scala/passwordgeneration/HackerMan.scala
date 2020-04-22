package passwordgeneration

trait Hacker {
  def generatePasswords(charSet: CharSet, minLength: Int, maxLength: Int): Stream[String]
}

/**
 * Travis + HackerMan = TrhackerMan
 */
object TrhackerMan extends Hacker {
  override def generatePasswords(charSet: CharSet = Trascii, minLength: Int = 7, maxLength: Int = 15): Stream[String] = {
    if(minLength < 7 || maxLength < 7) throw new Exception("Password must be at least of length 7!!! Password MUST contain the word Jackson!!!")
    val name = "Jackson"
    val namePermutations = name #:: name.toLowerCase #:: name.toUpperCase #:: Stream.empty
    val birthYear = "1991" #:: "91" #:: Stream.empty
    val charStream = Trascii.asList.map(_.toString).toStream
    val parts: Stream[String] = namePermutations ++ birthYear ++ charStream

    def generateNextPasswords(currentPassword: String): Stream[String] = {
      if (currentPassword.isEmpty) {
        val nextPossibleParts = getNextPossibleParts("")
        nextPossibleParts.flatMap(generateNextPasswords(_))
      }
      else {
        if (currentPassword.length == maxLength) {
          currentPassword #:: Stream.empty
        }
        else {
          val nextPossibleParts = getNextPossibleParts(currentPassword)
          currentPassword #:: nextPossibleParts.flatMap(part => generateNextPasswords(currentPassword + part))
        }
      }
    }

    def getNextPossibleParts(currentPassword: String): Stream[String] = {
      if (currentPassword.toLowerCase.contains("jackson") && (currentPassword.toLowerCase.contains("1991") || currentPassword.toLowerCase.contains("91"))) charStream
      else if (currentPassword.toLowerCase.contains("jackson")) charStream ++ birthYear
      else if (currentPassword.toLowerCase.contains("1991") || currentPassword.contains("91")) charStream ++ namePermutations
      else parts
    }

    generateNextPasswords("")
  }
}