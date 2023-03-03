package global.vigil.codechallenge.infrastructure.database

import io.getquill.{PostgresZioJdbcContext, SnakeCase}

/***
 * DB is a postgres ZIO jdbc context that support snake cases
 * for using implicit conversion between your class and db types just import DB.* 
 */
object DB extends PostgresZioJdbcContext(SnakeCase)
