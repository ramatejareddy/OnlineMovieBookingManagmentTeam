import { Component, OnInit } from "@angular/core";

import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { movie } from "../movie";
import { CustomerService } from "../customer.service";
import { Router, ActivatedRoute } from "@angular/router";
import { first } from "rxjs/operators";

@Component({
  selector: "app-update-movie",
  templateUrl: "./update-movie.component.html",
  styleUrls: ["./update-movie.component.css"],
})
export class UpdateMovieComponent implements OnInit {
  // success = false;
  movie: movie;
  editForm: FormGroup;
  currentId: number;
  successFlag = false;
  movieList: movie[] = [];
  submitted: boolean = false;
  movieObj: movie;
  constructor(
    private service: CustomerService,
    private router: Router,
    private formBuilder: FormBuilder,
    private activeRoute: ActivatedRoute
  ) {
    this.activeRoute.params.subscribe((params) => {
      this.currentId = params["id"];
    });
  }
  get language() {
    return this.editForm.get("language");
  }
  get genre() {
    return this.editForm.get("genre");
  }

  changeLanguage(e) {
    this.language.setValue(e.target.value, {
      onlySelf: true,
    });
  }

  changeGenre(e) {
    this.genre.setValue(e.target.value, {
      onlySelf: true,
    });
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      movieId: [{ value: "this.currentId", disabled: true }],
      movieName: [
        { value: "k.movieName" },
        [Validators.required, Validators.pattern("[A-Z][A-Z a-z]{2,14}")],
      ],
      hero: [
        { value: "k.hero" },
        [Validators.required, Validators.pattern("[A-Z][A-Z a-z]{2,14}")],
      ],
      heroine: [
        { value: "k.heroine" },
        [Validators.required, Validators.pattern("[A-Z][A-Z a-z]{2,14}")],
      ],
      language: [{ value: "k.language" }, [Validators.required]],
      director: [
        { value: "k.movieName" },
        [Validators.required, Validators.pattern("[A-Z][A-Z a-z]{2,14}")],
      ],
      genre: [, [Validators.required]],
      activeStatus: [""],
    });
    this.service.findById(this.currentId).subscribe((data) => {
      console.log(data);
      data.map((k) => {
        // this.updatemovie = k;
        this.editForm.setValue(k);
      });
      // this.editForm.setValue(data);
    });
  }
  updateMovie() {
    this.submitted = true;
    console.log(this.editForm.value);
    if (this.editForm.invalid) {
      return;
    }
    this.service
      .updateMovie(this.editForm.getRawValue())
      .subscribe((data) => (this.successFlag = true));
    // this.service.getAllMovies().subscribe((data) => (this.movieList = data));
    // this.router.navigate(["admin/viewMovies"]);
  }
}
