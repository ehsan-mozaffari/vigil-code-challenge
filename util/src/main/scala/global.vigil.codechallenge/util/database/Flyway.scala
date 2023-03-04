package global.vigil.codechallenge.infrastructure.database

import cats.effect.*
import fly4s.core.*
import fly4s.core.data.*
import fly4s.implicits.*
object Flyway {

  /** *
    *
    * @param host
    *   Database host for example localhost
    * @param port
    *   Database port
    * @param pass
    *   Database password
    * @param migrationsTable
    *   The target table for migration
    * @param migrationsLocations
    *   The list of location directories in the resource folder
    */
  case class PostgresDatabaseConfig(
      host:                String         = "localhost",
      port:                String         = "5432",
      user:                Option[String] = Some("postgres"),
      pass:                Option[String] = None,
      databaseName:        String,
      migrationsLocations: List[String]   = List("db")
  )

  def migrateDb(conf: PostgresDatabaseConfig): Resource[IO, MigrateResult] =
    Fly4s
      .make[IO](
        url      = s"jdbc:postgresql://${conf.host}:${conf.port}/${conf.databaseName}",
        user     = conf.user,
        password = conf.pass.map(_.toCharArray),
        config   = Fly4sConfig(
          ignoreMigrationPatterns =
            List(ValidatePattern.ignorePendingMigrations, ValidatePattern.ignoreIgnoredMigrations),
          outOfOrder              = true,
          locations               = Location.of(conf.migrationsLocations)
        )
      )
      .evalMap(_.validateAndMigrate.result)
}
