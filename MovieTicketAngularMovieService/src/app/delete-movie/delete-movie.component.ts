import { Component, OnInit } from "@angular/core";
import { movie } from "../movie";
import { CustomerService } from "../customer.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-delete-movie",
  templateUrl: "./delete-movie.component.html",
  styleUrls: ["./delete-movie.component.css"],
})
export class DeleteMovieComponent implements OnInit {
  movieList: movie[] = [];

  errorFlag = false;
  successFlag = false;
  message: any;
  deleteSuccessFlag: boolean;
  constructor(private service: CustomerService, private router: Router) {}

  ngOnInit() {
    this.service.getActiveMovies().subscribe(
      (data) => {
        this.movieList = data;
        this.successFlag = true;
        this.errorFlag = false;
        // this.service.setMovie(this.movieList);
      },
      (error) => {
        this.message = error.error;
        this.successFlag = false;
        this.errorFlag = true;
      }
    );
  }
  deleteMovie(id: number) {
    let deletemovie = confirm("Do you Want to delete for sure" + id);
    if (deletemovie) {
      this.service.deleteMovie(id).subscribe();
      this.service.getActiveMovies().subscribe((data) => {
        this.ngOnInit();
        this.deleteSuccessFlag = true;
      });

      this.router.navigate(["admin/deleteMovie"]);
    }
  }
}
