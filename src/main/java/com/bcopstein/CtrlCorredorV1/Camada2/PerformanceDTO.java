package com.bcopstein.CtrlCorredorV1.Camada2;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.Camada3.Evento;
import com.bcopstein.CtrlCorredorV1.Camada3.RepositorioEvento;

//Implemente uma nova funcionalidade (defina um “endpoint” correspondente) que permita identificar, dentre as provas da distância indicada ocorridas em um determinado ano (informado pelo usuário), em que momento foi obtido o melhor ganho de performance em relação a prova anterior. Para tanto compare os resultados das provas do ano duas a duas na ordem cronológica e identifique o par onde ocorreu a maior redução no tempo (melhoria de performance). Retorne o nome das duas provas. A estrutura do método que trata tal “endpoint” fica como segue:
public class PerformanceDTO {
    //private RepositorioEvento repositorioEvento;
    private String nomeEventoInicio;
    private String nomeEventoFinal;
    

    public PerformanceDTO(RepositorioEvento repositorioEvento, int distancia, int ano){
        List<Evento> lista = repositorioEvento.retornaEventosDistAno(distancia, ano);
        if(lista.size()>1){
            int aux = 0;
            double diferenca = lista.get(0).retornaTempoMin(distancia) - lista.get(1).retornaTempoMin(distancia);
            for(int i=1;i<lista.size()-1;i++){
                if (diferenca<lista.get(i).retornaTempoMin(distancia) - lista.get(i+1).retornaTempoMin(distancia)){
                    diferenca = lista.get(i).retornaTempoMin(distancia) - lista.get(i+1).retornaTempoMin(distancia);
                    aux = i;
                }
            }
            nomeEventoInicio = lista.get(aux).getNome();
            nomeEventoFinal = lista.get(aux+1).getNome();
        }
            
    }

    public String getNomeEventoInicio() {
        return nomeEventoInicio;
    }

    public String getNomeEventoFinal() {
        return nomeEventoFinal;
    }

}
