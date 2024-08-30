package Service;

import Model.Aluno;

public class DisciplinaService {
    // Método para adicionar aluno
    public void adicionarAluno(Aluno aluno) {
        if (isAtivo && !alunos.contains(aluno)) {
            alunos.add(aluno);
        }
    }
    // Método para remover aluno
    public void removerAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
            verificarAtivacao();
        }
    }
}
