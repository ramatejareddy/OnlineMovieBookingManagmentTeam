import { Injectable } from "@angular/core";

import { HttpClient } from "@angular/common/http";

import { Observable } from "rxjs";
import { Login } from "./login";
import { movie } from "./movie";

@Injectable({
  providedIn: "root",
})
export class CustomerService {
  public userName: string;
  public password: string;
  movie: movie[] = [];
  public setMovie(movie: movie[]): void {
    this.movie = movie;
  }
  public getMovie(): movie[] {
    return this.movie;
  }

  constructor(private http: HttpClient) {}

  public addMovie(movie: movie) {
    return this.http.post("http://localhost:1130/Admin/AddMovie", movie, {
      responseType: "text" as "json",
    });
  }

  public getActiveMovies() {
    return this.http.get<movie[]>("http://localhost:1130/User/Active-Movies");
  }

  public getInactiveMovies() {
    return this.http.get<movie[]>("http://localhost:1130/User/Inactive-Movies");
  }

  public getAllMovies() {
    return this.http.get<movie[]>("http://localhost:1130/Admin/Movies");
  }

  public deleteMovie(movieId: number): Observable<any> {
    // console.log(movieId);
    return this.http.delete(
      "http://localhost:1130/Admin/DeleteMovie/" + movieId,
      {}
    );
  }

  public searchMovie(movieName: string) {
    return this.http.get<movie[]>(
      "http://localhost:1130/User/SearchMovie/" + movieName
    );
  }

  public findById(movieId: number) {
    return this.http.get<movie[]>(
      "http://localhost:1130/Admin/Movie/" + movieId
    );
  }
  public updateMovie(movie: movie): Observable<any> {
    return this.http.put(
      "http://localhost:1130/Admin/UpdateMovie/" + movie.movieId,
      movie,
      {
        responseType: "text" as "json",
      }
    );

    // let end = movie.movieId;
    // const url = "http://localhost:1130/Admin/UpdateMovie" + end;
    // console.log(url);
    // return this.http.put(url, movie);
  }

  public loginValidate(userName: string, password: string) {
    this.password = password;
    this.userName = userName;
    return this.http.get(
      "http://localhost:1130/Login/Validate/" + userName + "/" + password
    );
  }
  public SignUp(user: Login) {
    return this.http.post("http://localhost:1130/SignUp/Register", user, {
      responseType: "text" as "json",
    });
  }

  // public getUserById(id: number) {
  //   return this.http.get<Customer[]>("http://localhost:1130/User/id/" + id);
  // }
  public loginDetails(name: string) {
    return this.http.get<Login>(
      "http://localhost:1130/Login/LoginDetails/" + name
    );
  }

  public changePassword(login: Login) {
    return this.http.put("http://localhost:1130/Login/ChangePassword", login, {
      responseType: "text" as "json",
    });
  }
}
