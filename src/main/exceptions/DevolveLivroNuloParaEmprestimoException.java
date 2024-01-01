package main.exceptions;

@SuppressWarnings("serial")
public class DevolveLivroNuloParaEmprestimoException extends Exception {
	public DevolveLivroNuloParaEmprestimoException()
    {
       super("--->Não pode emprestar livro inexistente!");
    }
}
