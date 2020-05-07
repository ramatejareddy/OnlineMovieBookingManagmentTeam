import { Component, OnInit } from '@angular/core';
import { BookingserviceService } from '../bookingservice.service';
import { Router } from '@angular/router';
import { Seats } from '../classes/seats';
import { SeatBooked } from '../classes/seatBooked';



import { CalculateFare } from '../classes/calculateFare';

@Component({
  selector: 'app-seats',
  templateUrl: './seats.component.html',
  styleUrls: ['./seats.component.css']
})
export class SeatsComponent implements OnInit {


 
  fare:CalculateFare=new CalculateFare();
  
  /**************************************************************************
   * creating seats array of Seats type to store the seat details 
  /**************************************************************************/
  seats:Seats[]=[];
  showId:number;
  availableSeats:number;
  
  /***************************************************************************************************
   * creating seatsBooked array of SeatBooked type to store the details of the seats which are booked 
  /***************************************************************************************************/
  seatsBooked:SeatBooked[]=[];
  msg:String;
  errMsg:String;
  flag=false;

  /*********************************************************************
   * Method: constructor
   * params:
   * return:
   * Description: constructor injects the BookingService and router module
   *
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/
  constructor(private route:Router,private bookingService:BookingserviceService,) { }
     /*********************************************************************
   * Method: ngOnInit is life cycle hook called by angular at first
   * params:
   * return:
   * Description: ngOnInit first load the showdId details of the show selected
   *              and loads all the seats in the starting and it is
   *              checking if seats array length is zero then load seats 
   *              and set the seats into the current array
   *              
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/

  ngOnInit() {
   
   
   this.showId=this.bookingService.getShowId();    
  this.bookingService.loadSeats(this.showId).subscribe(data=>{this.seats=data;});
   // this.seats=this.bookingService.getSeats();
    //alert(this.showId);
    this.bookingService.getNoOfAvailableSeats(this.showId).subscribe(data=>{this.availableSeats=data});
  
  }  
  /********************************************************************************
   * Method: blockSeats
   * params:
   * return:
   * Description: this method irst checks if the no of seats entered is less than 
   *               or equal to zero .If yes a errMsg is shown,else it will  call
   *                service BlockSeats method and block the seats selected
   *              every time and if a error is generated inside the servie then the errMsg is defined
   * Created Date: 28 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  blockSeats(){
 
    if(this.fare.noOfSeats<=0){
      this.errMsg="No of tickets cannot be less than or equal to zero";
    }
    
    else{
    this.bookingService.blockSeats(this.fare).subscribe((data)=>{console.log("Block the  seats");
    console.log("data",data);
    this.seatsBooked=data;
    this.errMsg=undefined;
    this.flag=true;
    this.bookingService.setSeatBooked(this.seatsBooked);
    this.bookingService.loadSeats(this.showId).subscribe(data=>{console.log("data",data);this.seats=data;});
    this.ngOnInit();},
    error=>{
     
      this.errMsg=error.error;
      console.log(error.error);
    });
    console.log("total fare:"+this.fare);
  }
    
  }
  /********************************************************************************
   * Method: ProceedToPayment
   * params:
   * return:
   * Description: this method call service getTotalFare method , if any error is generated 
   *              then the errMsg is defined and  routes the page to booking 
   * Created Date: 29 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  proceedToPayment(){
    this.bookingService.getTotalFare(this.fare).subscribe(data=>{this.fare.totalFare=data;
      console.log("total fare:",this.fare.totalFare);
      this.bookingService.setFare(this.fare);
      this.route.navigateByUrl("/booking");
    },
    error=>{
      this.errMsg=error.error;
      console.log(error.error);
    });
  }
  /********************************************************************************
   * Method: unBlockSeats
   * params:
   * return:
   * Description: this method call service unBlockSeats method and unblock the seats selected
   *              every time  
   * Created Date: 29 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  unblockSeats(){
    this.bookingService.unblockSeats(this.seatsBooked).subscribe(data=>{this.msg=data;console.log(this.msg);
    this.ngOnInit();
  this.flag=false;});
  }
  /********************************************************************************
   * Method: back
   * params:
   * return:
   * Description: this method call service unBlockSeats method and unblock the seats selected
   *              every time  and routes the page back to the seats 
   * Created Date: 29 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  back(){
    this.bookingService.unblockSeats(this.seatsBooked).subscribe(data=>{this.msg=data;console.log(this.msg);
      this.flag=false;});

  }

}
