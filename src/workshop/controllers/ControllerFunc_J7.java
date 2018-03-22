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

        for (Funcionario f : this.funcionarios) {
            if (f.getIdade() > idade)
                filtro.add(f);
        }
        return filtro;
    }

    public List<Funcionario> filtroDeDepartamento(String departamento) {
        List<Funcionario> filtro = new ArrayList<>();

        for (Funcionario f : this.funcionarios) {
            if (f.getDepartamento().equals(departamento)) {
                filtro.add(f);
            }
        }
        return filtro;
    }

    public double mediaSalarial() {
        double media = 0;
        for (Funcionario f : this.funcionarios) {
            media += f.getSalario();
        }
        media = media / this.funcionarios.size();
        return media;
    }

    public double custoFolhaPagamento(){
        double custo = 0;

        for(Funcionario f: this.funcionarios){
            custo += f.getSalario();
        }

        return custo;
    }


    public Funcionario maiorSalario() {
        Funcionario funcionario = this.funcionarios.get(0);
        for (Funcionario f : this.funcionarios) {
            if (f.getSalario() > funcionario.getSalario())
                funcionario = f;
        }
        return funcionario;
    }

    public Funcionario menorSalario() {
        Funcionario funcionario = this.funcionarios.get(0);
        for (Funcionario f : this.funcionarios) {
            if (f.getSalario() < funcionario.getSalario())
                funcionario = f;
        }
        return funcionario;
    }

    public void ordenarPorSalario() {

    }

    public boolean alguemFoiDemitido(){
        boolean demitido = false;

        for(Funcionario f : this.funcionarios){
            if(!f.estaContratado()){
                return true;
            }
        }
        return false;
    }

    public void iniciarExpediente(){
    }

    public Map<String, List<Funcionario>> listaParaMapa() {

        List<Funcionario> funcsDoDepartamento;
        Map<String, List<Funcionario>> mapaDerpamento = new HashMap<>();

        for (Funcionario f : this.funcionarios) {

            funcsDoDepartamento = filtroDeDepartamento(f.getDepartamento());

            if (!mapaDerpamento.containsKey(f.getDepartamento())) {
                mapaDerpamento.put(f.getDepartamento(), funcsDoDepartamento);
            }
        }
        return mapaDerpamento;
    }
}
