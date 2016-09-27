package se.gigurra.math

import scala.Specializable.Primitives

/**
  * Created by kjolh on 3/19/2016.
  */
case class Box[@specialized(Primitives) T : Numeric](width: T,
                                                     height: T,
                                                     center: Vec2[T]) {

  def x: T = center.x
  def y: T = center.y
}

object Box {

  implicit class BoxOpsFloat(val box: Box[Float]) extends AnyVal {
    import box._
    def left: Float = center.x - width / 2.0f
    def right: Float = center.x + width / 2.0f
    def top: Float = center.y + height / 2.0f
    def bottom: Float = center.y - height / 2.0f
  }

  implicit class BoxOpsDouble(val box: Box[Double]) extends AnyVal {
    import box._
    def left: Double = center.x - width / 2.0
    def right: Double = center.x + width / 2.0
    def top: Double = center.y + height / 2.0
    def bottom: Double = center.y - height / 2.0
  }

  implicit class BoxOpsInt(val box: Box[Int]) extends AnyVal {
    import box._
    def left: Int = math.round(center.x.toDouble - width.toDouble / 2.0).toInt
    def right: Int = math.round(center.x.toDouble + width.toDouble / 2.0).toInt
    def top: Int = math.round(center.y.toDouble + height.toDouble / 2.0).toInt
    def bottom: Int = math.round(center.y.toDouble - height.toDouble / 2.0).toInt
  }

  implicit class BoxOpsLong(val box: Box[Long]) extends AnyVal {
    import box._
    def left: Long = math.round(center.x.toDouble - width.toDouble / 2.0)
    def right: Long = math.round(center.x.toDouble + width.toDouble / 2.0)
    def top: Long = math.round(center.y.toDouble + height.toDouble / 2.0)
    def bottom: Long = math.round(center.y.toDouble - height.toDouble / 2.0)
  }

}
