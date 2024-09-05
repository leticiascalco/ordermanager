package com.example.ordermanager.adapters.`in`.consumer

import com.example.ordermanager.application.ports.`in`.OrderService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component("customKafkaBatchConsumer")
class KafkaBatchConsumer(
    private val orderService: OrderService
) {

    @KafkaListener(
        topics = ["input-topic"],
        groupId = "ordermanager-group",
        containerFactory = "kafkaListenerContainerFactory"
    )
    fun consume(messages: List<String>) {
        messages.forEach { message ->
            orderService.processMessage(message)
        }
    }
}