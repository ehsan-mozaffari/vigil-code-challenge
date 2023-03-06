package global.vigil.codechallenge.util.database

import io.getquill.{PostgresZioJdbcContext, SnakeCase}
import zio.{ULayer, ZLayer}


/***
 * DB is a postgres ZIO jdbc context that support snake cases
 * for using implicit conversion between your class and db types just import DB.* 
 */
object DB extends PostgresZioJdbcContext(SnakeCase){
  val layer: ULayer[DB.type] = ZLayer.succeed(DB)
}
