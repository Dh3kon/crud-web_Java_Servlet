package br.edu.devmedia.crud.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import br.edu.devmedia.comum.MensagensConstantes;
import br.edu.devmedia.exceptions.ValidationException;

public class LoginValidator implements Validator{

	public boolean validar(Map<String, Object> valores) throws ValidationException{
		
		String msgErro = "";
		for (String key : valores.keySet()) {
			String data = (String) valores.get(key);
			if (data == null || "".equals(data)) {
				msgErro += MensagensConstantes.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", key).concat("<br/>");
			}
			if (!"".equals(msgErro)) {
				throw new ValidationException(msgErro);
			}
		}
		return true;
	}
}

