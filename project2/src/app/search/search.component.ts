import { Component, OnInit } from '@angular/core';
import { SearchService } from '../service/search.service';
import { Router } from '@angular/router';
import { TradeForm } from '../model/tradeform.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  trades: TradeForm[];

  constructor(private router: Router, private search: SearchService) { }

  ngOnInit() {
    this.search.getAllTrades().subscribe(data => this.setData(data));
  }

  goToBid(tradeId) {
    localStorage.setItem('tradeId', tradeId);
    this.router.navigateByUrl('bids');
  }

  isLogged() {
    if (localStorage.getItem('user') != null) {
      return true;
    }
      return false;
  }

  setData(trades) {
    this.trades = trades;
  }

}
