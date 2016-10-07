package se.gigurra.math

import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-27.
  */

object Zero {
  def apply[@specialized(Int,Long,Float,Double) T: spire.math.Numeric]: T = implicitly[spire.math.Numeric[T]].zero
}
