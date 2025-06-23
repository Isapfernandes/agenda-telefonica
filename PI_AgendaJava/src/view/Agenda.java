package view;

import Model.Membro;
import Model.Dao.MembroDao;

import java.util.Scanner;

public class Agenda {

    public void testaInsercao(String nome, String telefone, String email) {
        Membro membroObj = new Membro();
        MembroDao dao = new MembroDao();

        membroObj.setNome(nome);
        membroObj.setTelefone(telefone);
        membroObj.setEmail(email);

        try {
            dao.inserir(membroObj);
            System.out.println("Contato inserido com sucesso");
        } catch (Exception e) {
            System.out.println("Problemas ao inserir o contato na agenda");
        }
    }

    public void testaExclusao(int id_membro) {
        Membro membroObj = new Membro();
        MembroDao dao = new MembroDao();

        membroObj.setId(id_membro);

        try {
            dao.deletar(membroObj);
            System.out.println("Contato excluído com sucesso");
        } catch (Exception e) {
            System.out.println("Problemas ao excluir o contato da agenda");
        }
    }

    public void testaAtualizacao(String nome, String telefone, String email, int id_membro) {
        Membro membroObj = new Membro();
        MembroDao dao = new MembroDao();
        membroObj.setNome(nome);
        membroObj.setTelefone(telefone);
        membroObj.setEmail(email);
        membroObj.setId(id_membro);

        try {
            dao.atualizar(membroObj);
            System.out.println("Membro atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Problemas ao atualizar o membro na agenda");
        }
    }

    public void testaListar() {
        MembroDao dao = new MembroDao();

        try {
            for (Membro membroObj : dao.listarDados()) {
                System.out.println(" id: " + membroObj.getId() +
                        " | nome: " + membroObj.getNome() +
                        " | telefone: " + membroObj.getTelefone() +
                        " | email: " + membroObj.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar os dados da agenda");
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n--- CONTATOS ---");
            System.out.println("\nOlá, o que você deseja fazer?");
            System.out.println("\n1 - Inserir contato");
            System.out.println("2 - Excluir contato");
            System.out.println("3 - Atualizar contato");
            System.out.println("4 - Listar contatos salvos");
            System.out.println("5 - Buscar contato por nome");
            System.out.println("0 - Sair");
            System.out.println("\n-------------------");
            System.out.print("Escolha uma opção: ");
            System.out.println("\n-------------------");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    agenda.testaInsercao(nome, telefone, email);
                    break;

                case 2:
                    System.out.print("ID do contato para excluir: ");
                    int idExcluir = scanner.nextInt();
                    agenda.testaExclusao(idExcluir);
                    break;

                case 3:
                    System.out.println("\nDeseja ver a lista de contatos antes de atualizar?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.print("Opção: ");
                    int verLista = scanner.nextInt();
                    scanner.nextLine(); 

                    if (verLista == 1) {
                        System.out.println("\nLista de contatos:");
                        MembroDao daoTemp = new MembroDao();
                        try {
                            for (Membro m : daoTemp.listarDados()) {
                                System.out.println("ID: " + m.getId() + " | Nome: " + m.getNome() +
                                        " | Telefone: " + m.getTelefone() + " | Email: " + m.getEmail());
                            }
                        } catch (Exception e) {
                            System.out.println("Erro ao listar os contatos.");
                        }
                        System.out.println("----------------------------");
                    }

                    System.out.print("\nInforme o ID do contato que deseja atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Escolha o que deseja atualizar:");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Telefone");
                    System.out.println("3 - Email");
                    System.out.print("Opção: ");
                    int escolhaAtualizacao = scanner.nextInt();
                    scanner.nextLine(); 

                    String nomeAtualizado = "";
                    String telefoneAtualizado = "";
                    String emailAtualizado = "";

                    switch (escolhaAtualizacao) {
                        case 1:
                            System.out.print("Novo nome: ");
                            nomeAtualizado = scanner.nextLine();
                            break;
                        case 2:
                            System.out.print("Novo telefone: ");
                            telefoneAtualizado = scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("Novo email: ");
                            emailAtualizado = scanner.nextLine();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }

                    // Buscar os dados atuais do contato
                    MembroDao dao = new MembroDao();
                    Membro membroAtual = null;
                    try {
                        for (Membro m : dao.listarDados()) {
                            if (m.getId() == idAtualizar) {
                                membroAtual = m;
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao buscar o membro.");
                    }

                    if (membroAtual != null) {
                        // Atualiza somente o campo informado pelo usuário
                        if (!nomeAtualizado.isEmpty()) membroAtual.setNome(nomeAtualizado);
                        if (!telefoneAtualizado.isEmpty()) membroAtual.setTelefone(telefoneAtualizado);
                        if (!emailAtualizado.isEmpty()) membroAtual.setEmail(emailAtualizado);

                        agenda.testaAtualizacao(
                            membroAtual.getNome(),
                            membroAtual.getTelefone(),
                            membroAtual.getEmail(),
                            membroAtual.getId()
                        );
                    } else {
                        System.out.println("Membro com ID informado não encontrado.");
                    }
                    break;

                case 4:
                    agenda.testaListar();
                    break;
                    
                case 5:
                    System.out.print("Digite o nome do contato que deseja buscar: ");
                    String nomeBusca = scanner.nextLine();

                    MembroDao daoBusca = new MembroDao();
                    boolean encontrado = false;
                    try {
                        for (Membro m : daoBusca.listarDados()) {
                            if (m.getNome().equalsIgnoreCase(nomeBusca)) {
                                System.out.println("\nContato encontrado:");
                                System.out.println("ID: " + m.getId() + " | Nome: " + m.getNome() +
                                        " | Telefone: " + m.getTelefone() + " | Email: " + m.getEmail());
                                encontrado = true;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao buscar o contato.");
                    }

                    if (!encontrado) {
                        System.out.println("Contato com o nome \"" + nomeBusca + "\" não encontrado.");
                    }
                    break;

                case 0:
                	System.out.println("\n-------------------");
                    System.out.println("Saindo da agenda...");
                    System.out.println("-------------------");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
