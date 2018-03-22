package workshop.controllers;

import workshop.model.Funcionario;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class ControllerFunc_J8 {

    private static final String NOME_DO_ARQUIVO = "funcionarios.data";
    private List<Funcionario> funcionarios;

    public ControllerFunc_J8() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();

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

    public Map<String, Double> mediaSalarioDpt() {
        return null;
    }

    public Double mediaSalarioDpt(String dpt) {
        return null;
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

}

