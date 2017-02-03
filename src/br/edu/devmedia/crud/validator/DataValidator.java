package br.edu.devmedia.crud.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import br.edu.devmedia.comum.MensagensConstantes;
import br.edu.devmedia.crud.exception.ValidationException;

public class DataValidator implements Validator{

	public boolean validar(Map<String, Object> valores) throws ValidationException{
		
		String msgErro = "";
		for (String key : valores.keySet()) {
			String data = (String) valores.get(key);
			if (!"".equals(data)) {
				try {
					if (data.length() < 10) {
						msgErro += MensagensConstantes.MSG_ERRO_CAMPO_DATA_MENOR_RECOMENDADO.replace("?", key)
								.concat("<br/>");
					}
					if (data.length() > 11) {
						msgErro += MensagensConstantes.MSG_ERRO_CAMPO_DATA_MAIOR_RECOMENDADO.replace("?", key)
								.concat("<br/>");
					}
					new SimpleDateFormat("dd/MM/yyyy").parse(data);
				} catch (ParseException e) {
					msgErro += MensagensConstantes.MSG_ERRO_CAMPO_INVALIDO.replace("?", key).concat("<br/>");
				}
			}			
		}
		if (!"".equals(msgErro)) {
			throw new ValidationException(msgErro);
		}
		return true;
	}
}
