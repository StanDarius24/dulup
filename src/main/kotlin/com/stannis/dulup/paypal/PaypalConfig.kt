package com.stannis.dulup.paypal

import com.paypal.base.rest.APIContext
import com.paypal.base.rest.OAuthTokenCredential
import lombok.Getter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@Getter
class PaypalConfig {

    @Value("\${paypal.client.id}")
    lateinit var clientId: String

    @Value("\${paypal.client.secret}")
    lateinit var clientSecret: String

    @Value("\${paypal.mode}")
    lateinit var mode: String

    @Bean
    fun oAuthTokenCredential(): OAuthTokenCredential {
        return OAuthTokenCredential(clientId, clientSecret, mapOf("mode" to mode))
    }

    @Bean
    fun apiContext(): APIContext {
        return APIContext(clientId, clientSecret, mode)
    }

}