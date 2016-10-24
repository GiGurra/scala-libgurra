package com.github.gigurra.lang

import scala.language.implicitConversions

/**
  * Created by johan on 2016-10-02.
  */
trait FixErasure[T]
trait FixErasure0[T]
trait FixErasure1[T]
trait FixErasure2[T]
trait FixErasure3[T]
trait FixErasure4[T]
trait FixErasure5[T]
trait FixErasure6[T]
trait FixErasure7[T]
trait FixErasure8[T]
trait FixErasure9[T]

object FixErasure  {
  implicit val fixErasure : FixErasure[Any]  = new FixErasure[Any]  {}
  implicit def fixErasureT[T]: FixErasure[T] = fixErasure.asInstanceOf[FixErasure[T]]
}
object FixErasure0 {
  implicit val fixErasure0: FixErasure0[Any] = new FixErasure0[Any] {}
  implicit def fixErasureT[T]: FixErasure0[T] = fixErasure0.asInstanceOf[FixErasure0[T]]
}
object FixErasure1 { implicit val fixErasure1: FixErasure1[Any] = new FixErasure1[Any] {}
  implicit def fixErasureT[T]: FixErasure1[T] = fixErasure1.asInstanceOf[FixErasure1[T]]
}
object FixErasure2 { implicit val fixErasure2: FixErasure2[Any] = new FixErasure2[Any] {}
  implicit def fixErasureT[T]: FixErasure2[T] = fixErasure2.asInstanceOf[FixErasure2[T]]
}
object FixErasure3 { implicit val fixErasure3: FixErasure3[Any] = new FixErasure3[Any] {}
  implicit def fixErasureT[T]: FixErasure3[T] = fixErasure3.asInstanceOf[FixErasure3[T]]
}
object FixErasure4 { implicit val fixErasure4: FixErasure4[Any] = new FixErasure4[Any] {}
  implicit def fixErasureT[T]: FixErasure4[T] = fixErasure4.asInstanceOf[FixErasure4[T]]
}
object FixErasure5 { implicit val fixErasure5: FixErasure5[Any] = new FixErasure5[Any] {}
  implicit def fixErasureT[T]: FixErasure5[T] = fixErasure5.asInstanceOf[FixErasure5[T]]
}
object FixErasure6 { implicit val fixErasure6: FixErasure6[Any] = new FixErasure6[Any] {}
  implicit def fixErasureT[T]: FixErasure6[T] = fixErasure6.asInstanceOf[FixErasure6[T]]
}
object FixErasure7 { implicit val fixErasure7: FixErasure7[Any] = new FixErasure7[Any] {}
  implicit def fixErasureT[T]: FixErasure7[T] = fixErasure7.asInstanceOf[FixErasure7[T]]
}
object FixErasure8 { implicit val fixErasure8: FixErasure8[Any] = new FixErasure8[Any] {}
  implicit def fixErasureT[T]: FixErasure8[T] = fixErasure8.asInstanceOf[FixErasure8[T]]
}
object FixErasure9 { implicit val fixErasure9: FixErasure9[Any] = new FixErasure9[Any] {}
  implicit def fixErasureT[T]: FixErasure9[T] = fixErasure9.asInstanceOf[FixErasure9[T]]
}
