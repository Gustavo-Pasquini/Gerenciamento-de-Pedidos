package unicesumar.gerenciamento_de_pedidos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import unicesumar.gerenciamento_de_pedidos.models.PedidoModel;
import unicesumar.gerenciamento_de_pedidos.services.PedidoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel) {
        PedidoModel request = pedidoService.criarPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/pedidos/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listarPedidos() {
        List<PedidoModel> resquest = pedidoService.listarPedidos();
        return ResponseEntity.ok().body(resquest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PedidoModel> listarPedidoPorId(@PathVariable Long id) {
        PedidoModel request = pedidoService.listarPedidoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deletarPedidoPorId(@PathVariable Long id) {
        pedidoService.deletarPedidoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
