
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
                    + " 1- Listar Nós\n"
                    + " 2- Inserir Nó no início\n"
                    + " 3- Inserir Nó no fim\n"
                    + " 4- Inserir Nó em uma posição especifica\n"
                    + " 5- Inserir Nó ordenado\n"
                    + " 6- Remover Nó do início\n"
                    + " 7- Remover Nó do fim\n"
                    + " 8- Remover Nó de uma posição específica\n"
                    + " 9- Remover Nó pelo valor\n"
                    + "10- Mostrar a posição de um Nó\n"
                    + "11- Mostrar a quantidade de Nós\n"
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
                    //Instancia um novo nó
                    No novo = new No();
                    //Preenche o valor do dado do nó
                    novo.setDado(leitura());
                    if (lst.inserirInicio(novo) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no início com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no início!");
                    }
                    break;
                }
                case 3: {
                    //Instancia um novo nó
                    No novo = new No();
                    //Preenche o valor do dado do nó
                    novo.setDado(leitura());
                    if (lst.inserirFim(novo) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no fim com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no fim!");
                    }
                    break;
                }
                case 4: {
                    //Le a posição a ser inserido o nó
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição:"));
                    //Instancia um novo nó
                    No novo = new No();
                    //Preenche o valor do dado do nó
                    novo.setDado(leitura());
                    if (lst.inserirPosicao(novo, k) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido na posição " + k + " com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido na posição " + k + "!");
                    }
                    break;
                }
                case 5: {
                    //Instancia um novo nó
                    No novo = new No();
                    //Preenche o valor do dado do nó
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
                    //Instancia um novo nó
                    No valor = new No();
                    //Preenche o valor do dado do nó
                    valor.setDado(Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do Nó a ser excluído:")));
                    if (lst.excluirValor(valor)) {
                        JOptionPane.showMessageDialog(null, "O valor " + valor.getDado() + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 10: {
                    //Instancia um novo nó
                    No valor = new No();
                    //Preenche o valor do dado do nó
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
