import { Component, inject } from '@angular/core';
import { HousingService } from "../housing.service";
import {HousingLocationResource} from "../housing-location";
import {HousingLocation} from "../housing-location/housing-location";

@Component({
  selector: 'app-home',
  imports: [HousingLocation],
  templateUrl: './home.html',
  styleUrls: ['./home.css'],
  standalone: true
})

export class Home
{
  public errorMessage?: string ;
  public housingService: HousingService = inject(HousingService) ;
  public housingLocationList: Array<HousingLocationResource> | [];

  constructor() {
    this.filterResults('') ;
  }

  change(text: string | null | undefined): void {
    console.log(text) ;
  }

  filterResults(text: string | null | undefined): void
  {
    if(text?.length)
    {
      this.housingService.searchByCityOrName(text)
          .then((list: Array<HousingLocationResource> | []) =>
          {
            this.housingLocationList = list ;
          }).catch(err =>
      {
        console.error(err?.message) ;
        this.errorMessage = err?.statusText ;
      }) ;

      return ;
    }

    this.housingService.getAllHousingLocation()
        .then((list: Array<HousingLocationResource> | []) =>
        {
          this.housingLocationList = list ;
        }).catch(err =>
    {
      console.error(err?.message) ;
      this.errorMessage = err?.statusText ;
    }) ;

    return ;
  }
}
