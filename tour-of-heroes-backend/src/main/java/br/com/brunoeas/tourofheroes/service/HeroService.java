package br.com.brunoeas.tourofheroes.service;

import java.util.List;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.brunoeas.tourofheroes.converter.HeroConverter;
import br.com.brunoeas.tourofheroes.dto.HeroDTO;
import br.com.brunoeas.tourofheroes.entity.Hero;
import br.com.brunoeas.tourofheroes.enumeration.ExceptionEnum;
import br.com.brunoeas.tourofheroes.repository.HeroRepository;

/**
 * Service de Hero
 *
 * @author Bruno Eduardo
 */
@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    HeroConverter heroConverter;

    /**
     * Salva um novo Hero
     *
     * @param dto - DTO de Hero
     * @return DTO do novo Hero
     */
    public HeroDTO save(final HeroDTO dto) {
        Hero hero = this.heroConverter.dtoToEntity(dto);
        hero.setIdHero(null);

        hero = this.heroRepository.save(hero);

        return this.heroConverter.entityToDto(hero);
    }

    /**
     * Atualiza um Hero
     *
     * @param dto - DTO de Hero
     * @return DTO do Hero atualizado
     */
    public HeroDTO update(final HeroDTO dto) {
        Hero hero = this.heroRepository.findById(dto.getIdHero())
                .orElseThrow(() -> new NoResultException(ExceptionEnum.ID_INEXISTENTE.getMessage()));
        this.heroConverter.dtoToEntity(dto, hero);

        hero = this.heroRepository.save(hero);

        return this.heroConverter.entityToDto(hero);
    }

    /**
     * Deleta um Hero pelo ID
     *
     * @param id - ID do Hero
     */
    public void deleteById(final Integer id) {
        final Hero hero = this.heroRepository.findById(id)
                .orElseThrow(() -> new NoResultException(ExceptionEnum.ID_INEXISTENTE.getMessage()));
        this.heroRepository.delete(hero);
    }

    /**
     * Busca os Heroes pelo nome
     *
     * @param term - Termo/Nome
     * @return Lista de DTO de Hero
     */
    public List<HeroDTO> findByName(final String term) {
        return (List<HeroDTO>) this.heroConverter.entityListToDtoList(this.heroRepository.findByName(term));
    }

    /**
     * Busca um Hero pelo ID
     *
     * @param id - ID do Hero
     * @return DTO de Hero
     */
    public HeroDTO findById(final Integer id) {
        final Hero hero = this.heroRepository.findById(id)
                .orElseThrow(() -> new NoResultException(ExceptionEnum.ID_INEXISTENTE.getMessage()));
        return this.heroConverter.entityToDto(hero);
    }

    /**
     * Busca todos os Heroes
     *
     * @return Lista de DTO de Hero
     */
    public List<HeroDTO> findAll() {
        return (List<HeroDTO>) this.heroConverter.entityListToDtoList(this.heroRepository.findAll(Sort.by("nmHero")));
    }

}