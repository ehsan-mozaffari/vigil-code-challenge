package global.vigil.codechallenge.util.database

import io.getquill.{PostgresZioJdbcContext, SnakeCase}
import zio.{ZIO, ZLayer}

/** * DB is a postgres ZIO jdbc context that support snake cases for using implicit conversion
  * between your class and db types just import DB.*
  */
object DB extends PostgresZioJdbcContext[SnakeCase](SnakeCase) {
  val layer: ZLayer[Any, Nothing, DB.type] = ZLayer.fromFunction(() => this)
  def apply(): ZIO[Any, Nothing, DB.type] = ZIO.service[DB.type].provide(layer)
}
