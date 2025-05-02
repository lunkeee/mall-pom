package org.example.common.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange("order.exchange", true, false);
    }

    @Bean
    public Queue myQueue() {
        // 参数说明：队列名, 是否持久化
        return new Queue("myQueue", true);
    }

    @Bean
    public Queue myQueue2() {
        // 参数说明：队列名, 是否持久化
        return new Queue("myQueue2", true);
    }


}
