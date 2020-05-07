import { Component, OnInit } from "@angular/core";
import { CustomerService } from "../customer.service";
import { movie } from "../movie";
import { Router } from "@angular/router";
@Component({
  selector: "app-view-movies",
  templateUrl: "./view-movies.component.html",
  styleUrls: ["./view-movies.component.css"],
})
export class ViewMoviesComponent implements OnInit {
  movieList: movie[] = [];
  errorFlag: boolean;
  successFlag = false;
  message: any;

  constructor(private service: CustomerService, private router: Router) {}

  ngOnInit(): void {
    this.service.getAllMovies().subscribe(
      (data) => {
        this.movieList = data;
        this.successFlag = true;
        this.errorFlag = false;
      },
      (error) => {
        this.message = error.error;
        this.errorFlag = true;
        this.successFlag = false;
      }
    );
  }
  updateMovie(movie: movie): void {
    // localStorage.removeItem("updatemovieId");
    // localStorage.setItem("updatemovieId", movie.movieId);
    this.router.navigate(["admin/updateMovie", movie.movieId]);
  }
}
