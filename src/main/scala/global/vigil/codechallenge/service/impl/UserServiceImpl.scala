package global.vigil.codechallenge.service.impl

import cats.data.EitherT
import cats.effect.Concurrent
import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.repository.UserRepository
import global.vigil.codechallenge.service.UserService

class UserServiceImpl [F[_]: Concurrent](userRepo: UserRepository[F]) extends UserService[F]{
  
  override def getUserById(id: Int): EitherT[F, Throwable, User] = userRepo.getUserById(id)
}
object UserServiceImpl {
  def apply[F[_]](userRepo: UserRepository[F]): UserService[F] = new UserServiceImpl[F](userRepo)
}
