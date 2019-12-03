package kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;

public class KafkaTopicConfig {
	
	 @Value(value = "${kafka.bootstrapAddress}")
	 public static String bootstrapAddress;
	 
	 @Bean
	    public KafkaAdmin kafkaAdmin() {
	        Map<String, Object> configs = new HashMap<>();
	        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
	        return new KafkaAdmin(configs);
	    }
	 
	 @Bean
	    public NewTopic topic1() {
	         return new NewTopic("ementa", 3, (short) 1);
	    }
	 @Bean
	    public NewTopic topic2() {
	         return new NewTopic("lei", 3, (short) 1);
	    }
	 @Bean
	    public NewTopic topic3() {
	         return new NewTopic("complementar", 3, (short) 1);
	    }
}
