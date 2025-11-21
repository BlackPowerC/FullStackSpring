import { Component, inject } from '@angular/core';
import {HousingService} from "../housing.service";
import {ActivatedRoute} from "@angular/router";
import type {HousingLocationInfo} from "../housing-location";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-details',
  imports: [ReactiveFormsModule],
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
  applyForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
  }) ;

  constructor()
  {
    this.housingLocationId = Number(this.route.snapshot.params["id"]) ;
    this.housingLocation = this.housingService.getHouseLocationById(this.housingLocationId) ;
  }

  submitApplication()
  {
    this.housingService.submitApplication(
       this.applyForm.value.firstName ?? '',
       this.applyForm.value.lastName ?? '',
       this.applyForm.value.email ?? '',
    ) ;
  }
}
