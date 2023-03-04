package global.vigil.codechallenge

import global.vigil.codechallenge.infrastructure.config.ZPConfig
import global.vigil.codechallenge.infrastructure.database.DB
import zio.*

object ZIOMain extends ZIOAppDefault {
//  def run = ZPConfig().map { a =>
//    println(a)
//    a
//  }

  override def run: ZIO[Any, Any, Any] = {
    val zioDS = DataSourceLayer.fromPrefix("ctx")
    val a = DB.run(quote(query[User])).provideLayer(zioDS)
    ZIO.succeed(println("dsfdsf"))
    a
  }

}
