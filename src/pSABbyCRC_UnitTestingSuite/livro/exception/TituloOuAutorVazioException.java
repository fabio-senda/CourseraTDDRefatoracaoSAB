package pSABbyCRC_UnitTestingSuite.livro.exception;

@SuppressWarnings("serial")
public class TituloOuAutorVazioException extends Exception {
	public TituloOuAutorVazioException(String message)
    {
       super(message);
    }
}