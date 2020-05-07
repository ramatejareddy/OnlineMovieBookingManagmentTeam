import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingserviceService } from '../bookingservice.service';
import { Show } from '../classes/show';
import { Time } from '@angular/common';
import { Theater } from '../classes/theater';


@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {
  todayDate : Date = new Date();
  lastDate:Date=new Date();
  
  
  bookingDate:Date;
  editFlag:boolean=false;
  
  /**************************************************************************
   * creating show array of Show type to store the show detail 
  /**************************************************************************/
 show:Show[]=[];
 
  /**************************************************************************
   * creating theater array of Theater type to store the theater detail 
  /**************************************************************************/
 theater:Theater[]=[];
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
   * Description: ngOnInit first sets the date upto which the booking can be done
   *              
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/

  ngOnInit() { 
    this.lastDate.setDate(this.lastDate.getDate()+2);
   

  }
  /********************************************************************************
   * Method: displaySeats
   * params: showId
   * return:
   * Description: this method call service setShowId method and 
   *             routes the page  to the seats 
   * Created Date: 27 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  displaySeats(showId:number){

    this.bookingService.setShowId(showId);
    this.route.navigateByUrl("/seats")
  }
  /********************************************************************************
   * Method: getShows
   * params:
   * return:
   * Description: this method call service loadShows method and add the shows and theaters
   *              every time ,if a error occurs then the errMsg is defined.
   * Created Date: 27 APR 2020
   * Author: Rama Teja Reddy
   **********************************************************************************/

  getShows()
  {
    this.bookingService.setTicketsBookedDate(this.bookingDate);
    console.log(this.bookingDate);
    this.bookingService.loadShow(this.bookingDate).subscribe(data=>{this.theater=data;console.log(data);this.errMsg=undefined;},
    error=>{
      this.errMsg=error.error;
      this.theater=undefined;
     
    }
    );
    
    this.editFlag=true;
    
  }


}
