package workshop.model;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanderson on 13/03/18.
 */
public class Funcionario {

    private String nome;
    private String departamento;
    private int idade;
    private double salario;
    private boolean contratado;


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

    public boolean estaContratado() {
        return contratado;
    }

    public void demitir() {
        this.contratado = false;
    }

    public void contratar() {
        this.contratado = true;
    }

    public void trabalhar() {
        try {
            while (true) {
                System.out.println("Estou trabalhando...");
                TimeUnit.SECONDS.sleep(1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
