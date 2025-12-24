package org.blackpowerc.training.fullstackspring.housing;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping(
        path = "/housing_locations",
        produces = APPLICATION_JSON_VALUE,
        consumes = APPLICATION_JSON_VALUE
)
public class HousingLocationController
{
    public HousingLocationRepository repository ;

    @Autowired
    public HousingLocationController(HousingLocationRepository repository) {
        this.repository = repository ;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(path = {"/bulk", "/bulk/"})
    public List<HousingLocation> bulkInsert(@NotEmpty @RequestBody List<@Valid HousingLocation> housingLocations) {
        return repository.saveAll(housingLocations) ;
    }
}
