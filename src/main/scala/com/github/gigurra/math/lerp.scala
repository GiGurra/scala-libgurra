package com.github.gigurra.math

/**
  * Created by johan on 2016-12-04.
  */
object lerp {

  /////////////////////////////////////
  // Scalar

  def apply(minInput: Double,
            maxInput: Double,
            input: Double,
            minOutput: Double,
            maxOutput: Double,
            clamp: Boolean): Double = {
    apply(
      delta = input - minInput,
      range = maxInput - minInput,
      minOutput = minOutput,
      maxOutput = maxOutput,
      clamp = clamp
    )
  }

  def apply(minInput: Double,
            maxInput: Double,
            input: Double,
            minOutput: Double,
            maxOutput: Double): Double = {
    apply(minInput, maxInput, input, minOutput, maxOutput, clamp = true)
  }

  def apply(delta: Double,
            range: Double,
            minOutput: Double,
            maxOutput: Double,
            clamp: Boolean): Double = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > range) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Double,
            range: Double,
            minOutput: Double,
            maxOutput: Double): Double = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }


  /////////////////////////////////////
  // Vec2

  def apply(delta: Double,
            range: Double,
            minOutput: Vec2[Double],
            maxOutput: Vec2[Double],
            clamp: Boolean): Vec2[Double] = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > range) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Double,
            range: Double,
            minOutput: Vec2[Double],
            maxOutput: Vec2[Double]): Vec2[Double] = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }

  def apply(delta: Float,
            range: Float,
            minOutput: Vec2[Float],
            maxOutput: Vec2[Float],
            clamp: Boolean): Vec2[Float] = {
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
            minOutput: Vec2[Float],
            maxOutput: Vec2[Float]): Vec2[Float] = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }


  /////////////////////////////////////
  // Vec3

  def apply(delta: Double,
            range: Double,
            minOutput: Vec3[Double],
            maxOutput: Vec3[Double],
            clamp: Boolean): Vec3[Double] = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > range) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Double,
            range: Double,
            minOutput: Vec3[Double],
            maxOutput: Vec3[Double]): Vec3[Double] = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }

    def apply(delta: Float,
            range: Float,
            minOutput: Vec3[Float],
            maxOutput: Vec3[Float],
            clamp: Boolean): Vec3[Float] = {
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
            minOutput: Vec3[Float],
            maxOutput: Vec3[Float]): Vec3[Float] = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }


  /////////////////////////////////////
  // Vec4

  def apply(delta: Double,
            range: Double,
            minOutput: Vec4[Double],
            maxOutput: Vec4[Double],
            clamp: Boolean): Vec4[Double] = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > range) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Double,
            range: Double,
            minOutput: Vec4[Double],
            maxOutput: Vec4[Double]): Vec4[Double] = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }


  def apply(delta: Float,
            range: Float,
            minOutput: Vec4[Float],
            maxOutput: Vec4[Float],
            clamp: Boolean): Vec4[Float] = {
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
            minOutput: Vec4[Float],
            maxOutput: Vec4[Float]): Vec4[Float] = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }

}
