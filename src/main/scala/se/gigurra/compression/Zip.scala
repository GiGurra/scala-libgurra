package se.gigurra.compression

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, InputStream}
import java.util.zip.{GZIPInputStream, GZIPOutputStream}

/**
  * Created by johan on 2016-06-12.
  */
object Zip {

  def compress(bytes: Array[Byte]): Array[Byte] = {
    val bos = new ByteArrayOutputStream()
    val zs = new GZIPOutputStream(bos)
    zs.write(bytes)
    zs.close()
    bos.toByteArray
  }

  def decompress(bytes: Array[Byte]): Array[Byte] = {
    val bis = new ByteArrayInputStream(bytes)
    val zs = new GZIPInputStream(bis)
    toByteArray(zs)
  }

  private def toByteArray(in: InputStream): Array[Byte] = {
    val arr = new Array[Byte](in.available)
    in.read(arr)
    arr
  }
}
