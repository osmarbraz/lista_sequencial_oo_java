
public class No {

    private int dado;

    /**
     * Construtor sem argumentos.
     */
    public No() {
        this.dado = 0;
    }

    /**
     * Construtor com argumentos.
     *
     * @param dado um valor do tipo inteiro
     */
    public No(int dado) {
        this.dado = dado;
    }

    /**
     * Recuporador de dado.
     *
     * @return Um inteiro com o dado do nó
     */
    public int getDado() {
        return dado;
    }

    /**
     * Modificador de dado.
     *
     * @param dado Um valor inteiro a ser atribuído para o dado.
     */
    public void setDado(int dado) {
        this.dado = dado;
    }

    /**
     * Retorna o valor em String do dado
     */
    public String toString() {
        return getDado() + "";
    }
}
