package passwordgeneration

sealed trait CharSet {
  def asList: List[Char]
}

case object Unicode extends CharSet {
  lazy val asList: List[Char] = ??? // making lazy because this could take some time
}
case object Ascii extends CharSet {
  val asList: List[Char] = (' ' to '~').toList
}

/**
 * Trascii is "Travis's Ascii", or the characters he would be most likely to use in a password
 */
case object Trascii extends CharSet {
  val asList: List[Char] = {
    val capitals = ('A' to 'Z').toList
    val lowers = ('a' to 'z').toList
    val numbers = ('0' to '9').toList
    val symbolsAtTopOfKeyboard = List('!', '@', '#', '$', '%', '^', '&', '*', '(', ')')
    capitals ++ lowers ++ numbers ++ symbolsAtTopOfKeyboard
  }
}