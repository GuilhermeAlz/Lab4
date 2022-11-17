package ControleDeAlunos;

import java.util.Scanner;

/**
 * Interface com menus de texto do programa.
 */
public class Main {
    public static void main(String[] args) {
        Controle controle = new Controle();
        Scanner scanner = new Scanner(System.in);
		String escolha = "";
		
        while (true) {
            escolha = menu(scanner);
            comando(escolha, controle, scanner);
        }
    }
        
        /**
         * Imprime o menu do programa e retorna a opcao.
         * 
         * @param scanner Scanner.
         * @return Opcao escolhida pelo usuario.
         */
        private static String menu(Scanner scanner) {
            System.out.println(
                    "\n---\nMENU\n" + 
                            "(C)adastrar Aluno\n" + 
                            "(E)xibir Aluno\n" +
                            "(N)ovo Grupo\n" +
                            "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
                            "(O)lhaí quais Grupos o Aluno Tá\n" + 
                            "(S)im, quero Fechar o Programa!\n" + 
                            "\n" + 
                            "Opção> ");
            return scanner.next().toUpperCase();
        }

        /**
         * Switch case que usa a opcao do usuario para selecionar o comando correto a ser executado.
         * 
         * @param opcao Opcao que o usuario escolheu.
         * @param controle Classe de controle do sistema.
         * @param scanner Scanner.
         */
        private static void comando(String opcao, Controle controle, Scanner scanner) {
            switch (opcao) {
            case "C":
                cadastraAluno(controle, scanner);
                break;
            case "E":
                exibeAluno(controle, scanner);
                break;
            case "N":
                novoGrupo(controle, scanner);
                break;
            case "A":
                System.out.println("\n(A)locar Aluno ou (P)ertinência a Grupo? ");
                String opcaoCasoA = scanner.next().toUpperCase();

                switch (opcaoCasoA) {
                    case "A":
                        alocarAluno(controle, scanner);
                        break;
                    case "P":
                        pertinenciaGrupo(controle, scanner);
                        break;
                    default:
                        break;
                }
                break;
            case "O":
                checarGruposAluno(controle, scanner);
                break;
            case "S":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
            }
        }

        /**
         * Cadastra um aluno no sistema.
         * 
         * @param controle Classe de controle do sistema.
         * @param scanner Scanner.
         */
        private static void cadastraAluno(Controle controle, Scanner scanner) {
            System.out.print("\nMatrícula: ");
            scanner.nextLine();
            String matricula = scanner.nextLine();
    
            System.out.print("\nNome: ");
            String nome = scanner.nextLine();
    
            System.out.print("\nCurso: ");
            String curso = scanner.nextLine();
            

            try {
                controle.cadastraAluno(matricula, nome, curso);
                System.out.println("\nCADASTRO REALIZADO!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * Exibe o aluno cadastrado em forma de string.
         * 
         * @param controle Classe de controle do sistema.
         * @param scanner Scanner.
         */
        private static void exibeAluno(Controle controle, Scanner scanner) {
            System.out.print("\nMatrícula: ");
            scanner.nextLine();
            String matricula = scanner.nextLine();

            try {
                System.out.println(controle.consultaAluno(matricula));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * Cria um novo grupo no sistema
         * 
         * @param controle Classe de controle do sistema.
         * @param scanner Scanner.
         */
        private static void novoGrupo(Controle controle, Scanner scanner) {
            System.out.println("\nGrupo: ");
            scanner.nextLine();
            String tema = scanner.nextLine();

            System.out.println("\nTamanho: ");
            String tamanho = scanner.nextLine();

            if (tamanho != "") {
                try {
                    controle.criaGrupo(tema, Integer.parseInt(tamanho.strip()));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    controle.criaGrupo(tema);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        /**
         * Adiciona um aluno ja cadastrado a um grupo criado previamente no sistema.
         * 
         * @param controle Classe de controle do sistema.
         * @param scanner Scanner.
         */
        private static void alocarAluno(Controle controle, Scanner scanner) {
           System.out.println("\nMatricula: ");
           scanner.nextLine();
           String matricula = scanner.nextLine();

           System.out.println("\nGrupo: ");
           String grupo = scanner.nextLine().toLowerCase();

           try {
            controle.alocarAlunoEmGrupo(matricula, grupo);
            System.out.println("ALUNO ALOCADO!");
           } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
           }
        }

        /**
         * Verifica se um aluno ja cadastrado pertence ou nao a um grupo especificado pelo usuario.
         * 
         * @param controle Classe de controle do sistema.
         * @param scanner Scanner.
         */
        private static void pertinenciaGrupo(Controle controle, Scanner scanner) {
            System.out.println("\nGrupo: ");
            scanner.nextLine();
            String tema = scanner.nextLine();

            System.out.println("\nAluno: ");
            String matricula = scanner.nextLine();

            try {
                if (controle.pertinenciaGrupo(tema, matricula)) {
                    System.out.println("ALUNO PERTENCE AO GRUPO.");
                } else {
                    System.out.println("ALUNO NÃO PERTENCE AO GRUPO.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * Imprime todos os grupos que um aluno especificado pelo usuario faz parte e sua lotacao.
         * 
         * @param controle Classe de controle do sistema.
         * @param scanner Scanner.
         */
        private static void checarGruposAluno(Controle controle, Scanner scanner) {
            System.out.println("\nAluno: ");
            scanner.nextLine();
            String matricula = scanner.nextLine();

            try {
                System.out.println("Grupos:");
                System.out.println(controle.checagemGrupos(matricula));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * Encerra o programa.
         */
        private static void sai() {
            System.out.println("Fechando o programa.");
            System.exit(0);
        }
    }


