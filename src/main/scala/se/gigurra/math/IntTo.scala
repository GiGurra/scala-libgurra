package se.gigurra.math

import scala.Specializable._

/**
  * Created by johan on 2016-09-27.
  */
object IntTo {
  def apply[@specialized(Primitives) T : Numeric](x: Int): T = implicitly[Numeric[T]].fromInt(x)
}
