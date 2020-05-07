import { LanguageList } from "./language-list.enum";

export class movie {
  movieId: number;
  movieName: string;
  hero: string;
  heroine: string;
  language: LanguageList;
  director: string;
  genre: string;
  activeStatus: boolean;

  // constructor(movieId, movieName, language, director, genre, activeStatus) {
  //   this.movieId = movieId;
  //   this.movieName = movieName;
  //   this.language = language;
  //   this.director = director;
  //   this.genre = genre;
  //   this.activeStatus = activeStatus;
  // }
}
