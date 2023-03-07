package global.vigil.codechallenge.repo

import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.repo.impl.UserRepoImpl
import global.vigil.codechallenge.util.database.DB
import global.vigil.codechallenge.util.model.error.Err
import io.getquill.{PostgresZioJdbcContext, SnakeCase}
import zio.*

trait UserRepo  {
  def get(id: Int): ZIO[Any, Err, User]
}
object UserRepo {

  val layer: ZLayer[DB.type , Nothing, UserRepo] = ZLayer(
    ZIO.service[DB.type ].map(new UserRepoImpl(_))
  )
}
