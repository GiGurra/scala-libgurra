package com.github.gigurra.math.fixpt

import com.github.gigurra.math.Vec2

/**
  * Created by johan on 2016-09-27.
  */
object vec2 {

  implicit class Vec2FixPt(val vec: Vec2[Long]) extends AnyVal {
    import vec._
    def isWithinFixPt(maxDelta: Long, otherPosition: Vec2[Long]) = _impl.distanceFixPt(vec, otherPosition) <= maxDelta
    def lengthFixPt = sqrt(x * x + y * y)
    def isZeroFixPt = x == 0L && y == 0L
    def normalizedFixPt(newLength: Long, acceptZeroLength: Boolean): Vec2[Long] = {
      if (isZeroFixPt && acceptZeroLength) {
        vec2.zero
      } else {
        _impl.normalizedFixPt(vec, newLength)
      }
    }
  }

  val zero: Vec2[Long] = Vec2(0L, 0L)

  object _impl {
    def normalizedFixPt(_v: Vec2[Long], newLength: Long): Vec2[Long] = {
      require(newLength < Int.MaxValue / 2, "Arithmetic issue - cannot normalize to lenth > Int.MaxValue / 2")
      require(_v.length < Int.MaxValue / 2, "Arithmetic issue - cannot normalize if v.length > Int.MaxValue / 2")
      require(!_v.isZeroFixPt, "Cannot normalize a zero vector")

      val upScale = Int.MaxValue / 4 / _v.lengthFixPt
      val v = _v * upScale
      v * newLength / v.lengthFixPt
    }

    def distanceFixPt(a: Vec2[Long], b: Vec2[Long]): Long = {

      val dx = a.x - b.x
      val dy = a.y - b.y

      require(dx < Int.MaxValue / 2, "Arithmetic issue - cannot normalize to dx > Int.MaxValue / 2")
      require(dy < Int.MaxValue / 2, "Arithmetic issue - cannot normalize to dx > Int.MaxValue / 2")

      val sumSquare = dx * dx + dy * dy
      sqrt(sumSquare)
    }
  }

}
