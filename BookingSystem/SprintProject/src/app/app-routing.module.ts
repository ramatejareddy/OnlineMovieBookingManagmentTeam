import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { ShowComponent } from './show/show.component';
import { SeatsComponent } from './seats/seats.component';
import { TicketComponent } from './ticket/ticket.component';
import { MovieComponent } from './movie/movie.component';

const routes: Routes = [{
  path: 'booking',component:BookingComponent},
{path:'tickets',component:TicketComponent},
{path:'show',component:ShowComponent},
{path:'seats',component:SeatsComponent},
{path:'movie',component:MovieComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
