package main.exceptions;

@SuppressWarnings("serial")
public class DevolveLivroDisponivelParaEmprestimoException extends Exception {
	public DevolveLivroDisponivelParaEmprestimoException(String livro)
    {
       super("---> Tentou devolver livro " + livro + " que está disponível para empréstimo!");
    }
}
