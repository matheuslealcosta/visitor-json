package padroescomportamentais.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PessoaJsonVisitorTest {

    @Test
    void deveExibirAlunoEmJson() {
        Aluno aluno = new Aluno(1, "Ana", new Curso("Sistemas de Informação"));

        PessoaJsonVisitor visitor = new PessoaJsonVisitor();
        assertEquals("""
                { 
                  "matricula": 1,
                  "nome": "Ana",
                  "curso": "Sistemas de Informação"
                }""", visitor.exibir(aluno));
    }

    @Test
    void deveExibirProfessorEmJson() {
        Professor professor = new Professor(1, "Maria", "Doutorado");

        PessoaJsonVisitor visitor = new PessoaJsonVisitor();
        assertEquals("""
                {
                  "matricula": 1,
                  "nome": "Maria",
                  "titulacao": "Doutorado"
                }""", visitor.exibir(professor));
    }

    @Test
    void deveExibirFuncionarioEmJson() {
        Funcionario funcionario = new Funcionario(1, "Pedro", 5000.0f);

        PessoaJsonVisitor visitor = new PessoaJsonVisitor();
        assertEquals("""
                {
                  "codigo": 1,
                  "nome": "Pedro",
                  "salario": 5000.0
                }""", visitor.exibir(funcionario));
    }

    @Test
    void deveExibirMesmoAlunoNosDoisFormatos() {
        Aluno aluno = new Aluno(2, "Bruno", new Curso("Ciência da Computação"));

        PessoaVisitor visitor = new PessoaVisitor();
        PessoaJsonVisitor visitorJson = new PessoaJsonVisitor();
        assertEquals("Aluno{matricula=2, nome='Bruno', curso=Ciência da Computação}", visitor.exibir(aluno));
        assertEquals("""
                {
                  "matricula": 2,
                  "nome": "Bruno",
                  "curso": "Ciência da Computação"
                }""", visitorJson.exibir(aluno));
    }

}
