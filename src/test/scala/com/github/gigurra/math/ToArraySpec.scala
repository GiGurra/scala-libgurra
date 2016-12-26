package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._
import scala.language.postfixOps

class ToArraySpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "ToArray" should {

    "Copy vec of Vec2s to an array without boxing" in {
      Vector(Vec2(1,2), Vec2(3,4), Vec2(5,6)).toElementArray shouldBe Vector(1,2,3,4,5,6)
    }

    "Copy vec of Vec3s to an array without boxing" in {
      Vector(Vec3(1,2,3), Vec3(4,5,6), Vec3(7,8,9)).toElementArray shouldBe Vector(1,2,3,4,5,6,7,8,9)
    }

    "Copy vec of Vec4s to an array without boxing" in {
      Vector(Vec4(1,2,3,4), Vec4(5,6,7,8), Vec4(9,10,11,12)).toElementArray shouldBe Vector(1,2,3,4,5,6,7,8,9,10,11,12)
    }
  }
}
