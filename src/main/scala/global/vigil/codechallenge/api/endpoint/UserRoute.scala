package global.vigil.codechallenge.api.endpoint

import global.vigil.codechallenge.service.UserService
import sttp.tapir.ztapir.ZServerEndpoint
import sttp.tapir.PublicEndpoint
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.ztapir.*

object UserRoute extends UserEndpoint {

  def apply[F[_]](userService: UserService[F]): List[ZServerEndpoint[Any, Any]] = List(
    getUserByIdEndpoint.zServerLogic(userService.getUserById),
  )
}
