package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class NormalizeAngleSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Normalizing angles" should {

    "For Floats" should {

      "Normalize degrees 0-360" in {
        -0.5f.normalizeDegrees0360 shouldBe 359.5f
        0.5f.normalizeDegrees0360 shouldBe 0.5f
        -30.0f.normalizeDegrees0360 shouldBe 330.0f
        -180.0f.normalizeDegrees0360 shouldBe 180.0f
        -360.0f.normalizeDegrees0360 shouldBe 0.0f
        -360.5f.normalizeDegrees0360 shouldBe 359.5f
        -400.0f.normalizeDegrees0360 shouldBe 320.0f
        30.0f.normalizeDegrees0360 shouldBe 30.0f
        180.0f.normalizeDegrees0360 shouldBe 180.0f
        360.0f.normalizeDegrees0360 shouldBe 0.0f
        400.0f.normalizeDegrees0360 shouldBe 40.0f
        1080.0f.normalizeDegrees0360 shouldBe 0.0f
        -1080.0f.normalizeDegrees0360 shouldBe 0.0f
      }

      "Normalize degrees +-180" in {
        -0.5f.normalizeDegreesPm180 shouldBe -0.5f
        0.5f.normalizeDegreesPm180 shouldBe 0.5f
        -30.0f.normalizeDegreesPm180 shouldBe -30.0f
        -180.0f.normalizeDegreesPm180 shouldBe 180.0f
        -360.0f.normalizeDegreesPm180 shouldBe 0.0f
        -360.5f.normalizeDegreesPm180 shouldBe -0.5f
        -400.0f.normalizeDegreesPm180 shouldBe -40.0f
        30.0f.normalizeDegreesPm180 shouldBe 30.0f
        180.0f.normalizeDegreesPm180 shouldBe 180.0f
        360.0f.normalizeDegreesPm180 shouldBe 0.0f
        400.0f.normalizeDegreesPm180 shouldBe 40.0f
        1080.0f.normalizeDegreesPm180 shouldBe 0.0f
        -1080.0f.normalizeDegreesPm180 shouldBe 0.0f
      }

      "Normalize radians 0-2pi" in {
        -0.5f.toRadians.normalizeRadians0TwoPi shouldBe 359.5f.toRadians
        0.5f.toRadians.normalizeRadians0TwoPi shouldBe 0.5f.toRadians
        -30.0f.toRadians.normalizeRadians0TwoPi shouldBe 330.0f.toRadians
        -180.0f.toRadians.normalizeRadians0TwoPi shouldBe 180.0f.toRadians
        -360.0f.toRadians.normalizeRadians0TwoPi shouldBe 0.0f.toRadians
        -360.5f.toRadians.normalizeRadians0TwoPi shouldBe 359.5f.toRadians
        -400.0f.toRadians.normalizeRadians0TwoPi shouldBe 320.0f.toRadians
        30.0f.toRadians.normalizeRadians0TwoPi shouldBe 30.0f.toRadians
        180.0f.toRadians.normalizeRadians0TwoPi shouldBe 180.0f.toRadians
        360.0f.toRadians.normalizeRadians0TwoPi shouldBe 0.0f.toRadians
        400.0f.toRadians.normalizeRadians0TwoPi shouldBe 40.0f.toRadians
        1080.0f.toRadians.normalizeRadians0TwoPi shouldBe 0.0f.toRadians
        -1080.0f.toRadians.normalizeRadians0TwoPi shouldBe 0.0f.toRadians
      }

      "Normalize degrees +-pi" in {
        -0.5f.toRadians.normalizeRadiansPmPi shouldBe -0.5f.toRadians
        0.5f.toRadians.normalizeRadiansPmPi shouldBe 0.5f.toRadians
        -30.0f.toRadians.normalizeRadiansPmPi shouldBe -30.0f.toRadians
        -180.0f.toRadians.normalizeRadiansPmPi shouldBe 180.0f.toRadians
        -360.0f.toRadians.normalizeRadiansPmPi shouldBe 0.0f.toRadians
        -360.5f.toRadians.normalizeRadiansPmPi shouldBe -0.5f.toRadians
        -400.0f.toRadians.normalizeRadiansPmPi shouldBe -40.0f.toRadians
        30.0f.toRadians.normalizeRadiansPmPi shouldBe 30.0f.toRadians
        180.0f.toRadians.normalizeRadiansPmPi shouldBe 180.0f.toRadians
        360.0f.toRadians.normalizeRadiansPmPi shouldBe 0.0f.toRadians
        400.0f.toRadians.normalizeRadiansPmPi shouldBe 40.0f.toRadians
        1080.0f.toRadians.normalizeRadiansPmPi shouldBe 0.0f.toRadians
        -1080.0f.toRadians.normalizeRadiansPmPi shouldBe 0.0f.toRadians
      }
    }
  }
}
