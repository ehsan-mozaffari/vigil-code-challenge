package global.vigil.codechallenge.util.json

import zio.json.{DeriveJsonCodec, JsonCodec}

import scala.deriving.Mirror

/***
  * Adds zio json codec to your case classes just mixin it in the companion object
  * @tparam T: Is your case class type
  */
trait ZioJsonCodec[T] {
  inline given codec(using mirror: Mirror.Of[T]): JsonCodec[T] = DeriveJsonCodec.gen[T]
}
