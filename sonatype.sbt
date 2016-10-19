// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "com.github.gigurra"

// To sync with Maven central, you need to supply the following information:
pomExtra in Global := {
  <url>https://github.com/GiGurra/scala-libgurra</url>
  <!-- License of your choice -->
  <licenses>
    <license>
      <name>MIT</name>
      <url>https://github.com/GiGurra/scala-libgurra/blob/master/LICENSE</url>
    </license>
  </licenses>
  <!-- SCM information. Modify the following URLs -->
  <scm>
    <connection>scm:git:github.com/gigurra/scala-libgurra</connection>
    <developerConnection>scm:git:git@github.com:gigurra/scala-libgurra</developerConnection>
    <url>github.com/gigurra/scala-libgurra</url>
  </scm>
  <!-- Developer contact information -->
  <developers>
    <developer>
      <id>gigurra</id>
      <name>Johan Kjölhede</name>
      <url>https://github.com/GiGurra/scala-libgurra</url>
    </developer>
  </developers>
}

