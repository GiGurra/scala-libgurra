package se.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class DividableSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "Dividable" should {

    "With with basic types" in {
      val divInt = implicitly[Dividable[Int]]
      val divFloat = implicitly[Dividable[Float]]
      val divLong = implicitly[Dividable[Long]]
      val divDouble = implicitly[Dividable[Double]]

      divInt.div(1,1) shouldBe 1
      divInt.div(2,1) shouldBe 2
      a[RuntimeException] should be thrownBy divInt.div(1,0)

      divLong.div(1,1) shouldBe 1
      divLong.div(2,1) shouldBe 2
      a[RuntimeException] should be thrownBy divLong.div(1,0)

    }
  }
}
