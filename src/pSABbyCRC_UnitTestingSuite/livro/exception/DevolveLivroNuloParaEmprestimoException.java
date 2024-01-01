package pSABbyCRC_UnitTestingSuite.livro.exception;

@SuppressWarnings("serial")
public class DevolveLivroNuloParaEmprestimoException extends Exception {
	public DevolveLivroNuloParaEmprestimoException()
    {
       super("--->Não pode emprestar livro inexistente!");
    }
}
