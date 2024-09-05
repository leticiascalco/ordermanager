package com.example.ordermanager.application.core.domain

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory

data class Order(
    val id: String,
    val content: String
) {
    companion object {
        private val objectMapper = jacksonObjectMapper()
        private val logger = LoggerFactory.getLogger(Order::class.java)

        fun fromMessage(message: String): Order {
            if (message.isBlank()) {
                logger.error("Mensagem JSON vazia ou em branco recebida")
                throw IllegalArgumentException("Mensagem inválida: JSON vazio ou em branco")
            }
            return try {
                objectMapper.readValue<Order>(message)
            } catch (e: Exception) {
                logger.error("Falha ao converter mensagem JSON: $message", e)
                throw IllegalArgumentException("Mensagem inválida: não é possível converter para Order", e)
            }
        }

        fun fromObject(order: Order): String {
            return objectMapper.writeValueAsString(order)
        }
    }

    fun process(): Order {
        return this.copy(content = this.content.uppercase())
    }

    fun toUpperCaseMessage(): String {
        return objectMapper.writeValueAsString(this)
    }
}
