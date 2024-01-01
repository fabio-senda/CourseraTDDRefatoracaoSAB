package main.exceptions;

@SuppressWarnings("serial")
public class UsuarioJaRegistradoException extends Exception {
	public UsuarioJaRegistradoException(String nomeUsuario)
    {
       super("Já existe usu‡rio com o nome " + nomeUsuario + "! Use outro nome!");
    }
}
