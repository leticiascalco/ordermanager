package com.example.ordermanager.adapters.out.repository

import com.example.ordermanager.application.core.domain.Order
import com.example.ordermanager.application.ports.out.OrderRepository
import org.springframework.stereotype.Component
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse
import java.util.concurrent.CompletableFuture

@Component
class OrderRepositoryImpl(private val dynamoDbAsyncClient: DynamoDbAsyncClient) : OrderRepository {

    override fun isProcessed(orderId: String): Boolean {
        val request = GetItemRequest.builder()
            .tableName("OrdersTable")
            .key(mapOf("id" to AttributeValue.builder().s(orderId).build()))
            .build()

        val response = dynamoDbAsyncClient.getItem(request).get()
        return response.hasItem()
    }

    override fun save(order: Order): CompletableFuture<PutItemResponse> {
        val request = PutItemRequest.builder()
            .tableName("OrdersTable")
            .item(mapOf(
                "id" to AttributeValue.builder().s(order.id).build(),
                "content" to AttributeValue.builder().s(order.content).build()
            ))
            .build()

        return dynamoDbAsyncClient.putItem(request)
    }
}
