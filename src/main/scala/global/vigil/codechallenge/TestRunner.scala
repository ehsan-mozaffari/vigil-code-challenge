package global.vigil.codechallenge

import cats.effect.IO
import global.vigil.codechallenge.infrastructure.database.Flyway
import global.vigil.codechallenge.infrastructure.database.Flyway.PostgresDatabaseConfig
import cats.effect.unsafe.implicits.global

object TestRunner extends App {
  Flyway
    .migrateDb(
      PostgresDatabaseConfig(
        user         = Some("db_pg_user"),
        pass         = Some("PleaseDon'tHackMe"),
        databaseName = "social_media"
      )
    )
    .use(dmr => IO(println(dmr)))
    .unsafeRunSync()
}
