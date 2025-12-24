import {Injectable} from "@angular/core";
import {HateoasResourceService, Include} from "@lagoshny/ngx-hateoas-client";
import {ApplicationResource} from "../application";

@Injectable({
    providedIn: "root"
})
export class ApplicationService
{
    constructor(private resourceService: HateoasResourceService) {
    }

    submitApplication(application: ApplicationResource): void
    {
        this.resourceService.createResource(ApplicationResource, {
            body: application,
            valuesOption: {
                include: Include.NULL_VALUES
            }
        }).subscribe((newApplication: ApplicationResource) => {
            console.log(newApplication) ;
        }) ;
    }
}