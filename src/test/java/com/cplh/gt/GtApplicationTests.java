package com.cplh.gt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GtApplicationTests {
	@Autowired
	StringRedisTemplate redisTemplate;
	@Autowired
	RabbitTemplate rabbitTemplatel;

	@Autowired
	AmqpAdmin amqpAdmin;
	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Test
	public void testString (){
		ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
		for (int i = 0; i < 10; i++) {
			stringStringValueOperations.set(String.valueOf(Math.random()),String.valueOf(Math.random()));
		}

	}

	@Test	public void test1(){
		amqpAdmin.declareExchange(new FanoutExchange("amqpadmin.fanout.exchange"));
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
		//public Binding(String destination, Binding.DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments)
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.fanout.exchange","321",null));

		rabbitTemplatel.convertAndSend("amqpadmin.fanout.exchange","666",new com.cplh.gt.bean.Test("4","小汪汪"));
	}

	@Test
	public void testSimpMail(){
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setBcc("290965350@qq.com");
		Date date = new Date();
		date.setMinutes(33);
		simpleMailMessage.setSentDate(date);  //设置发送时间
		simpleMailMessage.setSubject("这里是标题");
		simpleMailMessage.setText("这里是内容");
		simpleMailMessage.setFrom("290965350@qq.com");   //发送地址
		String[] a = {"290965350@163.com","1922293298@qq.com","1273996177@qq.com","1106197024@qq.com"};
		simpleMailMessage.setTo(a);  //接收人
		javaMailSender.send(simpleMailMessage);
	}


	@Test
	public void testMineMail() throws Exception{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setBcc("290965350@163.com");
		mimeMessageHelper.setSubject("这里是标题");
		mimeMessageHelper.setText("<h1 style='color:#F00'> 这是内容</h1>",true);
		mimeMessageHelper.setFrom("290965350@qq.com");   //发送地址
		String[] a = {"lw687a@Outlook.com"};
		String s = MimeUtility.encodeText("这是一个名字特别长的附件", "UTF8", null);  //编码附件名 有字数限制‘
		System.out.println(s);
		mimeMessageHelper.addAttachment(s,new File("E:\\普通文档\\壁纸\\XH~5~69J@E}_P$085@DXNXW.png"));

		mimeMessageHelper.setTo(a);  //接收人
		javaMailSender.send(mimeMessage);
	}




}