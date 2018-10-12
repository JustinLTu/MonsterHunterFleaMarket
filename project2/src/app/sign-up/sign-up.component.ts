import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  user: User;
  constructor(private rService: RegisterService) { }

  ngOnInit() {
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

    this.rService.signup(this.user).subscribe(data => {
        console.log(data);
    });
    }

}
