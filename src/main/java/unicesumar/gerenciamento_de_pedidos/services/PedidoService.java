package unicesumar.gerenciamento_de_pedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicesumar.gerenciamento_de_pedidos.models.PedidoModel;
import unicesumar.gerenciamento_de_pedidos.repositories.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel criarPedido(PedidoModel pedidoModel) {
        return pedidoRepository.save(pedidoModel);
    }

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public PedidoModel listarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).get();
    }

    public void deletarPedidoPorId(Long id) {
        pedidoRepository.deleteById(id);
    }

}
