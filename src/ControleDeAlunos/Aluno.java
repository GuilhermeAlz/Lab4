package ControleDeAlunos;

public class Aluno {
    private String matricula;
    private String nome;
    private String curso;


    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }


    @Override
    public int hashCode() {
        return this.matricula.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        
        Aluno al = (Aluno) o;
        return this.matricula.equals(al.matricula);
    }

    
    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso; 
    }
}
