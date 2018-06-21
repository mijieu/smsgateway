package cm.camerpay.sms;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;

import static cm.camerpay.sms.util.Util.*;

import java.util.Map;

public class SendMessage {

    public static void main(String[] args) throws Exception {
        configureLogging();            
        
//        String NEXMO_API_KEY = envVar("API_KEY");
//        String NEXMO_API_SECRET = envVar("API_SECRET");
//        String TO_NUMBER = envVar("TO_NUMBER");      
        String NEXMO_API_KEY = "d3d3db4a";
        String NEXMO_API_SECRET = "NUcQr3KKK95Y3GX7";
        String TO_NUMBER = "237696521490";
        String money = "237657049046";

        AuthMethod auth = new TokenAuthMethod(NEXMO_API_KEY, NEXMO_API_SECRET);
        NexmoClient client = new NexmoClient(auth);

        SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage(
                "CAMERPAY",
                TO_NUMBER,
                "Slt Clarkson c'est un Test. confirme le reception par WhatsApp. Doudou"));
        for (SmsSubmissionResult response : responses) {
            System.out.println(response);
        }
    }
}
