package br.com.fecaf.controller;

import br.com.fecaf.model.Carro;
import br.com.fecaf.model.Moto;
import br.com.fecaf.model.Veiculo;
import br.com.fecaf.repository.CarroRepository;
import br.com.fecaf.repository.MotoRepository;
import br.com.fecaf.repository.VeiculoRepository;
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
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private MotoRepository motoRepository;

    @CrossOrigin(origins = "http://localhost:5500", allowedHeaders = "*")
    @GetMapping("/listarVeiculos")
    @ResponseBody
    public List<Veiculo> listarVeiculos(){
        return veiculoService.listarVeiculos();
    }

    @PostMapping("/cadastrar")
    public String cadastrarVeiculo(@RequestParam("tipo") String tipo,
                                   @RequestParam("modelo") String modelo,
                                   @RequestParam("marca") String marca,
                                   @RequestParam("ano") int ano,
                                   @RequestParam("combustivel") String combustivel,
                                   @RequestParam("cor") String cor,
                                   @RequestParam("imagem") String imagem,
                                   @RequestParam("cambioAutomatico") boolean cambioAutomatico,
                                   @RequestParam(required = false) Double motor,
                                   @RequestParam(required = false) Integer portas,
                                   @RequestParam(required = false) Boolean arCondicionado,
                                   @RequestParam(required = false) Integer cilindradas,
                                   @RequestParam(required = false) Boolean bauCarga) {
        if (tipo.equals("carro")) {
            Carro carro = new Carro();
            carro.setModelo(modelo);
            carro.setMarca(marca);
            carro.setAno(ano);
            carro.setCombustivel(combustivel);
            carro.setCor(cor);
            carro.setImagem(imagem);
            carro.setCambioAutomatico(cambioAutomatico);
            carro.setMotor(motor);
            carro.setPortas(portas);
            carro.setArCondicionado(arCondicionado);

            veiculoService.salvarVeiculo(carro);
        } else if (tipo.equals("moto")) {
            Moto moto = new Moto();
            moto.setModelo(modelo);
            moto.setMarca(marca);
            moto.setAno(ano);
            moto.setCombustivel(combustivel);
            moto.setCor(cor);
            moto.setImagem(imagem);
            moto.setCambioAutomatico(cambioAutomatico);
            moto.setCilindradas(cilindradas);
            moto.setBauCarga(bauCarga);

            veiculoService.salvarVeiculo(moto);
        }

        return "redirect:/veiculos";
    }


    @GetMapping
    public String listarVeiculosHtml(Model model){
        model.addAttribute("veiculos", veiculoService.listarVeiculos());
        return "veiculos";
    }

    @PostMapping("/deletar")
    public String deletarVeiculo(@RequestParam("id") Long id){
        veiculoService.deleteVeiculo(id);
        System.out.println("Veiculo deletado com sucesso" + id);
        return "redirect:/veiculos";
    }
//    @PostMapping("/salvar")
//    public String salvarVeiculo(@ModelAttribute Veiculo veiculo){
//        veiculoService.salvarVeiculo(veiculo);
//        return "redirect:/veiculos";
//    }
//
}
