package one.DigitalInnovationOne;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada(int tamanhoLista) {
        primeiroNo = null;
        ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public ListaDuplamenteEncadeada() {

    }

    public int size(){
        return this.tamanhoLista;
    }

    public void add(int index, T conteudo){
        NoDuplo<T> noAux = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setNoProx(noAux);

        if (novoNo.getNoProx() != null){
            novoNo.setNoPrev(noAux.getNoPrev());
            novoNo.setNoProx(noAux.getNoProx());
            novoNo.getNoProx().setNoPrev(novoNo);
        }else{
            novoNo.setNoPrev(ultimoNo);
            ultimoNo = novoNo;
        }

        if (index == 0){
            primeiroNo = novoNo;
        }else {
            novoNo.getNoPrev().setNoProx(novoNo);
        }

        tamanhoLista++;
    }

    public void add(T conteudo){
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setNoProx(null);
        novoNo.setNoPrev(ultimoNo);
        if (primeiroNo == null){
            primeiroNo = novoNo;
        }if (ultimoNo != null){
            ultimoNo.setNoProx(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista += 1;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public void remove(int index){
        if (index == 0){
            primeiroNo = primeiroNo.getNoProx();
            if (primeiroNo != null){
                primeiroNo.setNoPrev(null);
            }
        }else {
            NoDuplo<T> noAux = getNo(index);
            noAux.getNoPrev().setNoProx(noAux.getNoProx());
            if (noAux != ultimoNo){
                noAux.getNoProx().setNoPrev(noAux.getNoPrev());
            }else {}
            ultimoNo = noAux;
        }
        tamanhoLista--;
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAux = primeiroNo;

        for (int i = 0; (i < index) && (noAux != null); i++){
            noAux = noAux.getNoProx();
        }
        return noAux;
    }
    @Override
    public String toString(){
        String strRetorno = "";
        NoDuplo<T> noAux = primeiroNo;
        for (int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo: " + noAux.getConteudo() + "}]--->";
            noAux = noAux.getNoProx();
        }
        strRetorno += "null";
        return strRetorno;
    }

}
