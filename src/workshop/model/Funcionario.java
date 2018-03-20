package workshop.model;

import java.util.Scanner;

/**
 * Created by wanderson on 13/03/18.
 */
public class Funcionario {

    private String nome;
    private String departamento;
    private int idade;
    private double salario;


    public Funcionario(String nome, String departamento, int idade, double salario) {
        this.nome = nome;
        this.departamento = departamento;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getIdade() {
        return idade;
    }

    public Double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, departamento: %s, idade: %d, salario: %.2f",
                getNome(), getDepartamento(), getIdade(), getSalario());
    }

    public static Funcionario extrairDeString(String stringFuncionario) {
        Scanner leitor = new Scanner(stringFuncionario);
        leitor.useDelimiter(";");

        String nome = leitor.next();
        String departamento = leitor.next();
        int idade = leitor.nextInt();
        double salario = leitor.nextDouble();

        return new Funcionario(nome, departamento, idade, salario);
    }

    public void demitir() {
        this.departamento = "desempregado";
        this.salario = 0;
    }
}
