import { Component, OnInit } from "@angular/core";
import { movie } from "../movie";
import { CustomerService } from "../customer.service";

@Component({
  selector: "app-inactive-movies",
  templateUrl: "./inactive-movies.component.html",
  styleUrls: ["./inactive-movies.component.css"],
})
export class InactiveMoviesComponent implements OnInit {
  movieList: movie[] = [];
  inactiveflag = false;
  errorFlag = false;
  message: any;
  successFlag = false;
  constructor(private service: CustomerService) {}

  ngOnInit(): void {
    this.service.getInactiveMovies().subscribe(
      (data) => {
        this.movieList = data;
        this.errorFlag = false;
        this.successFlag = true;
      },
      (error) => {
        this.message = error.error;
        this.errorFlag = true;
        this.successFlag = false;
      }
    );
  }
}
