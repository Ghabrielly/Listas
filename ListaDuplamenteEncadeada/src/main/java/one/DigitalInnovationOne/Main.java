package one.DigitalInnovationOne;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada();

        lista.add("c1");
        lista.add("c2");
        lista.add("c3");
        lista.add("c4");
        lista.add("c5");
        lista.add("c6");
        lista.add("c7");

        System.out.println(lista);

        lista.remove(3);
        lista.add(3, "c99");

        System.out.println(lista);
        System.out.println(lista.get(3));


    }
}
