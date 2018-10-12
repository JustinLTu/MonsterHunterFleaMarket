import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { User } from '../model/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: User;
  constructor(private login: LoginService) { }

  ngOnInit() {
  }

  loginUser(event) {
    event.preventDefault();
    const target = event.target;
    const username = target.querySelector('#username').value;
    const password = target.querySelector('#password').value;

    this.user = new User();
    this.user.username = username;
    this.user.password = password;
    this.user.hunter_name = null;
    this.user.rank = null;
    this.user.email = null;

    this.login.getInfo(this.user).subscribe(data => {
      console.log(this.user);
    });
    }
  }
