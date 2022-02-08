package com.jiddere.drones.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jiddere.drones.paystack.InitializationRequestDto;
import com.jiddere.drones.paystack.InitializeResponseDto;

@Service
public class InitializeTransactionServiceImp implements InitializeTransactionService {

	private RestTemplate template = new RestTemplate();
	
	@Override
	public InitializeResponseDto initializeTransaction(InitializationRequestDto requestDto) {
		String url = "https://api.paystack.co/transaction/";
		
		HttpHeaders headers = new HttpHeaders();
		String key = "pk_test_429f636cdad699968227da20fe37c503c945f7d2";
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + key);
		
		HttpEntity<InitializationRequestDto> entity = new HttpEntity<>(requestDto, headers);
		ResponseEntity<InitializeResponseDto> responseEntity = 
				template.postForEntity(url, entity, InitializeResponseDto.class);
		
		return responseEntity.getBody();
	}

}
