import { Component, OnInit, Input } from '@angular/core';
import { product } from '../models/product.Model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product!:product;
  constructor() { }

  ngOnInit(): void {
    this.title = 'Gun';
    this.description = 'semi-auto';
    this.createDate = new Date();
    this.price = 100;
    this.snaps = 1 ;
    this.imageUrl = 'assets/gun.jpg';
    this.buttonText = 'like'
  }



  title!:string;
  description!:string;
  createDate!:Date;
  price!:number;
  snaps!:number;
  imageUrl!: string;
  buttonText!:string;

  onSnap() {
    if (this.buttonText === 'like!') {
      this.snaps++;
      this.buttonText = 'dislike!';
    } else {
      this.snaps--;
      this.buttonText = 'like!';
    }
  }
  }
