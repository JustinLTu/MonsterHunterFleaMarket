import { Component, OnInit } from '@angular/core';
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
export class BidformComponent implements OnInit {

  public bidform: BidForm;

  tradeForm: TradeForm = {
    isOffer: false,
    itemName: 'hammer',
    itemQuantity: 10,
    message: 'this is a hammer'
  };

  dummyBid: BidForm = {
    itemName: 'Aquacore Ore',
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
    this.bidform = new BidForm();
    this.bidform.itemName = target.querySelector('#itemName').value;
    this.bidform.itemQuantity = target.querySelector('#itemQuantity').value;
    this.trade.sendBid(this.bidform).pipe(catchError(this.handleError)).subscribe(data => this.navigate(data));
  }
  ngOnInit() {
    // this.trade.getAllBids().subscribe(data => this.setData(data));
    console.log(localStorage.getItem('tradeId'));
  }

  setData(bidform) {
    this.bidform = bidform;
  }
}
