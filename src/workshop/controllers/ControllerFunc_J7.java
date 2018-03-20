package workshop.controllers;

import workshop.model.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by wanderson on 13/03/18.
 */
public class ControllerFunc_J7 {
    private static String NOME_DO_ARQUIVO = "exemplo.data";
    private List<Funcionario> funcionarios;

    public ControllerFunc_J7() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();
    }

    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ControllerFunc_J7.NOME_DO_ARQUIVO));
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

    public List<Funcionario> filtroDeIdade(int idade) {
        //Mostra o nome dos funcionários que possuem mais de X anos

        List<Funcionario> filtro = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            if (f.getIdade() > idade)
                filtro.add(f);
        }
        return filtro;
    }

    public List<Funcionario> filtroDeDepartamento(String departamento) {
        List<Funcionario> filtro = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            if (f.getDepartamento().equals(departamento)) {
                filtro.add(f);
            }
        }
        return filtro;
    }

    public double mediaSalarial() {
        double media = 0;
        for (Funcionario f : funcionarios) {
            media += f.getSalario();
        }
        media = media / funcionarios.size();
        return media;
    }

    public double medianaSalarial() {
        double mediana = 0;
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
            mediana = ((x + y) / 2);
            System.out.println("Mediana: " + mediana);
        }
        return mediana;
    }


    public Funcionario maiorSalario() {
        Funcionario funcionario = funcionarios.get(0);
        for (Funcionario f : funcionarios) {
            if (f.getSalario() > funcionario.getSalario())
                funcionario = f;
        }
        return funcionario;
    }

    public Funcionario menorSalario() {
        Funcionario funcionario = funcionarios.get(0);
        for (Funcionario f : funcionarios) {
            if (f.getSalario() < funcionario.getSalario())
                funcionario = f;
        }
        return funcionario;
    }

    public void ordenarPorSalario() {

    }

    public Map<String, List<Funcionario>> listaParaMapa() {

        List<Funcionario> funcsDoDepartamento;
        Map<String, List<Funcionario>> mapaDerpamento = new HashMap<>();

        for (Funcionario f : funcionarios) {

            funcsDoDepartamento = filtroDeDepartamento(f.getDepartamento());

            if (mapaDerpamento.containsKey(f.getDepartamento())) {
                mapaDerpamento.put(f.getDepartamento(), funcsDoDepartamento);
            }
        }
        return mapaDerpamento;
    }
}
