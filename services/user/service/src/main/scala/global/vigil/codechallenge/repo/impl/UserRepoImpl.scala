package global.vigil.codechallenge.repo.impl

import global.vigil.codechallenge.repo.UserRepo
import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.util.database.DB
import global.vigil.codechallenge.util.model.error.Err
import io.getquill.{PostgresZioJdbcContext, SnakeCase}
import zio.{ZIO, ZLayer}

class UserRepoImpl(db: PostgresZioJdbcContext[SnakeCase]) extends UserRepo {
  override def get(id: Int): ZIO[Any, Err, User] = ZIO.succeed(User(1,"","",Nil,true))
}
object UserRepoImpl {

  /***
    * Accessor methods allow us to utilize all the features inside the service through
    * the ZIO Environment. That means, if we call DocRepo.get, we don't need to pull out
    * the get function from the ZIO Environment. The ZIO.serviceWithZIO constructor
    * helps us to access the environment and reduce the redundant operations, every time.
    * @param id userId
    * @return
    */
  def get(id: Int): ZIO[UserRepo, Err, User] =
    ZIO.serviceWithZIO[UserRepo](_.get(id))
}
