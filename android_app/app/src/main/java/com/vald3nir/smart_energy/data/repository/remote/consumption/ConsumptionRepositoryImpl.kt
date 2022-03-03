package com.vald3nir.smart_energy.data.repository.remote.consumption

import com.hivemq.client.mqtt.datatypes.MqttQos
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client
import com.vald3nir.smart_energy.common.extensions.toConsumptionRealTimeDTO
import com.vald3nir.smart_energy.data.dto.ConsumptionRealTimeDTO
import java.util.*

class ConsumptionRepositoryImpl : ConsumptionRepository {

    private val clientMQTT = Mqtt5Client.builder()
        .identifier(UUID.randomUUID().toString())
        .serverHost(BROKEN_ADDRESS)
        .buildAsync()

    init {
        clientMQTT.connect()
    }

    companion object {
        const val BROKEN_ADDRESS = "broker.hivemq.com"
        const val BROKEN_TOPIC = "/smart_energy/publish/client/a32ab0af-970c-11ec-9779-a463a116a9e2"
    }

    override fun subscriberConsumptionRealTime(
        onResponse: (consumptionRealTimeDTO: ConsumptionRealTimeDTO) -> Unit
    ) {
        clientMQTT.toAsync().subscribeWith()
            .topicFilter(BROKEN_TOPIC)
            .qos(MqttQos.EXACTLY_ONCE)
            .callback(({ message ->
                run {
                    onResponse.invoke(String(message.payloadAsBytes).toConsumptionRealTimeDTO())
                }
            })).send()
    }
}