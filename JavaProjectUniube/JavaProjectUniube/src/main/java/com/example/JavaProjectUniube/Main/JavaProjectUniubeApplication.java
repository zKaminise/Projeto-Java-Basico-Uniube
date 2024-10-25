package com.example.JavaProjectUniube.Main;

import com.example.JavaProjectUniube.Entity.Autor;
import com.example.JavaProjectUniube.Entity.Livro;
import com.example.JavaProjectUniube.Entity.LivroInfantil;
import com.example.JavaProjectUniube.Service.Biblioteca;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaProjectUniubeApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Biblioteca<Livro> bLivros = new Biblioteca<>();
		Biblioteca<Autor> bAutores = new Biblioteca<>();

		while(true) {
			System.out.println("Menu:");
			System.out.println("1. Cadastrar Autor");
			System.out.println("2. Cadastrar Livro");
			System.out.println("3. Cadastrar Livro Infantil");
			System.out.println("4. Listar Autores");
			System.out.println("5. Listar Livros");
			System.out.println("6. Consultar Livro por Título");
			System.out.println("7. Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.println("Nome do Autor:");
					String nomeAutor = scanner.nextLine();
					System.out.println("Nacionalidade do Autor:");
					String nacionalidade = scanner.nextLine();
					Autor autor = new Autor(nomeAutor, nacionalidade);
					bAutores.adicionarItem(autor);
					break;
				case 2:
					System.out.println("Título do Livro:");
					String titulo = scanner.nextLine();
					System.out.println("Nome do Autor:");
					String nomeDoAutor = scanner.nextLine();
					Autor autorDoLivro = bAutores.buscarItem(nomeDoAutor,
							(Autor autorNome, String nome) -> autorNome.getNome().equalsIgnoreCase(nome));

					if (autorDoLivro != null) {
						System.out.println("Ano de Publicação:");
						int anoPublicacao = scanner.nextInt();
						System.out.println("Está disponível? (true/false):");
						boolean disponivel = scanner.nextBoolean();
						scanner.nextLine();
						Livro livro = new Livro(titulo, disponivel, anoPublicacao, autorDoLivro);
						bLivros.adicionarItem(livro);
					} else {
						System.out.println("Autor não encontrado. Cadastre o autor primeiro.");
					}
					break;
				case 3:
					System.out.println("Título do Livro Infantil");
					String tituloInfantil = scanner.nextLine();
					System.out.println("Nome do Autor:");
					String nomeDoAutorInfantil = scanner.nextLine();
					Autor autorDoLivroInfantil = bAutores.buscarItem(nomeDoAutorInfantil,
							(Autor autorNomeInfantil, String nome) -> autorNomeInfantil.getNome().equalsIgnoreCase(nome));

					if (autorDoLivroInfantil != null) {
						System.out.println("Ano de Publicação:");
						int anoPublicacaoInfantil = scanner.nextInt();
						System.out.println("Está disponível? (true/false):");
						boolean disponivelInfantil = scanner.nextBoolean();
						scanner.nextLine();
						System.out.println("Faixa Etária:");
						String faixaEtaria = scanner.nextLine();
						LivroInfantil livroInfantil = new LivroInfantil(tituloInfantil, disponivelInfantil, anoPublicacaoInfantil, autorDoLivroInfantil, faixaEtaria);
						bLivros.adicionarItem(livroInfantil);
					} else {
						System.out.println("Autor Não Encontrado. Cadastre o Autor Primeiro.");
					}
					break;
				case 4:
					System.out.println("Lista de Autores:");
					bAutores.listarItens();
					break;
				case 5:
					System.out.println("Lista de Livros:");
					bLivros.listarItens();
					break;
				case 6:
					System.out.println("Digite o título do livro:");
					String tituloLivro = scanner.nextLine();
					Livro livroEncontrado = bLivros.buscarItem(tituloLivro,
							(Livro l, String t) -> l.getTitulo().equalsIgnoreCase(t));

					if (livroEncontrado != null) {
						System.out.println("Livro encontrado: " + livroEncontrado);
					} else {
						System.out.println("Livro não encontrado.");
					}
					break;
				case 7:
					System.out.println("Saindo...");
					return;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		}
	}

}
