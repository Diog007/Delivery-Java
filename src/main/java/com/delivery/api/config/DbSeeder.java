package com.delivery.api.config;

import com.delivery.api.entidade.PizzaAdicionais;
import com.delivery.api.entidade.PizzaTipo;
import com.delivery.api.repository.PizzaAdicionaisRepository;
import com.delivery.api.repository.PizzaSaborRepository;
import com.delivery.api.repository.PizzaTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private PizzaTipoRepository tipoRepository;

    @Autowired
    private PizzaSaborRepository saborRepository;

    @Autowired
    private PizzaAdicionaisRepository adicionaisRepository;

    @Override
    public void run(String... args) {

        tipoRepository.deleteAll();
        saborRepository.deleteAll();
        adicionaisRepository.deleteAll();

        // Cria e salva tipos primeiro
        PizzaTipo vegetariana = PizzaTipo.builder()
                .nome("Pizza Grande")
                .descricao("Pizza Grande de 8 fatias")
                .precoBase(35.0)
                .imagemUrl("https://upload.wikimedia.org/wikipedia/commons/9/91/Pizza-3007395.jpg")
                .build();

        PizzaTipo carnes = PizzaTipo.builder()
                .nome("Pizza Pequena")
                .descricao("Pizzas pequena com 4 fatias")
                .precoBase(38.0)
                .imagemUrl("https://upload.wikimedia.org/wikipedia/commons/9/91/Pizza-3007395.jpg")
                .build();

        PizzaTipo tradicional = PizzaTipo.builder()
                .nome("Pizza Doce ")
                .descricao("Pizza doce com chocolate e morango")
                .precoBase(36.0)
                .imagemUrl("https://upload.wikimedia.org/wikipedia/commons/9/91/Pizza-3007395.jpg")
                .build();

        vegetariana = tipoRepository.save(vegetariana);
        carnes = tipoRepository.save(carnes);
        tradicional = tipoRepository.save(tradicional);

        // Cria sabores referenciando tipos salvos
        PizzaSabor margherita = PizzaSabor.builder()
                .nome("Margherita")
                .descricao("Molho de tomate, mussarela, manjericão")
                .preco(45.90)
                .imagemUrl("https://upload.wikimedia.org/wikipedia/commons/9/91/Pizza-3007395.jpg")
                .build();

        PizzaSabor calabresa = PizzaSabor.builder()
                .nome("Calabresa")
                .descricao("Molho de tomate, calabresa, cebola")
                .preco(40.90)
                .imagemUrl("https://upload.wikimedia.org/wikipedia/commons/9/91/Pizza-3007395.jpg")
                .build();

        PizzaSabor romana = PizzaSabor.builder()
                .nome("Romana")
                .descricao("Molho, mussarela, oregano")
                .preco(38.50)
                .imagemUrl("https://.../romana.jpg")
                .build();

        margherita = saborRepository.save(margherita);
        calabresa = saborRepository.save(calabresa);
        romana = saborRepository.save(romana);

        // Cria e salva adicionais
        PizzaAdicionais bordaCatupiry = PizzaAdicionais.builder()
                .nome("Borda de Catupiry")
                .descricao("Borda recheada com catupiry")
                .preco(5.0)
                .build();

        PizzaAdicionais bordaCheddar = PizzaAdicionais.builder()
                .nome("Borda de Cheddar")
                .descricao("Borda recheada com cheddar")
                .preco(5.0)
                .build();

        PizzaAdicionais azeitona = PizzaAdicionais.builder()
                .nome("Azeitona")
                .descricao("Azeitonas pretas")
                .preco(3.0)
                .build();

        PizzaAdicionais cebolaRoxa = PizzaAdicionais.builder()
                .nome("Cebola Roxa")
                .descricao("Cebola roxa em rodelas")
                .preco(2.0)
                .build();

        bordaCatupiry = adicionaisRepository.save(bordaCatupiry);
        bordaCheddar = adicionaisRepository.save(bordaCheddar);
        azeitona = adicionaisRepository.save(azeitona);
        cebolaRoxa = adicionaisRepository.save(cebolaRoxa);

        // Atualiza tipos com os sabores e adicionais correspondentes
        vegetariana.setPizzaSabores(List.of(margherita, romana));
        carnes.setPizzaSabores(List.of(calabresa));
        tradicional.setPizzaSabores(List.of(margherita, calabresa, romana));
        tradicional.setAdiocionaisPizzas(List.of(bordaCatupiry, bordaCheddar, azeitona, cebolaRoxa));


        tipoRepository.saveAll(List.of(vegetariana, carnes, tradicional));
    }
}
