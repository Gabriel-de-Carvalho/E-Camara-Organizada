package com.camara.demo.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
public class KafkaProducerConfig {
 
    @Autowired
    private KafkaTopicConfig kafkaTopicConfig;
	
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
    private final String topicName = "ementa";
    
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          kafkaTopicConfig.getBootStrap());
        configProps.put(
          ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
          StringSerializer.class);
        configProps.put(
          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
          StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }
 
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

     
    public void sendMessage(String message) {
    	ListenableFuture<SendResult<String, String>> future = 
    		      kafkaTemplate.send(topicName, message);
    		     
    		    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
    		 
    		        @Override
    		        public void onSuccess(SendResult<String, String> result) {
    		            System.out.println("Sent message=[" + message + 
    		              "] with offset=[" + result.getRecordMetadata().offset() + "]");
    		        }
    		        @Override
    		        public void onFailure(Throwable ex) {
    		            System.out.println("Unable to send message=["
    		              + message + "] due to : " + ex.getMessage());
    		        }
    		    });
    }   
}