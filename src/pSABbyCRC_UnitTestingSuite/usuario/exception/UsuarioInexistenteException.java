package pSABbyCRC_UnitTestingSuite.usuario.exception;

@SuppressWarnings("serial")
public class UsuarioInexistenteException extends Exception {
	public UsuarioInexistenteException()
    {
       super("Não pode registrar usuario inexistente!");
    }
}
