package app.entity;

import java.util.List;

public class Resultado {
	
	private int soma;
	private double media;
	private int maior;
	private int menor;
	private int quantidade;
	private int multiplicacao;
	private List<Integer> moda;

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public int getMaior() {
		return maior;
	}

	public void setMaior(int maior) {
		this.maior = maior;
	}
	
	public int getMenor() {
		return menor;
	}

	public void setMenor(int menor) {
		this.menor = menor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getMultiplicacao() {
		return multiplicacao;
	}

	public void setMultiplicacao(int multiplicacao) {
		this.multiplicacao = multiplicacao;
	}

	public List<Integer> getModa() {
		return moda;
	}

	public void setModa(List<Integer> moda) {
		this.moda = moda;
	}

}
