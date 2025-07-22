package com.DigitalInnovationOne;

public class Main {
    public static void main(String[] args) {
        ListaCircular<Integer> novaLista = new ListaCircular<>();

        System.out.println(novaLista);

        novaLista.add(1);
        novaLista.add(2);
        novaLista.add(3);
        novaLista.add(4);
        novaLista.add(5);

        System.out.println(novaLista);

        novaLista.remove(2);
        System.out.println(novaLista);

        novaLista.remove(1);
        System.out.println(novaLista);
    }
}
