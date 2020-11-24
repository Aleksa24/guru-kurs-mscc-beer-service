package cloud.springframework.gurukursmsccbeerservice.services;

import cloud.springframework.gurukursmsccbeerservice.domain.Beer;
import cloud.springframework.gurukursmsccbeerservice.repositories.BeerRepository;
import cloud.springframework.gurukursmsccbeerservice.web.controller.NotFoundException;
import cloud.springframework.gurukursmsccbeerservice.web.mappers.BeerMapper;
import cloud.springframework.gurukursmsccbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerMapper beerMapper;
    private final BeerRepository beerRepository;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId)
                .orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setUpc(beerDto.getUpc());
        beer.setPrice(beerDto.getPrice());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
