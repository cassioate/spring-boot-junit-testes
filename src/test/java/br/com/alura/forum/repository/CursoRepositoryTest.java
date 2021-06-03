package br.com.alura.forum.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository repository;

	@Test
	void deveriaCarregarUmCursoAoBuscarPeloNome() {
		String nomeCurso = "HTML 5";
		Curso curso = repository.findByNome(nomeCurso);
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());
		
	}

	@Test
	void naoDeveriaCarregarUmCursoAoBuscarPeloNome() {
		String nomeCurso = "HTML 1";
		Curso curso = repository.findByNome(nomeCurso);
		Assert.assertNull(curso);
	}
}
