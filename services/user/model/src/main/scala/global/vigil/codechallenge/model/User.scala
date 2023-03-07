package global.vigil.codechallenge.model

import global.vigil.codechallenge.util.json.ZioJsonCodec

import java.time.Instant

case class User(
    id:              Int,
    name:            String,
    email:           String,
    followedUserIds: List[Int],
    isOnline:        Boolean
)
object User extends ZioJsonCodec[User]

//case class User(
//    id:              UserId,
//    name:            Username,
//    email:           UserEmail,
//    followedUserIds: List[UserId],
//    isOnline:        IsOnline
//)
//object User {
//
//  opaque type UserId = Int
//
//  object UserId {
//    def apply(value:   Int):    UserId      = value
//    def unApply(value: UserId): Option[Int] = Some(value)
//    extension (v:      UserId) { def value: Int = v }
//  }
//
//  opaque type Username = String
//  object Username {
//    def apply(value:   String):   Username       = value
//    def unApply(value: Username): Option[String] = Some(value)
//    extension (v:      Username) { def value: String = v }
//  }
//
//  opaque type UserEmail = String
//  object UserEmail {
//    def apply(value:   String):    UserEmail      = value
//    def unApply(value: UserEmail): Option[String] = Some(value)
//    extension (v:      UserEmail) { def value: String = v }
//  }
//
//  opaque type IsOnline = Boolean
//  object IsOnline {
//    def apply(value:   Boolean):  IsOnline        = value
//    def unApply(value: IsOnline): Option[Boolean] = Some(value)
//    extension (v:      IsOnline) { def value: Boolean = v }
//  }
//
//}
