package pSABbyCRC_UnitTestingSuite.usuario.exception;

@SuppressWarnings("serial")
public class UsuarioComNomeVazioException extends Exception {
	public UsuarioComNomeVazioException()
    {
       super("Não pode registrar usuario com nome vazio!");
    }
}
