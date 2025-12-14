import {Component, input} from '@angular/core';
import {HousingLocationResource} from "../housing-location";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-housing-location',
  imports: [RouterLink],
  templateUrl: './housing-location.html',
  styleUrl: './housing-location.css',
  standalone: true
})

export class HousingLocation {
  public housingLocation = input.required<HousingLocationResource>() ;
}
