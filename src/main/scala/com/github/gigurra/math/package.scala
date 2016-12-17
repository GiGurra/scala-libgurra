package com.github.gigurra

import com.github.gigurra.lang.{FixErasure2, FixErasure3, FixErasure4}

import scala.reflect.ClassTag

/**
  * Created by johan on 2016-10-07.
  */
package object math {

  implicit class Vec2BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec2): Vec2 = vec * value
    def /(vec: Vec2): Vec2 = vec |/ value
    def +(vec: Vec2): Vec2 = vec + value
    def -(vec: Vec2): Vec2 = vec |- value
  }

  implicit class Vec3BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec3): Vec3 = vec * value
    def /(vec: Vec3): Vec3 = vec |/ value
    def +(vec: Vec3): Vec3 = vec + value
    def -(vec: Vec3): Vec3 = vec |- value
  }

  implicit class Vec4BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec4): Vec4 = vec * value
    def /(vec: Vec4): Vec4 = vec |/ value
    def +(vec: Vec4): Vec4 = vec + value
    def -(vec: Vec4): Vec4 = vec |- value
  }

  implicit class Vec2ToArrayOps(vec2s: Seq[Vec2]) {
    def toElementArray: Array[Float] = ToArray(vec2s)
  }

  implicit class Vec3ToArrayOps(vec3s: Seq[Vec3]) {
    def toElementArray: Array[Float] = ToArray(vec3s)
  }

  implicit class Vec4ToArrayOps(vec4s: Seq[Vec4]) {
    def toElementArray: Array[Float] = ToArray(vec4s)
  }

  implicit class NormalizedDegreesDouble(val value: Double) extends AnyVal {

    def normalizeDegrees0360: Double = {
      val n = value.toInt / 360
      val offset = value - (n * 360).toDouble
      if (offset > 360.0) offset - 360.0
      else if (offset < 0.0) offset + 360.0
      else offset
    }

    def normalizeDegreesPm180: Double = {
      val normalized0360 = value.normalizeDegrees0360
      if (normalized0360 > 180.0) normalized0360 - 360.0
      else normalized0360
    }
  }


  implicit class NormalizedDegreesFloat(val value: Float) extends AnyVal {

    def normalizeDegrees0360: Float = {
      val n = value.toInt / 360
      val offset = value - (n * 360).toFloat
      if (offset > 360.0f) offset - 360.0f
      else if (offset < 0.0f) offset + 360.0f
      else offset
    }

    def normalizeDegreesPm180: Float = {
      val normalized0360 = value.normalizeDegrees0360
      if (normalized0360 > 180.0f) normalized0360 - 360.0f
      else normalized0360
    }
  }

  implicit class NormalizedRadiansDouble(val value: Double) extends AnyVal {
    def normalizeRadians0TwoPi: Double = value.toDegrees.normalizeDegrees0360.toRadians
    def normalizeRadiansPmPi: Double   = value.toDegrees.normalizeDegreesPm180.toRadians
  }

  implicit class NormalizedRadiansFloat(val value: Float) extends AnyVal {
    def normalizeRadians0TwoPi: Float = value.toDegrees.normalizeDegrees0360.toRadians
    def normalizeRadiansPmPi: Float   = value.toDegrees.normalizeDegreesPm180.toRadians
  }
}
