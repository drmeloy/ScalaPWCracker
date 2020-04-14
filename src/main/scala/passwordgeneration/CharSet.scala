package passwordgeneration

sealed trait CharSet {

}

case object Unicode extends CharSet
case object Ascii extends CharSet