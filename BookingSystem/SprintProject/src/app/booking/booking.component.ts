import { Component, OnInit } from '@angular/core';

import { BookingserviceService } from '../bookingservice.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

import { CalculateFare } from '../classes/calculateFare';
import { SeatBooked } from '../classes/seatBooked';
import { Booking } from '../classes/booking';
import { SeatsComponent } from '../seats/seats.component';
import { Movie } from '../classes/movie';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
 
   /*********************************************************************
   *  Instance of Movie for manupulation
   **********************************************************************/
  movie:Movie=new Movie(); 
   /*********************************************************************
   *  Instance of CalculateFare for manupulation
   **********************************************************************/
  fare:CalculateFare=new CalculateFare();
  msg:String;
  
  /**************************************************************************
   * creating seats array of SeatsBooked type to store the seats  details 
  /**************************************************************************/
  seats:SeatBooked[]=[];
  seatCost:number;
  /*********************************************************************
   *  Instance of Booking for manupulation
   **********************************************************************/
  bookingDetails:Booking=new Booking();
  ticketBookedDate:Date;
  
/*********************************************************************
   * Method: constructor
   * params:
   * return:
   * Description: constructor injects the BookingService and router module
   *
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/  
  constructor(private bookingservice:BookingserviceService,private route:Router) { }

     /*********************************************************************
   * Method: ngOnInit is life cycle hook called by angular at first
   * params:
   * return:
   * Description: ngOnInit first loads fare ,seatsBooked,movie and ticket BookedDate.
                  using these details we calculate the seatcost.  
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/

  ngOnInit() {
    this.fare=this.bookingservice.getFare();
    this.seats=this.bookingservice.getSeatBooked();
    this.seatCost=this.fare.totalFare/this.fare.noOfSeats;
    this.ticketBookedDate=this.bookingservice.getTicketsBookedDate();
    this.movie=this.bookingservice.getMovie();
    
    console.log(this.seats);
  
    
  }

  /********************************************************************************
   * Method: generateTickets
   * params:
   * return:
   * Description: this method first call the details of the show and set the details of the
   *              booking in the instance of Booking.This method call the generateTickets
   *              in service based on the booking deatils as parameter and later it sets the 
   *              ticket details
   * Created Date: 30 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  generateTickets(){
    this.bookingDetails.showId=this.bookingservice.getShowId();
    this.bookingDetails.tkts=this.fare.noOfSeats;
    this.bookingDetails.seatsBooked=this.seats;
    this.bookingDetails.totalCost=this.fare.totalFare;
    this.bookingDetails.ticketsBookedDate=this.bookingservice.getTicketsBookedDate();
    this.bookingservice.generateTickets(this.bookingDetails).subscribe(data=>{
      this.msg=data;
      console.log(this.msg);
      this.bookingservice.setTicket(data);
      
      this.route.navigateByUrl("/tickets");
    })
  }
 
  /********************************************************************************
   * Method: unBlockSeats
   * params:
   * return:
   * Description: this method call service unBlockSeats method and unblock the seats selected
   *              every time  and routes the page back to the seats 
   * Created Date: 30 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  unblockSeats(){
    this.bookingservice.unblockSeats(this.seats).subscribe(data=>{this.msg=data;console.log(this.msg);
      this.route.navigateByUrl("/seats");
    })
    
  }

  /********************************************************************************
   * Method: toback
   * params:
   * return:
   * Description: this method call service unBlockSeats method and unblock the seats selected
   *              every time. 
   * Created Date: 30 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  toBack(){
    this.bookingservice.unblockSeats(this.seats).subscribe(data=>{this.msg=data;console.log(this.msg);})
      
    
    
  }
}
