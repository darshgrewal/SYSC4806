package Application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "buddies",path = "buddies")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long>{
    List<BuddyInfo> findByName(String name);
}
