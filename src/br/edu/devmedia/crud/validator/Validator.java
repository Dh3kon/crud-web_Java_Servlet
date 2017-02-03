package br.edu.devmedia.crud.validator;

import java.util.Map;

/*
 * Respons�vel por validar todos os tipos de valores do sistema
 */

import br.edu.devmedia.exceptions.ValidationException;

public interface Validator {

	/*
	 * M�todo efetivo de valida��o que recebe o mapa com os valores e os nomes
	 */
	public boolean validar(Map<String, Object> valores ) throws ValidationException, br.edu.devmedia.crud.exception.ValidationException;
	
	
}
