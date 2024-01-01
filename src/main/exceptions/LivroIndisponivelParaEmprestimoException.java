package main.exceptions;

@SuppressWarnings("serial")
public class LivroIndisponivelParaEmprestimoException extends Exception {
	public LivroIndisponivelParaEmprestimoException(String livro)
    {
       super("--->Livro " + livro + " indisponível para empréstimo!");
    }
}