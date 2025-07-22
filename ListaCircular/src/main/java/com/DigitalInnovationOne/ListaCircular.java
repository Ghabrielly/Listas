package com.DigitalInnovationOne;

public class ListaCircular <T>{

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public int size(){
        return this.tamanhoLista;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0? true : false;
    }

    public void add(T conteudo){
        No<T> novoNO = new No<>(conteudo);
        if (this.tamanhoLista == 0){
           this.cabeca = novoNO;
           this.cauda = this.cabeca;
           this.cabeca.setNoProx(cauda);
        }else{
            novoNO.setNoProx(this.cauda);
            this.cabeca.setNoProx(novoNO);
            this.cauda = novoNO;
        }
        this.tamanhoLista++;
    }

    public void remove(int index){
        if (index >= tamanhoLista){
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista.");
        }
        No<T> noAux = this.cauda;
        if (index == 0){
            this.cauda = this.cauda.getNoProx();
            this.cabeca.setNoProx(this.cauda);
        }else if (index == 1){
            this.cauda.setNoProx(this.cauda.getNoProx().getNoProx());
        }else {
            for (int i = 0; i < index-1; i++){
                noAux = noAux.getNoProx();
            }
            noAux.setNoProx(noAux.getNoProx().getNoProx());
        }
        this.tamanhoLista--;
    }

    public T get(int index){
       return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("Está vazia");

        if (index == 0){
            return this.cauda;
        }

        No<T> noAux = this.cauda;
        for (int i = 0; (i < index) && (noAux != null); i++){
            noAux.getNoProx();
        }
        return noAux;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAux = this.cauda;
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[No{Dado: " + noAux.getConteudo() + "}]--->";
            noAux = noAux.getNoProx();
        }
        strRetorno += this.size() != 0? "[Retorna ao começo]": "[ ]";
        return strRetorno;
    }
}
