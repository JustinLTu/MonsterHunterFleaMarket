import { Component, OnInit } from '@angular/core';
import { TradeForm } from '../model/tradeform.model';
import { BidForm } from '../model/bidform.model';

@Component({
  selector: 'app-bidform',
  templateUrl: './bidform.component.html',
  styleUrls: ['./bidform.component.css']
})
export class BidformComponent implements OnInit {


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
  
  constructor() { }

  ngOnInit() {
  }

}
