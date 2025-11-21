import { Component, inject } from '@angular/core';
import { HousingService } from "../housing.service";
import type {HousingLocationInfo} from "../housing-location";
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
  housingService: HousingService = inject(HousingService) ;
  housingLocationList: HousingLocationInfo[] ;

  constructor() {
    this.housingLocationList = this.housingService.getAllHousingLocation() ;
  }

}
