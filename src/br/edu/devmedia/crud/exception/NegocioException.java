package br.edu.devmedia.crud.exception;

/**
 * Classe respons�vel por gerenciar as excess�es da camada de neg�cio
 * @author KB-01
 *
 */
public class NegocioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException(Exception e) {
		super(e.getMessage());
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
}
