package com.github.gigurra.math

import spire.implicits._

/**
  * Created by johan on 2016-09-27.
  */
object Two {
  def apply[@specialized(Int,Long,Float,Double) T : spire.math.Numeric]: T = One[T] + One[T]
}
