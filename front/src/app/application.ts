import {HateoasResource, Resource} from "@lagoshny/ngx-hateoas-client";
import {HousingLocationResource} from "./housing-location";

@HateoasResource("applications")
export class ApplicationResource extends Resource
{
    public id?: string;
    public lastName: string;
    public firstName: string;
    public email: string;
    public location: HousingLocationResource
}