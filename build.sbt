organization := "com.github.gigurra"
name := "libgurra"
version := "0.4.0-SNAPSHOT"

scalaVersion := "2.11.8"
scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation")

scalacOptions += "-target:jvm-1.6"
javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

libraryDependencies ++= Seq(
  "org.scalatest"        %%   "scalatest"             %   "2.2.4"     %   "test",
  "org.mockito"           %   "mockito-core"          %   "1.10.19"   %   "test"
)

pgpPassphrase := sys.env.get("PGP_PASSPHRASE").map(_.toArray)

