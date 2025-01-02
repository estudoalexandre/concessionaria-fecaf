package br.com.fecaf.services;

import br.com.fecaf.model.Veiculo;
import br.com.fecaf.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.getReferenceById(id);
    }

    public void salvarVeiculo(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
    }

    public void deleteVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
