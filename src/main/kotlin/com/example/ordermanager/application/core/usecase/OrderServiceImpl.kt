package com.example.ordermanager.application.core.usecase

import com.example.ordermanager.application.ports.`in`.OrderService
import com.example.ordermanager.application.core.domain.Order
import com.example.ordermanager.application.ports.out.OrderRepository
import com.example.ordermanager.application.ports.out.KafkaProducer

class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val kafkaProducer: KafkaProducer
) : OrderService {

    override fun processMessage(message: String) {
        val order = Order.fromMessage(message)

        //Regra da idempotencia
        if (!orderRepository.isProcessed(order.id)) {
            val processedOrder = order.process()
            orderRepository.save(processedOrder)
            kafkaProducer.send(order.id, processedOrder.toUpperCaseMessage())
        }
    }
}
