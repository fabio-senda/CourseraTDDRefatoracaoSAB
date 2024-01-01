package pSABbyCRC_UnitTestingSuite.usuario.exception;

@SuppressWarnings("serial")
public class BuscaUsuarioComNomeVazioException extends Exception {
	public BuscaUsuarioComNomeVazioException()
    {
       super("--->Nome do usuário é vazio");
    }
}