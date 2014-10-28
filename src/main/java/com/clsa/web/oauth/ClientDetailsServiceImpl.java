package com.clsa.web.oauth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * @author clsa This class is user for get client information from database For
 *         this example: client is KFC restaurant
 */
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws OAuth2Exception {
		if (clientId.equals("client1")) {
			List<String> authorizedGrantTypes = new ArrayList<>();
			// This client will have all grant types
			
			authorizedGrantTypes.add("password");
			authorizedGrantTypes.add("refresh_token");
			authorizedGrantTypes.add("client_credentials");
			authorizedGrantTypes.add("authorization_code");
			authorizedGrantTypes.add("implicit");
			
			
			BaseClientDetails clientDetails = new BaseClientDetails();
			//Each client will have a client Id and client secret to identify, it just like user name and password
			clientDetails.setClientId("client1");
			clientDetails.setClientSecret("client1");
			
			// Oauth v2 support scope for each client
			clientDetails.setScope(Arrays.asList("withdraw", "view_balance", "tranfer"));
			clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
			
			// Client must register some call back link, after authorization
			// successful, server will redirect user to there link
			Set<String> uri = new HashSet<String>();
			uri.add("http://localhost:8080/web-client/app/buy");
			clientDetails.setRegisteredRedirectUri(uri);
			return clientDetails;
		} else {
			throw new NoSuchClientException("No client with requested id: " + clientId);
		}
	}
}
