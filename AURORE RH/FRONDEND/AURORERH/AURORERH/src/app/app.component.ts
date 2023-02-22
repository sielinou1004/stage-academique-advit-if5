import { Component, OnInit } from '@angular/core';
import { product } from './models/product.Model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'AURORERH';
  myproduct!: product;

  ngOnInit(){

  }
}
