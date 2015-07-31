/**
 * 
 */
package qa.qcri.aidr.predict.common;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * @author Latika
 * TODO centralize in all modules
 */
public class TaggerErrorLog {

	private static Logger logger = Logger.getLogger(TaggerErrorLog.class);
	
	public static void sendErrorMail(String code, String errorMsg) {
		Response clientResponse = null;
		Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
		try {
			WebTarget webResource = client.target(TaggerConfigurator.getInstance()
					.getProperty(TaggerConfigurationProperty.TAGGER_API) + "/misc/sendErrorEmail");
			
			Form form = new Form();
			form.param("module", "AIDRTagger");
			form.param("code", code);
			form.param("description", errorMsg);
			
			clientResponse = webResource.request().post(
					Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
			if (clientResponse.getStatus() != 200) {
				logger.warn("Couldn't contact AIDRTaggerAPI for sending error message");
			}
		} catch (Exception e) {
			logger.error("Error in contacting AIDRTaggerAPI: " + clientResponse);
		}
	}
}
