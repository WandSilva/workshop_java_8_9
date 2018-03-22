package workshop.controllers;

import workshop.model.Departamento;
import workshop.model.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by wanderson on 13/03/18.
 */
public class ControllerFunc_J7 {
    private static final String NOME_DO_ARQUIVO = "funcionarios.data";
    private List<Funcionario> funcionarios;
    private List<Thread> tarefas;

    public ControllerFunc_J7() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();
        this.tarefas = new ArrayList<>(this.funcionarios.size());
    }

    public List<Funcionario> ordenarPorSalario() {
        return null;
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

    public void imprimirFuncionarios(){
        for(Funcionario f: this.funcionarios){
            System.out.println(f);
        }
    }

    public void aumentoSalario(int limite, double percentil){
        for(Funcionario f: this.funcionarios){
            if(f.getSalario() < limite){
                f.aumentarSalario(percentil);
            }
        }
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

    public double custoFolhaPagamento() {
        double custo = 0;

        for (Funcionario f : this.funcionarios) {
            custo += f.getSalario();
        }

        return custo;
    }

    public Map<String, Double> mediaSalarioDpt() {
        Map<String, Double> mediaPorDpt = new HashMap();
        Map<String, List<Funcionario>> mapaDpt = this.listaParaMapa();

        for (Map.Entry<String, List<Funcionario>> map : mapaDpt.entrySet()) {
            double contador = 0;
            for (Funcionario f : map.getValue()) {
                contador += f.getSalario();
                double media = contador / map.getValue().size();
                mediaPorDpt.put(map.getKey(), media);
            }
        }
        return mediaPorDpt;
    }

    public Double mediaSalarioDpt(String dpt) {

        List<Funcionario> funcionarios = this.listaParaMapa().get(dpt);
        double contador = 0;
        for (Funcionario f : funcionarios) {
            contador += f.getSalario();
        }
        double media = contador / funcionarios.size();
        return media;
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

    public boolean alguemFoiDemitido() {
        boolean demitido = false;

        for (Funcionario f : this.funcionarios) {
            if (!f.estaContratado()) {
                return true;
            }
        }
        return false;
    }

    public void iniciarExpediente() {
        for(Funcionario f: this.funcionarios){
            Runnable tarefa = new Runnable() {
                @Override
                public void run() {
                    f.trabalhar();
                }
            };
            Thread t = new Thread(tarefa);
            this.tarefas.add(t);
            t.start();
        }
    }

    public void encerrarExpediente() {

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
