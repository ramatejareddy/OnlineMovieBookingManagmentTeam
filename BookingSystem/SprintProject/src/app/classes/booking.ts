import { SeatBooked } from './seatBooked';

export class Booking{
    showId:number;
    tkts:number;
    customerId:number;
    totalCost:number;
    seatsBooked:SeatBooked[]=[];
    ticketsBookedDate:Date;
}