package com.glureau.minikard.data

import java.util.*

data class CommentDomain(
    val id: String,
    val authorFirstName: String,
    val authorLastName: String,
    val authorAvatarUrl: String?,
    val createdAt: Date,
    val content: String?,
)
