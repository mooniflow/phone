package untitled.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "phonemanagements",
    path = "phonemanagements"
)
public interface PhonemanagementRepository
    extends PagingAndSortingRepository<Phonemanagement, Long> {}
