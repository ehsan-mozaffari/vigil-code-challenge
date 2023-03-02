package config

import pureconfig.*

import config.PureConfig.*

case class PureConfig(conf: Conf)
object PureConfig {
  // TODO Forced to manually defined the config readers because no automatic derivation for scala 3 in pure config
  given HttpConfReader: ConfigReader[HttpConf] = ConfigReader.forProduct2("server", "port")(HttpConf(_, _))
  given confReader: ConfigReader[Conf] = ConfigReader.forProduct1("http")(Conf(_))
  given pureConfigReader: ConfigReader[PureConfig] = ConfigReader.forProduct1("conf")(PureConfig(_))

  def apply(): PureConfig = ConfigSource.default.loadOrThrow[PureConfig]

  val loadOnce = apply()

  case class Conf(http: HttpConf)
  case class HttpConf(server: String, port: String)
}
