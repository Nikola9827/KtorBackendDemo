package com.example.backend

import kotlinx.serialization.Serializable

@Serializable
data class HelloResponse (
    val message: String
)