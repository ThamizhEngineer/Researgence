import { Component, OnInit, Renderer2 } from "@angular/core";
import { Router } from "@angular/router";
import { FormBuilder, Validators, FormGroup } from "@angular/forms";
import { AuthService } from "../../shared/services/firebase/auth.service";
import { NgbCarouselConfig } from "@ng-bootstrap/ng-bootstrap";

type UserFields = "email" | "password";
type FormErrors = { [u in UserFields]: string };
@Component({
  selector: 'app-loginmain',
  templateUrl: './loginmain.component.html',
  styleUrls: ['./loginmain.component.scss']
})
export class LoginmainComponent implements OnInit {

  images = [
    "assets/given/img/Image1.jpg",
    "assets/given/img/Image2.jpg",
    "assets/given/img/Image3.jpg",
  ];
  currentIndex = 0;
  ngOnInit() {
    setInterval(() => {
      this.currentIndex = (this.currentIndex + 1) % this.images.length;
    }, 3000);
  }
  public newUser = false;
 
  public loginForm: FormGroup;
  public formErrors: FormErrors = {
    email: "",
    password: "",
  };
  public errorMessage: any;

  loading = false;
  email = "";
  password = "";
  applicantionCode: string = "";
  data;
  msg: any;
  Alertmsg: any;
  returnUrl: string;
  // Encp
  title = "";

  constructor(
    public authService: AuthService,
    private fb: FormBuilder,
    config: NgbCarouselConfig,
    private router: Router,
    private renderer: Renderer2
  ) {
    this.renderer.setStyle(document.body, "overflow", "hidden");

    this.loginForm = fb.group({
      email: [[Validators.required]],
      password: [Validators.required],
    });
  }


  login() {
    let obj = JSON.stringify({ userName: this.email, password: this.password });
    this.authService.login(obj).subscribe((arg) => {
      this.loading = false;
      this.Alertmsg = { type: "danger", text: "Login" };
    });
  }

  redirect() {
    this.router.navigate(["/dashboard/default"]);
  }
}
