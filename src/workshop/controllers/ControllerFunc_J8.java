package workshop.controllers;

import workshop.model.Funcionario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerFunc_J8 {

    private static String NOME_DO_ARQUIVO = "exemplo.data";
    private List<Funcionario> funcionarios;

    public ControllerFunc_J8() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();
    }

    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
        return null;
    }

    public List<Funcionario> filtroDeIdade(int idade) {
        return null;
    }

    public List<Funcionario> filtroDeDepartamento(String departamento) {
        return null;
    }

    public double mediaSalarial() {
        return 0;
    }

    public double custoFolhaPagamento(){
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

    public boolean alguemFoiDemitido(){
        return false;
    }

    public void iniciarExpediente(){
    }

    public Map<String, List<Funcionario>> listaParaMapa() {
        return null;
    }
}

