package se.gigurra.math

import scala.Specializable.Primitives
import VecCompImplicits._

/**
  * Created by kjolh on 3/19/2016.
  */
case class Box2[@specialized(Primitives) T : VecComp](width: T,
                                                      height: T,
                                                      center: Vec2[T]) {

  lazy val left: T = center.x - width / Two[T]
  lazy val right: T = center.x + width / Two[T]
  lazy val top: T = center.y + height / Two[T]
  lazy val bottom: T = center.y - height / Two[T]

  lazy val ll: Vec2[T] = Vec2(left, bottom)
  lazy val lr: Vec2[T] = Vec2(right, bottom)
  lazy val ul: Vec2[T] = Vec2(left, top)
  lazy val ur: Vec2[T] = Vec2(right, top)
}
