import passwordgeneration.{Ascii, TrhackerMan, Unicode}

object Main {
  def main(args: Array[String]): Unit = {
    println("Commence hacking...")
    val minLength = args(0).toInt
    val maxLength = args(1).toInt
    val charSet = if (args(2) == "a") Ascii else Unicode
    val filePath = args(3)

    val passwords: Stream[String] = TrhackerMan.generatePasswords(charSet, minLength, maxLength)
    println("Passwords generated. Writing file...")
    PasswordFileWriterImpl.generateFile(filePath, passwords)
    println("File writing complete.")
  }
}
