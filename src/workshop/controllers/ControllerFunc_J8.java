package workshop.controllers;

import workshop.model.Funcionario;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ControllerFunc_J8 {

    private static String NOME_DO_ARQUIVO = "exemplo.data";
    private List<Funcionario> funcionarios;

    //contrutor
    public ControllerFunc_J8() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();

    }

    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
        return null;
    }

    public List<Funcionario> filtroDeIdade(int idade) {
        return null;
    }

    public double mediaSalarial() {
        return 0;
    }

    public double medianaSalarial() {
        return 0;
    }


    public Funcionario maiorSalario() {
        return null;
    }

    public Funcionario menorSalario() {
        return null;
    }

    public void ordenarPorSalario() {

    }

    public Map<String, List<Funcionario>> listaParaMapa() {
        return null;
    }

}

