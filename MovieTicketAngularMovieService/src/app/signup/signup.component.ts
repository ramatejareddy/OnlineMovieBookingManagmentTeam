import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { CustomerService } from "../customer.service";
@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.css"],
})
export class SignupComponent implements OnInit {
  addForm: FormGroup;
  submitted: boolean = false;
  message: string;
  errorFlag = false;
  constructor(
    private customerService: CustomerService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {}

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      name: [
        "",
        [Validators.required, Validators.pattern("[A-Z][A-Z a-z]{2,30}")],
      ],
      // lastName: [
      //   "",
      //   [Validators.required, Validators.pattern("[a-zA-Z]{3,20}")],
      // ],
      dateOfBirth: [""],
      contact: ["", [Validators.required, Validators.pattern("[6-9][0-9]{9}")]],
      // balanceAmt: ["", [Validators.required, Validators.min(50000)]],
      // email: ["", [Validators.required, Validators.email]],
      userName: ["", [Validators.required, Validators.pattern("[A-Z]{6,12}")]],
      password: [
        "",
        [
          Validators.required,
          Validators.minLength(6),
          Validators.maxLength(12),
        ],
      ],
    });
    if (localStorage.usr != null) {
      localStorage.removeItem("usr");
    }
  }

  addUser() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return alert(`Not Registered`);
    }
    console.log(this.addForm.value);
    this.customerService.SignUp(this.addForm.value).subscribe(
      (data) => {
        alert(
          `Hello, ${this.addForm.controls.name.value}. Your User has been created successfully😊`
        );
        this.router.navigate(["login"]);
      },
      (error) => {
        alert(error.error);
        this.message = error.error;
        this.errorFlag = true;
      }
    );
  }
}
