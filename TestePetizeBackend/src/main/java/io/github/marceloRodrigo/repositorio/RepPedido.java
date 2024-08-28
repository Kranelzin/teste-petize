package io.github.marceloRodrigo.repositorio;

import io.github.marceloRodrigo.objetos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepPedido extends JpaRepository<Pedido, Long> {
}

