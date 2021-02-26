package br.com.brunoeas.tourofheroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.brunoeas.tourofheroes.dto.HeroDTO;
import br.com.brunoeas.tourofheroes.service.HeroService;

/**
 * REST Controller de Hero
 *
 * @author Bruno Eduardo
 */
@RestController
@RequestMapping(HeroController.PATH)
public class HeroController {

    /**
     * Path base dos Endpoints
     */
    public static final String PATH = "/hero";

    @Autowired
    HeroService heroService;

    /**
     * Endpoint para salvar um novo Hero
     *
     * @param dto - DTO do Hero
     * @return DTO do novo Hero
     */
    @PostMapping
    public HeroDTO save(@RequestBody final HeroDTO dto) {
        return this.heroService.save(dto);
    }

    /**
     * Endpoint para atualizar um Hero
     *
     * @param dto - DTO do Hero
     * @return DTO do Hero atualizado
     */
    @PutMapping
    public HeroDTO update(@RequestBody final HeroDTO dto) {
        return this.heroService.update(dto);
    }

    /**
     * Endpoint para deletar um Hero pelo ID
     *
     * @param id - ID do Hero
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Integer id) {
        this.heroService.deleteById(id);
    }

    /**
     * Endpoint para buscar os Heroes pelo nome
     *
     * @param term - Termo/Nome
     * @return Lista de DTO de Hero
     */
    @GetMapping("/name")
    public List<HeroDTO> findByName(@RequestParam("term") final String term) {
        return this.heroService.findByName(term);
    }

    /**
     * Endpoint para buscar todos os Heroes
     *
     * @return Lista de DTO de Hero
     */
    @GetMapping
    public List<HeroDTO> findAll() {
        return this.heroService.findAll();
    }

    /**
     * Endpoint para buscar um Hero pelo ID
     *
     * @param id - ID do Hero
     * @return DTO de Hero
     */
    @GetMapping("/{id}")
    public HeroDTO findById(@PathVariable final Integer id) {
        return this.heroService.findById(id);
    }

}