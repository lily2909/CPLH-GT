package com.cplh.gt.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: liuhongli.
 * Date: 2019/3/25
 * json操作相关工具类
 */
public class JsonUtil {
	Logger logger = LoggerFactory.getLogger(JsonUtil.class);


	private static ObjectMapper mapper = new ObjectMapper();


	static {
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		//设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * 将对象转化为json串
	 * @param o
	 * @return
	 */
	public static String object2Json(Object o) {
		if (o == null)
			return null;

		String s = null;

		try {
			s = mapper.writeValueAsString(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 将集合转化为json串
	 * @param objects
	 * @param <T>
	 * @return
	 */
	public static <T> List<String> listObject2ListJson(List<T> objects) {
		if (objects == null)
			return null;

		List<String> lists = new ArrayList<String>();
		for (T t : objects) {
			lists.add(JsonUtil.object2Json(t));
		}

		return lists;
	}

	/**
	 * 将包含集合的json串转化为json对象
	 * @param jsons
	 * @param c
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> listJson2ListObject(List<String> jsons, Class<T> c) {
		if (jsons == null)
			return null;

		List<T> ts = new ArrayList<T>();
		for (String j : jsons) {
			ts.add(JsonUtil.json2Object(j, c));
		}

		return ts;
	}


	/**
	 * 将json串转化为指定对象
	 * @param json
	 * @param c
	 * @param <T>
	 * @return
	 */
	public static <T> T json2Object(String json, Class<T> c) {
		if (StringUtils.hasLength(json) == false)
			return null;

		T t = null;
		try {
			t = mapper.readValue(json, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}


	/**
	 *
	 * @param json
	 * @param tr
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2Object(String json, TypeReference<T> tr) {
		if (StringUtils.hasLength(json) == false)
			return null;

		T t = null;
		try {
			t = (T) mapper.readValue(json, tr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) t;
	}
}
