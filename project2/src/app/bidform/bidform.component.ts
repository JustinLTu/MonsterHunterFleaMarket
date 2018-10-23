import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { TradeForm } from '../model/tradeform.model';
import { BidForm } from '../model/bidform.model';
import { TradeService } from '../service/trade.service';
import { catchError } from 'rxjs/operators';
import { throwError} from 'rxjs';

@Component({
  selector: 'app-bidform',
  templateUrl: './bidform.component.html',
  styleUrls: ['./bidform.component.css']
})
export class BidformComponent implements AfterViewInit {

  private bidform: BidForm[];

  private tradeform: TradeForm;



  dummyTrade: TradeForm = {
    isOffer: false,
    itemName: 'Dummy Item',
    itemQuantity: 10,
    message: 'this is a dummy offer'
  };

  dummyBid: BidForm = {
    itemName: 'Dummy Item',
    itemQuantity: 4
  };
  constructor(private trade: TradeService, private router: Router) { }


  handleError(err: HttpErrorResponse) {
    if (err.status === 401) {
      document.getElementById('login-error').style.display = 'inline';
      return throwError('throwing error sending bid');
    }
  }

  navigate(bidform) {
    this.router.navigateByUrl('bids');
 }

  postBid(event) {
    event.preventDefault();
    const target = event.target;
    const bidform = new BidForm();
    bidform.itemName = target.querySelector('#itemName').value;
    bidform.itemQuantity = target.querySelector('#itemQuantity').value;
    this.trade.sendBid(bidform).pipe(catchError(this.handleError)).subscribe(data => this.navigate(data));
  }

  ngAfterViewInit() {
    // this.trade.getAllBids().subscribe(data => this.setData(data));
    // console.log(localStorage.getItem('tradeId'));
    this.trade.getStoredTrade().subscribe(trade => this.tradeform = trade);
    this.trade.getAllBids().subscribe(allBids => this.bidform = allBids);
  }

  refresh() {
    window.location.reload();
  }
}
