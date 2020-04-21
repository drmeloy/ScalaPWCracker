sealed trait PasswordFileWriter {
  def generateFile(filePath: String, passwords: Stream[String]): Unit
}

object PasswordFileWriterImpl extends PasswordFileWriter {
  override def generateFile(filePath: String, passwords: Stream[String]): Unit = ???
}