package br.edu.devmedia.crud.validator;

import java.util.Map;

import br.edu.devmedia.comum.MensagensConstantes;
import br.edu.devmedia.crud.exception.ValidationException;
import br.edu.devmedia.crud.util.Util;

public class CPFValidator implements Validator{

	String msgErro = "";
	@Override
	public boolean validar(Map<String, Object> valores) throws ValidationException {
		
		for (String key : valores.keySet()) {
			String cpf = (String) valores.get(key);
			
			if (!"".equals(cpf)) {
				if (Util.isCPF(cpf)) {
					msgErro += MensagensConstantes.MSG_ERRO_CAMPO_INVALIDO.replace("?", key).concat("<br/>");	
				}
				if (cpf.length() < 11) {
					msgErro += MensagensConstantes.MSG_ERRO_CAMPO_CPF_MENOR_RECOMENDADO.replace("?", key).concat("<br/>");	
				}
				if (cpf.length() > 11) {
					msgErro += MensagensConstantes.MSG_ERRO_CAMPO_CPF_MAIOR_RECOMENDADO.replace("?", key).concat("<br/>");	
				}
			} else {
				msgErro += MensagensConstantes.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", key).concat("<br/>");
			}
		}
		
		if (!"".equals(msgErro)) {
			throw new ValidationException(msgErro);
		}
		return false;
	}

	
}
