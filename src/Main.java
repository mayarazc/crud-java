import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu(){
        int opcao;

        do {
            System.out.println("\n===== Menu =====\n" +
                    "1. Adicionar Novo Aluno\n" +
                    "2. Buscar Aluno por Nome\n" +
                    "3. Excluir Aluno\n" +
                    "4. Listar Todos os Alunos\n" +
                    "5. Editar Dados de um Aluno\n" +
                    "6. Sair\n" +
                    "Escolha uma opção: ");

            opcao = scan.nextInt();

        } while (opcao < 1 || opcao > 6);

        switch (opcao){
            case 1:
                adicionarAluno();
                mostrarMenu();
                break;
            case 2:
                scan.nextLine();
                System.out.println("Digite o nome do aluno para fazer a busca: ");
                buscarAluno(scan.nextLine());
                mostrarMenu();
                break;
            case 3:
                scan.nextLine();
                System.out.println("Digite a matrícula do aluno para fazer a exclusão: ");
                excluirAluno(scan.nextLine());
                mostrarMenu();
                break;
            case 4:
                listarAlunos();
                mostrarMenu();
                break;
            case 5:
                scan.nextLine();
                System.out.println("Digite a matrícula do aluno: ");
                editarAluno(scan.nextLine());
                mostrarMenu();
                break;
            case 6:
                System.out.println("Saindo ...  ");
                break;
        }
    }

    public static void adicionarAluno(){
        Aluno aluno = new Aluno();
        scan.nextLine();
        System.out.println("Digite o nome do aluno: ");
        aluno.setNome(scan.nextLine());

        System.out.println("Digite a matrícula: ");
        aluno.setMatricula(scan.nextLine());

        System.out.println("Digite o nome do curso: ");
        aluno.setCurso(scan.nextLine());

        if(!aluno.getNome().equals("") || !aluno.getMatricula().equals("") || !aluno.getCurso().equals("")){
            alunos.add(aluno);
            System.out.println("Aluno adicionado com sucesso!");
        } else {
            System.out.print("Erro ao adicionar aluno.");
        }
    }

    public static Aluno buscarAluno(String dadoAluno) {
        Aluno alunoBusca = null;
        String dadoAlunoLowerCase = dadoAluno.toLowerCase();

        for (Aluno aluno : alunos) {
            String nomeAlunoLowerCase = aluno.getNome().toLowerCase();

            if (nomeAlunoLowerCase.contains(dadoAlunoLowerCase) || aluno.getMatricula().equalsIgnoreCase(dadoAluno)) {
                alunoBusca = aluno;
                System.out.println(aluno.retornarInfo());
                break;
            }
        }
        if (alunoBusca == null) {
            System.out.println("Aluno não encontrado");
        }
        return alunoBusca;
    }


    public static void excluirAluno(String matricula){
        Aluno alunoBusca = buscarAluno(matricula);

        if(!matricula.equalsIgnoreCase("") && alunoBusca != null){
            alunos.remove(alunoBusca);
            System.out.println("Aluno removido com sucesso!");

        } else {
            System.out.println("Não foi possível excluir o aluno.");
        }
    }

    public static void listarAlunos(){
        for (Aluno aluno : alunos){
            System.out.print(aluno.retornarInfo());
        }
    }

    public static void editarAluno(String matricula){
        Aluno alunoBusca = buscarAluno(matricula);

        if(!matricula.equals("") && alunoBusca != null){
            System.out.println("Digite os dados a serem atualizados: ");

            System.out.println("Nome: ");
            String inputNome = scan.nextLine();

            if (!inputNome.equals("")) {
                alunoBusca.setNome(inputNome);
            }

            System.out.println("Matrícula: ");
            String inputMatricula = scan.nextLine();

            if (!inputMatricula.equals("")) {
                alunoBusca.setMatricula(inputMatricula);
            }

            System.out.println("Curso: ");
            String inputCurso = scan.nextLine();

            if (!inputCurso.equals("")) {
                alunoBusca.setCurso(inputCurso);
            }

            System.out.println("Aluno editado com sucesso!");

        } else {
            System.out.println("Não foi possível editar o aluno.");
        }
    }
}