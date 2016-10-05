package se.gigurra.math

import scala.Specializable._
import scala.math.Numeric._
import scala.math.Ordering

/**
  * Created by johan on 2016-10-01.
  */
trait VecComp[@specialized(Primitives) T] extends Numeric[T]
  with Dividable[T]
  with Zero[T]
  with One[T]
  with Two[T]
  with Negative[T] {

}

trait VecCompImplicits extends Numeric.ExtraImplicits with Ordering.ExtraImplicits with DividableImplicits

object VecCompImplicits extends VecCompImplicits

object VecComp {

  implicit val vecCompInt = new VecComp[Int] with IntIsIntegral with Ordering.IntOrdering {
    override def div(x: Int, y: Int): Int = x / y
    override def two: Int = 2
  }

  implicit val vecCompFloat = new VecComp[Float] with FloatIsFractional with Ordering.FloatOrdering {
    override def two: Float = 2.0f
  }

  implicit val vecCompLong = new VecComp[Long] with LongIsIntegral with Ordering.LongOrdering {
    override def div(x: Long, y: Long): Long = x / y
    override def two: Long = 2L
  }

  implicit val vecCompDouble = new VecComp[Double] with DoubleIsFractional with Ordering.DoubleOrdering {
    override def two: Double = 2.0
  }
}