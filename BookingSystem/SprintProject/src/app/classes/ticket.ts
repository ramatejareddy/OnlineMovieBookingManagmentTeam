import { SeatBooked } from './seatBooked';

export class Ticket{
    noOfTickets:number;
    seatsBooked:SeatBooked[]=[];
     movieName:String;
     theaterName:String;
     ticketId:number;
     genere:String;
     bookingDate:Date;
     ticketsBookedDate:Date
     language:String;
     showStartTime:Date;
     totalCost:number;
    
}