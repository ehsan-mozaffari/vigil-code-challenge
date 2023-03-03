package global.vigil.codechallenge.model.core

/** * Confused types are here
  */
object Types {

  opaque type UserId = Int
  object UserId { def apply(value: Int): UserId = value }
  extension (v: UserId) { def value: Int = v }

  opaque type PostId = Int
  object PostId { def apply(value: Int): PostId = value }
  extension (v: PostId) { def value: Int = v }

  opaque type Content = String
  object Content { def apply(value: String): Content = value }
  extension (v: Content) { def value: String = v }

  opaque type Username = String
  object Username { def apply(value: String): Username = value }
  extension (v: Username) { def value: String = v }

  opaque type UserEmail = String
  object UserEmail { def apply(value: String): UserEmail = value }
  extension (v: UserEmail) { def value: String = v }

  opaque type IsOnline = Boolean
  object IsOnline { def apply(value: Boolean): IsOnline = value }
  extension (v: IsOnline) { def value: Boolean = v }

  opaque type IsRead = Boolean
  object IsRead { def apply(value: Boolean): IsRead = value }
  extension (v: IsRead) { def value: Boolean = v }
}
