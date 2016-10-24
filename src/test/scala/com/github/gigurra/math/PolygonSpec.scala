package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class PolygonSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {


  val concaveCCWVertices = Seq(
    Vec2(0,0), // 0
    Vec2(2,1), // 1
    Vec2(4,0), // 2
    Vec2(4,4), // 3
    Vec2(2,3), // 4
    Vec2(0,4)  // 5
  )

  "Polygon" should {

    "Be created from 3 or more edge vertices" in {
      noException should be thrownBy Polygon(concaveCCWVertices)
      noException should be thrownBy Polygon(concaveCCWVertices.take(3))
      an[IllegalArgumentException] should be thrownBy Polygon(concaveCCWVertices.take(2))
      an[IllegalArgumentException] should be thrownBy Polygon(concaveCCWVertices.take(1))
      an[IllegalArgumentException] should be thrownBy Polygon[Float](Seq.empty)
    }

    "Calculate ccw properly" in {
      Polygon(concaveCCWVertices).clockwise shouldBe false
      Polygon(concaveCCWVertices.reverse).clockwise shouldBe true
      Polygon(concaveCCWVertices).ccw shouldBe true
      Polygon(concaveCCWVertices.reverse).cw shouldBe true
    }

    "Calculate area properly" in {
      Polygon(concaveCCWVertices).area shouldBe 12
      Polygon(concaveCCWVertices.reverse).area shouldBe 12
    }

    "Can slice into pieces" in {
      val original = Polygon(concaveCCWVertices)
      val i1 = 1
      val i2 = 4
      val (left, right) = original.slice(i1, i2)
      left.area shouldBe 6
      right.area shouldBe 6
      left.area + right.area shouldBe original.area

      Polygon.isCompleteSlice(original, left, right, i1, i2) shouldBe true
    }

    "Can slice through air, and then get an incomplete slice" in {
      val original = Polygon(concaveCCWVertices)
      val i1 = 3
      val i2 = 5
      val (left, right) = original.slice(i1, i2)

      Polygon.isCompleteSlice(original, left, right, i1, i2) shouldBe false
    }

    "Fail to slice when not enough vertices between points" in {
      val original = Polygon(concaveCCWVertices)
      original.size shouldBe 6
      an[IllegalArgumentException] should be thrownBy original.slice(0, 5)
      an[IllegalArgumentException] should be thrownBy original.slice(5, 0)
      an[IllegalArgumentException] should be thrownBy original.slice(1, 0)
      an[IllegalArgumentException] should be thrownBy original.slice(0, 1)
      an[IllegalArgumentException] should be thrownBy original.slice(5, 4)
    }

    "Be transformed into a raw data array" in {
      Polygon(concaveCCWVertices).asElementArray shouldBe Array(0,0,2,1,4,0,4,4,2,3,0,4)
    }
  }
}
