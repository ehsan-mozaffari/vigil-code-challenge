package global.vigil.codechallenge

import global.vigil.codechallenge.route.Route
import global.vigil.codechallenge.util.config.ZPConfig
import global.vigil.codechallenge.util.model.error.Err
import org.slf4j.LoggerFactory
import sttp.tapir.server.interceptor.log.DefaultServerLog
import sttp.tapir.server.ziohttp.{ZioHttpInterpreter, ZioHttpServerOptions}
import zio.http.{HttpApp, Server, ServerConfig}
import zio.{Console, ExitCode, Scope, Task, ZIO, ZIOAppArgs, ZIOAppDefault, ZLayer}

object TapirMain extends ZIOAppDefault {

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = {

    val log = LoggerFactory.getLogger(ZioHttpInterpreter.getClass.getName)

//    lazy val appConfig = ZPConfig()

    val serverOptions: ZioHttpServerOptions[Any] =
      ZioHttpServerOptions.customiseInterceptors
        .serverLog(
          DefaultServerLog[Task](
            doLogWhenReceived      = msg => ZIO.succeed(log.debug(msg)),
            doLogWhenHandled       =
              (msg, error) => ZIO.succeed(error.fold(log.debug(msg))(err => log.debug(msg, err))),
            doLogAllDecodeFailures =
              (msg, error) => ZIO.succeed(error.fold(log.debug(msg))(err => log.debug(msg, err))),
            doLogExceptions        = (msg: String, ex: Throwable) => ZIO.succeed(log.debug(msg, ex)),
            noLog                  = ZIO.unit
          )
        )
        .options

    
    val app: HttpApp[Any, Throwable] = ZioHttpInterpreter(serverOptions).toHttp(Route.all)

    val port = sys.env.get("HTTP_PORT").flatMap(_.toIntOption).getOrElse(8080)

    (
      for
        _ <- Console.printLine(s"test")
        actualPort <- Server.install(app.withDefaultErrorResponse)
        _ <- Console.printLine(s"Go to http://localhost:${actualPort}/docs to open SwaggerUI.")
        _ <- Console.readLine
      yield ()
      ).provide(
      ServerConfig.live(ServerConfig.default.port(port)),
      Server.live
    ).exitCode
  }
}
