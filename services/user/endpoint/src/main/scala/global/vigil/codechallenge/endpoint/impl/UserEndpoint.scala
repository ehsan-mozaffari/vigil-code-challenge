package global.vigil.codechallenge.endpoint.impl

import global.vigil.codechallenge.endpoint.BaseEndpoint
import global.vigil.codechallenge.model.User
import global.vigil.codechallenge.util.model.error.Err
import sttp.tapir.generic.auto.*
import sttp.tapir.json.zio.*
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.ztapir.*
import sttp.tapir.{Endpoint, PublicEndpoint}

trait UserEndpoint extends BaseEndpoint{
  
  lazy val getUserByIdEndpoint: Endpoint[Unit, Int, Err, User, Any] =
    baseEndpoint.get
      .in(path[Int]("id"))
      .out(jsonBody[User])
      .errorOut(jsonBody[Err])

  val rootEndpoint = endpoint.get
    .in("test")
    .out(stringJsonBody)
}
