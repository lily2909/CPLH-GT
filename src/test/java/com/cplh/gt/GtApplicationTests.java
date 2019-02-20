package com.cplh.gt;

import com.alibaba.dubbo.config.annotation.Reference;
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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import com.test.pro.service.UserService;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GtApplicationTests {
	@Autowired
	StringRedisTemplate redisTemplate;
	//@Autowired
	//RedisTemplate redisTemplate1;
	@Autowired
	RabbitTemplate rabbitTemplatel;

	@Reference
	UserService userService;

	@Autowired
	AmqpAdmin amqpAdmin;
	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Test
	public void testString() {
		//String user = userService.getUser();
		//System.out.println(user);
		//ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
		//for (int i = 0; i < 10; i++) {
		//	stringStringValueOperations.set(String.valueOf(Math.random()), String.valueOf(Math.random()));
		//}

	}

	@Test
	public void test1() {
		amqpAdmin.declareExchange(new FanoutExchange("amqpadmin.fanout.exchange"));
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
		//public Binding(String destination, Binding.DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments)
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.fanout.exchange", "321", null));

		rabbitTemplatel.convertAndSend("amqpadmin.fanout.exchange", "666", new com.cplh.gt.bean.Test("4", "小汪汪"));
	}

	@Test
	public void testSimpMail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setBcc("290965350@qq.com");
		Date date = new Date();
		date.setMinutes(33);
		simpleMailMessage.setSentDate(date);  //设置发送时间
		simpleMailMessage.setSubject("这里是标题");
		simpleMailMessage.setText("这里是内容");
		simpleMailMessage.setFrom("290965350@qq.com");   //发送地址
		String[] a = {"290965350@163.com", "1922293298@qq.com", "1273996177@qq.com", "1106197024@qq.com"};
		simpleMailMessage.setTo(a);  //接收人
		javaMailSender.send(simpleMailMessage);
	}


	@Test
	public void testMineMail() throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setBcc("290965350@163.com");
		mimeMessageHelper.setSubject("这里是标题");
		mimeMessageHelper.setText("<h1 style='color:#F00'> 这是内容</h1>", true);
		mimeMessageHelper.setFrom("290965350@qq.com");   //发送地址
		String[] a = {"lw687a@Outlook.com"};
		String s = MimeUtility.encodeText("这是一个名字特别长的附件", "UTF8", null);  //编码附件名 有字数限制‘
		System.out.println(s);
		mimeMessageHelper.addAttachment(s, new File("E:\\普通文档\\壁纸\\XH~5~69J@E}_P$085@DXNXW.png"));

		mimeMessageHelper.setTo(a);  //接收人
		javaMailSender.send(mimeMessage);
	}

	@Test
	public void fileSplit() throws Exception {
		File file = new File("E:\\test\\xdoclet-1.2.1.zip");


		byte[] bytes = new byte[500*1024];
		FileInputStream fis = new FileInputStream(file);
		int a = 1;
		int flag1 = 0;
		//int flag2 = 400;
		while ((flag1 = fis.read(bytes)) != -1) {
			System.out.println(flag1);
			FileOutputStream fos = new FileOutputStream(new File("E:\\test\\xdoclet-1.2.1(" + a + ").zip"));
			fos.write(bytes);
			bytes = new byte[500*1024];
			fos.flush();
			fos.close();
			a++;
		}
		fis.close();


	}

	@Test
	public void fileMerge() throws Exception {
		byte[] bytes = new byte[1000*1024];
		int flag2;

		int nameFlag = 1;
		FileOutputStream fos = new FileOutputStream(new File("E:\\test\\xdoclet-1.2.1(new).zip"));
		while (true) {
			File file = new File("E:\\test\\xdoclet-1.2.1(" + nameFlag + ").zip");
			if(!file.exists())
				break;
			FileInputStream fis = new FileInputStream(file);
			while ((flag2 = fis.read(bytes)) != -1) {
				System.out.println(flag2);
				fos.write(bytes, 0, flag2);
				bytes = new byte[1000*1024];
			}
			nameFlag++;
			fis.close();
		}


		//File file1 = new File("E:\\test\\123(1).txt");
		//FileInputStream fis1 = new FileInputStream(file1);
		//File file2 = new File("E:\\test\\123(2).txt");
		//FileInputStream fis2 = new FileInputStream(file2);


		//while ((flag2 = fis1.read(bytes)) != -1) {
		//	System.out.println(bytes.length);
		//	fos.write(bytes, 0, flag2);
		//	bytes = new byte[1000];
		//}
		//while ((flag2 = fis2.read(bytes)) != -1) {
		//	System.out.println(bytes.length);
		//	fos.write(bytes, 0, flag2);
		//	bytes = new byte[1000];
		//}
		//fis1.close();
		//fis2.close();
		fos.flush();
		fos.close();
	}


}