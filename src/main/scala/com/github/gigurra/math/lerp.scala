package com.github.gigurra.math

/**
  * Created by johan on 2016-12-04.
  */
object lerp {

  /////////////////////////////////////
  // Scalar

  def apply(minInput: Float,
            maxInput: Float,
            input: Float,
            minOutput: Float,
            maxOutput: Float,
            clamp: Boolean): Float = {
    apply(
      delta = input - minInput,
      range = maxInput - minInput,
      minOutput = minOutput,
      maxOutput = maxOutput,
      clamp = clamp
    )
  }

  def apply(minInput: Float,
            maxInput: Float,
            input: Float,
            minOutput: Float,
            maxOutput: Float): Float = {
    apply(minInput, maxInput, input, minOutput, maxOutput, clamp = true)
  }

  def apply(delta: Float,
            range: Float,
            minOutput: Float,
            maxOutput: Float,
            clamp: Boolean): Float = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > range) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Float,
            range: Float,
            minOutput: Float,
            maxOutput: Float): Float = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }


  /////////////////////////////////////
  // Vec2

  def apply(delta: Float,
            range: Float,
            minOutput: Vec2,
            maxOutput: Vec2,
            clamp: Boolean): Vec2 = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > range) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Float,
            range: Float,
            minOutput: Vec2,
            maxOutput: Vec2): Vec2 = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }


  /////////////////////////////////////
  // Vec3

  def apply(delta: Float,
            range: Float,
            minOutput: Vec3,
            maxOutput: Vec3,
            clamp: Boolean): Vec3 = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > range) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Float,
            range: Float,
            minOutput: Vec3,
            maxOutput: Vec3): Vec3 = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }


  /////////////////////////////////////
  // Vec4

  def apply(delta: Float,
            range: Float,
            minOutput: Vec4,
            maxOutput: Vec4,
            clamp: Boolean): Vec4 = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > range) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Float,
            range: Float,
            minOutput: Vec4,
            maxOutput: Vec4): Vec4 = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }

}
