package demoZK.services.impl;


import demoZK.model.Report;
import demoZK.model.SaleData;
import demoZK.services.MyService;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
/**
 * Created by Admin on 23.05.2017.
 */

@Service("myService")
@Scope( proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyServiceImpl implements MyService {
	private String url="https://sandbox-secure.unitedthinkers.com/gates/xurl?";
	private static int CONNECT_TIMEOUT = 10 * 1000;
	private static int READ_TIMEOUT = 1 * 60 * 1000;
	private static String EMPTY = "";

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	public String sendPost(String url, SaleData saleData)throws IOException{
		HttpURLConnection conn = null;
		InputStream stream = null;
		URL urlLink = null;
		urlLink = new URL(url);
		OutputStreamWriter writer = null;
		conn = (HttpURLConnection)urlLink.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setConnectTimeout(CONNECT_TIMEOUT);
		conn.setReadTimeout(READ_TIMEOUT);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestMethod("POST");
		writer = new OutputStreamWriter(conn.getOutputStream());
		writer.write(getDataFromModel(saleData));
		writer.flush();
		writer.close();
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			stream = conn.getInputStream();
		} else {
			stream = conn.getErrorStream();
		}
		if (stream == null) {
			System.out.println("Response code is " + conn.getResponseCode());
			return EMPTY;
		}return stream2String(stream);
	}

	private String getDataFromModel(SaleData saleData){
		String amount =Integer.toString(saleData.getAmount());

		String res= "&requestType=sale"
				+ "&userName=829000"
				+ "&password=TestNt62400~"
				+ "&accountId=829001"
				+"&amount="+amount// "&amount=5000"
				+"&accountType=R"
				+"&transactionIndustryType=RE"
				+"&holderType=P"
				+"&holderName="+saleData.getHolderName()
				+"&accountNumber="+saleData.getAccountNumber()
				+"&accountAccessory="+saleData.getAcountAccessory()
				+"&csc="+saleData.getCsc()
				+"cscIndicator=P"
				+"&street="+saleData.getStreet()
				+"&city="+saleData.getCity()
				+"&state="+saleData.getState()
				+"&zipCode="+saleData.getZipCode();
		return  res;
	}

	private  String stream2String(InputStream is) throws IOException{
		StringBuilder sb = new StringBuilder(8192);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = br.readLine())!= null){
			sb.append(line);
		}
		return sb.toString();
	}

	public Report isSaleSuccesfull(SaleData saleData){
     Report report= new Report();
		String success ="providerResponseMessage=Approved" ;
		String responce = null;
		try {
			responce = sendPost(url, saleData);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(responce.indexOf(success) != -1){
		report.setIsSuccsessfull(true);
		report.setResponse(responce);}
		else {
			report.setIsSuccsessfull(false);
			report.setResponse(responce);
		}
			return report;
	}
}




