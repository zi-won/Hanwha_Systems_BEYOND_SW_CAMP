package com.ohgiraffers.section02.annotation.subsection04.resource;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceResource")
public class PokemonService {

    /* 설명. @Priamry보다 우선순위 높게 빈의 id(이름)으로 하나의 빈을 선정 */
//    @Resource(name = "pikachu")
//    private Pokemon pokemon;
//
//    public void pokemonAttack() {
//        pokemon.attack();
//    }

    @Resource       // @Autowired와 같은 개념
    private List<Pokemon> pokemonList;

    public void pokemonAttack() {
//        pokemonList.forEach(pokemon -> pokemon.attack());
        pokemonList.forEach(Pokemon::attack);
    }
}