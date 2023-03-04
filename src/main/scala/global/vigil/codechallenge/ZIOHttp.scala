package global.vigil.codechallenge

import io.getquill.{PostgresZioJdbcContext, SnakeCase}
import io.getquill.context.ZioJdbc.DataSourceLayer
import zio.*
import zio.http.*
import zio.http.model.Method

object ZIOHttp extends ZIOAppDefault {

  val app: HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "text" => Response.text("Hello World!")
  }
  

  override val run =
    Server.serve(app).provide(Server.default)
}
