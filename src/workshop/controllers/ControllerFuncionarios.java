package workshop.controllers;

import workshop.model.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanderson on 13/03/18.
 */
public class ControllerFuncionarios {
    private static String NOME_DO_ARQUIVO = "exemplo.data";
    private List<Funcionario> funcionarios;

    public ControllerFuncionarios() throws IOException {
        this.funcionarios = this.carregarFuncionariosDoArquivo();
    }

    private List<Funcionario> carregarFuncionariosDoArquivo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ControllerFuncionarios.NOME_DO_ARQUIVO));
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

    public void filtroDeIdade(int idade){
        //Mostra o nome dos funcionários que possuem mais de X anos
        for (Funcionario f : funcionarios) {
            if (f.getIdade() > idade)
                System.out.println(f);
        }
    }

}
