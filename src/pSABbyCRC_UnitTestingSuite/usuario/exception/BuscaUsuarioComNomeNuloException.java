package pSABbyCRC_UnitTestingSuite.usuario.exception;

@SuppressWarnings("serial")
public class BuscaUsuarioComNomeNuloException extends Exception {
	public BuscaUsuarioComNomeNuloException()
    {
       super("--->Nome do usuário é nulo");
    }
}