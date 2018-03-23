package workshop.controllers;

import workshop.model.Funcionario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;


public class ControllerFunc_J8 {

    private static final String NOME_DO_ARQUIVO = "funcionarios.data";
    private List<Funcionario> funcionarios;
    private List<Thread> tarefas;

    public ControllerFunc_J8() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();
        this.tarefas = new ArrayList<>();
    }

    public List<Funcionario> ordenarPorSalario() {
        return null;
    }


    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
        return null;
    }

    public void imprimirFuncionarios(){
    }

    public void aumentoSalario(int limite, double percentil){
    }

    public void aumentoSalario(double percentil){

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

    public double custoFolhaPagamento() {
     return 0;
    }

    public Funcionario maiorSalario() {
        return null;
    }

    public Funcionario menorSalario() {
        return null;
    }

    public boolean alguemFoiDemitido() {
        return false;
    }

    public void iniciarExpediente() {
    }

    public void encerrarExpediente() {
    }

    public Map<String, List<Funcionario>> listaParaMapa() {
        return null;

    }

    public Map<String, Double> mediaSalarioDpt() {
        return null;
    }

}

