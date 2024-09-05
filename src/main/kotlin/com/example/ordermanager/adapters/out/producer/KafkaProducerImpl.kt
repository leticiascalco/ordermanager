package com.example.ordermanager.adapters.out.producer

import com.example.ordermanager.application.ports.out.KafkaProducer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, String>
) : KafkaProducer {

    override fun send(key: String, message: String) {
        kafkaTemplate.send("output-topic", key, message)
    }
}
