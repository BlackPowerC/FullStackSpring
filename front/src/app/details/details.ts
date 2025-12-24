import { Component, inject } from '@angular/core';
import {HousingService} from "../housing.service";
import {ActivatedRoute} from "@angular/router";
import {ApplicationService} from "../services/application.service";
import {ApplicationResource} from "../application";
import {HousingLocationResource} from "../housing-location";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";

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
  applicationService: ApplicationService = inject(ApplicationService) ;
  housingLocation?: HousingLocationResource ;
  housingLocationId?: "" ;

  applyForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
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
    if(this.applyForm.invalid)
    {
      alert("Invalid Form") ;
      return ;
    }

    let application: ApplicationResource = new ApplicationResource() ;
    application.email = this.applyForm.value.email ;
    application.firstName = this.applyForm.value.firstName ;
    application.lastName = this.applyForm.value.lastName ;
    application.location = this.housingLocation ;

    this.applicationService.submitApplication(
        application
    ) ;
  }

  get firstName() {
    return this.applyForm.get("firstName") ;
  }

  get lastName() {
    return this.applyForm.get("lastName") ;
  }

  get email() {
    return this.applyForm.get("email") ;
  }
}
