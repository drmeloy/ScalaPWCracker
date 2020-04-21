package passwordgeneration

import org.specs2.mutable.Specification

class HackerTest extends Specification {
  val minPasswordLength = 6
  val maxPasswordLength = 15

  "Password generation" >> {
    "0 length returns 0 passwords" >> {
      TrhackerMan.generatePasswords(Ascii, 0, 0).length === 0
    }

    "1-character password list should be equal to the character set" >> {
      TrhackerMan.generatePasswords(Ascii, 1, 1) === Ascii.asList.map(_.toString).toStream
    }

    "All generated passwords contain the word Jackson and capitalization permutations of Jackson are present" >> {
      val passwords = TrhackerMan.generatePasswords().take(1000)
      passwords.forall(_.toLowerCase.contains("jackson")) &&
      passwords.exists(_.contains("Jackson")) &&
      passwords.exists(_.contains("JACKSON")) &&
      passwords.exists(_.contains("jackson"))
    }

    "Generated password lengths are within the specified range" >> {
      val passwords = TrhackerMan.generatePasswords(Trascii, minPasswordLength, maxPasswordLength).take(1000)
      passwords.forall(word => word.length >= minPasswordLength && word.length <= maxPasswordLength )
    }

    "There are no duplicate passwords" >> {
      val passwords = TrhackerMan.generatePasswords(maxLength = 9)
      val uniquePasswords = passwords.toSet
      passwords.length === uniquePasswords.size
    }

    "Password will return current password if current password is max length" >> {
      TrhackerMan.generatePasswords(maxLength = 7) === "Jackson" #:: Stream.empty
    }
  }
}
