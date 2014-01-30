package common

object DoubleOps {
  implicit class RichDouble(val x: Double) extends AnyVal {
    def **(exp: Double): Double = Math.pow(x, exp)
  }
}

object StringOps {
  implicit class RichString(val s: String) extends AnyVal {
    def notEquals(anObject: Any) = !s.equals(anObject)
  }
}
