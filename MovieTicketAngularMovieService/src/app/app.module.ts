import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";

import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { LoginComponent } from "./login/login.component";
import { CustomerService } from "./customer.service";
import { AdminComponent } from "./admin/admin.component";
import { AddMovieComponent } from "./add-movie/add-movie.component";
import { DeleteMovieComponent } from "./delete-movie/delete-movie.component";
import { ViewMoviesComponent } from "./view-movies/view-movies.component";
import { SearchMovieComponent } from "./search-movie/search-movie.component";
import { InactiveMoviesComponent } from "./inactive-movies/inactive-movies.component";
import { ActiveMoviesComponent } from "./active-movies/active-movies.component";
import { UserComponent } from "./user/user.component";
import { SignupComponent } from "./signup/signup.component";
import { UpdateMovieComponent } from "./update-movie/update-movie.component";
@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    LoginComponent,
    AddMovieComponent,
    DeleteMovieComponent,
    ViewMoviesComponent,
    SearchMovieComponent,
    InactiveMoviesComponent,
    ActiveMoviesComponent,
    UserComponent,
    SignupComponent,
    UpdateMovieComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent],
})
export class AppModule {}
