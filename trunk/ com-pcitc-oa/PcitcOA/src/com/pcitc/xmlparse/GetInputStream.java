package com.pcitc.xmlparse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetInputStream {
	public static String getString(String u){
		InputStream is = getInputStream(u);
		if(is!=null){
			BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
			String s = null;
			try {
				StringBuffer sb = new StringBuffer();
				while((s = bfr.readLine())!=null){
					sb.append(s);
					s=null;
				}
				s = sb.toString();
				is.close();
				bfr.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
		}
		return null;
	}
	public static InputStream getInputStream(String u){
		DefaultHttpClient httpclient = new DefaultHttpClient();
		URL url = null;
		try {
			url = new URL(u);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		httpclient.getAuthSchemes().register(AuthPolicy.NTLM,
				new NTLMSchemeFactory());
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(url.getHost(), url.getPort(),"oasp"),
				new NTCredentials("administrator", "Pcitc2009.",
						url.getHost(), "oasp"));

			HttpGet httpget = new HttpGet(u);
			HttpResponse response;
			try {
				response = httpclient.execute(httpget);
				InputStream is = response.getEntity().getContent();
				return is;
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//return is;

		return null;
	}
}
