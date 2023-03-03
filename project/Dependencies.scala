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
        val zioHttpServer: Seq[ModuleID] = Seq(
          "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server" % ver.tapir
        )
      }
    }

  }
}
