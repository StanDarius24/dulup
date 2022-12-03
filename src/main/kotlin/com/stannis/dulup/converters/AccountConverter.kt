package com.stannis.dulup.converters

import com.stannis.dulup.entity.Account
import com.stannis.dulup.services.OrderService
import com.stannis.dulup.view.AccountDto
import org.springframework.stereotype.Service

@Service
class AccountConverter {

    fun toEntity(accountDto: AccountDto, orderService: OrderService): Account {
        val account = Account()
        accountDto.name?.let { account.name = it }
        accountDto.email?.let { account.email = it }
        accountDto.encryptedPassword?.let { account.encryptedPassword = it }
        accountDto.reputation?.let { account.reputation = it }
        account.orders = ArrayList()
        accountDto.orders?.forEach { orderService.findById(it).ifPresent { order -> account.orders?.add(order) } }

        return account
    }

    fun toDto(newAccount: Account): AccountDto {
        return AccountDto(
                newAccount.id,
                newAccount.name,
                newAccount.email,
                newAccount.encryptedPassword,
                newAccount.reputation,
                newAccount.orders?.map { it.id }
        )
    }

}