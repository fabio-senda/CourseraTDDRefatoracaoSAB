package main.exceptions;

@SuppressWarnings("serial")
public class BuscaUsuarioComNomeNuloException extends Exception {
	public BuscaUsuarioComNomeNuloException()
    {
       super("--->Nome do usuário é nulo");
    }
}