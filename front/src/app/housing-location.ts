import {HateoasResource, Resource} from "@lagoshny/ngx-hateoas-client";

@HateoasResource("housing_locations")
export class HousingLocationResource extends Resource
{
    id?: string;
    name: string;
    city: string;
    state: string;
    photo: string;
    availableUnits: number;
    wifi: boolean;
    laundry: boolean
}
