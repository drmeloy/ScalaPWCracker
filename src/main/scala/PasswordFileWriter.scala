sealed trait PasswordFileWriter {
  def generateFile(filePath: String, passwords: List[String]): Unit
}

object PasswordFileWriterImpl extends PasswordFileWriter {
  override def generateFile(filePath: String, passwords: List[String]): Unit = ???
}