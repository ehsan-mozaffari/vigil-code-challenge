package global.vigil.codechallenge.model

import java.time.Instant

case class Post(id: Int, content: String, image: Option[String], publishDate: Instant, authorId: Int)
//case class Post(id: PostId, content: Content, image: Option[String], publishDate: Instant, authorId: UserId)
//object Post {
//
//  opaque type PostId = Int
//  object PostId {
//    def apply(value:   Int):    PostId      = value
//    def unApply(value: PostId): Option[Int] = Some(value)
//    extension (v:      PostId) { def value: Int = v }
//  }
//
//  opaque type Content = String
//  object Content {
//    def apply(value:   String):  Content        = value
//    def unApply(value: Content): Option[String] = Some(value)
//    extension (v:      Content) { def value: String = v }
//  }
//}
