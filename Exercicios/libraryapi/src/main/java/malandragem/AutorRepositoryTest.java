/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package malandragem;
/*
import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.model.GeneroLivro;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author barbo
 */
//@SpringBootTest*/
public class AutorRepositoryTest {
/*
    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livrorepository;

    @Test
    public void salvarTeste() {

        Autor autor = new Autor();
        autor.setNome("Julia");
        autor.setNacionalidade("BR");
        autor.setDataNascimento(LocalDate.of(1995, 8, 15));

        var autorSalvo = repository.save(autor);

        System.out.println("Autor Salvo: " + autorSalvo);

    }

    @Test
    public void atualizartest() {
        var id = UUID.fromString("2ff06e28-fc53-4255-a0f8-82cf241c59ee");

        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autor = possivelAutor.get();

            autor.setDataNascimento(LocalDate.of(1981, 12, 19));
            repository.save(autor);
            System.out.println("Encontrado: " + autor);
        }
    }

    @Test
    public void listarTest() {
        List<Autor> autores = repository.findAll();
        autores.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Quantidade de autores: " + repository.count());
    }

    @Test
    public void deletePorIdTest() {
        var id = UUID.fromString("be17d3f1-ecc4-48b4-bb8c-154319a2007f");

        repository.deleteById(id);
    }

    @Test
    public void deleteTest() {
        var id = UUID.fromString("f125689e-c239-4d76-b091-4cb9928154a9");
        var autor = repository.findById(id).get();
        repository.delete(autor);
    }

    @Test
    void salvarAutorComLivrosTest() {

        Autor autor = new Autor();
        autor.setNome("Valéria");
        autor.setNacionalidade("Uru");
        autor.setDataNascimento(LocalDate.of(1994, 8, 3));

        //Livro
        Livro livro = new Livro();

        livro.setIsbn("76321-7465");
        livro.setPreco(BigDecimal.valueOf(204));
        livro.setDataPublicacao(LocalDate.of(2011, 2, 7));
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setTitulo("Salvo Com autor certo");
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("7894-9090");
        livro2.setPreco(BigDecimal.valueOf(204));
        livro2.setDataPublicacao(LocalDate.of(2017, 8, 14));
        livro2.setGenero(GeneroLivro.MISTERIO);
        livro2.setTitulo("O livro da capa vermelha");
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);

        //Usado para salvar uma lista de registros
        //livrorepository.saveAll(autor.getLivros());
    }
    
    void listarLivrosAutor(){
        var id = UUID.fromString("");
        var autor = repository.findById(id).get();
        
        autor.getLivros().forEach(System.out::println);
    }

    @Test
    void listarLivrosAuto() {
        var id = UUID.fromString("0e71c6e7-252e-487a-abcc-ba40e6c8fa89");
        var autor = repository.findById(id).get();

        //Buscar livros
        List<Livro> livros = livrorepository.findByAutor(autor);
        autor.setLivros(livros);
        autor.getLivros().forEach(System.out::println);
    }
    */
    

}
