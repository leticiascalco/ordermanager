package com.example.ordermanager.application.ports.out

interface KafkaProducer {
    fun send(key: String, message: String)
}
