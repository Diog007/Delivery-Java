package com.delivery.api.service;

import com.delivery.api.dto.ListarSaboresDTO;
import com.delivery.api.dto.ListarTiposDTO;
import com.delivery.api.entidade.PizzaTipo;
import com.delivery.api.repository.PizzaTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private PizzaTipoRepository repository;

    public List<ListarTiposDTO> listarTipos() {
        List<PizzaTipo> tipos = repository.findAll();
        return tipos.stream().map(ListarTiposDTO::new).collect(Collectors.toList());
    }

    public List<ListarSaboresDTO> listarSaboresPorTipo (String tipoId) {
        PizzaTipo tipo = repository.findById(tipoId).orElseThrow(() -> new RuntimeException("Tipo de pizza não encontrado: " + tipoId));

        List<ListarSaboresDTO> listarSaboresDTOS = tipo.getPizzaSabores().stream().map(ListarSaboresDTO::new).collect(Collectors.toList());

        return listarSaboresDTOS;
    }


}
