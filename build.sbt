haxeSettings

haxeJavaSettings

haxeOptions in Compile ++= Seq("-dce", "no")

haxeOptions in Compile ++= Seq("--macro", "include('haxe.unit')")

haxeOptions in Test ++= Seq("--macro", "exclude('haxe.unit')")

name := "test-interface"

organization := "com.qifun.sbt-haxe"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

version := "0.1.1"

crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies += "org.scala-sbt" % "test-interface" % "1.0"

doc in Compile :=  {
  (doc in Compile).result.value.toEither match {
    case Left(_) => {
      // Ignore error
      (target in doc in Compile).value
    }
    case Right(right) => {
      right
    }
  }
}

description := "The Haxe unit interface framework for sbt."

homepage := Some(url("https://github.com/qifun/sbt-haxe-test-interface"))

startYear := Some(2014)

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

publishTo <<= (isSnapshot) { isSnapshot: Boolean =>
  if (isSnapshot)
    Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else
    Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

scmInfo := Some(ScmInfo(
  url("https://github.com/github/sbt-haxe-test-interface"),
  "scm:git:https://github.com/github/sbt-haxe-test-interface.git",
  Some("scm:git:git@github.com:github/sbt-haxe-test-interface.git")))

pomExtra :=
  <developers>
    <developer>
      <id>chank</id>
      <name>方里权</name>
      <timezone>+8</timezone>
      <email>fangliquan@qq.com</email>
    </developer>
    <developer>
      <id>Atry</id>
      <name>杨博</name>
      <timezone>+8</timezone>
      <email>pop.atry@gmail.com</email>
    </developer>
  </developers>
