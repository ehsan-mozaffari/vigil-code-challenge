package global.vigil.codechallenge.endpoint

import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.util.model.error.Err
import sttp.tapir.{Endpoint, PublicEndpoint}
import sttp.tapir.generic.auto.*
import sttp.tapir.json.zio.*
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.ztapir.*

private[this] trait BaseEndpoint {
  lazy val baseEndpoint: Endpoint[Unit, Unit, Unit, Unit, Any] =
    endpoint
      .in("user")
  //      .out(jsonBody[Err])
  //      .out(oneOf)
}
