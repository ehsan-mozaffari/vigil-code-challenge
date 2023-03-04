package global.vigil.codechallenge.repository

import cats.data.EitherT
import global.vigil.codechallenge.model.User
import zio.ZIO

trait UserRepository[F[_]] {

  def getUserById(id: Int): EitherT[F, Throwable, User]
}
//
//class UserRepositoryImpl[F[_]] extends UserRepository[F] {
//  
//}
