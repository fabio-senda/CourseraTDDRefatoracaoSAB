package main.exceptions;

@SuppressWarnings("serial")
public class UsuarioComNomeVazioException extends Exception {
	public UsuarioComNomeVazioException()
    {
       super("Não pode registrar usuario com nome vazio!");
    }
}
