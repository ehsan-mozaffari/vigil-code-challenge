import sbt._ // For understanding Dependencies object as an sbt file

object Dependencies {

  private object ver {
    val pureConfig = "0.17.2"
  }

  object lib {
    object config {
      // A type safe scala configuration management supports .conf .json .properties
      // TODO: change it to this after supporting implicits:
      //  val pureConfig = Seq("com.github.pureconfig" %% "pureconfig" % ver.pureConfig)
      //  .map(_.cross(CrossVersion.for3Use2_13))
      val pureConfigCore = Seq("com.github.pureconfig" %% "pureconfig-core" % ver.pureConfig)
    }
  }
}
