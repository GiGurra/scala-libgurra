package com.github.gigurra

import com.github.gigurra.lang.{FixErasure2, FixErasure3, FixErasure4}

import scala.reflect.ClassTag

/**
  * Created by johan on 2016-10-07.
  */
package object math {

  implicit class Vec2BaseInfixOpsInt(val value: Int) extends AnyVal{
    def *(vec: Vec2[Int]): Vec2[Int] = vec * value
    def /(vec: Vec2[Int]): Vec2[Int] = vec |/ value
    def +(vec: Vec2[Int]): Vec2[Int] = vec + value
    def -(vec: Vec2[Int]): Vec2[Int] = vec |- value
  }

  implicit class Vec2BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec2[Float]): Vec2[Float] = vec * value
    def /(vec: Vec2[Float]): Vec2[Float] = vec |/ value
    def +(vec: Vec2[Float]): Vec2[Float] = vec + value
    def -(vec: Vec2[Float]): Vec2[Float] = vec |- value
  }

  implicit class Vec2BaseInfixOpsLong(val value: Long) extends AnyVal {
    def *(vec: Vec2[Long]): Vec2[Long] = vec * value
    def /(vec: Vec2[Long]): Vec2[Long] = vec |/ value
    def +(vec: Vec2[Long]): Vec2[Long] = vec + value
    def -(vec: Vec2[Long]): Vec2[Long] = vec |- value
  }

  implicit class Vec2BaseInfixOpsDouble(val value: Double) extends AnyVal {
    def *(vec: Vec2[Double]): Vec2[Double] = vec * value
    def /(vec: Vec2[Double]): Vec2[Double] = vec |/ value
    def +(vec: Vec2[Double]): Vec2[Double] = vec + value
    def -(vec: Vec2[Double]): Vec2[Double] = vec |- value
  }

  implicit class Vec3BaseInfixOpsInt(val value: Int) extends AnyVal {
    def *(vec: Vec3[Int]): Vec3[Int] = vec * value
    def /(vec: Vec3[Int]): Vec3[Int] = vec |/ value
    def +(vec: Vec3[Int]): Vec3[Int] = vec + value
    def -(vec: Vec3[Int]): Vec3[Int] = vec |- value
  }

  implicit class Vec3BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec3[Float]): Vec3[Float] = vec * value
    def /(vec: Vec3[Float]): Vec3[Float] = vec |/ value
    def +(vec: Vec3[Float]): Vec3[Float] = vec + value
    def -(vec: Vec3[Float]): Vec3[Float] = vec |- value
  }

  implicit class Vec3BaseInfixOpsLong(val value: Long) extends AnyVal {
    def *(vec: Vec3[Long]): Vec3[Long] = vec * value
    def /(vec: Vec3[Long]): Vec3[Long] = vec |/ value
    def +(vec: Vec3[Long]): Vec3[Long] = vec + value
    def -(vec: Vec3[Long]): Vec3[Long] = vec |- value
  }

  implicit class Vec3BaseInfixOpsDouble(val value: Double) extends AnyVal {
    def *(vec: Vec3[Double]): Vec3[Double] = vec * value
    def /(vec: Vec3[Double]): Vec3[Double] = vec |/ value
    def +(vec: Vec3[Double]): Vec3[Double] = vec + value
    def -(vec: Vec3[Double]): Vec3[Double] = vec |- value
  }

  implicit class Vec4BaseInfixOpsInt(val value: Int) extends AnyVal {
    def *(vec: Vec4[Int]): Vec4[Int] = vec * value
    def /(vec: Vec4[Int]): Vec4[Int] = vec |/ value
    def +(vec: Vec4[Int]): Vec4[Int] = vec + value
    def -(vec: Vec4[Int]): Vec4[Int] = vec |- value
  }

  implicit class Vec4BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec4[Float]): Vec4[Float] = vec * value
    def /(vec: Vec4[Float]): Vec4[Float] = vec |/ value
    def +(vec: Vec4[Float]): Vec4[Float] = vec + value
    def -(vec: Vec4[Float]): Vec4[Float] = vec |- value
  }

  implicit class Vec4BaseInfixOpsLong(val value: Long) extends AnyVal {
    def *(vec: Vec4[Long]): Vec4[Long] = vec * value
    def /(vec: Vec4[Long]): Vec4[Long] = vec |/ value
    def +(vec: Vec4[Long]): Vec4[Long] = vec + value
    def -(vec: Vec4[Long]): Vec4[Long] = vec |- value
  }

  implicit class Vec4BaseInfixOpsDouble(val value: Double) extends AnyVal {
    def *(vec: Vec4[Double]): Vec4[Double] = vec * value
    def /(vec: Vec4[Double]): Vec4[Double] = vec |/ value
    def +(vec: Vec4[Double]): Vec4[Double] = vec + value
    def -(vec: Vec4[Double]): Vec4[Double] = vec |- value
  }

  implicit class Vec2ToArrayOps[@specialized(Int,Long,Float,Double) T : ClassTag : FixErasure2](vec2s: Seq[Vec2[T]]) {
    def toElementArray: Array[T] = ToArray(vec2s)
  }

  implicit class Vec3ToArrayOps[@specialized(Int,Long,Float,Double) T : ClassTag : FixErasure3](vec3s: Seq[Vec3[T]]) {
    def toElementArray: Array[T] = ToArray(vec3s)
  }

  implicit class Vec4ToArrayOps[@specialized(Int,Long,Float,Double) T : ClassTag : FixErasure4](vec4s: Seq[Vec4[T]]) {
    def toElementArray: Array[T] = ToArray(vec4s)
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
