package resources;

import java.io.IOException;

import org.testng.annotations.Test;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;


	public class SlackTest {
		
		//private static String webhooksurl="https://hooks.slack.com/services/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";
		private static String webhooksurl="https://hooks.slack.com/services/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";
		
		//private static String outhtoken="xoxb-2374413761331-4399475913479-S0crX2I8bLceTDOsstx7tOJT";
		//private static String slackchannel="qa_automation_results";
		private static String slackchannel="demo";

		@Test
		public static String Sendmessage(String message) throws IOException {

			StringBuilder msgbuilder=new StringBuilder();
			msgbuilder.append(message);
			Payload payload= Payload.builder().channel(slackchannel).iconUrl(message).text(msgbuilder.toString()).build();
			WebhookResponse wbResp= Slack.getInstance().send(webhooksurl, payload);
		return message;	
	  }
	}

