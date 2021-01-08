package com.PaymentApi.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Configuration
public class APIConfiguration {

	@Value("${paypal.client.id}")
	private String clientId;

	@Value("${paypal.client.secret}")
	private String clientpwd;

	@Value("${paypal.mode}")
	private String mode;

	@Bean
	public Map<String, String> sdkConfig() {
		Map<String, String> sdkConfigMap = new HashMap<>();
		sdkConfigMap.put("mode", mode);
		return sdkConfigMap;
	}

	@Bean
	public OAuthTokenCredential authTokenCredential() {
		return new OAuthTokenCredential(clientId, clientpwd, sdkConfig());
	}

	@Bean
	public APIContext apiContext() throws PayPalRESTException {
		APIContext context = new APIContext(authTokenCredential().getAccessToken());
		context.addConfigurations(sdkConfig());
		return context;
	}
	
	
}
