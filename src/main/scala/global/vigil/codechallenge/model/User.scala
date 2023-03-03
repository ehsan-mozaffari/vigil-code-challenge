package global.vigil.codechallenge.model

import global.vigil.codechallenge.model.core.Types.*

import java.time.Instant

case class User(
    id:              UserId,
    name:            Username,
    email:           UserEmail,
    followedUserIds: List[UserId],
    isOnline:        IsOnline
)
