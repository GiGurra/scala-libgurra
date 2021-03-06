package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class BoxSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Box" should {

    "Have left/right/bottom/top implicitly imported functions" in {
      val intBox = Box2(4,4,2,2)
      val longBox = Box2(4L,4L,2L,2L)
      val floatBox = Box2(4.0f,4.0f,2.0f,2.0f)

      intBox shouldBe Box2(Vec2(4,4), Vec2(2,2))
      longBox shouldBe Box2(Vec2(4L,4L), Vec2(2L,2L))
      floatBox shouldBe Box2(Vec2(4.0f,4.0f), Vec2(2.0f,2.0f))

      intBox.ll shouldBe Vec2(4,4)
      intBox.lr shouldBe Vec2(6,4)
      intBox.ur shouldBe Vec2(6,6)
      intBox.ul shouldBe Vec2(4,6)
      intBox.center shouldBe Vec2(5,5)
      intBox.size shouldBe Vec2(2,2)
      intBox.left shouldBe 4
      intBox.bottom shouldBe 4
      intBox.top shouldBe 6
      intBox.right shouldBe 6

    }

    "Have working overlap code" in {
      val box1 = Box2(0.0f, 0.0f, 2.0f, 2.0f)
      val box2 = Box2(1.5f, 1.5f, 2.0f, 2.0f)

      box1.overlaps(box1) shouldBe true
      box2.overlaps(box2) shouldBe true

      box1.overlaps(box2) shouldBe true
      box2.overlaps(box1) shouldBe true

      val box3 = Box2(0.0f, 0.0f, 2.0f, 2.0f)
      val box4 = Box2(1.5f, -1.5f, 2.0f, 2.0f)

      box3.overlaps(box4) shouldBe true
      box4.overlaps(box3) shouldBe true

      val box5 = Box2(0.0f, 0.0f, 2.0f, 2.0f)
      val box6 = Box2(2.5f, 0.0f, 2.0f, 2.0f)
      val box7 = Box2(-2.5f, 0.0f, 2.0f, 2.0f)
      val box8 = Box2(0.0f, 2.5f, 2.0f, 2.0f)
      val box9 = Box2(0.0f, -2.5f, 2.0f, 2.0f)

      for {
        a <- Vector(box5,box6,box7,box8,box9)
        b <- Vector(box5,box6,box7,box8,box9).filter(_ != a)
      } {
        a.overlaps(b) shouldBe false
        b.overlaps(a) shouldBe false
      }

    }

    "Have working contains code" in {
      val box1 = Box2(0.0f, 0.0f, 2.0f, 2.0f)
      box1.contains(Vec2(-0.25f, 0.0f)) shouldBe false
      box1.contains(Vec2(2.25f, 0.0f)) shouldBe false
      box1.contains(Vec2(0.0f, -0.25f)) shouldBe false
      box1.contains(Vec2(0.0f, 2.25f)) shouldBe false
      box1.contains(Vec2(0.25f, 0.25f)) shouldBe true
    }
  }
}
