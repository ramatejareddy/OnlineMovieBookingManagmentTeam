import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingserviceService } from '../bookingservice.service';
import { Movie } from '../classes/movie';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
  
  /**************************************************************************
   * creating movie array of Movie type to store the movie detail 
  /**************************************************************************/
  movie:Movie[]=[];
  errMsg:String;

   /*********************************************************************
   * Method: constructor
   * params:
   * return:
   * Description: constructor injects the BookingService and router module
   *
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/

   
  constructor(private route:Router,private bookingService:BookingserviceService) { }

   /*********************************************************************
   * Method: ngOnInit is life cycle hook called by angular at first
   * params:
   * return:
   * Description: ngOnInit  loads all the movies in the starting and it is
   *              checking if movie array length is zero then load movies 
   *              and set the movies into the current array
   *              
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/

  ngOnInit() {
    this.bookingService.loadMovies().subscribe(data=>{this.movie=data;this.errMsg=undefined},error=>{
      this.errMsg=error.error;
      console.log(this.errMsg);
    });
    
  }
  /********************************************************************************
   * Method: getTheater
   * params: movie
   * return:
   * Description: this method call service setMovie method and routes the page  to the shows 
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  getTheater(movie:Movie){
    this.bookingService.setMovie(movie);
    console.log(movie);
    this.route.navigateByUrl("/show");
  }


}
