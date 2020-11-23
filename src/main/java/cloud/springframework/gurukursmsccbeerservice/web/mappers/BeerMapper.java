package cloud.springframework.gurukursmsccbeerservice.web.mappers;

import cloud.springframework.gurukursmsccbeerservice.domain.Beer;
import cloud.springframework.gurukursmsccbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
