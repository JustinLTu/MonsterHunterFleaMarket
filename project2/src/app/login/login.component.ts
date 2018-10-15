import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError} from 'rxjs';
import { Router } from '@angular/router';


import { LoginService } from '../service/login.service';
import { User } from '../model/user.model';
import { Routes } from '@angular/router';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: User;
  constructor(private login: LoginService, private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('user')) {
      this.router.navigateByUrl('home');
    }
  }

  handleError(err: HttpErrorResponse) {
    if (err.status === 401) {
      document.getElementById('login-error').style.display = 'inline';
      return throwError('throwing error login');
    }
  }

  navigate(user) {
    localStorage.setItem('user', JSON.stringify(user));
    this.router.navigateByUrl('home');
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

    this.login.getInfo(this.user).pipe(catchError(this.handleError)).subscribe(data => this.navigate(data));
  }
  }
