import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./login/login.component";

import { AdminComponent } from "./admin/admin.component";
import { SearchMovieComponent } from "./search-movie/search-movie.component";
import { ActiveMoviesComponent } from "./active-movies/active-movies.component";
import { InactiveMoviesComponent } from "./inactive-movies/inactive-movies.component";
import { AddMovieComponent } from "./add-movie/add-movie.component";
import { DeleteMovieComponent } from "./delete-movie/delete-movie.component";
import { UpdateMovieComponent } from "./update-movie/update-movie.component";
import { ViewMoviesComponent } from "./view-movies/view-movies.component";
import { UserComponent } from "./user/user.component";
import { SignupComponent } from "./signup/signup.component";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignupComponent },
  // { path: "updateMovie/:id", component: UpdateMovieComponent },
  {
    path: "user",
    component: UserComponent,
    children: [
      { path: "", component: ActiveMoviesComponent },
      { path: "searchMovie", component: SearchMovieComponent },
      { path: "activeMovies", component: ActiveMoviesComponent },
      { path: "inactiveMovies", component: InactiveMoviesComponent },
      { path: "**", redirectTo: "/user", pathMatch: "full" },
    ],
  },
  {
    path: "admin",
    component: AdminComponent,
    children: [
      { path: "", component: ViewMoviesComponent },
      { path: "updateMovie/:id", component: UpdateMovieComponent },
      { path: "addMovie", component: AddMovieComponent },
      { path: "deleteMovie", component: DeleteMovieComponent },
      { path: "viewMovies", component: ViewMoviesComponent },
      { path: "**", redirectTo: "/admin", pathMatch: "full" },
    ],
  },
  // { path: "updateMovie", component: UpdateMovieComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
