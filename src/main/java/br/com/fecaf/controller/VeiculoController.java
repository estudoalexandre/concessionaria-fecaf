package br.com.fecaf.controller;

import br.com.fecaf.model.Carro;
import br.com.fecaf.model.Moto;
import br.com.fecaf.model.Veiculo;
import br.com.fecaf.repository.CarroRepository;
import br.com.fecaf.repository.MotoRepository;
import br.com.fecaf.repository.VeiculoRepository;
import br.com.fecaf.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
                                   @RequestParam("preco") BigDecimal preco,
                                   @RequestParam("quilometragem") long quilometragem,
                                   @RequestParam("disponibilidade") boolean disponibilidade,
                                   @RequestParam("imagem") String imagem,
                                   @RequestParam("cambioAutomatico") boolean cambioAutomatico,
                                   @RequestParam(required = false) Double motor,
                                   @RequestParam(required = false) Integer portas,
                                   @RequestParam(required = false) Boolean arCondicionado,
                                   @RequestParam(required = false) Integer cilindradas,
                                   @RequestParam(required = false) Boolean bauCarga) {
        if (tipo.equals("carro")) {
            Carro carro = new Carro();
            carro.setTipo(tipo);
            carro.setModelo(modelo);
            carro.setMarca(marca);
            carro.setAno(ano);
            carro.setCombustivel(combustivel);
            carro.setCor(cor);
            carro.setDisponibilidade(disponibilidade);
            carro.setPreco(preco);
            carro.setQuilometragem(quilometragem);
            carro.setImagem(imagem);
            carro.setCambioAutomatico(cambioAutomatico);
            carro.setMotor(motor);
            carro.setPortas(portas);
            carro.setArCondicionado(arCondicionado);

            veiculoService.salvarVeiculo(carro);
        } else if (tipo.equals("moto")) {
            Moto moto = new Moto();
            moto.setTipo(tipo);
            moto.setModelo(modelo);
            moto.setMarca(marca);
            moto.setAno(ano);
            moto.setCombustivel(combustivel);
            moto.setCor(cor);
            moto.setDisponibilidade(disponibilidade);
            moto.setPreco(preco);
            moto.setQuilometragem(quilometragem);
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


    @GetMapping("/editar/{id}")
    public String editarVeiculo(@PathVariable Long id, Model model){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        if (veiculoOptional.isPresent()) {
            Veiculo veiculo = veiculoOptional.get();
            model.addAttribute("veiculo", veiculo);
            return "veiculo_detalhes";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado");
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarVeiculo(@PathVariable Long id,
                                    @RequestParam("tipo") String tipo,
                                    @RequestParam("modelo") String modelo,
                                    @RequestParam("marca") String marca,
                                    @RequestParam("ano") int ano,
                                    @RequestParam("combustivel") String combustivel,
                                    @RequestParam("cor") String cor,
                                    @RequestParam("preco") BigDecimal preco,
                                    @RequestParam("quilometragem") long quilometragem,
                                    @RequestParam("disponibilidade") boolean disponibilidade,
                                    @RequestParam("imagem") String imagem,
                                    @RequestParam("cambioAutomatico") boolean cambioAutomatico,
                                    @RequestParam(required = false) Double motor,
                                    @RequestParam(required = false) Integer portas,
                                    @RequestParam(required = false) Boolean arCondicionado,
                                    @RequestParam(required = false) Integer cilindradas,
                                    @RequestParam(required = false) Boolean bauCarga) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        if (veiculoOptional.isPresent()) {
            Veiculo veiculoExistente = veiculoOptional.get();
            
            // Atualiza os campos comuns
            veiculoExistente.setModelo(modelo);
            veiculoExistente.setMarca(marca);
            veiculoExistente.setAno(ano);
            veiculoExistente.setCombustivel(combustivel);
            veiculoExistente.setCor(cor);
            veiculoExistente.setPreco(preco);
            veiculoExistente.setQuilometragem(quilometragem);
            veiculoExistente.setDisponibilidade(disponibilidade);
            veiculoExistente.setCambioAutomatico(cambioAutomatico);
            veiculoExistente.setImagem(imagem);
    
            // Verifica o tipo e atualiza os campos específicos
            if (tipo.equals("carro") && veiculoExistente instanceof Carro) {
                Carro carro = (Carro) veiculoExistente;
                carro.setMotor(motor);
                carro.setPortas(portas);
                carro.setArCondicionado(arCondicionado);
                veiculoRepository.save(carro);
            } else if (tipo.equals("moto") && veiculoExistente instanceof Moto) {
                Moto moto = (Moto) veiculoExistente;
                moto.setCilindradas(cilindradas);
                moto.setBauCarga(bauCarga);
                veiculoRepository.save(moto);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de veículo inválido ou inconsistência nos dados.");
            }
    
            return "redirect:/veiculos";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado");
        }
    }
    


}
