package de.gie.tool.commontasks.url.alias.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AliasRepository extends JpaRepository<Alias, Long> {
    List<Alias> findByAliasName(String name);
}
