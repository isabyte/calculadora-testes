package app.servicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Entrada;
import app.entity.Resultado;
import app.service.CalculosService;

@SpringBootTest // contexto do spring nos testes
public class CalculosServiceTest {
	
	@Autowired
	CalculosService calculosService;
	
	@Test // JUNIT - indicação do método de teste
	@DisplayName("Teste unitário - cenário de soma = 10")
	void cenario01() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(4);
		lista.add(2);
		
		int soma = calculosService.somar(lista);
		
		Assertions.assertEquals(10, soma); // JUNIT - verificação - testes em si

	}
	
	@Test
	@DisplayName("Teste unitário - cenário de erro")
	void cenario02() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(4);
		lista.add(null);
		
		Assertions.assertThrows(Exception.class, () -> {
			int soma = calculosService.somar(lista);
		} );
		
	}
	
	@Test
	@DisplayName("Teste unitário - média = 4")
	void cenarioMedia() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(4);
		lista.add(4);
		
		double media = calculosService.media(lista);
		
		Assertions.assertEquals(4, media);
		
	}
	
	@Test
	@DisplayName("Teste unitário - moda = 5")
	void cenarioModa() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(3);
		lista.add(5);
		lista.add(5);
		
		List<Integer> modas = calculosService.moda(lista);
		
		List<Integer> resultadoEsperado = new ArrayList<>();
		resultadoEsperado.add(5);
		
		Assertions.assertEquals(resultadoEsperado, modas);

	}
	
	@Test
	@DisplayName("Teste unitário - mais de uma moda")
	void cenarioModas() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(2);
		lista.add(3);
		lista.add(5);
		lista.add(5);
		
		List<Integer> modas = calculosService.moda(lista);
		
		List<Integer> resultadoEsperado = new ArrayList<>();
		resultadoEsperado.add(2);
		resultadoEsperado.add(5);
		
		Assertions.assertEquals(resultadoEsperado, modas);

	}
	
	@Test
	@DisplayName("Teste unitário - mediana = 3")
	void cenarioMedianaImpar() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(2);
		lista.add(3);
		lista.add(5);
		lista.add(5);
		
		double mediana = calculosService.mediana(lista);
		
		Assertions.assertEquals(3.0, mediana);
	}
	
	@Test
	@DisplayName("Teste unitário - mediana = 2.5")
	void cenarioMedianaPar() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(2);
		lista.add(3);
		lista.add(5);
		
		double mediana = calculosService.mediana(lista);
		
		Assertions.assertEquals(2.5, mediana);
	}
	
	@Test
	@DisplayName("Teste unitário - calcular")
	void cenarioCalcular() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(2);
		lista.add(3);
		lista.add(5);
		
		Entrada entrada = new Entrada();
		entrada.setLista(lista);
		Resultado resultado = calculosService.calcular(entrada);
		
		List<Integer> modaEsperada = new ArrayList<>();
		modaEsperada.add(2);
				
		Assertions.assertEquals(12, resultado.getSoma());
		Assertions.assertEquals(3.0, resultado.getMedia());
		Assertions.assertEquals(5, resultado.getMaior());
		Assertions.assertEquals(2, resultado.getMenor());
		Assertions.assertEquals(4, resultado.getQuantidade());
		Assertions.assertEquals(60, resultado.getMultiplicacao());
		Assertions.assertEquals(modaEsperada, resultado.getModa());
		Assertions.assertEquals(2.5, resultado.getMediana());

	}

}
