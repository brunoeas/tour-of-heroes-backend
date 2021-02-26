package br.com.brunoeas.tourofheroes.entity;

import javax.persistence.*;

/**
 * Entidade Hero
 */
@Entity
@Table(name = Hero.TABLE_NAME)
public class Hero {

    /**
     * Nome da tabela na base de dados
     */
    public static final String TABLE_NAME = "hero";

    /**
     * ID
     */
    @Id
    @Column(name = "id_hero", updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHero;

    /**
     * Nome
     */
    @Column(name = "nm_hero", length = 100, nullable = false)
    private String nmHero;

    public Integer getIdHero() {
        return this.idHero;
    }

    public void setIdHero(final Integer idHero) {
        this.idHero = idHero;
    }

    public String getNmHero() {
        return this.nmHero;
    }

    public void setNmHero(final String nmHero) {
        this.nmHero = nmHero;
    }

}