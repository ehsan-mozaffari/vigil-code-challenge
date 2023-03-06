package global.vigil.codechallenge.util.model.error

import zio.json.JsonCodec

sealed abstract class Err(m: String)
object Err{
  given codec: JsonCodec[Err] = JsonCodec[Err]
}
case class NotFound(message: String) extends Err(message)
