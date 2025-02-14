package akeir.order.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

	@Bean
	NewTopic newOrdersTopic() 
	{
		return new NewTopic("new-orders", 3, (short) 1); // 3 partitions - a small size, but can be changed along when needed 
	}
}
