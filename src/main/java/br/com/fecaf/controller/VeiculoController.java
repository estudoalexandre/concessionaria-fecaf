package br.com.fecaf.controller;

import br.com.fecaf.model.Veiculo;
import br.com.fecaf.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @CrossOrigin(origins = "http://localhost:5500", allowedHeaders = "*")
    @GetMapping("/listarVeiculos")
    @ResponseBody
    public List<Veiculo> listarVeiculos(){
        return veiculoService.listarVeiculos();
    }

    @GetMapping
    public String listarVeiculosHtml(Model model){
        model.addAttribute("veiculos", veiculoService.listarVeiculos());
        return "veiculos";
    }

    @PostMapping("/salvar")
    public String salvarVeiculo(@ModelAttribute Veiculo veiculo){
        veiculoService.salvarVeiculo(veiculo);
        return "redirect:/veiculos";
    }
}
