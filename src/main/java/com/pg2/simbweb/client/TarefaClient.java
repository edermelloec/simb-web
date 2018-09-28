package com.pg2.simbweb.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pg2.simbweb.domain.tarefa.Tarefa;


@Component
public class TarefaClient {
	BovinoClient bovinoClient = new BovinoClient();
	
	private RestTemplate restTemplate = new RestTemplate();
	private String URI_BASE = bovinoClient.uri_global+"/tarefa";
	
	
	
	public TarefaClient(){
		
	}
	
	public String salvar(Tarefa tarefa){
		
		RequestEntity<Tarefa> request = RequestEntity
				.post(URI.create(URI_BASE))
				.body(tarefa);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
	public String deletar(Long codigo){
		
		RequestEntity<Void> request = RequestEntity
				.delete(URI.create(URI_BASE + "/" + codigo))
				.build();
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getStatusCode().toString();
	}
	
	public String alterar(Tarefa tarefa){
		
		RequestEntity<Tarefa> request = RequestEntity
				.put(URI.create(URI_BASE))
				.body(tarefa);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
	
	public Tarefa listarUma(Long codigo){
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE+ "/" +codigo))
				.build();
		ResponseEntity<Tarefa> response = restTemplate.exchange(request, Tarefa.class);
		return response.getBody();
			
	}
	
	public List<Tarefa> listarAtivas(){
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE+"/ativas"))
				.build();
		ResponseEntity<Tarefa[]> response = restTemplate.exchange(request, Tarefa[].class);
		return Arrays.asList(response.getBody());
			
	}
	
	public List<Tarefa> listarConcluidas(){
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE+"/concluidas"))
				.build();
		ResponseEntity<Tarefa[]> response = restTemplate.exchange(request, Tarefa[].class);
		return Arrays.asList(response.getBody());
			
	}
	
	public List<Tarefa> listarTarefaAtivasPorData(String busca,String tipoBusca){
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE+"/dataAtivas/"+busca+"/"+tipoBusca))
				.build();
		ResponseEntity<Tarefa[]> response = restTemplate.exchange(request, Tarefa[].class);
		return Arrays.asList(response.getBody());
			
	}
	
	public List<Tarefa> listarTarefaConcluidasPorData(String busca,String tipoBusca){
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE+"/dataConcluidas/"+busca+"/"+tipoBusca))
				.build();
		ResponseEntity<Tarefa[]> response = restTemplate.exchange(request, Tarefa[].class);
		return Arrays.asList(response.getBody());
			
	}
	
public List<Tarefa> listarTarefasBovinoMatriz(Long codigo){
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE+"/bovinoMatriz/"+codigo))
				.build();
		ResponseEntity<Tarefa[]> response = restTemplate.exchange(request, Tarefa[].class);
		return Arrays.asList(response.getBody());
			
	}
	
	
	
	
	
	

}

