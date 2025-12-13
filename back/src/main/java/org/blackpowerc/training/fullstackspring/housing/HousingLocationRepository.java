package org.blackpowerc.training.fullstackspring.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

/**
 * Repo Spring data pour les locations, les méthodes d'écritures sont protégées par le role <i>ROLE_ADMIN</i>
 *
 * @author jordy fatigba72@gmail.com
 */
@Repository
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RepositoryRestResource(collectionResourceRel = "housing_locations", path = "housing_locations")
public interface HousingLocationRepository extends JpaRepository<HousingLocation, UUID>
{
    @Override
    @Secured("ROLE_ADMIN")
    <S extends HousingLocation> S saveAndFlush(S entity) ;

    @Override
    @Secured("ROLE_ADMIN")
    <S extends HousingLocation> List<S> saveAllAndFlush(Iterable<S> entities) ;

    @Override
    @Secured("ROLE_ADMIN")
    default void deleteInBatch(Iterable<HousingLocation> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAllInBatch(Iterable<HousingLocation> entities) ;

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAllByIdInBatch(Iterable<UUID> uuids) ;

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAllInBatch() ;

    @Override
    @Secured("ROLE_ADMIN")
    <S extends HousingLocation> S save(S entity) ;

    @Override
    @Secured("ROLE_ADMIN")
    <S extends HousingLocation> List<S> saveAll(Iterable<S> entities) ;

    @Override
    @Secured("ROLE_ADMIN")
    void deleteById(UUID uuid);

    @Override
    @Secured("ROLE_ADMIN")
    void delete(HousingLocation entity);

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAllById(Iterable<? extends UUID> uuids);

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAll(Iterable<? extends HousingLocation> entities);

    @Override
    @Secured("ROLE_ADMIN")
    void deleteAll();
}
