package pSABbyCRC_UnitTestingSuite.livro.exception;

public class AdicionarLivroInexistenteException extends Exception {
	public AdicionarLivroInexistenteException()
    {
       super("Não pode adicionar livro inexistente!");
    }
}