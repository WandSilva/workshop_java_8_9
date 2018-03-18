package workshop.controllers;

import workshop.model.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wanderson on 13/03/18.
 */
public class ControllerFuncionarios {
    private static String NOME_DO_ARQUIVO = "exemplo.data";
    private List<Funcionario> funcionarios;

    public ControllerFuncionarios() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();
    }

    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ControllerFuncionarios.NOME_DO_ARQUIVO));
        Funcionario funcionario;
        List<Funcionario> funcionarios = new ArrayList<>();

        while (br.ready()) {
            String linha = br.readLine();
            funcionario = Funcionario.extrairDeString(linha);
            funcionarios.add(funcionario);
        }
        br.close();

        return funcionarios;
    }

    public void filtroDeIdade(int idade) {
        //Mostra o nome dos funcionários que possuem mais de X anos
        for (Funcionario f : funcionarios) {
            if (f.getIdade() > idade)
                System.out.println(f);
        }
    }


    public void mediaSalarial() {
        double media = 0;
        for (Funcionario f : funcionarios) {
            media += f.getSalario();
        }
        media = media / funcionarios.size();
        System.out.println("Média salarial: " + media);
    }

    public void medianaSalarial() {
        int resto = funcionarios.size() % 2;
        //para um lista de tamanho impar basta pegar o valor do meio
        if (resto > 0) {
            int indice = funcionarios.size() / 2;
            System.out.println("Mediana: " + funcionarios.get(indice).getSalario());
        }
        //para uma lista de tamanho par deve-se usar a média dos dois valores centrais
        else if (resto == 0) {
            int indice = funcionarios.size() / 2;
            double x = funcionarios.get(indice - 1).getSalario();
            double y = funcionarios.get(indice).getSalario();
            double mediana = ((x + y) / 2);
            System.out.println("Mediana: " + mediana);
        }
    }


    public void maiorSalario() {
        Funcionario funcionario = funcionarios.get(0);
        for (Funcionario f : funcionarios) {
            if (f.getSalario() > funcionario.getSalario())
                funcionario = f;
        }
        System.out.println("Maior salario:");
        System.out.println(funcionario);
    }

    public void menorSalario() {
        Funcionario funcionario = funcionarios.get(0);
        for (Funcionario f : funcionarios) {
            if (f.getSalario() < funcionario.getSalario())
                funcionario = f;
        }
        System.out.println("Menor salario:");
        System.out.println(funcionario);
    }

    public void ordenarPorSalario() {

        Collections.sort(funcionarios, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario f1, Funcionario f2) {
                return f1.getSalario().compareTo(f2.getSalario());
            }
        });

        for (Funcionario f : funcionarios)
            System.out.println(f);
    }

}
