package com.github.gigurra.math

import com.github.gigurra.lang._

/**
  * Created by johan on 2016-10-24.
  */
object ToArray {

  def apply(vec2s: Seq[Vec2])(implicit f: FixErasure2[_]): Array[Float] = {
    val n = vec2s.length * 2
    val out = new Array[Float](n)
    var i = 0
    val iMax = vec2s.length
    while(i < iMax) {
      out(i * 2 + 0) = vec2s(i).x
      out(i * 2 + 1) = vec2s(i).y
      i += 1
    }
    out
  }

  def apply(vec3s: Seq[Vec3])(implicit f: FixErasure3[_]): Array[Float] = {
    val n = vec3s.length * 3
    val out = new Array[Float](n)
    var i = 0
    val iMax = vec3s.length
    while(i < iMax) {
      out(i * 3 + 0) = vec3s(i).x
      out(i * 3 + 1) = vec3s(i).y
      out(i * 3 + 2) = vec3s(i).z
      i += 1
    }
    out
  }

  def apply(vec4s: Seq[Vec4])(implicit f: FixErasure4[_]): Array[Float] = {
    val n = vec4s.length * 4
    val out = new Array[Float](n)
    var i = 0
    val iMax = vec4s.length
    while(i < iMax) {
      out(i * 4 + 0) = vec4s(i).x
      out(i * 4 + 1) = vec4s(i).y
      out(i * 4 + 2) = vec4s(i).z
      out(i * 4 + 3) = vec4s(i).w
      i += 1
    }
    out
  }

}
