package main.exceptions;

@SuppressWarnings("serial")
public class UsuarioInexistenteException extends Exception {
	public UsuarioInexistenteException()
    {
       super("Não pode registrar usuario inexistente!");
    }
}
