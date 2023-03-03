package global.vigil.codechallenge

import cats.effect.IO
import global.vigil.codechallenge.infrastructure.database.{DB, Flyway}
import global.vigil.codechallenge.infrastructure.database.Flyway.PostgresDatabaseConfig
import model.User
import cats.effect.unsafe.implicits.global
import io.getquill.*
import io.getquill.context.ZioJdbc.DataSourceLayer
import zio.{ZIO, ZIOAppDefault, ZLayer}

object TestRunner extends ZIOAppDefault {
//  Flyway
//    .migrateDb(
//      PostgresDatabaseConfig(
//        user         = Some("postgres"),
//        pass         = Some("simplepass"),
//        databaseName = "social_media"
//      )
//    )
//    .use(dmr => IO(println(dmr)))
//    .unsafeRunSync()

  override def run: ZIO[Any, Any, Any] ={
    import DB._
    val zioDS = DataSourceLayer.fromPrefix("ctx")
    val a = DB.run(quote(query[User])).provideLayer(zioDS)
    ZIO.succeed(println("dsfdsf"))
    a
  }
}
