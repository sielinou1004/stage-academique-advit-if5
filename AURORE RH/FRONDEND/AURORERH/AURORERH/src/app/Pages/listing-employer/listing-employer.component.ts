import { Component, OnInit } from '@angular/core';
import { LIST_EMPLOYERS } from 'src/app/Shared/_elements/api_constante';
import { EmployerService } from 'src/app/Shared/_services/employerService';

@Component({
  selector: 'app-listing-employer',
  templateUrl: './listing-employer.component.html',
  styleUrls: ['./listing-employer.component.css']
})
export class ListingEmployerComponent implements OnInit {

  public employers: any[] = [];
  constructor(
    private employerService: EmployerService,
  ) { }

  ngOnInit(): void {
    this.getEmployer();
  }
  getEmployer(){
    this.employerService.get(LIST_EMPLOYERS).then((response:any)=>{
      this.employers = response;
      console.log(this.employers)
    }
    )
  }

}
