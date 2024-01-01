package main.models;

import main.exceptions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Biblioteca {
	private String _nome;
	private int _nrUnico = 0; // _nrUnico > zero!
	private TreeSet<Livro> _repositorioLivros;
	private HashSet<Usuario> _usuarios;

	public Biblioteca(String nome) {
		_nome = nome;
		_repositorioLivros = new TreeSet<Livro>();
		_usuarios = new HashSet<Usuario>();
	}

	private int getNrUnico() {
		// Assumo que cada livro recebe um nrUnico diferente
		return _nrUnico = _nrUnico + 1;
	}

	public int sizeRepositorioLivros() {
		return _repositorioLivros.size();
	}

	public int sizeUsuarios() {
		return _usuarios.size();
	}

	public void adicionaLivroCatalogo(Livro livro) throws AdicionarLivroInexistenteException {
		if(livro == null){
			throw new AdicionarLivroInexistenteException();
		}
		livro.setNrCatalogo(this.getNrUnico());
		_repositorioLivros.add(livro);
	}

	public void registraUsuario(String nome) throws UsuarioJaRegistradoException, UsuarioComNomeVazioException, UsuarioInexistenteException {
		if (nome == null){
			throw new UsuarioInexistenteException();
		}
		if(nome.isEmpty()){
			throw new UsuarioComNomeVazioException();
		}

		Usuario usuario = new Usuario(nome);
		if (_usuarios.contains(usuario)) {
			throw new UsuarioJaRegistradoException(nome);
		}
		_usuarios.add(usuario);
	}

	public void emprestaLivro(Livro livro, Usuario usuario) throws LivroIndisponivelParaEmprestimoException, LivroOuUsuarioNulosException {
		if ((livro == null) && (usuario == null))
			throw new LivroOuUsuarioNulosException("--->Livro e Usu�rio inexistentes!");
		if (livro == null){
			throw new LivroOuUsuarioNulosException("--->N�o pode emprestar livro inexistente!");
		}
		if (usuario == null) {
			throw new LivroOuUsuarioNulosException("--->N�o pode emprestar livro a Usu�rio inexistente!");
		}
		if (livro.getUsuario() == null) {
			usuario.anexaLivroAoUsuario(livro);
			livro.anexaUsuarioAoLivro(usuario);
		} else
			throw new LivroIndisponivelParaEmprestimoException(livro.getTitulo());
	}

	public void devolveLivro(Livro livro) throws DevolveLivroDisponivelParaEmprestimoException, DevolveLivroNuloParaEmprestimoException {
		if (livro == null) {
			throw new DevolveLivroNuloParaEmprestimoException();
		}
		Usuario usuario = livro.getUsuario();
		if (usuario == null) {
			throw new DevolveLivroDisponivelParaEmprestimoException(livro.getTitulo());
		}
		usuario.desanexaLivroDoUsuario(livro);
		livro.desanexaUsuarioDoLivro();
	}

	public Livro buscaLivroPorNrCatalogo(int nrUnico) {
		// nrUnico <= zero devolve nulo: n�o encontrou livro algum!
		Iterator<Livro> iter = _repositorioLivros.iterator();
		while (iter.hasNext()) {
			Livro livro = iter.next();
			if (livro.getNrCatalogo() == nrUnico)
				return livro;
		}
		return null;
	}

	public Livro buscaLivroPorTituloAutor(String titulo, String autor) throws TituloOuAutorVazioException, TituloOuAutorNuloException {
		if ((titulo == null) || (autor == null)) {
			throw new TituloOuAutorNuloException("--->Nome do titulo e/ou do autor �(s�o) nulo(s)<<<");
		}
		if (titulo.isEmpty() || autor.isEmpty()) {
			throw new TituloOuAutorVazioException("--->Nome do titulo e/ou do autor �(s�o) vazio(s)<<<");
		}

		Iterator<Livro> iter = _repositorioLivros.iterator();
		while (iter.hasNext()) {
			Livro livro = (Livro) iter.next();
			if ((livro.getTitulo().equals(titulo)) && (livro.getAutor().equals(autor))) {
				return livro;
			}
		}

		return null;
	}

	public Usuario buscaUsuarioPorNome(String nome) throws BuscaUsuarioComNomeVazioException, BuscaUsuarioComNomeNuloException {
		if ((nome == null)) {
			throw new BuscaUsuarioComNomeNuloException();
		}
		if (nome.isEmpty()) {
			throw new BuscaUsuarioComNomeVazioException();
		}
		Iterator<Usuario> iter = _usuarios.iterator();
		while (iter.hasNext()) {
			Usuario usuario = iter.next();
			if (usuario.getNome().equals(nome)) {
				return usuario;
			}
		}

		return null;
	}

	public void exibeLivrosDisponiveis() {
		System.out.println("Biblioteca: " + _nome);
		System.out.println(">>>Livros Dispon�veis para Empr�stimo<<<");
		if (_repositorioLivros.size() != 0) {
			Iterator<Livro> iter = _repositorioLivros.iterator();
			while (iter.hasNext() == true) {
				Livro livro = (Livro) iter.next();
				if (livro.getUsuario() == null) {
					livro.exibe();
				}
			}
		} else
			System.out.println("---> Nenhum livro no reposit�rio");
		System.out.println("<<< Livros Dispon�veis >>>");
		System.out.println();
	}

	public void exibeLivrosEmprestados() {
		System.out.println("Biblioteca: " + _nome);
		System.out.println(">>>Livros Emprestados<<<");
		if (_repositorioLivros.size() != 0) {
			Iterator<Livro> iter = _repositorioLivros.iterator();
			while (iter.hasNext() == true) {
				Livro livro = (Livro) iter.next();
				if (livro.getUsuario() != null) {
					System.out.println("\t\t"
							+ "--------------------------------------------");
					livro.exibe();
				}
			}
		} else
			System.out.println("---> Nenhum livro no reposit�rio");
		System.out.println("<<< Livros Emprestados >>>");
		System.out.println();
	}

	public void exibeUsuarios() {
		System.out.println("Biblioteca: " + _nome);
		System.out.println(">>>Usu�rios da Biblioteca<<<");
		if (_usuarios.size() != 0) {
			Iterator<Usuario> iter = _usuarios.iterator();
			while (iter.hasNext() == true) {
				Usuario usuario = (Usuario) iter.next();
				usuario.exibe();
			}
		} else
			System.out.println("---> Nenhum usu�rio na Biblioteca");
		System.out.println("<<< Usu�rios >>>");
		System.out.println();
	}
}
