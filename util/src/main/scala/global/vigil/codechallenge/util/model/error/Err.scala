package global.vigil.codechallenge.util.model.error

import global.vigil.codechallenge.util.json.ZioJsonCodec
import sttp.tapir.generic.auto.*
import sttp.tapir.json.zio.*
import zio.json.*

sealed abstract class Err(m: String)
object Err extends ZioJsonCodec[Err]

case class NotFound(message: String) extends Err(message)
object NotFound                      extends ZioJsonCodec[NotFound]
