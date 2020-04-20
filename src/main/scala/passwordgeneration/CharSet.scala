package passwordgeneration

sealed trait CharSet {
  def asList: List[Char]
}

case object Unicode extends CharSet {
  override lazy val asList: List[Char] = ??? // making lazy because this could take some time
}
case object Ascii extends CharSet {
  override val asList: List[Char] = (' ' to 'z').toList
}