package main.exceptions;

@SuppressWarnings("serial")
public class TituloOuAutorNuloException extends Exception {
	public TituloOuAutorNuloException(String message)
    {
       super(message);
    }
}