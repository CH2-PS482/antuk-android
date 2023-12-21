package com.antukcapstone.antuk.core.data.local.datastore

data class UserModel(
    val idUser: String,
    val fullName: String,
    val phoneNumber: String,
    val token: String,
    val isLoggedIn: Boolean = false
)