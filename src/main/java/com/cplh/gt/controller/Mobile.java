package com.cplh.gt.controller;

import com.cplh.gt.bean.QueryPro;
import com.cplh.gt.bean.Test;
import com.cplh.gt.bean.YsInfo;
import com.cplh.gt.service.GtService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 控制器
 * Author: liuhongli.
 * Date: 2018/11/5
 */
//swagger api 标明这个方法需要生成文档
@Api(value = "现场验收 展示调用controller",description = "现场验收 展示调用controller",hidden = true)
//标明这是个controller 并且返回的都是json数据
@RestController
public class Mobile {
	Logger logger = LoggerFactory.getLogger(Mobile.class);
	@Autowired
	GtService gtService;
	@Autowired
	RabbitTemplate rabbitTemplate;

	//swagger  api 描述方法的简介和详情
	@ApiOperation(value = "默认调用接口", notes = "测试发布状态")
	//swagger api 标明文档中所列的返回值的状态码 返回信息 与返回值的类型
	@ApiResponses({
			@ApiResponse(code = 200,message = "成功",response = String.class),
			@ApiResponse(code = 201,message = "成功",response = String.class),
			@ApiResponse(code = 202,message = "成功",response = String.class)
	})
	//拦截post请求
	@PostMapping({"/index.html", "/", "/index"})
	@ResponseBody
	public String index() {
		return "连接成功";
	}





	@ApiOperation(value = "测试缓存接口", notes = "缓存查询数据")
	//swagger api 定义需要输入的参数 参数名 说明 是否必须 参数类型 参数传输方式
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int", paramType = "path")
	})
	@GetMapping(value = {"/main/{id}"})
	@ResponseBody
	public Test indexAaa(@PathVariable Integer id) {

		Test a = gtService.getTest(id);
		rabbitTemplate.convertAndSend("test.fanout","123",a);
		System.out.println();
		return a;

	}

	//rabbitmq 的监听  监听test1队列 当队列中有数据时 自动调用 并消费消息
	@RabbitListener(queues = "test1")
	public void receive1(Test a){
		System.out.println("1收到信息了");
		System.out.println(a);

	}
	@RabbitListener(queues = "test1")
	public void receive2(Test a){
		System.out.println("2收到信息了");
		System.out.println(a);

	}

	/**
	 * 查询所有工作中工序的接口
	 * 取当前时间前一分钟的数据为准
	 * restful传递机组
	 *
	 * @param jz
	 */
	@ApiOperation(value = "查询所有工序接口", notes = "查询所有工序接口")
	//hystrix 熔断器api  标明触发熔断是调用什么方法 和超时调用时间 默认貌似是一秒
	//@HystrixCommand(fallbackMethod = "Fail1", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	@PostMapping("/queryPro")
	@ResponseBody
	public QueryPro queryPro() {
		long l = System.currentTimeMillis();

		logger.info("查询所有工序");
		QueryPro queryPro = gtService.queryPro();
		long l2= System.currentTimeMillis();
		long l1 = l2 - l;
		queryPro.set_MSG_(String.valueOf(l1));
		return queryPro;
	}

	/**
	 * 查询具体数据的接口
	 *
	 * @param jz
	 * @param code
	 */
	//@HystrixCommand(fallbackMethod = "Fail2", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	@ApiOperation(value = "查询具体数据的接口", notes = "查询具体数据的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "weldCode", value = "焊口标号", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "hjCode", value = "焊机编号", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "layer", value = "焊接工序", required = true, dataType = "String", paramType = "path")
	})

	@PostMapping("/clickPro/{weldCode}/{hjCode}/{layer}")
	@ResponseBody
	public QueryPro clickPro(@PathVariable("layer") String layer, @PathVariable("hjCode") String hjCode, @PathVariable("weldCode") String weldCode) {
		long l = System.currentTimeMillis();

		logger.info("查询工序详细数据接口,当前查询为" + layer + " 工序的 " + hjCode + "焊机" + weldCode + "焊口");
		QueryPro queryPro = gtService.clickPro(layer, hjCode, weldCode);
		long l2= System.currentTimeMillis();
		long l1 = l2 - l;
		queryPro.set_MSG_(String.valueOf(l1));
		return queryPro;
	}

	/**
	 * 返回验收所有数据的接口
	 *
	 * @param weld_code
	 */
	//@HystrixCommand(fallbackMethod = "Fail3", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	@ApiOperation(value = "返回验收所有数据的接口", notes = "返回验收所有数据的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "weldCode", value = "焊口标号", required = true, dataType = "String", paramType = "path",example = "123")
	})
	@PostMapping("/info/{weldCode}")
	@ResponseBody
	public YsInfo info(@PathVariable("weldCode") String weldCode) {
		long l = System.currentTimeMillis();
		logger.info("查询验收详细数据接口,当前查询焊口为" + weldCode);
		YsInfo queryPro = gtService.info(weldCode);
		long l2= System.currentTimeMillis();
		long l1 = l2 - l;
		queryPro.set_msg_(String.valueOf(l1));
		return queryPro;
	}

	/**
	 * 同步焊口 工艺规程关系到机组
	 *
	 * @param weld_code
	 * @param pr_no
	 */
	@ApiOperation(value = "同步焊口 工艺规程关系到机组", notes = "同步焊口 工艺规程关系到机组")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "weldCode", value = "焊口标号", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "prNo", value = "工艺规程编号", required = true, dataType = "String", paramType = "path")
	})
	@PostMapping("/sys/{weldCode}/{prNo}")
	@ResponseBody
	//@HystrixCommand(fallbackMethod = "Fail4", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	public QueryPro sysWeldPro(@PathVariable String weldCode, @PathVariable String prNo) throws InterruptedException {
		logger.info("同步焊口 工艺规程接口 焊口：" + weldCode + " 工艺规程：" + prNo);
		QueryPro queryPro = gtService.sysWeldPro(weldCode, prNo);
		return queryPro;
	}


	/**
	 * 错误调用方法
	 *
	 * @return
	 */
	//swagger api 忽略该方法 不会再文档中展示该方法
	@ApiIgnore
	public QueryPro Fail1() {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

	@ApiIgnore
	public QueryPro Fail2(@PathVariable String layer, @PathVariable String hj_code, @PathVariable String weldCode) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

	@ApiIgnore
	public QueryPro Fail3(@PathVariable String weld_code, @PathVariable String flag) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

	@ApiIgnore
	public QueryPro Fail4(@PathVariable String weld_code, @PathVariable String pr_no) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}


	// 定时任务注解 从任意时间开始 每秒调用一次 周一到周末循环
	@Scheduled(cron = "*/1 * * * * 0-7")
	public void TestSeduch() {
		System.out.println("123");
	}

}
