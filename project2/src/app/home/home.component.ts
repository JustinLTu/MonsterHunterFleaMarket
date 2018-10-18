import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetformsService } from '../service/getforms.service';
import { TradeForm } from '../model/tradeform.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  trades: TradeForm[];

  constructor(private router: Router, private getInfo: GetformsService) { }

  user = localStorage.getItem('user');
  cUser = JSON.parse(this.user);
  username = this.cUser.username;
  hunter_name = this.cUser.hunter_name;
  email = this.cUser.email;
  rank = this.cUser.rank;

  ngOnInit() {
    this.getInfo.getUserTrades().subscribe(data => this.setData(data));

  }

  setData(trades) {
    this.trades = trades;
  }

  postTrade() {
    this.router.navigateByUrl('posttrade');
  }

  logoutUser() {
    localStorage.removeItem('user');
    this.router.navigateByUrl('welcome');
  }
}
