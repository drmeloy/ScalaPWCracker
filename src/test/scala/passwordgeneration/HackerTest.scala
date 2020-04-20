package passwordgeneration

import org.specs2.mutable.Specification

class HackerTest extends Specification {
  "Password generation" >> {
    "0 length returns 0 passwords" >> {
      HackerMan.generatePasswords(Ascii, 0, 0).length === 0
    }

    "1-character password list should be equal to the character set" >> {
      HackerMan.generatePasswords(Ascii, 1, 1) === Ascii.asList.map(_.toString)
    }
  }
}
