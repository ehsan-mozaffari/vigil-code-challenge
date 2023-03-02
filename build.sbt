import Dependencies._
logLevel := Level.Info

name := "vigil code challenge"

lazy val scala3Version = "3.2.2"
scalaVersion := scala3Version

lazy val root = project
  .in(file("."))
  .settings(
    version := "0.1.0",
    libraryDependencies ++= Nil
  )
