package xyz.cicy.producer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender
{
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private FanoutExchange exchange;

	public  void send(String message)
	{
		rabbitTemplate.convertAndSend(exchange.getName(),"cc",message);
	}
}
