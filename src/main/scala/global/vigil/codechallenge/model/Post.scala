package global.vigil.codechallenge.model

import global.vigil.codechallenge.model.core.Types.*

import java.time.Instant

case class Post(id: PostId, content: Content, image: Option[String], date: Instant, author: UserId)
