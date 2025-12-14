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
  public filteredLocationList: HousingLocationResource[] | [] ;

  constructor()
  {
    this.housingService.getAllHousingLocation()
        .then((list: Array<HousingLocationResource> | []) =>
        {
          this.housingLocationList = list ;
          this.filteredLocationList = list ;
        }).catch(err =>
        {
          console.error(err?.message) ;
          this.errorMessage = err?.statusText ;
        }) ;
  }

  filterResults(text: string | null | undefined): void
  {
    console.log(text) ;

    if(text?.length)
    {
      this.filteredLocationList = this.housingLocationList.filter(housingLocation => {
        return housingLocation?.city.toLowerCase().includes(text.toLowerCase()) ;
      });

      return ;
    }

    this.filteredLocationList = this.housingLocationList ;
    return ;
  }
}
