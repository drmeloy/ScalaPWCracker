package passwordgeneration

import scala.annotation.tailrec

trait Hacker {
  def generatePasswords(charSet: CharSet, minLength: Int, maxLength: Int): Stream[String]
}

/**
 * Travis + HackerMan = TrhackerMan
 */
object TrhackerMan extends Hacker {
  override def generatePasswords(charSet: CharSet = Trascii, minLength: Int = 7, maxLength: Int = 15): Stream[String] = {
    val minPasswordLength = 5
    if(minLength < minPasswordLength || maxLength < minPasswordLength) throw new Exception(s"Password must be at least of length $minPasswordLength!!!")
    val name = "Jackson"
    val username = "jhlee"
    val namePermutations = name #:: name.toLowerCase #:: name.toUpperCase #:: username #:: Stream.empty
    val birthYear = "1991" #:: "91" #:: Stream.empty
    val charStream = Trascii.asList.map(_.toString).toStream
    val parts: Stream[String] = namePermutations ++ birthYear ++ charStream

    def generateNextPasswords(currentPassword: String): Stream[String] = {
      if (currentPassword.isEmpty) {
        val nextPossibleParts = getNextPossibleParts("")
        nextPossibleParts.flatMap(generateNextPasswords)
      }
      else {
        if (currentPassword.length == maxLength) {
          currentPassword #:: Stream.empty
        }
        else if (currentPassword.length < minLength) {
          val nextPossibleParts = getNextPossibleParts(currentPassword)
          nextPossibleParts.flatMap(part => generateNextPasswords(currentPassword + part))
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