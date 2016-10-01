package se.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class VecCompSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "VecComp" should {

    "Be numeric" in {
      implicitly[VecComp[Int]]    shouldBe a[Numeric[_]]
      implicitly[VecComp[Float]]  shouldBe a[Numeric[_]]
      implicitly[VecComp[Long]]   shouldBe a[Numeric[_]]
      implicitly[VecComp[Double]] shouldBe a[Numeric[_]]
    }

    "Be Zeroable" in {
      implicitly[VecComp[Int]]    shouldBe a[Zero[_]]
      implicitly[VecComp[Float]]  shouldBe a[Zero[_]]
      implicitly[VecComp[Long]]   shouldBe a[Zero[_]]
      implicitly[VecComp[Double]] shouldBe a[Zero[_]]
    }

    "Be Dividable" in {
      implicitly[VecComp[Int]]    shouldBe a[Dividable[_]]
      implicitly[VecComp[Float]]  shouldBe a[Dividable[_]]
      implicitly[VecComp[Long]]   shouldBe a[Dividable[_]]
      implicitly[VecComp[Double]] shouldBe a[Dividable[_]]
    }
  }
}
