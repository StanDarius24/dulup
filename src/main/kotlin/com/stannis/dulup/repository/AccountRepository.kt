package com.stannis.dulup.repository

import com.stannis.dulup.entity.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: CrudRepository <Account, Long> {

}