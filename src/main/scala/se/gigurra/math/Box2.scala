package se.gigurra.math

import scala.Specializable.Primitives
import VecCompImplicits._

/**
  * Created by kjolh on 3/19/2016.
  */
case class Box2[@specialized(Primitives) T : VecComp](ll: Vec2[T], size: Vec2[T]) {

  def width = size.x
  def height = size.y

  def center = ll + size / Two[T]

  def left: T = ll.x
  def right: T = ll.x + width
  def top: T = ll.y + height
  def bottom: T = ll.y

  def lr: Vec2[T] = Vec2(right, bottom)
  def ul: Vec2[T] = Vec2(left, top)
  def ur: Vec2[T] = Vec2(right, top)

  def contains(pos: Vec2[T]): Boolean = {
    left <= pos.x && pos.x <= right && bottom <= pos.y && pos.y <= top
  }

  // Given by http://stackoverflow.com/questions/306316/determine-if-two-rectangles-overlap-each-other
  def overlaps(other: Box2[T]): Boolean = {
    this.left < other.right && this.right > other.left && this.top < other.bottom && this.bottom > other.top
  }
}

object Box2 {
  def apply[@specialized(Primitives) T : VecComp](x: T, y: T, width: T, height: T): Box2[T] = Box2(ll = Vec2(x,y), size = Vec2(width, height))
}
