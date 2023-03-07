package global.vigil.codechallenge.route

//import sttp.tapir.*
import sttp.tapir.EndpointInput
import sttp.tapir.server.ServerEndpoint
import sttp.tapir.swagger.bundle.SwaggerInterpreter
import sttp.tapir.ztapir.*
import zio.{Task, ZIO}

object Route {

  lazy val all: List[ZServerEndpoint[Any, Any]] =
    docRoutes ++ apiRoutesWithPrefixPath

  private lazy val docRoutes: List[ZServerEndpoint[Any, Any]] =
    SwaggerInterpreter()
        .fromServerEndpoints[Task](apiRoutesWithPrefixPath, "Vigil Code Challenge API", "1.0.0")

  extension (s: List[ZServerEndpoint[Any, Any]]) {
    private def prependPathAll(path: String): List[ZServerEndpoint[Any, Any]] = s.map { e =>
      ServerEndpoint(e.endpoint.copy(input = path / e.endpoint.input), e.securityLogic, e.logic)
    }
  }

  private lazy val apiRoutesWithPrefixPath = apiRoutes.prependPathAll(apiRoutesRootPath)

  private lazy val apiRoutesRootPath = "api"
  private lazy val apiRoutes: List[ZServerEndpoint[Any, Any]] = UserRoute()
}
