package br.com.brunoeas.tourofheroes.dto;

import java.io.Serializable;

/**
 * DTO de Hero
 *
 * @author Bruno Eduardo
 */
public class HeroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer idHero;

    /**
     * Nome
     */
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