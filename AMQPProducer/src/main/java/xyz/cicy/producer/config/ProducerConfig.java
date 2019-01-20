package xyz.cicy.producer.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "xyz.cicy.*")
public class ProducerConfig
{
	@Bean
	public ConnectionFactory connectionFactory()
	{
		return new CachingConnectionFactory();
	}

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory)
	{
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory)
	{
		return new RabbitTemplate(connectionFactory);
	}

	@Bean
	public Queue queue()
	{
		return new Queue("queue");
	}

	@Bean
	public FanoutExchange fanoutExchange()
	{
		return new FanoutExchange("fanout");
	}

	@Bean
	public Binding binding(FanoutExchange exchange, Queue queue)
	{
		Binding binding = BindingBuilder.bind(queue).to(exchange);
		return binding;
	}
}
