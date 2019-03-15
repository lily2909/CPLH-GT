package com.cplh.gt;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuhongli.
 * Date: 2019/2/19
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class AliOcrTest {

	/**
	 * 连接阿里ocr图片文字识别功能
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {

		File file = new File("E:\\123.jpg");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		 fileInputStream.read(bytes);
		bytes = Base64.encode(bytes);
		String image = new String(bytes);


		String host = "https://ocrapi-document.taobao.com";
		String path = "/ocrservice/document";
		String method = "POST";
		String appcode = "61088b78c8c84dacb31d9a575f18557f";
		Map<String, String> headers = new HashMap<String, String>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		//根据API的要求，定义相对应的Content-Type
		headers.put("Content-Type", "application/json; charset=UTF-8");
		Map<String, String> querys = new HashMap<String, String>();
		String bodys = "{\"img\":\""+image+"\",\"url\":\"\",\"prob\":false}";

		CloseableHttpClient aDefault = HttpClients.createDefault();

		HttpClient httpClient = wrapClient(host);
		HttpPost request = new HttpPost(buildUrl(host, path, querys));
		for (Map.Entry<String, String> e : headers.entrySet()) {
			request.addHeader(e.getKey(), e.getValue());
		}
		// 在request中添加body post提交参数
		request.setEntity(new StringEntity(bodys, "utf-8"));

		HttpResponse execute = httpClient.execute(request);
		System.out.println(execute.toString());
		prase(EntityUtils.toString(execute.getEntity()));

	}

	/**
	 * 将字符串转换为对象
	 * @param string
	 */
	public static void prase(String string){
		JSONObject jsonObject=JSONObject.parseObject(string);
		JSONArray jsonArray=jsonObject.getJSONArray("prism_wordsInfo");
		for (int i=0;i<jsonArray.size();i++){
			JSONObject newjsonObject=(JSONObject) jsonArray.get(i);
			String word = newjsonObject.getString("word");
			System.out.println(word);

			//output(newjsonObject.getString("word"));
		}
	}

	/**
	 * 返回一个http连接对象
	 * @param host
	 * @return
	 */
	private static HttpClient wrapClient(String host) {
		HttpClient httpClient = new DefaultHttpClient();
		if (host.startsWith("https://")) {
			sslClient(httpClient);
			System.out.println("1123213213123131232132131");

		}

		return httpClient;
	}

	/**
	 * 创建一个ssl的clent
	 * @param httpClient
	 */
	private static void sslClient(HttpClient httpClient) {
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				public void checkClientTrusted(X509Certificate[] xcs, String str) {

				}
				public void checkServerTrusted(X509Certificate[] xcs, String str) {

				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(ctx);
			ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			ClientConnectionManager ccm = httpClient.getConnectionManager();
			SchemeRegistry registry = ccm.getSchemeRegistry();
			registry.register(new Scheme("https", 443, ssf));
		} catch (KeyManagementException ex) {
			throw new RuntimeException(ex);
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 创建url
	 * @param host  主机地址
	 * @param path  连接路径
	 * @param querys    提交参数
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
		StringBuilder sbUrl = new StringBuilder();
		sbUrl.append(host);
		if (!StringUtils.isBlank(path)) {
			sbUrl.append(path);
		}
		if (null != querys) {
			StringBuilder sbQuery = new StringBuilder();
			for (Map.Entry<String, String> query : querys.entrySet()) {
				if (0 < sbQuery.length()) {
					sbQuery.append("&");
				}
				if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
					sbQuery.append(query.getValue());
				}
				if (!StringUtils.isBlank(query.getKey())) {
					sbQuery.append(query.getKey());
					if (!StringUtils.isBlank(query.getValue())) {
						sbQuery.append("=");
						sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
					}
				}
			}
			if (0 < sbQuery.length()) {
				sbUrl.append("?").append(sbQuery);
			}
		}

		return sbUrl.toString();
	}
}

