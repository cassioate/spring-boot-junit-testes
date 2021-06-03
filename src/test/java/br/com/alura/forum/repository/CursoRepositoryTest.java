package br.com.alura.forum.repository;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
//Esse comando faz a mesma coisa do comando na linha abaixo dele.
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager em;

	@Test
	void deveriaCarregarUmCursoAoBuscarPeloNome() {
		//Inserindo curso no banco para ser feito o teste
		Curso html5 = new Curso();
		html5.setNome("HTML 5");
		html5.setCategoria("Programacao");
		em.persist(html5);
		
		//Fazendo a comparação se existe um curso HTML 5 no banco;
		Curso curso = repository.findByNome("HTML 5");
		Assert.assertNotNull(curso);
<<<<<<< HEAD
		Assert.assertEquals(nomeCurso, curso.getNome());
		
=======
		Assert.assertEquals("HTML 5", curso.getNome());
>>>>>>> main
	}

	@Test
	void naoDeveriaCarregarUmCursoAoBuscarPeloNome() {
		String nomeCurso = "HTML 1";
		Curso curso = repository.findByNome(nomeCurso);
		Assert.assertNull(curso);
	}
}
