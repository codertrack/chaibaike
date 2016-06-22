package qianfeng.httplib;

/**
 * Created by wukai on 16/6/21.
 */
public class StringRequest extends Request<String> {

	public StringRequest(String url, Method method, Callback callback) {
		super(url, method, callback);
	}

	@Override
	public String getContent(byte[] content) {
		return new String(content);
	}


}
