package global.vigil.codechallenge.infrastructure.config

import global.vigil.codechallenge.infrastructure.config.{Host, ZPConfig}
import zio.*
import zio.config.*
import zio.config.magnolia.descriptor
import zio.config.typesafe.TypesafeConfigSource

case class Host(url: String, port: Int)
case class Postgres(host:String, port: String, user: String, pass: String, databaseName: String)
case class DB(postgres:Postgres)
case class ZPConfig(host: Host, db: DB)

/***
 * This is a ZIO Pure Configuration (ZPConfig) that collaborates pure configuration management.
 */
object ZPConfig {
  private lazy val layer: ZLayer[Any, ReadError[String], ZPConfig] =
    ZLayer(read(descriptor[ZPConfig].from(TypesafeConfigSource.fromResourcePath)))

  def apply(): ZIO[Any, ReadError[String], ZPConfig] = ZIO.service[ZPConfig].provide(layer)
}
