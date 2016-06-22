package qianfeng.httplib;

import java.util.HashMap;

/**
 * Created by wukai on 16/6/20.
 */
abstract public class Request<T> {

	private String url;

	private Method method;

	private Callback<T> callback;


	public Request(String url, Method method,Callback<T> callback) {
		this.url = url;
		this.method = method;
		this.callback = callback;
	}


	public  enum Method{
		GET,POST
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public void onError(Exception e) {
		callback.onError(e);
	}

	public void onResponse(byte[] res){
		callback.onResponse(getContent(res));
	}


	public static interface  Callback<T>{

		 void onError(Exception e);
		 void onResponse(T response);
	}


	public HashMap<String,String> getPostParams(){
		return null;
	}

	abstract public T getContent(byte[] content);
}
