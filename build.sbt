organization := "com.github.gigurra"
name := "libgurra"
version := "0.2.6-SNAPSHOT"

scalaVersion := "2.11.8"
scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "org.spire-math"       %%   "spire"                 %   "0.12.0",
  "org.scalatest"        %%   "scalatest"             %   "2.2.4"     %   "test",
  "org.mockito"           %   "mockito-core"          %   "1.10.19"   %   "test"
)
