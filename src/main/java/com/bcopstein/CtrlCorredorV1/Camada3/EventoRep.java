package com.bcopstein.CtrlCorredorV1.Camada3;

import java.util.List;

public interface EventoRep {
    List<Evento> retornaEventos();
    boolean deleteAll();
    boolean adicionaEvento(Evento novoEvento);
}
