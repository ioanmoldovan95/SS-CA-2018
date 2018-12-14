package com.ca.ss2018.model

data class Participant(
    val timestamp: String = "",
    val username: String = "",
    val name: String = "",
    val phoneNumber: String = "",
    val county: String = "",
    val city: String = "",
    val addressLine: String = "",
    val postalCode: String = "",
    val fbProfile: String = "",
    val description: String = "",
    val whishlist: String = "",
    val give: Boolean = false,
    val receive: Boolean = false
)