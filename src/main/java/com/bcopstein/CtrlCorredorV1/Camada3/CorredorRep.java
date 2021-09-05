package com.bcopstein.CtrlCorredorV1.Camada3;

import java.util.List;

public interface CorredorRep {
    List<Corredor> retornaCorredores();
    void deleteAll();
    boolean adicionaCorredor(Corredor novoCorredor);
}
