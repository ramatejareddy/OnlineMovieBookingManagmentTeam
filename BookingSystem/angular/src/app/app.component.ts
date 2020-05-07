import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'Welcome To Online Movie Ticket Booking System';
constructor(private route:Router){}
ngOnInit():void{
  this.route.navigateByUrl("/movie");

}


}
