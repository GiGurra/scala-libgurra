package com.github.gigurra.lang

import scala.language.implicitConversions

/**
  * Created by johan on 2016-10-02.
  */
trait FixErasure[T] {

}

object FixErasure {
  implicit val fixErasure: FixErasure[Any] = new FixErasure[Any] {}
}
