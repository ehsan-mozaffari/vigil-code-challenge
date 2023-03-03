import Dependencies._
logLevel := Level.Info

name := "vigil code challenge"

lazy val scala3Version = "3.2.2"
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

lazy val root = project
  .in(file("."))
  .settings(
    version                        := "1.0.0",
    libraryDependencies ++= (Nil   ++
      lib.zio.core                 ++
      lib.zio.config               ++
      lib.zio.configTypesafe       ++
      lib.zio.configMagnolia       ++
      lib.api.tapir.zioHttpServer  ++
      lib.zio.http                 ++
      lib.zio.streams              ++
      lib.zio.json                 ++
      lib.test.munit               ++
      lib.database.migration.fly4s ++
      lib.database.driver.postgres ++
      lib.database.quill.core      ++
      Nil)
      .map(library =>
        library withSources () withJavadoc () // Download source and Java Doc without IDE plugin
      )
  )
