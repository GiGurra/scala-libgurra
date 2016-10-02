package se.gigurra.math

import se.gigurra.lang.FixErasure

import scala.Specializable._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-10-02.
  */
trait VecBase[@specialized(Primitives) T, Vec] {
  def +[_: FixErasure](vec: Vec): Vec
  def -[_: FixErasure](vec: Vec): Vec
  def dot(vec: Vec): T
  def *|*(vec: Vec): Vec
  def /|/(vec: Vec): Vec
  def *(value: T): Vec
  def /(value: T): Vec
  def +(value: T): Vec
  def -(value: T): Vec
  def unary_- : Vec
  protected[math] def |/(value: T): Vec
  protected[math] def |-(value: T): Vec
}

trait VecBaseInfixImplicits {

  implicit class VecBaseInfixOpsInt(value: Int) {
    def *[Vec <: VecBase[Int, Vec]](vec: Vec): Vec = vec * value
    def /[Vec <: VecBase[Int, Vec]](vec: Vec): Vec = vec |/ value
    def +[Vec <: VecBase[Int, Vec]](vec: Vec): Vec = vec + value
    def -[Vec <: VecBase[Int, Vec]](vec: Vec): Vec = vec |- value
  }

  implicit class VecBaseInfixOpsFloat(value: Float) {
    def *[Vec <: VecBase[Float, Vec]](vec: Vec): Vec = vec * value
    def /[Vec <: VecBase[Float, Vec]](vec: Vec): Vec = vec |/ value
    def +[Vec <: VecBase[Float, Vec]](vec: Vec): Vec = vec + value
    def -[Vec <: VecBase[Float, Vec]](vec: Vec): Vec = vec |- value
  }

  implicit class VecBaseInfixOpsLong(value: Long) {
    def *[Vec <: VecBase[Long, Vec]](vec: Vec): Vec = vec * value
    def /[Vec <: VecBase[Long, Vec]](vec: Vec): Vec = vec |/ value
    def +[Vec <: VecBase[Long, Vec]](vec: Vec): Vec = vec + value
    def -[Vec <: VecBase[Long, Vec]](vec: Vec): Vec = vec |- value
  }

  implicit class VecBaseInfixOpsDouble(value: Double) {
    def *[Vec <: VecBase[Double, Vec]](vec: Vec): Vec = vec * value
    def /[Vec <: VecBase[Double, Vec]](vec: Vec): Vec = vec |/ value
    def +[Vec <: VecBase[Double, Vec]](vec: Vec): Vec = vec + value
    def -[Vec <: VecBase[Double, Vec]](vec: Vec): Vec = vec |- value
  }
}

object VecBaseInfixImplicits extends VecBaseInfixImplicits
