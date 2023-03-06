package global.vigil.codechallenge.route

import global.vigil.codechallenge.endpoint.impl.UserEndpoint
import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.repo.UserRepo
import global.vigil.codechallenge.service.UserService
import global.vigil.codechallenge.util.database.DB
import global.vigil.codechallenge.util.model.error.Err
import sttp.tapir.PublicEndpoint
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.ztapir.*
import zio.ZIO
import zio.ZIO.ServiceWithZIOPartiallyApplied

object UserRoute extends UserEndpoint {

  private def zUserService(f: UserService => ZIO[UserService, Err, User]) =
    ZIO.serviceWithZIO[UserService](f).provide(UserService.layer, UserRepo.layer, DB.layer)

  def apply(): List[ZServerEndpoint[Any, Any]] = List(
    getUserByIdEndpoint.zServerLogic(id => zUserService(_.getUserById(id)))
  )
}
