class PasswordFileWriterImplTest extends org.specs2.mutable.Specification {
  "File writing" >> {
    "File writing fails if provided path does not exist" >> {
      PasswordFileWriterImpl.generateFile("foobar", List("password")) === "Path does not exist"
    }

    "File can be created at provided path" >> {
      PasswordFileWriterImpl.generateFile("C:\\Users\\Dan\\Documents\\alchemy\\Scala", List("password")) === ???
    }

    "Generated file contains the provided passwords" >> {
      PasswordFileWriterImpl.generateFile("C:\\Users\\Dan\\Documents\\alchemy\\Scala", List("password", "secret", "zomg")) === ???
    }
  }
}
