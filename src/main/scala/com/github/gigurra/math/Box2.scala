package com.github.gigurra.math

/**
  * Created by kjolh on 3/19/2016.
  */
case class Box2(ll: Vec2, size: Vec2) {

  final def width: Float = size.x
  final def height: Float = size.y

  final def center: Vec2 = ll + size / 2.0f

  final def left: Float = ll.x
  final def right: Float = ll.x + width
  final def top: Float = ll.y + height
  final def bottom: Float = ll.y

  final def lr: Vec2 = Vec2(right, bottom)
  final def ul: Vec2 = Vec2(left, top)
  final def ur: Vec2 = Vec2(right, top)

  final def +(offset: Vec2): Box2 = Box2(ll = ll + offset, size)
  final def -(offset: Vec2): Box2 = Box2(ll = ll - offset, size)
  final def *(scale: Float): Box2 = Box2(ll, size * scale)
  final def /(invScale: Float): Box2 = Box2(ll, size / invScale)

  // Given by http://stackoverflow.com/questions/306316/determine-if-two-rectangles-overlap-each-other
  final def notContains(pos: Vec2): Boolean = notContains(pos.x, pos.y)
  final def contains(pos: Vec2): Boolean = !notContains(pos)
  final def notContains(x: Float, y: Float): Boolean = left > x || x > right || bottom > y || y > top
  final def contains(x: Float, y: Float): Boolean = !notContains(x, y)

  final def notOverlaps(other: Box2): Boolean = notOverlaps(other.left, other.right, other.bottom, other.top)
  final def overlaps(other: Box2): Boolean = overlaps(other.left, other.right, other.bottom, other.top)
  final def notOverlaps(otherLeft: Float, otherRight: Float, otherBottom: Float, otherTop: Float): Boolean = left > otherRight || right < otherLeft || top < otherBottom || bottom > otherTop
  final def overlaps(otherLeft: Float, otherRight: Float, otherBottom: Float, otherTop: Float): Boolean = !notOverlaps(otherLeft, otherRight, otherBottom, otherTop)
}

object Box2 {
  def apply(x: Float, y: Float, width: Float, height: Float): Box2 = Box2(ll = Vec2(x,y), size = Vec2(width, height))
}
