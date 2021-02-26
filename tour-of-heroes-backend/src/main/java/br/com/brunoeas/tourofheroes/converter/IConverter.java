package br.com.brunoeas.tourofheroes.converter;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Contrato de um Converter entre DTO e Entidade
 *
 * @param <E> - Tipo da Entidade
 * @param <D> - Tipo do DTO
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
public interface IConverter<E, D> {

    /**
     * Converte um DTO para o formato Entidade usando uma referência de um objeto Entidade já existente
     *
     * @param dto - DTO que vai ser convertido
     * @param orm - Referência do objeto Entidade que vai ser retornado
     * @return Entidade convertida
     */
    E dtoToEntity(final D dto, final E orm);

    /**
     * Converte uma Entidade para o formato DTO usando uma referência de um objeto DTO já existente
     *
     * @param orm - Entidade que vai ser convertida
     * @param dto - Referência do objeto DTO que vai ser retornado
     * @return DTO convertido
     */
    D entityToDto(final E orm, final D dto);

    /**
     * @return Nova instância da Entidade.
     */
    E getEntityNewInstance();

    /**
     * @return Nova instância do DTO.
     */
    D getDtoNewInstance();

    /**
     * Converte um DTO para o formato Entidade.
     *
     * @param dto - DTO que vai ser convertido
     * @return Entidade convertida
     */
    default E dtoToEntity(final D dto) {
        if (dto == null) {
            return null;
        }

        final E orm = this.getEntityNewInstance();
        return this.dtoToEntity(dto, orm);
    }

    /**
     * Converte uma Entidade para o formato DTO.
     *
     * @param orm - Entidade que vai ser convertida
     * @return DTO convertido
     */
    default D entityToDto(final E orm) {
        if (orm == null) {
            return null;
        }

        final D dto = this.getDtoNewInstance();
        return this.entityToDto(orm, dto);
    }

    /**
     * Converte uma lista de DTO para uma lista de Entidades.
     *
     * @param dtoList - Lista de DTO's
     * @return Lista de Entidades convertidas
     */
    default Iterable<E> dtoListToEntityList(final Iterable<D> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return StreamSupport.stream(dtoList.spliterator(), false).map(this::dtoToEntity).collect(Collectors.toList());
    }

    /**
     * Converte uma lista de Entidades para uma lista de DTO.
     *
     * @param ormList - Lista de Entidades
     * @return Lista de DTO's convertidos
     */
    default Iterable<D> entityListToDtoList(final Iterable<E> ormList) {
        if (ormList == null) {
            return null;
        }
        return StreamSupport.stream(ormList.spliterator(), false).map(this::entityToDto).collect(Collectors.toList());
    }

}