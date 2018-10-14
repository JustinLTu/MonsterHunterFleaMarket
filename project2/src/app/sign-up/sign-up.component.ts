import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../model/user.model';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  public user: User;
  constructor(private rService: RegisterService, private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('user')) {
      this.router.navigateByUrl('home');
    }
  }

  navigate(user) {

    localStorage.setItem('user', JSON.stringify(user));
    this.router.navigateByUrl('home');
    
  }

  registerUser(event) {
    event.preventDefault();
    const target = event.target;
    const username = target.querySelector('#username').value;
    const password = target.querySelector('#password').value;
    const rank = target.querySelector('#rank').value;
    const hunter_name = target.querySelector('#hunter_name').value;
    const email = target.querySelector('#email').value;

    this.user = new User();
    this.user.username = username;
    this.user.password = password;
    this.user.hunter_name = hunter_name;
    this.user.rank = rank;
    this.user.email = email;

    this.rService.signup(this.user).subscribe(data =>  this.navigate(data));
    }
}
