package com.github.gigurra.compression

import java.util

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps
import scala.util.Random

class ZipSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Zip" should {

    "Zip and unzip some bytes" in {
      val data = Random.nextString(100*1024).getBytes()
      val compressed = Zip.compress(data)
      val decompressed = Zip.decompress(compressed)
      util.Arrays.equals(data, decompressed)
    }
  }
}
