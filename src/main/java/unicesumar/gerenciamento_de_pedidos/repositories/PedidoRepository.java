package unicesumar.gerenciamento_de_pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unicesumar.gerenciamento_de_pedidos.models.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
