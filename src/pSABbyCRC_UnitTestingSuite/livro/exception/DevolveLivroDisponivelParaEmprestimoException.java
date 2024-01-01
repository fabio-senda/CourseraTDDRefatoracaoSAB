package pSABbyCRC_UnitTestingSuite.livro.exception;

@SuppressWarnings("serial")
public class DevolveLivroDisponivelParaEmprestimoException extends Exception {
	public DevolveLivroDisponivelParaEmprestimoException(String livro)
    {
       super("---> Tentou devolver livro " + livro + " que está disponível para empréstimo!");
    }
}
