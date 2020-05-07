import { Component, OnInit } from "@angular/core";
import { Validators, FormBuilder, FormGroup } from "@angular/forms";
import { CustomerService } from "../customer.service";
import { Router } from "@angular/router";
import { Login } from "../login";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  public loginarr: Login[] = [];
  public userName: string;
  public password: string;
  public loginFlag: boolean = false;
  public adminFlag: boolean = false;
  public empFlag: boolean = false;
  loginArr: Login[] = [];

  loginForm: FormGroup;
  invalidLogin = false;

  submitted: boolean = false;
  message: any;
  errorFlag: boolean;
  constructor(
    public customerservice: CustomerService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}
  ngOnInit() {
    //  this.empservice.getLoginDetails().subscribe(data=>this.loginArr=data);
    //  this.empservice.getLeaveDetails().subscribe(data=>this.leaveArr=data);

    this.loginForm = this.formBuilder.group({
      userName: ["", Validators.required],
      password: ["", Validators.required],
    });
  }

  public authenticate() {
    this.submitted = true;
    if (this.loginForm.valid) {
      this.userName = this.loginForm.controls.userName.value;
      this.password = this.loginForm.controls.password.value;
      this.customerservice
        .loginValidate(this.userName, this.password)
        .subscribe(
          (data) => {
            if (data === 1) {
              this.router.navigate(["/user"]);
            } else if (data === 2) {
              this.router.navigate(["/admin"]);
            }
          },
          (error) => {
            this.message = error.error;
            this.errorFlag = true;
          }
        );
    } else {
      return;
    }
  }
}
