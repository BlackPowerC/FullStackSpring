import { Component, inject } from '@angular/core';
import {HousingService} from "../housing.service";
import {ActivatedRoute} from "@angular/router";
import {HousingLocationResource} from "../housing-location";
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
  housingLocation?: HousingLocationResource ;
  housingLocationId?: "" ;
  applyForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
  }) ;

  constructor()
  {
    this.housingLocationId = this.route.snapshot.params["id"] ;

    this.housingService.getHouseLocationById(this.housingLocationId)
        .then((location: HousingLocationResource) => {
          this.housingLocation = location ;
        });
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
