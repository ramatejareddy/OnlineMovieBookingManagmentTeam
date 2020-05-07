import { Component, OnInit } from "@angular/core";
import { movie } from "../movie";
import { Router } from "@angular/router";
import { CustomerService } from "../customer.service";

@Component({
  selector: "app-search-movie",
  templateUrl: "./search-movie.component.html",
  styleUrls: ["./search-movie.component.css"],
})
export class SearchMovieComponent implements OnInit {
  name: string = "";
  searchNameFlag: boolean = false;

  nameIsEmptyFlag: boolean = false;
  errorFlag: boolean = false;

  movieList: movie[] = [];
  message: string;
  constructor(private router: Router, private service: CustomerService) {}

  ngOnInit(): void {}

  searchName() {
    if (this.name === "") {
      this.nameIsEmptyFlag = true;
    } else {
      this.nameIsEmptyFlag = false;

      this.movieList.splice(0, this.movieList.length);
      this.service.searchMovie(this.name).subscribe(
        (data) => {
          this.movieList = data;
          if (this.movieList.length === 0) {
            this.errorFlag = true;
          } else {
            this.errorFlag = false;

            this.searchNameFlag = true;
          }
        },
        (error) => {
          alert(error.error);
          this.errorFlag=true;
          this.message = error.error;
        }
      );
    }
  }
  back() {
    this.searchNameFlag = false;
    this.router.navigate(["/customer"]);
  }
  back1() {
    this.errorFlag = false;
  }
}
