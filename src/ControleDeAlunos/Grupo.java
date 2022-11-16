package ControleDeAlunos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Grupo {
    private String tema;
    private HashSet<Aluno> alunos;
    private int tamanho;
    
    public Grupo(String tema, int tamanho) {
        this.tema = tema;
        this.tamanho = tamanho;
    }

    public Grupo(String tema) {
        this.tema = tema;
        this.tamanho = Integer.MAX_VALUE;
    }

    public String getTema() {
        return this.tema;
    }

    public HashSet<Aluno> getAlunos() {
        return this.alunos;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void adicionaAluno(Aluno aluno) {
        if (this.alunos.size() < tamanho) {
            this.alunos.add(aluno);
        } else {
            throw new IllegalArgumentException("GRUPO CHEIO!");
        }
    }

    @Override
    public int hashCode() {
        return this.tema.hashCode();
    }

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
