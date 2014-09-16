crossBuildingSettings

sbtPlugin := true

name := "haxe-unit-interface"

organization := "com.qifun"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

version := "0.0.1-SNAPSHOT"

CrossBuilding.crossSbtVersions := Seq("0.13")

description := "The Haxe unit test plugins for sbt."

homepage := Some(url("https://github.com/Atry/stateless-future"))

startYear := Some(2014)

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

publishTo <<= (isSnapshot) { isSnapshot: Boolean =>
  if (isSnapshot)
    Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else
    Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

scmInfo := Some(ScmInfo(
  url("https://bitbucket.org/qforce/haxe-unit-interface"),
  "scm:git:https://bitbucket.org/qforce/ai-demo.git",
  Some("scm:git:git@bitbucket.org:qforce/haxe-unit-interface.git")))

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
