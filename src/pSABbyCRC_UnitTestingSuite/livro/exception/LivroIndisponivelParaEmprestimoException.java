package pSABbyCRC_UnitTestingSuite.livro.exception;

@SuppressWarnings("serial")
public class LivroIndisponivelParaEmprestimoException extends Exception {
	public LivroIndisponivelParaEmprestimoException(String livro)
    {
       super("--->Livro " + livro + " indisponível para empréstimo!");
    }
}