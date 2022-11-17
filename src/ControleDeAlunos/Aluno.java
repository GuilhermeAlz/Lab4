package ControleDeAlunos;

/**
 * Classe que representa um aluno com nome, matricula e curso.
 */
public class Aluno {
    private String matricula;
    private String nome;
    private String curso;

    /**
     * Constroi um aluno.
     */
    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Retorna o hashcode de um aluno com base no hashcode de sua matricula.
     * 
     * @return hashcode do aluno.
     */
    @Override
    public int hashCode() {
        return this.matricula.hashCode();
    }

    /**
     * Checa se dois alunos sao iguais com base nas suas matriculas.
     * 
     * @return Booleano que confirma ou nega a igualdade.
     */
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

    /**
     * Representacao em string de um aluno
     * 
     * @return String que representa o aluno no formato "matricula - nome - curso".
     */
    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso; 
    }
}
