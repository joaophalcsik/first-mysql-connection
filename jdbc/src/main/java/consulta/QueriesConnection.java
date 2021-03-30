package consulta;

import java.util.List;
import java.sql.*;


public class QueriesConnection {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();

        // Consultar
        List<Aluno> alunos = alunoDAO.list();

        alunos.stream().forEach(System.out::println);


        // Consultar com filtro
        Aluno alunoParaConsulta = alunoDAO.getById(1);


        // Insercão
        Aluno alunoParaInsercao = new Aluno(
                "Matheus",
                40,
                "SP"
        );

        // Atualizar
        Aluno alunoParaAtualizar = alunoDAO.getById(3);
        alunoParaAtualizar.setNome("Paulo");
        alunoParaAtualizar.setIdade(18);
        alunoParaAtualizar.setEstado("SC");

        // Delete
        alunoDAO.delete(1);
    }
}
