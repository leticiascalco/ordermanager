package com.example.ordermanager.application.ports.out

import com.example.ordermanager.application.core.domain.Order
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse
import java.util.concurrent.CompletableFuture

interface OrderRepository {
    fun isProcessed(orderId: String): Boolean
    fun save(order: Order): CompletableFuture<PutItemResponse>
}
