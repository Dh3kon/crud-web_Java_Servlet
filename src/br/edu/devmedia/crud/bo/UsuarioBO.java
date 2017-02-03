package br.edu.devmedia.crud.bo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.comum.MensagensConstantes;
import br.edu.devmedia.crud.dao.UsuarioDAO;
import br.edu.devmedia.crud.dto.UsuarioDTO;
import br.edu.devmedia.crud.exception.NegocioException;
import br.edu.devmedia.crud.util.Util;
import br.edu.devmedia.crud.validator.LoginValidator;
import br.edu.devmedia.exceptions.ValidationException;

/**
 * Classe responsável por gerenciar os métodosde negócios da aplicação do usuário
 * @author KB-01
 *
 */
public class UsuarioBO {

	/**
	 * Método responsável por validar o usuário
	 * @param request
	 * @return
	 * @throws NegocioException 
	 */
	public boolean validarUsuario(UsuarioDTO usuarioDTO) throws NegocioException {
		
		boolean isValido = true;
		try {
			
			//Valida campos obrigatórios
			Map<String, Object> valores = new HashMap<>();
			valores.put("Usuario", usuarioDTO.getUsuario());
			valores.put("Senha", usuarioDTO.getSenha());
			if (new LoginValidator().validar(valores)) {
				isValido = true;
			}

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			isValido = usuarioDAO.validarUsuario(usuarioDTO);
			if (!isValido) {
				throw new NegocioException(MensagensConstantes.MSG_ERRO_USUARIO_SENHA_INVALIDOS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return isValido;
	}
}
