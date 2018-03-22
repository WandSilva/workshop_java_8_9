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

    private static final String NOME_DO_ARQUIVO = "exemplo.data";
    private List<Funcionario> funcionarios;
    private List<Thread> tarefas;

    //contrutor
    public ControllerFunc_J8() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();
        this.tarefas = new ArrayList<>(this.funcionarios.size());
    }

    public void imprimirFuncionarios(){
        this.funcionarios.forEach(System.out::println);
    }

    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
       return Files.lines(Paths.get(NOME_DO_ARQUIVO))
                .map(Funcionario::extrairDeString)
                .collect(Collectors.toList());
    }

    public List<Funcionario> filtroDeIdade(int idade) {
        return this.funcionarios.stream()
                .filter(f -> f.getIdade() > idade)
                .collect(Collectors.toList());
    }

    public double mediaSalarial() {
        return this.funcionarios.stream()
                .mapToDouble(Funcionario::getSalario)
                .average()
                .orElse(0);
    }

    public double medianaSalarial() {
        return 0;
    }

    public void aumentoSalario(int limite, double percentil){
        this.funcionarios.stream()
                .filter(f-> f.getSalario() < limite)
                .forEach(f -> f.aumentarSalario(percentil));
    }


    public Funcionario maiorSalario() {
        return this.funcionarios.stream()
                .max(Comparator.comparing(Funcionario::getSalario))
                .get();
    }

    public Funcionario menorSalario() {
               return this.funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getSalario)
                        .reversed()
                        .thenComparing(Funcionario::getNome))
                .get();
    }

    public Map<String, Double> mediaSalarioDpt(){
        return this.listaParaMapa().entrySet().stream()
                .collect(
                        Collectors.toMap(Map.Entry::getKey,
                                data-> data.getValue().stream()
                                        .mapToDouble(Funcionario::getSalario)
                                        .average()
                                        .orElse(0))
                );
    }

    public List<Funcionario> ordenarPorSalario() {
        return this.funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getSalario))
                .collect(Collectors.toList());
    }

    public Map<String, List<Funcionario>> listaParaMapa() {
        return this.funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getDepartamento));
    }

    public void iniciarExpediente(){
        this.funcionarios.stream()
                .filter(Funcionario::estaContratado)
                .map(f-> new Thread(f::trabalhar))
                .collect(Collectors.toCollection(()-> this.tarefas))
                .forEach(Thread::start);
    }

    public void encerrarExpediente(){
        this.tarefas.forEach(Thread::interrupt);
    }

}

