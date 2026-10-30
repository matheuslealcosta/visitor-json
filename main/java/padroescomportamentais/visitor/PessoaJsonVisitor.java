package padroescomportamentais.visitor;

public class PessoaJsonVisitor implements Visitor {

    public String exibir(Pessoa pessoa) {
        return pessoa.aceitar(this);
    }

    @Override
    public String exibirAluno(Aluno aluno) {
        return "{\n" +
                "  \"matricula\": " + aluno.getMatricula() + ",\n" +
                "  \"nome\": \"" + aluno.getNome() + "\",\n" +
                "  \"curso\": \"" + aluno.getNomeCurso() + "\"\n" +
                "}";
    }

    @Override
    public String exibirProfessor(Professor professor) {
        return "{\n" +
                "  \"matricula\": " + professor.getMatricula() + ",\n" +
                "  \"nome\": \"" + professor.getNome() + "\",\n" +
                "  \"titulacao\": \"" + professor.getTitulacao() + "\"\n" +
                "}";
    }

    @Override
    public String exibirFuncionario(Funcionario funcionario) {
        return "{\n" +
                "  \"codigo\": " + funcionario.getCodigo() + ",\n" +
                "  \"nome\": \"" + funcionario.getNome() + "\",\n" +
                "  \"salario\": " + funcionario.getSalario() + "\n" +
                "}";
    }
}
