package akeir.discontinued.order.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic newOrdersTopic() 
	{
		return new NewTopic("new-orders", 3, (short) 1); // 3 partitions
	}
	
	@Bean
	public NewTopic processedOrdersTopic()
	{
		return new NewTopic("processed-orders", 3, (short) 1);
	}
}
