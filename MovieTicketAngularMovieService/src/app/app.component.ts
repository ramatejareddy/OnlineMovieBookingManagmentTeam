import { Component, OnInit } from "@angular/core";

import { CustomerService } from "./customer.service";
import { Router } from "@angular/router";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  title = "onlinemoviebookingsystem";

  public userName: string;

  public password: string;

  public loginFlag: boolean = false;

  public adminFlag: boolean = false;

  public customerflag: boolean = false;

  public custFlag: boolean = false;

  loginForm: FormGroup;

  submitted: boolean = false;

  constructor(
    public customerService: CustomerService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.router.navigate(["/login"]);
  }

  ngOnInit() {}
}
