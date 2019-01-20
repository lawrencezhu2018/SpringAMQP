package xyz.cicy.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.cicy.producer.config.ProducerConfig;

public class Producer
{

	public static void main(String[] args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(ProducerConfig.class);
		MessageSender messageSender=context.getBean(MessageSender.class);
		messageSender.send("hello,cc");
	}


}
