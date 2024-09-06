package app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;

@Service
public class CalculosService {
	
	
	public Resultado calcular(Entrada entrada) {
		
		Resultado resultado = new Resultado();
		
		int soma = this.somar(entrada.getLista() );
		System.out.println("A soma deu "+ soma);
		resultado.setSoma(soma);
		
		double media = this.media(entrada.getLista());
		resultado.setMedia(media);
		
		int maiorNumero = this.maior(entrada.getLista());
		resultado.setMaior(maiorNumero);
		
		int menorNumero = this.menor(entrada.getLista());
		resultado.setMenor(menorNumero);
		
		int quantidadeNumeros = this.quantidade(entrada.getLista());
		resultado.setQuantidade(quantidadeNumeros);
		
		int multiplicacao = this.multiplicar(entrada.getLista());
		resultado.setMultiplicacao(multiplicacao);
		
		List<Integer> moda = this.moda(entrada.getLista());
		resultado.setModa(moda);
		
		double meadiana = this.mediana(entrada.getLista());
		resultado.setMediana(meadiana);
				
		return resultado;
		
	}
	
	public int somar(List<Integer> lista) {
		
		int soma = 0;
		
		for(int i=0; i<lista.size(); i++) {
			soma += lista.get(i);
		}
		
		return soma;
		
	}
	
	public double media(List<Integer> lista) {
		return this.somar(lista) / lista.size();
	}
	
	public int maior(List<Integer> lista) {
		
		int maiorNumero = lista.get(0);
		
		
		for(int num : lista) {
			if (num > maiorNumero) {
				maiorNumero = num;
			}
		}
		
		
		return maiorNumero;
	}
	
	
	public int menor(List<Integer> lista) {
		int menorNumero = lista.get(0);
		
		for(int num : lista) {
			if(num < menorNumero) {
				menorNumero = num;
			}
		}
		
		return menorNumero;
	}
	
	public int quantidade(List<Integer> lista) {
		return lista.size();
	}
	
	public int multiplicar(List<Integer> lista) {
		int resultado = 1;
		
		for(int num : lista) {
			resultado *= num;
		}
		
		return resultado;
	}
	
	public List<Integer> moda(List<Integer> lista) {
		
		// ordena a lista
		Collections.sort(lista);
		
		// lista de modas
		List<Integer> modas = new ArrayList<>();
		
		// variáveis de controle
		int contagemMax = 0;
		int contagemAtual = 1;
		int ultimoNumero = lista.get(0);
		
		// percorre a lista e conta as ocorrêncas
		for(int i = 1; i < lista.size(); i++) {
			int numeroAtual = lista.get(i);
			
			if(numeroAtual == ultimoNumero) {
				contagemAtual++;
			} else {
				if(contagemAtual > contagemMax) {
					modas.clear();
					modas.add(ultimoNumero);
					contagemMax = contagemAtual;
				} else if(contagemAtual == contagemMax) {
					modas.add(ultimoNumero);
				}
				contagemAtual = 1;
				ultimoNumero = numeroAtual;
			}
		}
		
		// verifica a última sequência
		if(contagemAtual > contagemMax) {
			modas.clear();
			modas.add(ultimoNumero);
		} else if(contagemAtual == contagemMax) {
			modas.add(ultimoNumero);
		}
		
		return modas;
	}
	
	public double mediana(List<Integer> lista) {
		
		// ordena a lista
		Collections.sort(lista);
		
		// se a lista for ímpar
		if((lista.size() % 2) == 1) {
			return lista.get((lista.size() / 2));
		}
		
		// se for par
		double meio1 = lista.get((lista.size() / 2) - 1);
		double meio2 = lista.get((lista.size() / 2));
		
		return ((meio1 + meio2) / 2);
	}

}
