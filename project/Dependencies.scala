import sbt._ // For understanding Dependencies object as an sbt file

object Dependencies {

  private object ver {
    val zio       = "2.0.9"
    val zioConfig = "3.0.7"
  }

  object lib {

    object zio {
      val core:           Seq[ModuleID] = Seq("dev.zio" %% "zio" % ver.zio)
      val config:         Seq[ModuleID] = Seq("dev.zio" %% "zio-config" % ver.zioConfig)
      val configTypesafe: Seq[ModuleID] = Seq("dev.zio" %% "zio-config-typesafe" % ver.zioConfig)
      val configMagnolia: Seq[ModuleID] = Seq("dev.zio" %% "zio-config-magnolia" % ver.zioConfig)
    }
  }
}
