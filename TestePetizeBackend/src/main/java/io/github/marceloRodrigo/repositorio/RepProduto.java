package io.github.marceloRodrigo.repositorio;

import io.github.marceloRodrigo.objetos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepProduto extends JpaRepository<Produto, Long> {
}

