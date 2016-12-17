package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class Vec2ScalarOpsSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "Vec2" should {

    "Add" in {
      Vec2(1.0f, 2.0f) + Vec2(1.0f, 2.0f) shouldBe Vec2(2.0f, 4.0f)
      Vec2(1.0f, 2.0f) + 2.0f shouldBe Vec2(3.0f, 4.0f)
      (2.0f + Vec2(1.0f, 2.0f)) shouldBe Vec2(3.0f, 4.0f)
    }

    "Subtract" in {
      Vec2(11.0f, 12.0f) - Vec2(1.0f, 2.0f) shouldBe Vec2(10.0f, 10.0f)
      Vec2(11.0f, 12.0f) - 2.0f shouldBe Vec2(9.0f, 10.0f)
      (12.0f - Vec2(1.0f, 2.0f)) shouldBe Vec2(11.0f, 10.0f)
    }

    "Multiply" in {
      Vec2(11.0f, 12.0f) *|* Vec2(1.0f, 2.0f) shouldBe Vec2(11.0f, 24.0f)
      Vec2(11.0f, 12.0f) * 2.0f shouldBe Vec2(22.0f, 24.0f)
      (12.0f * Vec2(1.0f, 2.0f)) shouldBe Vec2(12.0f, 24.0f)
    }

    "Divide" in {
      Vec2(11.0f, 12.0f) /|/ Vec2(1.0f, 2.0f) shouldBe Vec2(11.0f, 6.0f)
      Vec2(11.0f, 12.0f) / 2.0f shouldBe Vec2(5.5f, 6.0f)
      (12.0f / Vec2(1.0f, 2.0f)) shouldBe Vec2(12.0f, 6.0f)
    }

    "Dot" in {
      val v1 = Vec2(3,4)
      val v2 = Vec2(5,1)
      v1 dot v2 shouldBe 19
    }

    /** No cross product exists in R2
    "Cross" in {
      ???
    }
    */

    "Negate" in {
      -Vec2(3.0f,4.0f) shouldBe Vec2(-3.0f,-4.0f)
    }


    "norm/length" in {
      Vec2(1,1).norm shouldBe math.sqrt(2.0).toFloat
      Vec2(4,3).norm shouldBe 5.0
    }

    def v(x: Int, y: Int) = Vec2(x, y)

    "angle range is 180 to -180" in {
      v(1,0).angle shouldBe 0.0
      v(1, 1).angle shouldBe 45.0
      v(1, -1).angle shouldBe -45.0
      v(0, 1).angle shouldBe 90.0
      v(-1, 0).angle shouldBe 180.0
      v(0, -1).angle shouldBe -90.0
      v(-1, -1).angle shouldBe -135.0
    }

    "angle to vector" in {
      v(0, 1) angleTo v(0, 1)  shouldBe 0.0
      v(0, 1) angleTo v(1, 0)  shouldBe 90.0
      v(0, 1) angleTo v(-1, 0) shouldBe -90.0
      v(0, 1) angleTo v(-1, -1) shouldBe -135.0
      v(-1, -1) angleTo v(0, -1) shouldBe -45.0
      v(1, 1) angleTo v(0, -1) shouldBe 135.0
      v(1, -1) angleTo v(-1, 0) shouldBe 135.0
      v(-1, 0) angleTo v(1, -1) shouldBe -135.0
    }

    "cw angle to vector" in {
      v(0, 1) cwAngleTo v(0, 1)  shouldBe 0.0
      v(0, 1) cwAngleTo v(1, 0)  shouldBe 90.0
      v(0, 1) cwAngleTo v(-1, 0) shouldBe 270.0
      v(0, 1) cwAngleTo v(-1, -1) shouldBe 225.0
      v(-1, -1) cwAngleTo v(0, -1) shouldBe 315.0
      v(1, 1) cwAngleTo v(0, -1) shouldBe 135.0
      v(1, -1) cwAngleTo v(-1, 0) shouldBe 135.0
      v(-1, 0) cwAngleTo v(1, -1) shouldBe 225.0
    }

    "ccw angle to vector" in {
      v(0, 1) ccwAngleTo v(0, 1)  shouldBe 0.0
      v(0, 1) ccwAngleTo v(1, 0)  shouldBe 270.0
      v(0, 1) ccwAngleTo v(-1, 0) shouldBe 90.0
      v(0, 1) ccwAngleTo v(-1, -1) shouldBe 135.0
      v(-1, -1) ccwAngleTo v(0, -1) shouldBe 45.0
      v(1, 1) ccwAngleTo v(0, -1) shouldBe 225.0
      v(1, -1) ccwAngleTo v(-1, 0) shouldBe 225.0
      v(-1, 0) ccwAngleTo v(1, -1) shouldBe 135.0
    }
  }
}
