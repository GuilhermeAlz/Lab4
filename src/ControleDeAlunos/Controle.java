package ControleDeAlunos;

import java.util.HashMap;

/**
 * Classe sistema que controla os alunos e os grupos. 
 */
public class Controle {
    private HashMap<String, Aluno> alunos;
    private HashMap<String, Grupo> grupos;

    /**
     * Constroi uma classe controle com um hashmap de alunos e outro de grupos.
     */
    public Controle() {
        this.alunos = new HashMap<String, Aluno>();
        this.grupos = new HashMap<String, Grupo>();
    }
    
    /**
     * Cadastra um aluno no sistema
     * 
     * @param matricula Matricula do aluno (String)
     * @param nome Nome do aluno (String)
     * @param curso Curso do aluno (String)
     */
    public void cadastraAluno(String matricula, String nome, String curso) {
        Aluno aluno = new Aluno(matricula, nome, curso);

        if (!this.alunos.containsKey(matricula)) {
            this.alunos.put(matricula, aluno);
        } else {
            throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA!");
        }
    }

    /**
     * Cria um grupo com um tema de estudo especifico.
     * 
     * @param tema Tema do grupo em questao.
     */
    public void criaGrupo(String tema) {
        Grupo grupo = new Grupo(tema.toLowerCase());

        if (!this.grupos.containsKey(tema)) {
            grupos.put(tema, grupo);
        } else {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
        }
    }

    /**
     * Cria um grupo com um tema e um tamanho limite.
     * 
     * @param tema Tema do grupo em questao
     * @param tamanho Tamanho limite do grupo a ser criado.
     */
    public void criaGrupo(String tema, int tamanho) {
        Grupo grupo = new Grupo(tema.toLowerCase(), tamanho);

        if (!this.grupos.containsKey(tema)) {
            grupos.put(tema, grupo);
        } else {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
        }
    }

    /**
     * Consulta um aluno a partir de sua matricula e mostra uma representacao em string do mesmo
     * 
     * @param matricula Matricula do aluno a ser exibido
     * @return Representacao em string do aluno
     */
    public String consultaAluno(String matricula) {
        if (this.alunos.get(matricula) != null) {
            return this.alunos.get(matricula).toString();
        } else {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO.");
        }
    }

    /**
     * Adiciona um aluno ja cadastrado em um grupo previamente criado.
     * 
     * @param matricula Matricula do aluno a ser adicionado no grupo.
     * @param tema Tema do grupo no qual o aluno vai ser adicionado
     */
    public void alocarAlunoEmGrupo(String matricula, String tema) {
        if (!this.alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO.");
        }
        if (!this.grupos.containsKey(tema)) {
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO");
        }

        Aluno aluno = this.alunos.get(matricula);
        Grupo grupo = this.grupos.get(tema);

        grupo.adicionaAluno(aluno);
    }

    /**
     * Verifica se um aluno pertence ou nao a um grupo especifico.
     * 
     * @param tema Tema do grupo que se deseja verificar.
     * @param matricula Matricula do aluno a ser verificado.
     * @return Booleano que confirma ou nega a presenca do aluno no grupo.
     */
    public boolean pertinenciaGrupo(String tema, String matricula) {
        if (!this.grupos.containsKey(tema)) {
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO");
        }

        Grupo grupo = this.grupos.get(tema);

        if (grupo.getAlunos().contains(this.alunos.get(matricula))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Imprime todos os grupos que o aluno faz parte e a lotacao de cada um.
     * 
     * @param matricula Matricula do aluno a ser pesquisado
     * @return String que mostra todos os grupos que o aluno faz parte e sua lotacao.
     */
    public String checagemGrupos(String matricula) {
        String out = "";

        for (Grupo grupo : this.grupos.values()) {         
            if (grupo.getAlunos().contains(this.alunos.get(matricula))) {
                if (grupo.getTamanho() == Integer.MAX_VALUE) {
                    out += "\n- " + grupo.getTema() + " " + grupo.getAlunos().size() + "/Ilimitado"; 
                } else {
                    out += "\n- " + grupo.getTema() + " " + grupo.getAlunos().size() + "/" + grupo.getTamanho();            
                }
            }
        }
        return out;
    }
}
