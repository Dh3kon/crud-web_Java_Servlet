package br.edu.devmedia.crud.validator;

import java.util.Map;

/*
 * Responsável por validar todos os tipos de valores do sistema
 */

import br.edu.devmedia.exceptions.ValidationException;

public interface Validator {

	/*
	 * Método efetivo de validação que recebe o mapa com os valores e os nomes
	 */
	public boolean validar(Map<String, Object> valores ) throws ValidationException, br.edu.devmedia.crud.exception.ValidationException;
	
	
}
