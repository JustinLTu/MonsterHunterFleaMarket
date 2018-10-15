import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { createUrlResolverWithoutPackagePrefix } from '@angular/compiler';
import { User } from '../model/user.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private router: Router) { }

  user = localStorage.getItem('user');
  cUser = JSON.parse(this.user);
  username = this.cUser.username;
  hunter_name = this.cUser.hunter_name;
  email = this.cUser.email;
  rank = this.cUser.rank;

  ngOnInit() {
  if (localStorage.getItem('form')) {

  }
  }

  postTrade() {
    this.router.navigateByUrl('posttrade');
  }

  logoutUser() {
    localStorage.removeItem('user');
    this.router.navigateByUrl('welcome');
  }
}
