import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-oders',
  templateUrl: './oders.component.html',
  styleUrls: ['./oders.component.css']
})
export class OdersComponent implements OnInit {



  id!: string;
  description!: string;
  prix!: string;

  constructor() { }

  ngOnInit(): void {
  }

}
