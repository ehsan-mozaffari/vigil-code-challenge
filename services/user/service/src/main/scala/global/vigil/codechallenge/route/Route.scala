package global.vigil.codechallenge.route

import sttp.tapir.swagger.bundle.SwaggerInterpreter
import sttp.tapir.ztapir.ZServerEndpoint
import zio.{Task, ZIO}

object Route {

  lazy val all: List[ZServerEndpoint[Any, Any]] = apiRoutes ++ docRoutes

  private lazy val docRoutes: List[ZServerEndpoint[Any, Any]] =
    SwaggerInterpreter()
      .fromServerEndpoints[Task](apiRoutes, "Vigil Code Challenge API", "1.0.0")

  private lazy val apiRoutes: List[ZServerEndpoint[Any, Any]] = UserRoute()

}
