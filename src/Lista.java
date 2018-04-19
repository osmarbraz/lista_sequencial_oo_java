
/**
 * Implementação de Lista Sequencial de forma orientada a objetos.
 *
 */
public class Lista {

    /**
     * Tamanho máximo da lista.
     */
    private static final int TAMANHO_LISTA = 100;
    /**
     * Tamanho atual da lista.
     */
    private int n;
    /**
     * Vetor que armazena os nós.
     */
    private No lista[] = new No[TAMANHO_LISTA];

    public Lista() {
        //Inicializa a lista o 0 elementos
        n = 0;
    }

    /**
     * Recuporador de N.
     *
     * @return Um inteiro com a quantidade de nós da lista.
     */
    public int getN() {
        return n;
    }

    /**
     * Modificador de N.
     *
     * @param n Um valor inteiro a ser atribuído para a N.
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * Insere um elemento em uma posição especifica da lista.
     *
     * @param _novo Novo nó a ser inserido.
     * @param _k Posição a ser inserida o valor.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirPosicao(No _novo, int _k) {
        if (n < TAMANHO_LISTA) {
            //Verifica se a posição está no intervalo de valores da lista.
            if ((_k >= 0) && (_k <= getN())) {
                //Desloca os elementos do fim até a posição k
                for (int i = n - 1; i >= _k; i--) {
                    lista[i + 1] = lista[i];
                }
                //Insere o novo valor na posição k.
                lista[_k] = _novo;
                //Incrementa a quantidade de elementos.
                setN(getN() + 1);
                return true;
            } else {
                System.out.print("Posição inválida!\n");
                return false;
            }
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Insere um elemento no início da lista.
     *
     * @param _novo Novo nó a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirInicio(No _novo) {
        return inserirPosicao(_novo, 0);
    }

    /**
     * Insere um elemento no final da lista.
     *
     * @param _novo Novo nó a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirFim(No _novo) {
        return inserirPosicao(_novo, getN());
    }

    /**
     * Inclui de forma ordenado um elemento na lista levando em consideração o
     * seu valor.
     *
     * @param _novo Novo nó ser inserido.
     *
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirOrdenado(No _novo) {
        if (n < TAMANHO_LISTA) {
            int i = 0;
            while ((i < getN()) && (_novo.getDado() > lista[i].getDado())) {
                i = i + 1;
            }
            if (i <= n) {
                return inserirPosicao(_novo, i);
            } else {
                System.out.print("Posição Inválida!");
                return false;
            }
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Excluir um elemento da lista pela posição.
     *
     * @param _k Posição do elemento a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor da posição.
     */
    public boolean excluirPosicao(int _k) {
        if (n != 0) {
            //Verifica se a posição está no intervalo de elementos da lista.
            if ((_k >= 0) && (_k < getN())) {
                //Desloca os elementos do fim até a posição k da lista.
                for (int i = _k; i < getN(); i++) {
                    lista[i] = lista[i + 1];
                }
                //Decrementa a quantidade de elementos da lista.
                setN(getN() - 1);
                return true;
            } else {
                System.out.print("Posicao invalida!\n");
                return false;
            }
        } else {
            System.out.print("A lista está vazia!\n");
            return false;
        }
    }

    /**
     * Excluir um elemento do final da lista.
     *
     * @return Verdadeiro ou falso se excluiu o valor do final.
     */
    public boolean excluirFim() {
        return excluirPosicao(getN() - 1);
    }

    /**
     * Excluir um elemento do início da lista.
     *
     * @return Verdadeiro ou falso se excluiu o valor do início.
     */
    public boolean excluirInicio() {
        return excluirPosicao(0);
    }

    /**
     * Excluir um elemento da lista pelo valor.
     *
     * @param _valor Nó a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor.
     */
    public boolean excluirValor(No _valor) {
        if (getN() != 0) {
            int i = 0;
            //Procura a posição do elemento na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < getN()) && (_valor.getDado() != lista[i].getDado())) {
                i = i + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (i < n) {
                //Chama o método excluir para a posição i
                excluirPosicao(i);
                return true;
            } else {
                System.out.print("Valor nao existe na lista!\n");
                return false;
            }
        } else {
            System.out.print("Lista Vazia!");
            return false;
        }
    }

    /**
     * Retorna a posição de um elemento na lista.
     *
     * @param _valor Nó a ser procurado na lista.
     * @return A posição de valor na lsita.
     */
    public int posicaoValor(No _valor) {
        if (getN() != 0) {
            int i = 0;
            //Procura a posição do elemento na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < getN()) && (_valor.getDado() != lista[i].getDado())) {
                i = i + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (i < getN()) {
                return i;
            } else {
                return -1;
            }
        } else {
            System.out.print("Lista Vazia!");
            return -1;
        }
    }

    /**
     * Lista os dados da lista.
     *
     * @return Uma String com os dados da lista.
     */
    public String listar() {
        String temp = "";
        for (int i = 0; i < getN(); i++) {
            temp = temp + (i) + "-" + lista[i] + "\n";
        }
        return temp;
    }

    /**
     * Retorna se a lista está cheia.
     *
     * @return Verdadeiro ou falso se a lista está cheia.
     */
    public boolean estaCheia() {
        return getN() == TAMANHO_LISTA;
    }

    /**
     * Retorna se a lista esta vazia.
     *
     * @return Verdadeiro ou falso se a lista está vazia.
     */
    public boolean estaVazia() {
        return getN() == 0;
    }
}
