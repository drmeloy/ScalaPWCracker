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
      TrhackerMan.generatePasswords(Ascii, 1, 1) === Ascii.asList.map(_.toString)
    }

    "Generated password contains the word Jackson" >> {
      TrhackerMan.generatePasswords(Trascii, minPasswordLength, maxPasswordLength)
    }
  }
}
