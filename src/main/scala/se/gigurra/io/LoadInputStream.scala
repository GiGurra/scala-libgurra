package se.gigurra.io

import java.io.{FileInputStream, InputStream}
import java.nio.charset.{Charset, StandardCharsets}

import scala.io.Codec
import scala.util.Try

/**
  * Created by johan on 2016-10-01.
  */
object LoadInputStream {

  def from(location: String,
           lookForLocalResource: Boolean = true,
           lookForGlobalResource: Boolean = true,
           lookForFile: Boolean = true): Option[InputStream] = {

    require(lookForLocalResource || lookForGlobalResource || lookForFile, s"Must provide some location to look for '$location'")

    def loadIf(condition: Boolean, loadFcn: => Option[InputStream]): Option[InputStream] = {
      Option(location).filter(_ => condition).flatMap(_ => loadFcn)
    }

    loadIf(lookForLocalResource, Option(getClass.getResourceAsStream(location)))
      .orElse(loadIf(lookForGlobalResource, Option(getClass.getClassLoader.getResourceAsStream(location))))
      .orElse(loadIf(lookForFile, Try(new FileInputStream(location)).toOption))
  }
}
