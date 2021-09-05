package com.bcopstein.CtrlCorredorV1.Camada2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bcopstein.CtrlCorredorV1.Camada3.RepositorioEvento;

import org.springframework.beans.factory.annotation.Autowired;

//consultar as seguintes estatísticas: média, mediana e desvio padrão do tempo em minutos que o corredor tem levado para concluir provas de uma determinada distancia

public class EstatísticasDTO {
    private RepositorioEvento repositorioEvento;
    private double media=0;
    private double mediana=0;
    private double desvio=0;
    

    @Autowired
    public EstatísticasDTO(RepositorioEvento repositorioEvento, int distancia){
        this.repositorioEvento = repositorioEvento;
        List<Double> listMediana = new ArrayList<Double>();
        double aux=0;
        for(int i=0;i<repositorioEvento.retornaEventosDist(distancia).size();i++){
            aux = repositorioEvento.retornaEventosDist(distancia).get(i).retornaTempoMin(distancia);
            if(aux!=0){
                media = media + aux;
                listMediana.add(aux);
            }
        }
        media = media/listMediana.size();
        Collections.sort(listMediana);
        mediana = listMediana.get(listMediana.size()/2);
        desvio=0;
        for(int i  = 0;i<listMediana.size();i++){
            desvio = desvio + Math.pow((listMediana.get(i)-media),2);
        }
        desvio = Math.sqrt(desvio/listMediana.size());
    }

    public double getMedia() {
        return media;
    }
    public double getMedianaInt() {
        return mediana;
    }
    public double getDesvio() {
        return desvio;
    }
    

    @Override
    public String toString() {
        return "Estatisticas [media="+media+", mediana="+mediana+", desvio padrao="+desvio+"]";
    }

}
//*/

