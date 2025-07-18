package one.digitalInnovationOne;

public class ListaEncadeada<T> {
    No<T> refEntrada;

    public ListaEncadeada() {
        this.refEntrada = null;
    }


    public T get(int index){
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index){

        validaIndice(index);
        No<T> noAux = refEntrada;
        No<T> noRetorno = null;
        for(int i = 0; i <= index; i++){
            noRetorno = noAux;
            noAux = noAux.getProximoNo();
        }
        return noRetorno;
    }

    public T remove(int index){
        No<T> noPivo = this.getNo(index);
        if (index == 0){
            refEntrada = noPivo.getProximoNo();
            return noPivo.getConteudo();
        }
        No<T> noAnterior = getNo(index-1);
        noAnterior.setProximoNo(noPivo.getProximoNo());
        return noPivo.getConteudo();

    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()){
            refEntrada = novoNo;
            return;
        }

        No<T> noAux = refEntrada;
        for(int i = 0; i < this.size() -1; i++){
            noAux = noAux.getProximoNo();
        }

        noAux.setProximoNo(novoNo);
    }

    public int size(){
        int tamanhoLista = 0;
        No<T> refAux = refEntrada;
        while (true){
            if(refAux != null){
                tamanhoLista++;
                if (refAux.getProximoNo() != null){
                    refAux = refAux.getProximoNo();
                }else{
                    break;
                }
            }else {
                break;
            }
        }
        return tamanhoLista;
    }

    private void validaIndice(int index){
        if (index>= size()){
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice " + index + " desta lista. Esta lista só vai até o indice" + ultimoIndice + ".");
        }
    }

    public boolean isEmpty(){
        return refEntrada == null? true:false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAux = refEntrada;
        for(int i = 0; i < this.size(); i++){
            strRetorno += "[No{Conteudo=" + noAux.getConteudo() + "}]--->";
            noAux = noAux.getProximoNo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}
