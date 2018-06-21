package cm.camerpay.sms;

import java.io.IOException;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AbstractAuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.numbers.AvailableNumber;
import com.nexmo.client.numbers.SearchNumbersResponse;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;

public class PrototySMS {
	
	final static String API_KEY = "d3d3db4a";
	final static String API_SECRET = "NUcQr3KKK95Y3GX7";
	final static String FROM_NUMBER = "123456";
	final static String TO_NUMBER= "237696521490";
	
	public static void main(String[] a) throws IOException, NexmoClientException {
		AbstractAuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
		NexmoClient client = new NexmoClient(auth);
		SearchNumbersResponse  snrResp = client.getNumbersClient().searchNumbers("CM");
		System.out.println("Number found: " + snrResp.getCount());
		AvailableNumber[] numbers = snrResp.getNumbers();
		System.out.println("numbers: " + numbers);
		for (AvailableNumber resp: numbers) {
			System.out.println("Nr.: " + resp.getMsisdn());
			System.out.println("Cost: " + resp.getCost());
			System.out.println("Type: " + resp.getType());
			System.out.println("Feature: " + resp.getFeatures());
			System.out.println("##############################################################\n");
		}
		
//		System.out.println(FROM_NUMBER);
//
//		SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage(
//		        FROM_NUMBER,
//		        TO_NUMBER,
//		        "Hello Clarkson c'est juste un Text!"));
//		for (SmsSubmissionResult response : responses) {
//		    System.out.println(response);
//		}
	}

}
