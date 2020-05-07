import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Seats } from './classes/seats';
import { SeatBooked } from './classes/seatBooked';
import { CalculateFare } from './classes/calculateFare';
import { Booking } from './classes/booking';
import { Ticket } from './classes/ticket';
import { Movie } from './classes/movie';

@Injectable({
  providedIn: 'root'
})
export class BookingserviceService {
  private fare:CalculateFare=new CalculateFare();
   private seats:Seats[]=[];
  private seatBooked:SeatBooked[]=[];
  private ticketsBookedDate:Date;
  private ticket:Ticket=new Ticket();
  private movie:Movie=new Movie();

  private showId:number;
 
  

  constructor(private http:HttpClient) { }

  /*********************************************************************
   * Method: getTotalFare
   * params: CalculateFare
   * return: Observable
   * Description: this method gets the totalCost of the booking
   *
   * Created Date: 29 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/
  getTotalFare(fare:CalculateFare):Observable<any>{
    let end=this.showId;
    let end1=fare.noOfSeats;
    
    return this.http.get("http://localhost:8089/seatfare/"+end+"/"+end1,{responseType:'text'});

  }
 
  setTicketsBookedDate(date:Date):void{
    this.ticketsBookedDate=date;
  }
  getTicketsBookedDate():Date{
    return this.ticketsBookedDate;
  }
  setFare(fare:CalculateFare):void{
    this.fare=fare;
    
  }
  getFare():CalculateFare{
   return this.fare;
  }
  /*********************************************************************
   * Method: loadMovies
   * params:
   * return: Observable
   * Description: this method fetches all the movies
   *
   * Created Date: 26 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/
loadMovies():Observable<any>{
  return this.http.get("http://localhost:8089/getMovies")
}
setMovie(movie:Movie){
  this.movie=movie;
}
getMovie():Movie{
  return this.movie;
}
/*********************************************************************
   * Method: loadShow
   * params:bookingDate
   * return: Observable
   * Description: this method gets all the theaters and show of the movie
   *              selected and on the date the customer wants to book.
   * Created Date: 27 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/ 
  loadShow(bookingDate:Date):Observable<any>{
    let end=bookingDate;
    let end1=this.movie.movieId;
    return this.http.get("http://localhost:8089/getTheaterAndShow/"+end+"/"+end1);
    
  }

   /*********************************************************************
   * Method: loadSeats
   * params:showId
   * return: Observable
   * Description: this method fetches all the seats of the particular show
   *
   * Created Date: 28 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/
  loadSeats(showId:number):Observable<any>{
    let end=showId;
    return this.http.get("http://localhost:8089/getSeats/"+end);

  }
   setSeats(seats:Seats[]):void{
    this.seats=seats;
   

  }
  setShowId(showId:number):void{
    this.showId=showId;
    }
  getShowId():number{
   
    return this.showId;
  }
   getSeats():Seats[]{
    return this.seats;
  }
  setSeatBooked(seatBooked:SeatBooked[]):void{
    this.seatBooked=seatBooked;
  }
  getSeatBooked():SeatBooked[]{
    return this.seatBooked;
  }
   /*********************************************************************
   * Method: getNoOfAvailableSeats
   * params:ShowId
   * return: Observable
   * Description: this method fetches the no of seats available
   *
   * Created Date: 29 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/
  getNoOfAvailableSeats(showId:number):Observable<any>{
    let end=showId;
    return this.http.get("http://localhost:8089/getAvailableSeats/"+end);
  }
   /*********************************************************************
   * Method: blockSeats
   * params:fare
   * return: Observable
   * Description: this method blocks the seats selected by the customer
   *
   * Created Date: 28 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/
  blockSeats(fare:CalculateFare):Observable<any>{
    let end=this.showId;
    let end1=fare.noOfSeats;
    return this.http.put("http://localhost:8089/selectedSeats/"+end1+"/"+end,{responseType:'text'});
  }
   /*********************************************************************
   * Method:unblockSeats
   * params:seatsBooked
   * return: Observable
   * Description: this method unblocks the seats booked by the customer
   *
   * Created Date: 29 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/
  unblockSeats(seatBooked:SeatBooked[]):Observable<any>{
    let end=this.showId;
    console.log(seatBooked[0])
    return this.http.put("http://localhost:8089/cancelBlockSeats/"+end,seatBooked,{responseType:'text'});
  }
   /*********************************************************************
   * Method: generateTickets
   * params:bookingId
   * return: Observable
   * Description: this method fetches the ticket details
   *
   * Created Date: 30 APR 2020
   * Author: Rama Teja Reddy
   ************************************************************************/
  generateTickets(booking:Booking):Observable<any>{
    booking.customerId=11;
    console.log(booking);
    return this.http.post("http://localhost:8089/generateTickets/",booking);
  }
  setTicket(ticket:Ticket):void{
    this.ticket=ticket;
  }
  getTicket():Ticket{
    console.log(this.ticket.movieName)
    return this.ticket;
  }
  
}
