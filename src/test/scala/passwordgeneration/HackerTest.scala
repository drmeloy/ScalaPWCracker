package passwordgeneration

import org.specs2.mutable.Specification

class HackerTest extends Specification {
  val minPasswordLength = 6
  val maxPasswordLength = 15

  "Password generation" >> {
    "Max length less than 7 returns an Exception" >> {
      TrhackerMan.generatePasswords(Ascii, 7, 0) must throwA[Exception]
    }

    "Min length less than 7 returns an Exception" >> {
      TrhackerMan.generatePasswords(Ascii, 0, 7) must throwA[Exception]
    }

    "All of the Trascii character set should be used in some password" >> {
      val passwords = TrhackerMan.generatePasswords(Ascii, 5, 5).take(10000)
      Trascii.asList.map(_.toString).forall(passwords.contains(_))
    }

    "All generated passwords contain the word Jackson and capitalization permutations of Jackson are present" >> {
      val passwords = TrhackerMan.generatePasswords().take(10000)
      passwords.exists(_.contains("Jackson")) and
      passwords.exists(_.contains("JACKSON")) and
      passwords.exists(_.contains("jackson"))
    }

    "Generated password lengths are within the specified range" >> {
      val passwords = TrhackerMan.generatePasswords(Trascii, minPasswordLength, maxPasswordLength).take(1000)
      passwords.forall(word => word.length >= minPasswordLength && word.length <= maxPasswordLength )
    }

    "There are no duplicate passwords" >> {
      val passwords = TrhackerMan.generatePasswords(maxLength = 5).take(1000)
      val uniquePasswords = passwords.toSet
      passwords.length === uniquePasswords.size
    }
  }
}
