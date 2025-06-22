package vetor;

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

    private void aumentarCapacidade() {
        if (this.tamanho >= this.elementos.length){
            T[] newElementos = (T[]) new Object[this.elementos.length * 2];
            for (int i=0;i<this.elementos.length; i++){
                newElementos[i] = this.elementos[i];
            }
            this.elementos = newElementos;
        }
    }

    private void verificarValidadePosicao(int posicao) throws IllegalAccessException {
        if(!(posicao>=0 && posicao < tamanho)){
            throw new IllegalAccessException("Posição inválida!");
        }
    }

}
