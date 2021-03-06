package com.github.gigurra

import scala.reflect.ClassTag

/**
  * Created by johan on 2016-12-03.
  */
package object lang {
  implicit class RichType(val o: AnyRef) extends AnyVal {
    def as[T: ClassTag]: Option[T] = o match {
      case t: T => Some(t)
      case _ => None
    }
  }
}
