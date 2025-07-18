package one.DigitalInnovationOne;

public class NoDuplo<T> {


   private T conteudo;
   private NoDuplo<T> noProx;
   private NoDuplo<T> noPrev;

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoProx() {
        return noProx;
    }

    public void setNoProx(NoDuplo<T> noProx) {
        this.noProx = noProx;
    }

    public NoDuplo<T> getNoPrev() {
        return noPrev;
    }

    public void setNoPrev(NoDuplo<T> noPrev) {
        this.noPrev = noPrev;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
