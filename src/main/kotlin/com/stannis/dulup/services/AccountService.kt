package com.stannis.dulup.services

import com.stannis.dulup.converters.AccountConverter
import com.stannis.dulup.entity.Account
import com.stannis.dulup.repository.AccountRepository
import com.stannis.dulup.view.AccountDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class AccountService {

    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Autowired
    private lateinit var accountConverter: AccountConverter

    @Lazy
    @Autowired
    private lateinit var orderService: OrderService

    fun getAccount(id: Long): Account = accountRepository.findById(id).orElseThrow()

    fun getAccountById(id: Long): AccountDto = getAccount(id).let { accountConverter.toDto(it) }

    fun getAllAccounts(): List<AccountDto> = accountRepository.findAll().map { accountConverter.toDto(it) }.toList()

    fun createAccount(account: AccountDto) : AccountDto {
        val newAccount = accountRepository.save(accountConverter.toEntity(account, orderService))
        return accountConverter.toDto(newAccount)
    }

}