package main.exceptions;

@SuppressWarnings("serial")
public class TituloOuAutorVazioException extends Exception {
	public TituloOuAutorVazioException(String message)
    {
       super(message);
    }
}