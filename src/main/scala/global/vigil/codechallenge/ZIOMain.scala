package global.vigil.codechallenge

import global.vigil.codechallenge.infrastructure.config.ZPConfig
import zio.*

object ZIOMain extends ZIOAppDefault {
  def run = ZPConfig().map { a =>
    println(a)
    a
  }

}
