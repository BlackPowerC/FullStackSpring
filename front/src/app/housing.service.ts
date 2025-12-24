import { Injectable } from '@angular/core';
import {lastValueFrom} from "rxjs";
import {HousingLocationResource} from './housing-location';
import {HateoasResourceService} from "@lagoshny/ngx-hateoas-client";

@Injectable({
  providedIn: 'root',
})
export class HousingService
{
  constructor(private resourceService: HateoasResourceService) {
  }

  async searchByCityOrName(query: string): Promise<Array<HousingLocationResource> | []>
  {
    let pagedSearch = await lastValueFrom(this.resourceService
        .searchPage(HousingLocationResource,"cityOrName", {
          params: {
            city: query,
          }
        })
    ) ;

    return pagedSearch.resources ?? []
  }

  async getAllHousingLocation(): Promise<Array<HousingLocationResource> | []>
  {
    let pagedResource = await lastValueFrom(this.resourceService.getPage(HousingLocationResource, {})) ;

    return pagedResource.resources ?? [] ;
  }

  async getHouseLocationById(id: string): Promise<HousingLocationResource>
  {
    return await lastValueFrom(
        this.resourceService.getResource(HousingLocationResource, id)
    ) ;
  }
}
