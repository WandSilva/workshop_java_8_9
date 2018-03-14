/**
 * Created by wanderson on 13/03/18.
 */
public class Funcionario {

    private String nome;
    private String departamento;
    private int idade;
    private int salario;


    public Funcionario(String nome, String departamento, int idade, int salario) {
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

    public int getSalario() {
        return salario;
    }
}
