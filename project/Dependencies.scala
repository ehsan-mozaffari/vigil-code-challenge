import sbt._ // For understanding Dependencies object as an sbt file

object Dependencies {

  private object ver {
    val catsCore       = "2.9.0"
    val catsEffect     = "3.4.8"
    val zio            = "2.0.9"
    val zioConfig      = "3.0.7"
    val fly4s          = "0.0.17"
    val postgresDriver = "42.5.4"
    val zioHttp        = "0.0.4"
    val zioJson        = "0.4.2"
    val munit          = "0.7.29"
    val tapir          = "1.2.9"
    val quill          = "4.6.0.1"
  }

  object lib {

    object cats {
      val core: Seq[ModuleID] = Seq("org.typelevel" %% "cats-core" % ver.catsCore)

      object effect {
        // Cats effect core withSources() to download source without IDE plugin and same for withJavadoc()
        val core: Seq[ModuleID] = Seq(
          "org.typelevel" %% "cats-effect" % ver.catsEffect withSources () withJavadoc ()
        )
      }
    }

    object zio {
      val core:           Seq[ModuleID] = Seq("dev.zio" %% "zio" % ver.zio)
      val config:         Seq[ModuleID] = Seq("dev.zio" %% "zio-config" % ver.zioConfig)
      val configTypesafe: Seq[ModuleID] = Seq("dev.zio" %% "zio-config-typesafe" % ver.zioConfig)
      val configMagnolia: Seq[ModuleID] = Seq("dev.zio" %% "zio-config-magnolia" % ver.zioConfig)

      val streams:   Seq[ModuleID] = Seq("dev.zio" %% "zio-streams" % ver.zio)
      val test:      Seq[ModuleID] = Seq("dev.zio" %% "zio-test" % ver.zio)
      val testSbt:   Seq[ModuleID] = Seq("dev.zio" %% "zio-test-sbt" % ver.zio)
      val testJUnit: Seq[ModuleID] = Seq("dev.zio" %% "zio-test-junit" % ver.zio)
      val json:      Seq[ModuleID] = Seq("dev.zio" %% "zio-json" % ver.zioJson)
      val http:      Seq[ModuleID] = Seq("dev.zio" %% "zio-http" % ver.zioHttp)
    }

    object database {

      object quill {
        // Quill provides a Quoted Domain Specific Language (QDSL) to express queries in Scala in SQL & CQL
        val core: Seq[ModuleID] = Seq("io.getquill" %% "quill-jdbc-zio" % ver.quill)
      }

      object driver {
        val postgres = Seq("org.postgresql" % "postgresql" % ver.postgresDriver)
      }

      object migration {
        val fly4s = Seq("com.github.geirolz" %% "fly4s-core" % ver.fly4s)
      }
    }

    object test {
      // map for the sake of learning
      val munit: Seq[ModuleID] = Seq("org.scalameta" %% "munit" % ver.munit).map(_ % Test)
    }

    object api {

      object tapir {
        // contains an interpreter useful when exposing the endpoints using the ZIO Http server via Tapir
        // which already depends on tapir-zio
        val zioHttpServer:   Seq[ModuleID] = Seq(
          "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server" % ver.tapir
        )
        val swaggerUiBundle: Seq[ModuleID] = Seq(
          "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % ver.tapir
        )
        val jsonZio:         Seq[ModuleID] = Seq(
          "com.softwaremill.sttp.tapir" %% "tapir-json-zio" % ver.tapir
        )
        val sttpStubServer:  Seq[ModuleID] = Seq(
          "com.softwaremill.sttp.tapir" %% "tapir-sttp-stub-server" % ver.tapir % Test
        )
      }
    }
  }

  object common {
    val endpoints = (Nil ++
      lib.api.tapir.zioHttpServer   ++
      lib.api.tapir.swaggerUiBundle ++
      lib.api.tapir.jsonZio         ++
      lib.api.tapir.sttpStubServer  ++
      Nil)
      .map(library =>
        library withSources () withJavadoc () // Download source and Java Doc without IDE plugin
      )

    val core = (Nil ++
      lib.zio.core                 ++
      lib.zio.config               ++
      lib.zio.configTypesafe       ++
      lib.zio.configMagnolia       ++
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
  }
}
