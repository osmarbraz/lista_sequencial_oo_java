
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

    /**
     * Construtor sem parâmetro da lista.
     */
    public Lista() {
        //Inicializa a lista com o 0 nós
        this.n = 0;
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
     * Insere um nó no início da lista.
     *
     * @param novo Novo nó a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirInicio(No novo) {
        if (n < TAMANHO_LISTA) {
            //Desloca os nós do fim até a posição 0
            for (int i = n - 1; i >= 0; i--) {
                lista[i + 1] = lista[i];
            }
            //Insere o novo valor na posição 0.
            lista[0] = novo;
            //Incrementa a quantidade de nós.
            setN(getN() + 1);
            return true;
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Insere um nó em uma posição especifica da lista.
     *
     * @param novo Novo nó a ser inserido.
     * @param k Posição a ser inserida o valor.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirPosicao(No novo, int k) {
        if (n < TAMANHO_LISTA) {
            //Verifica se a posição está no intervalo de valores da lista.
            if ((k >= 0) && (k <= getN())) {
                //Desloca os nós do fim até a posição k
                for (int i = n - 1; i >= k; i--) {
                    lista[i + 1] = lista[i];
                }
                //Insere o novo valor na posição k.
                lista[k] = novo;
                //Incrementa a quantidade de nós.
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
     * Insere um nó no final da lista.
     *
     * @param novo Novo nó a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirFim(No novo) {
        if (n < TAMANHO_LISTA) {
            //Desloca os nós do fim até a posição n
            for (int i = n - 1; i >= getN(); i--) {
                lista[i + 1] = lista[i];
            }
            //Insere o novo valor na posição n.
            lista[getN()] = novo;
            //Incrementa a quantidade de nós.
            setN(getN() + 1);
            return true;
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Inclui de forma ordenado um nó na lista levando em consideração o seu
     * valor.
     *
     * @param novo Novo nó ser inserido.
     *
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirOrdenado(No novo) {
        if (n < TAMANHO_LISTA) {
            int j = 0;
            while ((j < getN()) && (novo.getDado() > lista[j].getDado())) {
                j = j + 1;
            }
            if (j <= n) {
                //Desloca os nós do fim até a posição j
                for (int i = n - 1; i >= j; i--) {
                    lista[i + 1] = lista[i];
                }
                //Insere o novo valor na posição j.
                lista[j] = novo;
                //Incrementa a quantidade de nós.
                setN(getN() + 1);
            } else {
                System.out.print("Posição Inválida!");
                return false;
            }
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
        return false;
    }

    /**
     * Excluir um nó do início da lista.
     *
     * @return Verdadeiro ou falso se excluiu o valor do início.
     */
    public boolean excluirInicio() {
        return excluirPosicao(0);
    }

    /**
     * Excluir um Nó da lista pela posição.
     *
     * @param k Posição do nó a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor da posição.
     */
    public boolean excluirPosicao(int k) {
        if (getN() != 0) {
            //Verifica se a posição está no intervalo de nós da lista.
            if ((k >= 0) && (k < getN())) {
                //Desloca os nós do fim até a posição k da lista.
                for (int i = k; i < getN(); i++) {
                    lista[i] = lista[i + 1];
                }
                //Decrementa a quantidade de nós da lista.
                setN(getN() - 1);
                return true;
            } else {
                System.out.print("Posição inválida!\n");
                return false;
            }
        } else {
            System.out.print("A lista está vazia!\n");
            return false;
        }
    }

    /**
     * Excluir um nó do final da lista.
     *
     * @return Verdadeiro ou falso se excluiu o valor do final.
     */
    public boolean excluirFim() {
        if (getN() != 0) {
            //atribui null para posição final
            lista[getN() - 1] = null;
            //Decrementa a quantidade de nós da lista.
            setN(getN() - 1);
            return true;
        } else {
            System.out.print("A lista está vazia!\n");
            return false;
        }
    }

    /**
     * Excluir um nó da lista pelo valor.
     *
     * @param chave Nó a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor.
     */
    public boolean excluirValor(No chave) {
        if (getN() != 0) {
            int j = 0;
            //Procura a posição do nó na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((j < getN()) && (chave.getDado() != lista[j].getDado())) {
                j = j + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (j < n) {                
                //Desloca os nós do fim até a posição j da lista.
                for (int i = j; i < getN(); i++) {
                    lista[i] = lista[i + 1];
                }
                //Decrementa a quantidade de nós da lista.
                setN(getN() - 1);                
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
     * Retorna a posição de um nó na lista.
     *
     * @param chave Nó a ser procurado na lista.
     * @return A posição de valor na lsita.
     */
    public int posicaoValor(No chave) {
        if (getN() != 0) {
            int i = 0;
            //Procura a posição do nó na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < getN()) && (chave.getDado() != lista[i].getDado())) {
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
