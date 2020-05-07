import { Component, OnInit } from "@angular/core";
import { movie } from "../movie";
import { CustomerService } from "../customer.service";

@Component({
  selector: "app-active-movies",
  templateUrl: "./active-movies.component.html",
  styleUrls: ["./active-movies.component.css"],
})
export class ActiveMoviesComponent implements OnInit {
  movieList: movie[] = [];
  successFlag = false;
  message: any;
  errorFlag = false;
  constructor(private service: CustomerService) {}

  ngOnInit(): void {
    this.service.getActiveMovies().subscribe((data) => {
      this.movieList = data;
      this.errorFlag = false;
      this.successFlag = true;
    }),
      (error) => {
        this.message = error.error;
        this.errorFlag = true;
        this.successFlag = false;
      };
  }
}
