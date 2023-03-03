package global.vigil.codechallenge.model

import global.vigil.codechallenge.model.core.Types.*

import java.time.Instant

case class Notification(userId: UserId, postId: PostId, publishDate: Instant, isRead: IsRead)
