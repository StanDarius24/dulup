package com.stannis.dulup.view

data class AccountDto(

        var id: Long?,
        var name: String?,
        var email: String?,
        var encryptedPassword: String?,
        var reputation: Long?,
        var orders: List<Long>? = null

)
