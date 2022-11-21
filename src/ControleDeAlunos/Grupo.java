package ControleDeAlunos;

import java.util.HashSet;

public class Grupo {
    private String tema;
    private HashSet<Aluno> alunos;
    private int tamanho;
    
    /**
     * Constroi um grupo com um tema e um tamanho
     * 
     * @param tema Tema de estudo do grupo
     * @param tamanho Tamanho limite do grupo
     */
    public Grupo(String tema, int tamanho) {
        this.tema = tema;
        this.alunos = new HashSet<Aluno>();
        this.tamanho = tamanho;
    }

    /**
     * Cria um grupo apenas com um tema e tamanho ilimitado
     * 
     * @param tema Tema de estudo do grupo
     */
    public Grupo(String tema) {
        this.tema = tema;
        this.alunos = new HashSet<Aluno>();
        this.tamanho = Integer.MAX_VALUE;
    }

    /**
     * Retorna o tema do grupo
     * 
     * @return Tema do grupo
     */
    public String getTema() {
        return this.tema;
    }

    /**
     * Retorna o conjunto de alunos do grupo.
     * 
     * @return Alunos pertencentes ao grupo.
     */
    public HashSet<Aluno> getAlunos() {
        return this.alunos;
    }

    /**
     * Retorna o tamanho do grupo.
     * 
     * @return Tamanho do grupo.
     */
    public int getTamanho() {
        return this.tamanho;
    }

    /**
     * Adiciona um aluno ao grupo se ele ja nao fizer parte do mesmo.
     * 
     * @param aluno Aluno a ser adicionado ao grupo.
     */
    public void adicionaAluno(Aluno aluno) {
        if (this.alunos.size() < tamanho) {
            this.alunos.add(aluno);
        } else {
            throw new IllegalArgumentException("GRUPO CHEIO!");
        }
    }

    /**
     * Retorna o hashcode do grupo com base no tema do mesmo.
     */
    @Override
    public int hashCode() {
        return this.tema.hashCode();
    }

    /**
     * Checa se um grupo e igual a outro com base no tema do mesmo.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        
        Grupo gr = (Grupo) o;
        return this.tema.equals(gr.tema);
    }
}
