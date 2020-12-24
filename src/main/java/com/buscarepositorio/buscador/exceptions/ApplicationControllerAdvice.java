package com.buscarepositorio.buscador.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.buscarepositorio.buscador.exceptions.ErrorObject;

public class ApplicationControllerAdvice {
	
	/*
	 * @Autowired private MessageSource messageSource; //Deve estar ativado para usar interface MessageSource. Injeção do MessageSource
	 */

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex) {
		Map<String, Object> resposta = new HashMap<>();
		resposta.put("mensagem", ex.getReason());
		resposta.put("status", "error");
		resposta.put("code", ex.getStatus().value());
		return ResponseEntity.status(ex.getStatus()).body(resposta);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)//Interceptando uma execessão de método, onde quando enviamos parametros invalidos no corpo da requisição ele é negado.
	public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, Object> resposta = new HashMap<>();
		
		/*   //Devem estar ativados para usar interface MessageSource(Linhas 42 a 50)
		 * List<ErrorObject> errors = new ArrayList<>();
		 * ex.getBindingResult().getFieldErrors().forEach(e->{ errors.add(new
		 * ErrorObject(messageSource.getMessage(e, LocaleContextHolder.getLocale()),
		 * e.getField(),//Locale: De onde o cliente vem, qual a linguagem padrão do
		 * navegador/disposito que mandou essa requisição? A requisição é enviada junto
		 * com um Header, q e.getRejectedValue())); });
		 * 
		 * resposta.put("mensagem", "Argumento inválido"); resposta.put("code", 400);
		 * resposta.put("status", "error"); resposta.put("erros", errors);
		 */
		
		resposta.put("mensagem", "Argumento inválido"); //Deve estar deativados para usar interface MessageSource(Linhas 53 a 59)
		resposta.put("code", 400);
		resposta.put("status", "error");
		resposta.put("erros",
				ex.getBindingResult().getFieldErrors().stream().map(// Mapeando todos os campos que derão erro na REQUISIÇÃO
						error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))//Erros mapeados
						.collect(Collectors.toList()));

		return resposta;
	}

}
