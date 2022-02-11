ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

ThisBuild / libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-effect" % "3.3.5",
  "org.typelevel" %% "cats-core" % "2.7.0",
  "com.lihaoyi" %% "scalatags" % "0.11.1" withSources(),
//  "com.github.japgolly.scalajs-react" %%% "core" % "2.0.1",
//  "org.scala-js" %%% "scalajs-dom" % "2.1.0",
  "ch.qos.logback" % "logback-classic" % "1.2.10",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4",
//  "org.webjars" % "three.js" % "r88"
)

lazy val root = (project in file("."))
//  .enablePlugins(ScalaJSPlugin)
  .settings(
      name := "websitespike"
  )
