package cloud.springframework.gurukursmsccbeerservice.repositories;

import cloud.springframework.gurukursmsccbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
