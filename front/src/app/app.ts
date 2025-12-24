import {Component} from '@angular/core';
import {Home} from "./home/home";
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: "app-root",
  imports: [Home, RouterLink, RouterOutlet],
  templateUrl: "./app.html" ,
  standalone: true,
  styleUrls: ["./app.css"]
})

export class App
{
  title = "Default" ;
}