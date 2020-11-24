package cloud.springframework.gurukursmsccbeerservice.web.controller;

import cloud.springframework.gurukursmsccbeerservice.domain.Beer;
import cloud.springframework.gurukursmsccbeerservice.repositories.BeerRepository;
import cloud.springframework.gurukursmsccbeerservice.services.BeerService;
import cloud.springframework.gurukursmsccbeerservice.web.mappers.BeerMapper;
import cloud.springframework.gurukursmsccbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity(beerService.getById(beerId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Validated @RequestBody BeerDto beerDto){
        return new ResponseEntity(beerService.saveNewBeer(beerDto),HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId,@Validated @RequestBody BeerDto beerDto){
        return new ResponseEntity(beerService.updateBeer(beerId,beerDto),HttpStatus.NO_CONTENT);
    }

}
