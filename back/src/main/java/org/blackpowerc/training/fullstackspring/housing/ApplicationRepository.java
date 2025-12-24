package org.blackpowerc.training.fullstackspring.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Validated
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RepositoryRestResource(collectionResourceRel = "applications", path = "applications")
public interface ApplicationRepository extends JpaRepository<Application, UUID>
{
    @Override
    @Secured("ROLE_ADMIN")
    default void deleteInBatch(Iterable<Application> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAllInBatch(Iterable<Application> entities) ;

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAllByIdInBatch(Iterable<UUID> uuids) ;

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAllInBatch() ;

    @Override
    @Secured("ROLE_CLIENT")
    <S extends Application> S save(S entity) ;

    @Override
    @Secured("ROLE_ADMIN")
    <S extends Application> List<S> saveAll(Iterable<S> entities) ;

    @Override
    @Secured("ROLE_ADMIN")
    void deleteById(UUID uuid);

    @Override
    @Secured("ROLE_ADMIN")
    void delete(Application entity);

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAllById(Iterable<? extends UUID> uuids);

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAll(Iterable<? extends Application> entities);

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAll();
}
