import java.util.ArrayList;
import java.util.Scanner;

public class Tarefa {

    Scanner parametro = new Scanner(System.in);
    Scanner texto = new Scanner(System.in);
    Scanner Value = new Scanner(System.in);
    private Thread tempo;

    ArrayList<String> lista_tarefas = new ArrayList<String>();
    ArrayList<String> lista_feitas = new ArrayList<String>();

    public void app() {
        {
            tempo = Thread.currentThread();
            int opcao = 6;
            do {
                for (int i = 0; i < 300; i++) {
                    System.out.println("\n");
                }

                System.out.println("-----------------------");
                System.out.println("-----------------------");
                if (lista_tarefas.size() == 0) {
                    System.out.println("VOCE NAO POSSUI TAREFAS");
                } else {
                    System.out.println("ESTAS SAO SUAS TAREFAS" + "\n");
                    for (int i = 0; i < lista_tarefas.size(); i++) {
                        System.out.print("TAREFA: " + i + " ");
                        System.out.println(lista_tarefas.get(i) + "\n");
                    }
                }
                System.out.println("-----------------------");
                System.out.println("-----------------------");
                System.out.println("1 - Adicionar Tarefa");
                System.out.println("2 - Finalizar Tarefa");
                System.out.println("3 - Desfazer Tarefa Finalizada");
                System.out.println("4 - Mostrar Terefas Finalizadas");
                System.out.println("5 - Excluir Tarefa");
                System.out.println("6 - Fechar App");
                System.out.print("Digite uma opção: ");
                opcao = parametro.nextInt();
                System.out.println("-----------------------");
                if (opcao == 1) {
                    System.out.println("Digite uma tarefa");
                    String tarefa = String.valueOf(texto.nextLine());
                    lista_tarefas.add(tarefa);
                    System.out.println("-----------------------");
                } else if (opcao == 2) {
                    for (int i = 0; i < lista_tarefas.size(); i++) {
                        System.out.print("TAREFA " + i + " ");
                        System.out.println(lista_tarefas.get(i) + "\n");
                    }
                    System.out.print("Qual tarefas deseja finalizar:");
                    int valor_delete = Value.nextInt();
                    if (valor_delete <= lista_tarefas.size() - 1 && valor_delete >= 0) {
                        lista_feitas.add(lista_tarefas.get(valor_delete));
                        lista_tarefas.remove(valor_delete);
                    } else {
                        System.out.println("");
                        System.out.println("Nao foi possivel encontrar a tarefa: " + valor_delete);
                    }
                    try {
                        tempo.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (opcao == 3) {
                    if (lista_feitas.size() > 0) {
                        System.out.println("Qual tarefas deseja desfazer:");
                        for (int i = 0; i < lista_feitas.size(); i++) {
                            System.out.print("TAREFA: " + i + " ");
                            System.out.println(lista_feitas.get(i) + "\n");
                        }
                        System.out.print("Digite qual tarefa deseja desfazer: ");
                        int valor_delete = Value.nextInt();
                        if (valor_delete <= lista_feitas.size() - 1 && valor_delete >= 0) {
                            lista_tarefas.add(lista_feitas.get(valor_delete));
                            lista_feitas.remove(valor_delete);
                            System.out.println("Tarefa: " + valor_delete + " desfeita");
                            System.out.println("-----------------------");
                        } else {
                            System.out.println("");
                            System.out.println("Nao foi possivel encontrar a tarefa: " + valor_delete);
                        }
                    }
                    try {
                        tempo.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (opcao == 4) {
                    System.out.println("\n");
                    if (lista_feitas.size() == 0) {
                        System.out.println("VOCE NAO FINALIZOU NENHUMA TAREFA");
                    } else {
                        System.out.println("Tarefas finalizadas: " + "\n");
                        for (int i = 0; i < lista_feitas.size(); i++) {
                            System.out.print("TAREFA " + i + ":");
                            System.out.println(lista_feitas.get(i) + "\n");
                        }
                    }
                    try {
                        tempo.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (opcao == 5) {
                    if (lista_tarefas.size() > 0) {
                        System.out.println("Qual tarefas deseja excluir:");
                        for (int i = 0; i < lista_tarefas.size(); i++) {
                            System.out.print("TAREFA " + i + " ");
                            System.out.println(lista_tarefas.get(i) + "\n");
                        }
                        System.out.print("Digite qual tarefa deseja desfazer: ");
                        int valor_delete = Value.nextInt();
                        if (valor_delete <= lista_tarefas.size() - 1 && valor_delete >= 0) {
                            System.out.println("\n" + "Tem certeza que deseja excluir tarefa: ");
                            System.out.println("1- Sim,desejo excluir a tarefa: " + valor_delete);
                            System.out.println("2- Nao,desejo excluir a tarefa: " + valor_delete);
                            int confir = Value.nextInt();
                            if (confir == 1) {
                                lista_tarefas.remove(valor_delete);
                            } else {
                                System.out.println("Tarefa excluida");
                                System.out.println("-----------------------");
                            }
                        } else {
                            System.out.println("\n");
                            System.out.println("Nao foi possivel excluir tarefas");
                        }
                    } else {
                        System.out.println("\n");
                        System.out.println("Nao foi possivel encontrar tarefas");
                    }

                }
            } while (opcao != 6);
            System.out.println("SAINDO DO APP");
        }


    }
}
