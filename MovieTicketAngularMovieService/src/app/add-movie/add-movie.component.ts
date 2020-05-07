import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { CustomerService } from "../customer.service";
import { movie } from "../movie";
import { LanguageList } from "../language-list.enum";

@Component({
  selector: "app-add-movie",
  templateUrl: "./add-movie.component.html",
  styleUrls: ["./add-movie.component.css"],
})
export class AddMovieComponent implements OnInit {
  addForm: FormGroup;
  submitted = false;
  movieObj: movie;
  movieList: movie[] = [];
  id: number = 0;

  success = false;
  constructor(
    private formBuilder: FormBuilder,
    private service: CustomerService
  ) {}

  get language() {
    return this.addForm.get("language");
  }
  get genre() {
    return this.addForm.get("genre");
  }

  ngOnInit(): void {
    this.service.getAllMovies().subscribe((data) => (this.movieList = data));

    this.addForm = this.formBuilder.group({
      movieName: [
        "",
        [
          Validators.required,
          Validators.pattern("[A-Z][A-Za-z0-9:, .-]{1,50}"),
        ],
      ],
      hero: [
        "",
        [Validators.required, Validators.pattern("[A-Z][A-Z a-z0-9]{1,50}")],
      ],
      heroine: [
        "",
        [Validators.required, Validators.pattern("[A-Z][A-Z a-z0-9]{1,50}")],
      ],
      director: [
        "",
        [Validators.required, Validators.pattern("[A-Z][A-Z a-z]{3,50}")],
      ],
      genre: ["", Validators.required],
      language: ["", [Validators.required]],
    });
  }
  addMovie() {
    this.submitted = true;
    for (let movie of this.movieList) {
      if (this.id < movie.movieId) {
        this.movieObj = movie;
        this.id = movie.movieId;
      }
    }
    if (this.addForm.valid) {
      this.movieObj.movieId = this.id + 1;
      this.movieObj.movieName = this.addForm.get("movieName").value;
      this.movieObj.hero = this.addForm.get("hero").value;
      this.movieObj.heroine = this.addForm.get("heroine").value;
      this.movieObj.genre = this.addForm.get("genre").value;
      this.movieObj.director = this.addForm.get("director").value;
      this.movieObj.language = this.addForm.get("language").value;
      this.movieObj.activeStatus = true;
      this.service.addMovie(this.movieObj).subscribe((data) => {
        this.success = true;
      });
    }
  }
}
