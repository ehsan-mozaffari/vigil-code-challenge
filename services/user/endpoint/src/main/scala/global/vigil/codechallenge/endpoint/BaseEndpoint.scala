package global.vigil.codechallenge.endpoint

import sttp.tapir.Endpoint
import sttp.tapir.ztapir.*

private[this] trait BaseEndpoint {
  lazy val baseEndpoint: Endpoint[Unit, Unit, Unit, Unit, Any] =
    endpoint
      .in("user")
  //      .out(jsonBody[Err])
  //      .out(oneOf)
}
