package com.github.gigurra.math

/**
  * Created by johan on 2016-10-31.
  */
trait Double2[@specialized(Int,Long,Float,Double) T] {
  def cvt(dbl: Double): T
}
object Double2 {
  implicit val Double2Int = new Double2[Int] {
    override def cvt(dbl: Double): Int = dbl.toInt
  }
  implicit val Double2Long = new Double2[Long] {
    override def cvt(dbl: Double): Long = dbl.toLong
  }
  implicit val Double2Float = new Double2[Float] {
    override def cvt(dbl: Double): Float = dbl.toFloat
  }
  implicit val Double2Double = new Double2[Double] {
    override def cvt(dbl: Double): Double = dbl.toDouble
  }
}
