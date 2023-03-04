package global.vigil.codechallenge.api.endpoint

import global.vigil.codechallenge.service.UserService
import global.vigil.codechallenge.service.impl.UserServiceImpl
import sttp.tapir.swagger.bundle.SwaggerInterpreter
import sttp.tapir.ztapir.ZServerEndpoint
import zio.{Task, ZIO}

object Route {

  lazy val all = apiRoutes ++ docRoutes

  private lazy val docRoutes: List[ZServerEndpoint[Any, Any]] =
    SwaggerInterpreter()
      .fromServerEndpoints[Task](apiRoutes, "Vigil Code Challenge API", "1.0.0")

  private lazy val apiRoutes: List[ZServerEndpoint[Any, Any]] = UserRoute(new UserServiceImpl[ZIO]())
}
