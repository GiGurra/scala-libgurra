package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class PerpSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Perp" should {

    "perp zero" in {
      perp(delta = 0, range = 3.0, exponent = 0.5, 0.0, 2.0, clamp = false) shouldBe 0.0
      perp(delta = 0, range = 3.0, exponent = 1.0, 0.0, 2.0, clamp = false) shouldBe 0.0
      perp(delta = 0, range = 3.0, exponent = 2.0, 0.0, 2.0, clamp = false) shouldBe 0.0
    }

    "perp half" in {
      perp(delta = 1.5, range = 3.0, exponent = 0.5, 0.0, 2.0, clamp = false) shouldBe math.sqrt(2.0)
      perp(delta = 1.5, range = 3.0, exponent = 1.0, 0.0, 2.0, clamp = false) shouldBe 1.0
      perp(delta = 1.5, range = 3.0, exponent = 2.0, 0.0, 2.0, clamp = false) shouldBe 0.5
    }

    "perp full" in {
      perp(delta = 3.0, range = 3.0, exponent = 0.5, 0.0, 2.0, clamp = false) shouldBe 2.0
      perp(delta = 3.0, range = 3.0, exponent = 1.0, 0.0, 2.0, clamp = false) shouldBe 2.0
      perp(delta = 3.0, range = 3.0, exponent = 2.0, 0.0, 2.0, clamp = false) shouldBe 2.0
    }

    "perp zero Vec2" in {
      val min = Vec2(2.0, 6.0)
      val max = Vec2(4.0, 8.0)

      perp(delta = 0, range = 3.0, exponent = 0.5, min, max, clamp = false) shouldBe min
      perp(delta = 0, range = 3.0, exponent = 1.0, min, max, clamp = false) shouldBe min
      perp(delta = 0, range = 3.0, exponent = 2.0, min, max, clamp = false) shouldBe min
    }

    "perp half Vec2" in {
      val min = Vec2(2.0, 6.0)
      val max = Vec2(4.0, 8.0)

      perp(delta = 1.5, range = 3.0, exponent = 0.5, min, max, clamp = false) shouldBe (Vec2(math.sqrt(2.0), math.sqrt(2.0)) + min)
      perp(delta = 1.5, range = 3.0, exponent = 1.0, min, max, clamp = false) shouldBe (Vec2(1.0, 1.0) + min)
      perp(delta = 1.5, range = 3.0, exponent = 2.0, min, max, clamp = false) shouldBe (Vec2(0.5, 0.5) + min)
    }

    "perp full Vec2" in {
      val min = Vec2(2.0, 6.0)
      val max = Vec2(4.0, 8.0)

      perp(delta = 3.0, range = 3.0, exponent = 0.5, min, max, clamp = false) shouldBe max
      perp(delta = 3.0, range = 3.0, exponent = 1.0, min, max, clamp = false) shouldBe max
      perp(delta = 3.0, range = 3.0, exponent = 2.0, min, max, clamp = false) shouldBe max
    }
  }
}
