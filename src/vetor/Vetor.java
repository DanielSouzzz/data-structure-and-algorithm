package vetor;

import java.util.Arrays;

// declara uma classe genérica com o tipo T, que permite qualquer tipo de dado seja armazenado
public class Vetor<T> {
    private T[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        // cria um array de Object e converte para T[]
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    // adiciona um elemento ao final da lista
    public boolean adicionar(T elemento){
        aumentarCapacidade();
        if (this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        } else {
            return false;
        }
    }

    // adiciona um elemento em qualquer posicao da lista
    public boolean adicionar(int index, T elemento) throws IndexOutOfBoundsException {
        verificarValidadePosicaoParaAdicionar(index);
        aumentarCapacidade();
        for (int i = this.tamanho - 1; i>= index; i--){
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[index] = elemento;
        this.tamanho++;
        return true;
    }

    public boolean remover(T elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i] == elemento) {
                for (int j = i; j < this.tamanho - 1; j++){
                    this.elementos[j] = this.elementos[j+1];
                }
                this.elementos[this.tamanho - 1]= null;
                this.tamanho--;
                return true;
            }
        }
        return false;
    }

    private void aumentarCapacidade() {
        if (this.tamanho >= this.elementos.length){
            T[] newElementos = (T[]) new Object[this.elementos.length * 2];
            for (int i=0;i<this.elementos.length; i++){
                newElementos[i] = this.elementos[i];
            }
            this.elementos = newElementos;
        }
    }

    private void verificarValidadePosicaoParaAdicionar(int index) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida!");
        }
    }

    @Override
    public String toString() {
        return "Vetor{" +
                "elementos=" + Arrays.toString(elementos) +
                ", tamanho=" + tamanho +
                '}';
    }
}
