package ControleDeAlunos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Controle {
    private HashMap<String, Aluno> alunos;
    private HashSet<Grupo> grupos;

    public void cadastraAluno(String matricula, String nome, String curso) {
        Aluno aluno = new Aluno(matricula, nome, curso);

        if (!this.alunos.containsKey(matricula)) {
            this.alunos.put(matricula, aluno);
        } else {
            throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA!");
        }
    }

    public void criaGrupo(String tema) {
        Grupo grupo = new Grupo(tema.toLowerCase());

        if (!this.grupos.contains(grupo)) {
            grupos.add(grupo);
        } else {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
        }
    }

    public void criaGrupo(String tema, int tamanho) {
        Grupo grupo = new Grupo(tema.toLowerCase(), tamanho);

        if (!this.grupos.contains(grupo)) {
            grupos.add(grupo);
        } else {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
        }
    }

    public String consultaAluno(String matricula) {
        if (this.alunos.get(matricula) != null) {
            return this.alunos.get(matricula).toString();
        } else {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO.");
        }
    }

    public void alocarAlunoEmGrupo(String matricula, String tema) {
        if (!this.alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO.");
        }
        if (!grupoCadastrado(tema)) {
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO");
        }

        Aluno aluno = this.alunos.get(matricula);
        for (Grupo gru : this.grupos) {
            if (gru.getTema().equals(tema)) {
                gru.adicionaAluno(aluno);
            }
        }
    }

    private boolean grupoCadastrado(String tema) {
        for (Grupo gru : this.grupos) {
            if (gru.getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    public boolean pertinenciaGrupo(String tema, String matricula) {
        if (!grupoCadastrado(tema)) {
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO");
        }

        for (Grupo grupo : this.grupos) {
            for(Aluno aluno : grupo.getAlunos()) {
                if (aluno.equals(this.alunos.get(matricula))) {
                    return true;
                }
            }
        }
        return false;
    }

    public String checagemGrupos(String matricula) {
        String out = "";

        for (Grupo grupo : this.grupos) {
            for(Aluno aluno : grupo.getAlunos()) {
                if (aluno.equals(this.alunos.get(matricula))) {
                    out += "\n- " + grupo.getTema() + " " + grupo.getAlunos().size() + "/" + grupo.getTamanho();
                }
            }
        }
        return out;
    }
}
