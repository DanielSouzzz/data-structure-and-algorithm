import vetor.Vetor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Vetor vetor = new Vetor<>(5);
        vetor.adicionar("A");
        vetor.adicionar("B");
        vetor.adicionar("C");
        vetor.adicionar("D");
        vetor.adicionar("E");

        System.out.println("Vetor atual: "+vetor);

        vetor.remover("B");

        System.out.println("Vetor após remover: "+vetor);
    }
}