package br.edu.devmedia.crud.bo;

import java.util.HashMap;
import java.util.Map;

import br.edu.devmedia.comum.MensagensConstantes;
import br.edu.devmedia.crud.dto.CidadeDTO;
import br.edu.devmedia.crud.dto.PessoaDTO;
import br.edu.devmedia.crud.exception.NegocioException;
import br.edu.devmedia.crud.validator.CPFValidator;
import br.edu.devmedia.crud.validator.DataValidator;

/**
 * Classe responsável por gerenciar os métodosde negócios da aplicação do pessoa
 * @author KB-01
 *
 */
public class PessoaBO {

	/**
	 * Método responsável por validar a pessoa
	 * @param request
	 * @return
	 * @throws NegocioException 
	 */
	public boolean validarPessoa(PessoaDTO pessoaDTO) throws NegocioException {
		
		boolean isValido = true;
		try {
			
			//Valida campos obrigatórios
			
			if (pessoaDTO.getNome() == null || "".equals(pessoaDTO.getNome())){
				throw new NegocioException(MensagensConstantes.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "Nome"));
			}
			
			Map<String, Object> valores = new HashMap<>();
			valores.put("CPF", pessoaDTO.getCpf());
			if (new CPFValidator().validar(valores)) {
				isValido = true;
			}
			
			valores = new HashMap<>();
			valores.put("Data Nascimento", pessoaDTO.getDtNasc());
			if (new DataValidator().validar(valores)) {
				isValido = true;
			}
			
			if (pessoaDTO.getSexo() == ' '){
				throw new NegocioException(MensagensConstantes.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "Sexo"));
			}

			CidadeDTO cidade = pessoaDTO.getEndereco().getCidade();
			if (cidade.getUf().getIdUF() == null) {
				throw new NegocioException(MensagensConstantes.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "Estado"));
			}
			
			if (cidade.getIdCidade() == null){
				throw new NegocioException(MensagensConstantes.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "Cidade"));
			}
			
			
			if (pessoaDTO.getEndereco().getLogradouro() == null || "".equals(pessoaDTO.getEndereco().getLogradouro())) {
				throw new NegocioException(MensagensConstantes.MSG_ERRO_CAMPO_OBRIGATORIO.replace("?", "Logradouro"));
			}

			if (!isValido) {
				throw new NegocioException(MensagensConstantes.MSG_ERRO_PESSOA_DADOS_INVALIDOS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return isValido;
	}
}
