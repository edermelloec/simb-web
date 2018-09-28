package com.pg2.simbweb.client;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pg2.simbweb.domain.bovino.Ecc;


@Component
public class EccClient {
	BovinoClient bovinoClient = new BovinoClient();
	private RestTemplate restTemplate = new RestTemplate();
	private String URI_BASE = bovinoClient.uri_global+"/ecc";
	
	
	public String deletar(Long codigo){
		
		RequestEntity<Void> request = RequestEntity
				.delete(URI.create(URI_BASE + "/" + codigo))
				.build();
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getStatusCode().toString();
	}


	public String alterar(Ecc ecc) {
		
		RequestEntity<Ecc> request = RequestEntity
				.put(URI.create(URI_BASE))
				.body(ecc);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
		
	}

}
