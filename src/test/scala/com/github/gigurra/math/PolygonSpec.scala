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
    Vec2(0,0),
    Vec2(2,0),
    Vec2(2,2),
    Vec2(1,3),
    Vec2(0,2)
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
      Polygon(concaveCCWVertices).ccw shouldBe true
      Polygon(concaveCCWVertices.reverse).cw shouldBe true
    }
  }
}
