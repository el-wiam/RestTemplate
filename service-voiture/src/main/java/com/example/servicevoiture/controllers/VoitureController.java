package com.example.servicevoiture.controllers;

import com.example.servicevoiture.VoitureResponse;
import com.example.servicevoiture.services.VoitureService;
import com.example.servicevoiture.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voiture")
public class VoitureController {

    @Autowired
    public VoitureService voitureService;


    @GetMapping("/voituresClient/{id}")
    public ResponseEntity<List<VoitureResponse>> getVoituresByClient(@PathVariable Long id) {
        List<VoitureResponse> voitureResponses = voitureService.getVoituresByClient(id);
        if(voitureResponses==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voitureResponses);
    }

    @PostMapping
    public VoitureResponse addVoiture(@RequestBody Voiture voiture) throws Exception {
        return voitureService.addVoiture(voiture);
    }

    @GetMapping
    public List<VoitureResponse> findAll() {
        return voitureService.findAll();
    }

    @GetMapping("/{id}")
    public VoitureResponse findById(@PathVariable Long id) throws Exception {
        return voitureService.findById(id);
    }
    @DeleteMapping("/voitures/{id}")
    public ResponseEntity<String> deleteVoiture(@PathVariable Long id) {
        try {
            voitureService.deleteVoiture(id);
            return ResponseEntity.ok("Voiture deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
