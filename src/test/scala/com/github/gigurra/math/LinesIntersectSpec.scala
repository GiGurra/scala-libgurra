package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class LinesIntersectSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "LinesIntersect" should {

    "Return true when lines intersect" in {
      val line1 = (Vec2(1,0), Vec2(1,2))
      val line2 = (Vec2(0,1), Vec2(2,1))
      LinesIntersect(line1, line2) shouldBe true
    }

    "Return true when lines intersect (above)" in {
      val line1 = (Vec2(1,0), Vec2(1,2))
      val line2 = (Vec2(0,3), Vec2(2,3))
      LinesIntersect(line1, line2) shouldBe false
    }

    "Return true when lines intersect (below)" in {
      val line1 = (Vec2(1,0), Vec2(1,2))
      val line2 = (Vec2(0,-3), Vec2(2,-3))
      LinesIntersect(line1, line2) shouldBe false
    }

    "Return true when lines intersect (right of)" in {
      val line1 = (Vec2(1,0), Vec2(1,2))
      val line2 = (Vec2(2,1), Vec2(3,1))
      LinesIntersect(line1, line2) shouldBe false
    }

    "Return true when lines intersect (left of)" in {
      val line1 = (Vec2(1,0), Vec2(1,2))
      val line2 = (Vec2(-2,1), Vec2(-3,1))
      LinesIntersect(line1, line2) shouldBe false
    }
  }
}
