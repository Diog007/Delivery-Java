package com.delivery.api.controller;

import com.delivery.api.dto.ListarAdicionaisDTO;
import com.delivery.api.dto.ListarSaboresDTO;
import com.delivery.api.dto.ListarTiposDTO;
import com.delivery.api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/menu")
@CrossOrigin("*")
public class MenuPublicoController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/tipos")
    public ResponseEntity<List<ListarTiposDTO>> listarTipos() {
        List<ListarTiposDTO> tipos = menuService.listarTipos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/sabores/{tipoId}")
    public ResponseEntity<List<ListarSaboresDTO>> listarSaboresPorTipo(@PathVariable String tipoId) {
        List<ListarSaboresDTO> listarSaboresDTOS = menuService.listarSaboresPorTipo(tipoId);
        return ResponseEntity.ok(listarSaboresDTOS);
    }

    @GetMapping("/adicionais/{tipoId}")
    public ResponseEntity<List<ListarAdicionaisDTO>> listarAdicionaisPorTipo(@PathVariable String tipoId) {
        List<ListarAdicionaisDTO> listarAdicionaisDTOS = menuService.listarAdicionaisPorTipo(tipoId);
        return ResponseEntity.ok(listarAdicionaisDTOS);
    }


}
