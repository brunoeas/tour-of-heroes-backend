package br.com.brunoeas.tourofheroes.converter;

import org.springframework.stereotype.Service;

import br.com.brunoeas.tourofheroes.dto.HeroDTO;
import br.com.brunoeas.tourofheroes.entity.Hero;

/**
 * Converter de Hero
 *
 * @author Bruno Eduardo
 */
@Service
public class HeroConverter implements IConverter<Hero, HeroDTO> {

    /**
     * Converte um DTO para o formato Entidade usando uma referência de um objeto Entidade já existente
     *
     * @param dto - DTO que vai ser convertido
     * @param orm - Referência do objeto Entidade que vai ser retornado
     * @return Entidade convertida
     */
    @Override
    public Hero dtoToEntity(final HeroDTO dto, final Hero orm) {

        orm.setIdHero(dto.getIdHero());
        orm.setNmHero(dto.getNmHero());

        return orm;
    }

    /**
     * Converte uma Entidade para o formato DTO usando uma referência de um objeto DTO já existente
     *
     * @param orm - Entidade que vai ser convertida
     * @param dto - Referência do objeto DTO que vai ser retornado
     * @return DTO convertido
     */
    @Override
    public HeroDTO entityToDto(final Hero orm, final HeroDTO dto) {

        dto.setIdHero(orm.getIdHero());
        dto.setNmHero(orm.getNmHero());

        return dto;
    }

    /**
     * @return Nova instância da Entidade.
     */
    @Override
    public Hero getEntityNewInstance() {
        return new Hero();
    }

    /**
     * @return Nova instância do DTO.
     */
    @Override
    public HeroDTO getDtoNewInstance() {
        return new HeroDTO();
    }

}