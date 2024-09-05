package com.example.ordermanager.config

import com.example.ordermanager.application.core.usecase.OrderServiceImpl
import com.example.ordermanager.application.ports.`in`.OrderService
import com.example.ordermanager.application.ports.out.OrderRepository
import com.example.ordermanager.application.ports.out.KafkaProducer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun orderService(orderRepository: OrderRepository, kafkaProducer: KafkaProducer): OrderService {
        return OrderServiceImpl(orderRepository, kafkaProducer)
    }
}
