import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  title = 'PORTFOLIO MANAGER';
  hide = true;

  credentials = {
    username: '',
    password: '',
  };

  constructor(private userService: UserService) {}

  ngOnInit(): void {}

  onSubmit() {
    if (
      this.credentials.username != '' &&
      this.credentials.password != '' &&
      this.credentials.username != null &&
      this.credentials.password != null
    ) {
      console.log('working');
      this.userService.generateToken(this.credentials).subscribe(
        (response: any) => {
          this.userService.loginUser(response);
          window.location.href = '/home';
        },
        (error) => {
          console.log('error  -> ', error);
        }
      );
    } else {
      console.log('Fields are required');
    }
  }
}
