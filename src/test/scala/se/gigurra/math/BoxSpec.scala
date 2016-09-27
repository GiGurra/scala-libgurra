package se.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.collection.mutable
import scala.language.postfixOps

class BoxSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Box" should {

    "Have left/right/bottom/top implicitly imported functions" in {
      val intBox = Box[Int](4,4,Vec2(2,2))
      val longBox = Box[Long](4L,4L,Vec2(2L,2L))
      val floatBox = Box[Float](4.0f,4.0f,Vec2(2.0f,2.0f))
      val DoubleBox = Box[Double](4.0,4.0,Vec2(2.0,2.0))

      noException should be thrownBy intBox.left
      noException should be thrownBy intBox.right
      noException should be thrownBy intBox.bottom
      noException should be thrownBy intBox.top

      noException should be thrownBy longBox.left
      noException should be thrownBy longBox.right
      noException should be thrownBy longBox.bottom
      noException should be thrownBy longBox.top

      noException should be thrownBy floatBox.left
      noException should be thrownBy floatBox.right
      noException should be thrownBy floatBox.bottom
      noException should be thrownBy floatBox.top

      noException should be thrownBy DoubleBox.left
      noException should be thrownBy DoubleBox.right
      noException should be thrownBy DoubleBox.bottom
      noException should be thrownBy DoubleBox.top

    }
  }
}
