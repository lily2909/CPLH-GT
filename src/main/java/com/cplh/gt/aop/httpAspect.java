package com.cplh.gt.aop;

import com.cplh.gt.bean.ConFfZp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author: liuhongli.
 * Date: 2019/3/25
 * 测试aop开发
 * try {
 *        //@Before
 *        result = method.invoke(target, args);
 *        //@After
 *        return result;
 *    } catch (InvocationTargetException e) {
 *        Throwable targetException = e.getTargetException();
 *        //@AfterThrowing
 *        throw targetException;
 *    } finally {
 *        //@AfterReturning
 *    }
 *
 */
@Aspect
@Component
public class httpAspect {
	Logger logger = LoggerFactory.getLogger(httpAspect.class);


	//定义公共切点
	//public 任意返回值  指定类中的任意方法签名的方法
	@Pointcut("execution(public * com.cplh.gt.controller.Mobile.*(..))")
	public void tes() {
	}
	//指定切入点为transferFile 方法
	@Pointcut("execution(public * com.cplh.gt.controller.Mobile.transferFile(..))")
	public void tes1() {
	}


	//前置通知 可以更改入参
	@Before("tes()")
	public void test1(JoinPoint joinPoint) {
		//获取参数列表 判断参数类型 更改对应参数的值
		Object[] args = joinPoint.getArgs();
		for (Object argItem : args) {
			System.out.println("---->now-->argItem:" + argItem);
			if (argItem instanceof ConFfZp) {
				ConFfZp paramVO = (ConFfZp) argItem;
				paramVO.setEquipCode("更改参数值");
			}
			System.out.println("---->after-->argItem:" + argItem);
		}

		//获取request中的信息
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url={}", request.getRequestURI());

		//method
		logger.info("method={}", request.getMethod());

		//ip
		logger.info("ip={}", request.getRemoteAddr());


		//获取方法详细信息
		//method
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

	}

	//后置通知
	//@After("tes()")
	public void doAfter() {
		System.out.println(123);
	}

	//环绕通知 可以控制目标方法是否执行  多用来做权限控制 事务等 可以控制返回值
	@Around("tes1()")
	public Object test2(ProceedingJoinPoint joinPoint) throws Throwable {
		//执行方法
		Object proceed = joinPoint.proceed();
		System.out.println(44444+proceed.toString());
		return proceed;
	}

/**
 * 后置返回通知
 * 这里需要注意的是:
 * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
 * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
 * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
*/
	@AfterReturning(returning = "obj", pointcut = "tes()")
	public void doAfterReturnig(JoinPoint joinPoint, Object obj) {
		logger.info("reponse={}", obj);
	}


}
