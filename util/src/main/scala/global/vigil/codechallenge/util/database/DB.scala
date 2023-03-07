package global.vigil.codechallenge.util.database

import io.getquill.{PostgresZioJdbcContext, SnakeCase}
import zio.{ULayer, ZIO, ZLayer}


/***
 * DB is a postgres ZIO jdbc context that support snake cases
 * for using implicit conversion between your class and db types just import DB.* 
 */
class DB extends PostgresZioJdbcContext[SnakeCase](SnakeCase)
object DB{
  val layer: ZLayer[Any, Nothing, DB] = ZLayer.fromFunction(() => new DB())
  def apply() = ZIO.service[DB].provide(layer)
}
