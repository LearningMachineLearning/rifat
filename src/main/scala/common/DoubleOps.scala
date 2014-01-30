package common

object DoubleOps {
  implicit class RichDouble(val x: Double) extends AnyVal {
    def **(exp: Double): Double = Math.pow(x, exp)
  }
}
