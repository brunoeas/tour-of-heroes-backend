package br.com.brunoeas.tourofheroes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.brunoeas.tourofheroes.entity.Hero;

/**
 * Repository de Hero
 *
 * @author Bruno Eduardo
 */
public interface HeroRepository extends CrudRepository<Hero, Integer> {

    /**
     * Busca no banco os Heroes filtrando pelo nome
     *
     * @param term - Termo/Nome
     * @return Lista de Heroes
     */
    @Query(
            value = "SELECT h.* FROM hero AS h "
                    + "WHERE UNACCENT(h.nm_hero) ILIKE UNACCENT(CONCAT('%', :term, '%')) ORDER BY h.nm_hero",
            nativeQuery = true
    )
    List<Hero> findByName(@Param("term") final String term);

    /**
     * Busca no banco todos os Heroes com ordenação dinâmica
     *
     * @param sort - Ordenação
     * @return Lista de Heroes
     */
    List<Hero> findAll(final Sort sort);

}