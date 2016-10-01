package se.gigurra.math

import scala.Specializable._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-27.
  */
trait Dividable[@specialized(Primitives) T] {
  def div(x: T, y: T): T

  class Ops(lhs: T) {
    def /(rhs: T) = div(lhs, rhs)
  }
  implicit def mkDivisibleOps(lhs: T): Ops = new Ops(lhs)
}

object Dividable {
  implicit val intDivisible = new Dividable[Int] {
    override def div(x: Int, y: Int): Int = x / y
  }
  implicit val floatDivisible = new Dividable[Float] {
    override def div(x: Float, y: Float): Float = x / y
  }
  implicit val longDivisible = new Dividable[Long] {
    override def div(x: Long, y: Long): Long = x / y
  }
  implicit val doubleDivisible = new Dividable[Double] {
    override def div(x: Double, y: Double): Double = x / y
  }
}
