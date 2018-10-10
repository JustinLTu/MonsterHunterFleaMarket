import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  user: User;
  constructor() { }

  ngOnInit() {
   // this.resetForm();
  }

  resetForm(form?: NgForm) {
    if (form != null) {
      form.reset();
      this.user = {
        hunter_name: '',
        rank: '',
        email: '',
        password: '',
        username: ''
        };
      }
  }
}
