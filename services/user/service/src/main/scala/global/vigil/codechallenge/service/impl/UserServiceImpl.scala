package global.vigil.codechallenge.service.impl

import global.vigil.codechallenge.repo.UserRepo
import global.vigil.codechallenge.service.UserService
import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.util.model.error.Err
import zio.ZIO

class UserServiceImpl(userRepo: UserRepo) extends UserService{
  override def getUserById(id: Int): ZIO[Any, Err, User] = userRepo.get(id)
}
object UserServiceImpl{
  def getUserById(id: Int): ZIO[UserService, Err, User] =
    ZIO.serviceWithZIO[UserService](_.getUserById(id))
}
