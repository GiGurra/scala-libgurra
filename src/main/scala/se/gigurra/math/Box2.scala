package se.gigurra.math

import spire.implicits._

/**
  * Created by kjolh on 3/19/2016.
  */
case class Box2[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](ll: Vec2[T], size: Vec2[T]) {

  final def width = size.x
  final def height = size.y

  final def center = ll + size / Two[T]

  final def left: T = ll.x
  final def right: T = ll.x + width
  final def top: T = ll.y + height
  final def bottom: T = ll.y

  final def lr: Vec2[T] = Vec2(right, bottom)
  final def ul: Vec2[T] = Vec2(left, top)
  final def ur: Vec2[T] = Vec2(right, top)

  // Given by http://stackoverflow.com/questions/306316/determine-if-two-rectangles-overlap-each-other
  final def notContains(pos: Vec2[T]): Boolean = notContains(pos.x, pos.y)
  final def contains(pos: Vec2[T]): Boolean = !notContains(pos)
  final def notContains(x: T, y: T): Boolean = left > x || x > right || bottom > y || y > top
  final def contains(x: T, y: T): Boolean = !notContains(x, y)

  final def notOverlaps(other: Box2[T]): Boolean = notOverlaps(other.left, other.right, other.bottom, other.top)
  final def overlaps(other: Box2[T]): Boolean = overlaps(other.left, other.right, other.bottom, other.top)
  final def notOverlaps(otherLeft: T, otherRight: T, otherBottom: T, otherTop: T): Boolean = left > otherRight || right < otherLeft || top < otherBottom || bottom > otherTop
  final def overlaps(otherLeft: T, otherRight: T, otherBottom: T, otherTop: T): Boolean = !notOverlaps(otherLeft, otherRight, otherBottom, otherTop)
}

object Box2 {
  def apply[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](x: T, y: T, width: T, height: T): Box2[T] = Box2(ll = Vec2(x,y), size = Vec2(width, height))
}
