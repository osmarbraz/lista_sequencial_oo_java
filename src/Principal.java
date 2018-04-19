
/**
 * Implementação de Lista Sequencial de forma orientada a objeto.
 *
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    public static void main(String[] args) {
        /**
         * Declaração e instanciamento da lista.
         */
        Lista lst = new Lista();
        // Controla o menu da lista
        int opcao = -1;
        while (opcao != 99) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Lista Sequencial ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 1- Listar elementos\n"
                    + " 2- Inserir elemento no início\n"
                    + " 3- Inserir elemento no fim\n"
                    + " 4- Inserir elemento em uma posição especifica\n"
                    + " 5- Inserir elemento ordenado\n"
                    + " 6- Remover elemento do início\n"
                    + " 7- Remover elemento do fim\n"
                    + " 8- Remover elemento de uma posição específica\n"
                    + " 9- Remover elemento pelo valor\n"
                    + "10- Mostrar a posição de um elemento\n"
                    + "11- Mostrar a quantidade de elementos\n"
                    + "12- Está cheia?\n"
                    + "13- Está vazia?\n"
                    + "99- Sair\n"));
            switch (opcao) {
                case 1: {
                    if (lst.estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Listagem \n" + lst.listar());
                    }
                    break;
                }
                case 2: {
                    No novo = new No();
                    novo.setDado(leitura());
                    if (lst.inserirInicio(novo) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no início com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no início!");
                    }
                    break;
                }
                case 3: {
                    No novo = new No();
                    novo.setDado(leitura());
                    if (lst.inserirFim(novo) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no fim com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no fim!");
                    }
                    break;
                }
                case 4: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição:"));
                    No novo = new No();
                    novo.setDado(leitura());
                    if (lst.inserirPosicao(novo, k) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido na posição " + k + " com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido na posição " + k + "!");
                    }
                    break;
                }
                case 5: {
                    No novo = new No();
                    novo.setDado(leitura());
                    if (lst.inserirOrdenado(novo) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido ordenado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido ordenado!");
                    }
                    break;
                }
                case 6: {
                    if (lst.excluirInicio()) {
                        JOptionPane.showMessageDialog(null, "O Nó do início foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó do início não foi excluído!");
                    }
                    break;
                }
                case 7: {
                    if (lst.excluirFim()) {
                        JOptionPane.showMessageDialog(null, "O Nó do fim foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó do fim não foi excluído!");
                    }
                    break;
                }
                case 8: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição a ser excluída:"));
                    if (lst.excluirPosicao(k)) {
                        JOptionPane.showMessageDialog(null, "O valor da posição " + k + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 9: {
                    No valor = new No();
                    valor.setDado(Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do Nó a ser excluído:")));
                    if (lst.excluirValor(valor)) {
                        JOptionPane.showMessageDialog(null, "O valor " + valor.getDado() + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 10: {
                    No valor = new No();
                    valor.setDado(Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser procurado:")));
                    int posicao = lst.posicaoValor(valor);
                    JOptionPane.showMessageDialog(null, "O valor " + valor.getDado() + " esta na posição " + posicao);
                    break;
                }
                case 11: {
                    JOptionPane.showMessageDialog(null, "Quantidade de Nós na lista : " + lst.getN());
                    break;
                }
                case 12: {
                    JOptionPane.showMessageDialog(null, "Lista está cheia : " + lst.estaCheia());
                    break;
                }
                case 13: {
                    JOptionPane.showMessageDialog(null, "Lista está vazia : " + lst.estaVazia());
                    break;
                }
            }
        }
    }
}
