
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
    
   /**
     * Método principal.
     * 
     * @param args 
     */    
    public static void main(String[] args) {
        /**
         * Declara e instancia a lista.
         */
        Lista lista = new Lista();
        
        // Controla o menu da lista
        int opcao = -1;
        
        //Laço do menu de opções
        while (opcao != 99) {
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Lista Sequencial ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 1- Listar Nós\n"
                    + " 2- Inserir Nó no início\n"
                    + " 3- Inserir Nó em uma posição especifica\n"
                    + " 4- Inserir Nó no fim\n"
                    + " 5- Inserir Nó ordenado\n"
                    + " 6- Remover Nó do início\n"
                    + " 7- Remover Nó de uma posição específica\n"
                    + " 8- Remover Nó do fim\n"
                    + " 9- Remover Nó pelo valor\n"
                    + "10- Procurar o dado de uma posição específica\n"
                    + "11- Procurar a posição de um dado\n"
                    + "12- Mostrar a quantidade de Nós\n"
                    + "13- Está cheia?\n"
                    + "14- Está vazia?\n"
                    + "99- Sair\n"));
            switch (opcao) {
                case 1: {
                    if (lista.estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Listagem \n" + lista.listar());
                    }
                    break;
                }
                case 2: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (lista.inserirInicio(dado) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no início com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no início!");
                    }
                    break;
                }
                case 3: {
                    //Le a posição a ser inserido o nó
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição:"));
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (lista.inserirPosicao(dado, k) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido na posição " + k + " com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido na posição " + k + "!");
                    }
                    break;
                }
                case 4: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (lista.inserirFim(dado) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no fim com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no fim!");
                    }
                    break;
                }
                case 5: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (lista.inserirOrdenado(dado) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido ordenado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido ordenado!");
                    }
                    break;
                }
                case 6: {
                    if (lista.excluirInicio()) {
                        JOptionPane.showMessageDialog(null, "Nó do início foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó do início não foi excluído!");
                    }
                    break;
                }
                case 7: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição a ser excluída:"));
                    if (lista.excluirPosicao(k)) {
                        JOptionPane.showMessageDialog(null, "O valor da posição " + k + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 8: {
                    if (lista.excluirFim()) {
                        JOptionPane.showMessageDialog(null, "Nó do fim foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó do fim não foi excluído!");
                    }
                    break;
                }
                case 9: {
                    //Preenche o valor do dado                    
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do Nó a ser excluído:"));
                    if (lista.excluirValor(dado)) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 10: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do dado a ser procurada:"));
                    int dado = lista.procurarPosicao(k);
                    if (dado != -1) {
                        JOptionPane.showMessageDialog(null, "O valor da posição " + k + "  possui o dado = " + dado);
                    } else {
                        JOptionPane.showMessageDialog(null, "A posição " + k + " não está preenchida");
                    }
                    break;
                }
                case 11: {
                    //Preenche o valor do dado
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser procurado:"));
                    int posicao = lista.procuraValor(dado);
                    JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + posicao);
                    break;
                }
                case 12: {
                    JOptionPane.showMessageDialog(null, "Quantidade de Nós na lista : " + lista.getQuantidade());
                    break;
                }
                case 13: {
                    JOptionPane.showMessageDialog(null, "Lista está cheia : " + lista.estaCheia());
                    break;
                }
                case 14: {
                    JOptionPane.showMessageDialog(null, "Lista está vazia : " + lista.estaVazia());
                    break;
                }
                //Opção de saída do programa
                case 99: {
                    System.out.println("Saindo do programa!");
                    break;
                }
                //Opção inválida do menu
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }//Fim switch
        }//Fim while
    }//Fim main
}//Fim Principal