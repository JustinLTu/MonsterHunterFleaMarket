import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { TradeForm } from '../model/tradeform.model';
import { TradeService } from '../service/trade.service';
import { catchError } from 'rxjs/operators';
import { throwError} from 'rxjs';

@Component({
  selector: 'app-pform',
  templateUrl: './pform.component.html',
  styleUrls: ['./pform.component.css']
})
export class PformComponent implements OnInit {

  public tradeForm: TradeForm;

  constructor(private trade: TradeService, private router: Router) { }

  ngOnInit() {
  }

  handleError(err: HttpErrorResponse) {
    if (err.status === 401) {
      document.getElementById('login-error').style.display = 'inline';
      return throwError('throwing error login');
    }
  }

  navigate(tradeForm) {
    localStorage.setItem('form', tradeForm);
    this.router.navigateByUrl('home');
 }

  postTrade(event) {
    event.preventDefault();
    const target = event.target;
    const tradeType = target.querySelector('#isOffer').value;
    let isOffer = false;
    if (tradeType === 'Offer') {
       isOffer = true;
    }
    const itemName = target.querySelector('#itemName').value;
    const itemQuantity = target.querySelector('#itemQuantity').value;
    const message = target.querySelector('#message').value;

    this.tradeForm = new TradeForm();
    this.tradeForm.isOffer = isOffer;
    this.tradeForm.itemName = itemName;
    this.tradeForm.itemQuantity = itemQuantity;
    this.tradeForm.message = message;

    console.log(this.tradeForm);
    this.navigate(this.tradeForm);
    this.trade.sendTrade(this.tradeForm).pipe(catchError(this.handleError)).subscribe(data => this.navigate(data));
  }

}
