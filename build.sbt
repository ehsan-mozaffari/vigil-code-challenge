import Dependencies._
logLevel := Level.Info

name    := "vigil code challenge"
version := "1.0.0"

val scala3Version = "3.2.2"
scalaVersion := scala3Version

scalacOptions ++= Seq(
  "-J-target:jvm-19", // It is no preventing not to compile scala with other java version, it just shows the byte code java version is jdk 19
  "-J-release 19",
  "-J-enable-preview"
)

javacOptions ++= Seq(
  "--release 19",
  "--enable-preview"
)

javaOptions ++= Seq(
  "--enable-preview"
)

// checks the specific version of java version to run the project
initialize := {
  val _ = initialize.value // Needed to run previous initialization.
  assert(scala.util.Properties.isJavaAtLeast("19"), "Java 19 is required!")
}

resolvers ++= Resolver.sonatypeOssRepos("snapshots")

lazy val services = project
  .in(file("services"))
  .dependsOn(user)
  .settings(scalaVersion := scala3Version)

lazy val util = project
  .in(file("util"))
  .settings(
    libraryDependencies ++= common.util,
    scalaVersion := scala3Version
  )

lazy val userModel    = project.in(file("services/user/model")).settings(scalaVersion := scala3Version)
lazy val userEndpoint = project
  .in(file("services/user/endpoint"))
  .settings(libraryDependencies ++= common.endpoints, scalaVersion := scala3Version)
  .dependsOn(util, userModel)
lazy val userService  = project
  .in(file("services/user/service"))
  .settings(
    libraryDependencies ++= common.core,
    scalaVersion := scala3Version
  )
lazy val user         =
  project
    .in(file("services/user"))
    .dependsOn(userEndpoint, userService)
    .settings(scalaVersion := scala3Version)
