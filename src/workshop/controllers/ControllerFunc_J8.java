package workshop.controllers;

import workshop.model.Departamento;
import workshop.model.Funcionario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ControllerFunc_J8 {

    private static final String NOME_DO_ARQUIVO = "funcionarios.data";
    private List<Funcionario> funcionarios;
    private List<Thread> tarefas;

    public ControllerFunc_J8() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();
        this.tarefas = new ArrayList<>();
    }

    public List<Funcionario> ordenarPorSalario() {
       this.funcionarios.sort(Comparator.comparingDouble(Funcionario::getSalario));
       return this.funcionarios;
    }


    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
        return Files.lines(Paths.get(NOME_DO_ARQUIVO))
                .map(Funcionario::extrairDeString)
                .collect(Collectors.toList());
    }

    public void imprimirFuncionarios(){
        this.funcionarios.stream()
                .forEach(System.out::println);
    }

    public void aumentoSalario(int limite, double percentil){
        this.funcionarios.stream()
                .filter(f-> f.getSalario() < limite)
                .forEach(f-> f.aumentarSalario(percentil));
    }

    public void aumentoSalario(double percentil){
        this.funcionarios.forEach(f-> f.aumentarSalario(percentil));
    }

    public List<Funcionario> filtroDeIdade(int idade) {
       return  this.funcionarios.stream()
                .filter(f-> f.getIdade() < idade)
                .collect(Collectors.toList());
    }

    public List<Funcionario> filtroDeDepartamento(String departamento) {
        return this.funcionarios.stream()
                .collect(Collectors.filtering(
                        f-> f.getDepartamento().equals(departamento),
                        Collectors.toList()));
    }

    public double mediaSalarial() {
        return this.funcionarios.stream()
                .mapToDouble(Funcionario::getSalario)
                .average()
                .orElse(0);
    }

    public double custoDosTop3(){
        //Alternativa 1
        this.listaParaMapa().entrySet().stream()
                .collect(Collectors.toMap(
                        k-> k.getKey(),
                        k-> k.getValue().stream()
                                .mapToDouble(Funcionario::getSalario)
                                .sum()
                )).entrySet().stream()
                .mapToDouble(Map.Entry::getValue)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToDouble(Double::shortValue)
                .limit(3)
                .sum();

        //Alternativa 2
        return this.listaParaMapa().entrySet().stream()
                .collect(Collectors.toList())
                .stream()
                .map(s -> s.getValue().stream().mapToDouble(Funcionario::getSalario).sum())
                .sorted(Comparator.reverseOrder())
                .mapToDouble(Double::shortValue)
                .limit(3)
                .sum();

    }

    public double custoFolhaPagamento() {
        return this.funcionarios.stream()
                .mapToDouble(Funcionario::getSalario)
                .sum();
    }

    public Funcionario maiorSalario() {
        return this.funcionarios.stream()
                .max(Comparator.comparingDouble(Funcionario::getSalario))
                .get();
    }

    public Funcionario menorSalario() {
        return this.funcionarios.stream()
                .min(Comparator.comparingDouble(Funcionario::getSalario))
                .get();
    }

    public boolean alguemFoiDemitido() {
        return this.funcionarios.stream()
                .anyMatch(f-> !f.estaContratado());
    }

    public void iniciarExpediente() {
        this.funcionarios.stream()
                .map(f-> new Thread(f::trabalhar))
                .collect(Collectors.toCollection(()-> this.tarefas))
                .forEach(Thread::start);
    }

    public void encerrarExpediente() {
        this.tarefas.forEach(Thread::interrupt);
        this.tarefas.clear();
    }

    public void cortarCustos(double tetoSalario){
        List<Funcionario> demitidos = new ArrayList<>();

        this.funcionarios.stream()
                .filter(f-> f.getSalario() > tetoSalario)
                .filter(f-> !f.getDepartamento().equals("RH"))
                .collect(Collectors.toCollection(()->demitidos));
    }

    public Map<String, List<Funcionario>> listaParaMapa() {
        return this.funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getDepartamento));
    }

    public Map<String, Double> mediaSalarioDpt() {
        return this.listaParaMapa().entrySet().stream()
                .collect(Collectors.toMap(
                        k-> k.getKey(),
                        k-> k.getValue().stream()
                                .mapToDouble(Funcionario::getSalario)
                                .average()
                                .orElse(0)
                ));
    }

}

