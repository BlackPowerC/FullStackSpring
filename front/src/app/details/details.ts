import { Component, inject } from '@angular/core';
import {HousingService} from "../housing.service";
import {ActivatedRoute} from "@angular/router";
import type {HousingLocationInfo} from "../housing-location";

@Component({
  selector: 'app-details',
  imports: [],
  templateUrl: './details.html',
  styleUrl: './details.css',
  standalone: true
})
export class Details
{
  route: ActivatedRoute = inject(ActivatedRoute) ;
  housingService: HousingService = inject(HousingService) ;
  housingLocation?: HousingLocationInfo ;
  housingLocationId: number = -1 ;

  constructor() {
    this.housingLocationId = Number(this.route.snapshot.params["id"]) ;
    this.housingLocation = this.housingService.getHouseLocationById(this.housingLocationId) ;
  }
}
