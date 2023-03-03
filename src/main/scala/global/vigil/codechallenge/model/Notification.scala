package global.vigil.codechallenge.model

import global.vigil.codechallenge.model.Notification.*
import global.vigil.codechallenge.model.Post.*
import global.vigil.codechallenge.model.User.*

import java.time.Instant

case class Notification(userId: Int, postId: Int, isRead: Boolean)
//case class Notification(userId: UserId, postId: PostId, publishDate: Instant, isRead: IsRead)
//object Notification {
//
//  opaque type IsRead = Boolean
//  object IsRead {
//    def apply(value:   Boolean): IsRead          = value
//    def unApply(value: IsRead):  Option[Boolean] = Some(value)
//    extension (v:      IsRead) { def value: Boolean = v }
//  }
//}
