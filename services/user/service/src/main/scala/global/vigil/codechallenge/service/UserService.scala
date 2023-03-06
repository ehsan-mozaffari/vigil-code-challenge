package global.vigil.codechallenge.service

import global.vigil.codechallenge.repo.UserRepo
import global.vigil.codechallenge.service.impl.UserServiceImpl
import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.util.model.error.Err
import zio.{ZIO, ZLayer}

import java.sql.SQLException

trait UserService {
  def getUserById(id: Int): ZIO[Any, Err, User]
}
object UserService {
  val layer: ZLayer[UserRepo, Nothing, UserService] = ZLayer(
    ZIO.service[UserRepo].map(new UserServiceImpl(_))
  )
}
