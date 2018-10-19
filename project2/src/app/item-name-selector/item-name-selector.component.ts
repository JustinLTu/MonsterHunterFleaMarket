import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-item-name-selector',
  templateUrl: './item-name-selector.component.html',
  styleUrls: ['./item-name-selector.component.css']
})
export class ItemNameSelectorComponent implements OnInit {

  @Output() itemName;

  constructor() { }

  ngOnInit() {
  }

}
