package br.edu.devmedia.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.exception.NegocioException;

/**
 * Interface para o padr�o Command
 * @author KB-01
 *
 */
public interface Command {

	/**
	 * M�todo de execu��odo comando 
	 * @param request
	 * @return
	 * @throws NegocioException
	 */
	public String execute(HttpServletRequest request);
}
