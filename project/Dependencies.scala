import sbt._ // For understanding Dependencies object as an sbt file

object Dependencies {

  private object ver {
    val catsCore       = "2.9.0"
    val catsEffect     = "3.4.8"
    val zio            = "2.0.9"
    val zioConfig      = "3.0.7"
    val fly4s          = "0.0.17"
    val postgresDriver = "42.5.4"
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
    }
    object database {

      object driver    {
        val postgres = Seq("org.postgresql" % "postgresql" % ver.postgresDriver)
      }
      object migration {
        val fly4s = Seq("com.github.geirolz" %% "fly4s-core" % ver.fly4s)
      }
    }
  }
}
