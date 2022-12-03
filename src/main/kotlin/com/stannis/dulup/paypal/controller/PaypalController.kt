package com.stannis.dulup.paypal.controller

import com.paypal.api.payments.Payment
import com.paypal.base.rest.PayPalRESTException
import com.stannis.dulup.paypal.model.Order
import com.stannis.dulup.paypal.services.PaypalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class PaypalController {

    @Autowired
    private lateinit var paypalService: PaypalService

    val SUCCESS_URL = "pay/success"
    val CANCEL_URL = "pay/cancel"

    @GetMapping("/")
    fun home(): String? {
        return "home"
    }

    @PostMapping("/pay")
    fun payment(@ModelAttribute("order") order: Order): String? {
        try {
            val payment: Payment = paypalService.createPayment(
                order.price, order.currency, order.method,
                order.intent, order.description, "http://localhost:9090/$CANCEL_URL",
                "http://localhost:9090/$SUCCESS_URL"
            )
            for (link in payment.links) {
                if (link.rel.equals("approval_url")) {
                    return "redirect:" + link.href
                }
            }
        } catch (e: PayPalRESTException) {
            e.printStackTrace()
        }
        return "redirect:/"
    }

    @GetMapping(value = ["pay/cancel"])
    fun cancelPay(): String? {
        return "cancel"
    }

    @GetMapping(value = ["pay/success"])
    fun successPay(@RequestParam("paymentId") paymentId: String?, @RequestParam("PayerID") payerId: String?): String? {
        try {
            val payment: Payment? = paymentId?.let { payerId?.let { it1 -> paypalService.executePayment(it, it1) } }
            payment?.let {
                println(payment.toJSON())
                if (payment.state == "approved") {
                    return "success"
                }
            }
        } catch (e: PayPalRESTException) {
            println(e.message)
        }
        return "redirect:/"
    }

}