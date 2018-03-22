package workshop.controllers;

import workshop.model.Funcionario;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class ControllerFunc_J8 {

    private static final String NOME_DO_ARQUIVO = "exemplo.data";
    private List<Funcionario> funcionarios;

    public ControllerFunc_J8() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();

    }

    public void ordenarPorSalario() {
    }

    public void iniciarExpediente() {
    }

    public void encerrarExpediente() {

    }

    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
        return null;
    }

    public void imprimirFuncionarios(){
    }

    public void aumentoSalario(int limite, double percentil){
    }
    public List<Funcionario> filtroDeIdade(int idade) {
    }

    public List<Funcionario> filtroDeDepartamento(String departamento) {

    }

    public double mediaSalarial() {

    }

    public double custoFolhaPagamento() {

    }

    public Map<String, Double> mediaSalarioDpt() {

    }

    public Double mediaSalarioDpt(String dpt) {

    }


    public Funcionario maiorSalario() {

    }

    public Funcionario menorSalario() {

    }

    public boolean alguemFoiDemitido() {

    }

    public Map<String, List<Funcionario>> listaParaMapa() {

    }

}

