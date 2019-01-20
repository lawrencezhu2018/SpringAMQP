package xyz.cicy.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.cicy.consumer.config.ConsumerConfig;

public class Consumer
{
	public static void main(String[] args)
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(ConsumerConfig.class);
	}
}
