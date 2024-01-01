package main.exceptions;

public class AdicionarLivroInexistenteException extends Exception {
	public AdicionarLivroInexistenteException()
    {
       super("Não pode adicionar livro inexistente!");
    }
}