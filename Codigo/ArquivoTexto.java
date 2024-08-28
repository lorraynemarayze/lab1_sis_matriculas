import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTexto {

    // Método para salvar uma lista de cursos em cursos.txt
    public static void salvarCursos(List<Curso> cursos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cursos.txt"))) {
            for (Curso curso : cursos) {
                writer.write(curso.getNome() + ";" + curso.getId() + ";" + curso.getDuracao());
                writer.newLine();
            }
        }
    }

    // Método para carregar uma lista de cursos de cursos.txt
    public static List<Curso> carregarCursos() throws IOException {
        List<Curso> cursos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("cursos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                cursos.add(new Curso(partes[0], partes[1], Integer.parseInt(partes[2])));
            }
        }
        return cursos;
    }

    // Método de pesquisa para um curso pelo ID
    public static Curso pesquisarCursoPorId(String id) throws IOException {
        List<Curso> cursos = carregarCursos();
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        return null; 
    }

    // Método para salvar uma lista de alunos em alunos.txt
    public static void salvarAlunos(List<Aluno> alunos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("alunos.txt"))) {
            for (Aluno aluno : alunos) {
                writer.write(aluno.getNome() + ";" + aluno.getId());
                writer.newLine();
            }
        }
    }

    // Método para carregar uma lista de alunos de alunos.txt
    public static List<Aluno> carregarAlunos() throws IOException {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("alunos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                alunos.add(new Aluno(partes[0], partes[1]));
            }
        }
        return alunos;
    }

    // Método de pesquisa para um aluno pelo ID
    public static Aluno pesquisarAlunoPorId(String id) throws IOException {
        List<Aluno> alunos = carregarAlunos();
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        return null; 
    }

    // Método para salvar uma lista de professores em professores.txt
    public static void salvarProfessores(List<Professor> professores) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("professores.txt"))) {
            for (Professor professor : professores) {
                writer.write(professor.getNome() + ";" + professor.getId() + ";" + professor.getSenha());
                writer.newLine();
            }
        }
    }

    // Método para carregar uma lista de professores de professores.txt
    public static List<Professor> carregarProfessores() throws IOException {
        List<Professor> professores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("professores.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                professores.add(new Professor(partes[0], partes[1], partes[2]));
            }
        }
        return professores;
    }

    // Método de pesquisa para um professor pelo ID
    public static Professor pesquisarProfessorPorId(String id) throws IOException {
        List<Professor> professores = carregarProfessores();
        for (Professor professor : professores) {
            if (professor.getId().equals(id)) {
                return professor;
            }
        }
        return null; 

    // Método para salvar uma lista de disciplinas em disciplinas.txt
    public static void salvarDisciplinas(List<Disciplina> disciplinas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("disciplinas.txt"))) {
            for (Disciplina disciplina : disciplinas) {
                writer.write(disciplina.getNome() + ";" + disciplina.getId() + ";" + disciplina.getCargaHoraria());
                writer.newLine();
            }
        }
    }

    // Método para carregar uma lista de disciplinas de disciplinas.txt
    public static List<Disciplina> carregarDisciplinas() throws IOException {
        List<Disciplina> disciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("disciplinas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                disciplinas.add(new Disciplina(partes[0], partes[1], Integer.parseInt(partes[2])));
            }
        }
        return disciplinas;
    }

    // Método de pesquisa para uma disciplina pelo ID
    public static Disciplina pesquisarDisciplinaPorId(String id) throws IOException {
        List<Disciplina> disciplinas = carregarDisciplinas();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId().equals(id)) {
                return disciplina;
            }
        }
        return null; 
    }

    // Método para salvar uma lista de secretários em secretarios.txt
    public static void salvarSecretarios(List<Secretario> secretarios) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("secretarios.txt"))) {
            for (Secretario secretario : secretarios) {
                writer.write(secretario.toString()); 
                writer.newLine();
            }
        }
    }

    // Método para carregar uma lista de secretários de secretarios.txt
    public static List<Secretario> carregarSecretarios() throws IOException {
        List<Secretario> secretarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("secretarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                secretarios.add(new Secretario()); 
            }
        }
        return secretarios;
    }

    // Método de pesquisa para um secretário pelo ID
    public static Secretario pesquisarSecretarioPorId(String id) throws IOException {
        List<Secretario> secretarios = carregarSecretarios();
        for (Secretario secretario : secretarios) {
            if (secretario.getId().equals(id)) { 
                return secretario;
            }
        }
        return null; 
    }

    }
}