package global.vigil.codechallenge.api.endpoint

import sttp.tapir.PublicEndpoint
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.ztapir.*
import zio.*
import zio.http.{HttpApp, Request, Response}

trait UserEndpoint {

  private lazy val endpointWithUserPrefix = endpoint.in("user")

  lazy val getUserByIdEndpoint =
    endpointWithUserPrefix.get
      .in(path[Int]("id"))
      .out(stringJsonBody)
}
