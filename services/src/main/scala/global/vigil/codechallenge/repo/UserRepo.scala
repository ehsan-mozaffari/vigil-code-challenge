package global.vigil.codechallenge.repo

import global.vigil.codechallenge.repo.impl.UserRepoImpl
import global.vigil.codechallenge.model.User
import io.getquill.{PostgresZioJdbcContext, SnakeCase}
import zio.*

trait UserRepo  {
  def get(id: Int): ZIO[Any, Throwable, User]
}
object UserRepo {
  val layer: ZLayer[PostgresZioJdbcContext[SnakeCase], Nothing, UserRepo] = ZLayer(
    ZIO.service[PostgresZioJdbcContext[SnakeCase]].map(new UserRepoImpl(_))
  ) 
}
