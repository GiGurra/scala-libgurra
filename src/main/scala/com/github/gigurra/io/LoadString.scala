package com.github.gigurra.io

import java.nio.charset.{Charset, StandardCharsets}

import scala.io.Codec

/**
  * Created by johan on 2016-10-01.
  */
object LoadString {

  def from(location: String,
           lookForLocalResource: Boolean = true,
           lookForGlobalResource: Boolean = true,
           lookForFile: Boolean = true,
           charset: Charset = StandardCharsets.UTF_8): Option[String] = {

    val streamOpt = LoadInputStream.from(
      location = location,
      lookForLocalResource = lookForLocalResource,
      lookForGlobalResource = lookForGlobalResource,
      lookForFile = lookForFile
    )

    val out = streamOpt.map(stream => scala.io.Source.fromInputStream(stream)(Codec(charset)).mkString)
    streamOpt.foreach(_.close())
    out
  }
}
