package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class InterpolatorSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Interpolator" should {

    "perp half" in {
      Interpolator(range = 3.0f, perp(_:Float, _:Float, exponent = 0.5f, 0.0f, 2.0f, clamp = false)).interpolate(1.5f) shouldBe math.sqrt(2.0f).toFloat
    }

    "be chained" in {

      val i1 = Interpolator(range = 3.0f, perp(_:Float, _:Float, exponent = 0.5f, 0.0f, 2.0f, clamp = true))
      val i2 = Interpolator(range = 3.0f, lerp(_:Float, _:Float, 0.0f, 2.0f, clamp = false))

      val ic = i1.andThen(i2).andThen(i1)

      ic.interpolate(-10.0f) shouldBe 0.0f
      ic.interpolate(0.0f) shouldBe 0.0f
      ic.interpolate(1.5f) shouldBe math.sqrt(2.0f).toFloat
      ic.interpolate(4.5f) shouldBe 1.0f
      ic.interpolate(7.5f) shouldBe math.sqrt(2.0f).toFloat
      ic.interpolate(9.0f) shouldBe 2.0f
      ic.interpolate(10.5f) shouldBe 2.0f
    }

  }
}
