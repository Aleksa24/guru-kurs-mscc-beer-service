package cloud.springframework.gurukursmsccbeerservice.bootstrap;

import cloud.springframework.gurukursmsccbeerservice.domain.Beer;
import cloud.springframework.gurukursmsccbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBearObjects();
    }

    private void loadBearObjects() {
        if (beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(337010000001l)
                    .price(new BigDecimal("12.95"))
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(337010000002l)
                    .price(new BigDecimal("11.95"))
                    .build());
        }
    }
}
