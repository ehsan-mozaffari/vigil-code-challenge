package global.vigil.codechallenge.service

import cats.data.EitherT
import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.repository.UserRepository
import zio.ZIO


trait UserService[F[_]] {

  def getUserById(id: Int):EitherT[F, Throwable, User]
}

object UserService{
  def apply[F[_]](using userService: UserService[F]): UserService[F] = implicitly //implicitly[UserService[F]]
}
