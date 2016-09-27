organization := "se.gigurra"
name := "libgurra"
version := "SNAPSHOT"

scalaVersion := "2.11.8"
scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "org.scalatest"        %%   "scalatest"             %   "2.2.4"     %   "test",
  "org.mockito"           %   "mockito-core"          %   "1.10.19"   %   "test"
)
