package com.stannis.dulup.controller

import com.stannis.dulup.services.AccountService
import com.stannis.dulup.view.AccountDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AccountController {

    @Autowired
    private lateinit var accountService: AccountService

    @GetMapping("/accounts")
    fun getAll(): List<AccountDto> = try {
        accountService.getAllAccounts()
    } catch (e: Exception) {
        throw e
    }

    @GetMapping("/accounts/{id}")
    fun getAccountById(@PathVariable id: Long): AccountDto = try {
        accountService.getAccountById(id)
    } catch (e: Exception) {
        throw e
    }

    @PostMapping("/account")
    fun createAccount(account: AccountDto): AccountDto = try {
        accountService.createAccount(account)
    } catch (e: Exception) {
        throw e
    }

}