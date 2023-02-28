import { Component, OnInit } from '@angular/core';
import { DELETE_EMPLOYER, LIST_EMPLOYERS } from 'src/app/shared/_elements/api_constante';
import { EmployerReponseModel } from 'src/app/shared/_models/responses/employer-response.model';
import { EmployerService } from 'src/app/shared/_services/employerService';

@Component({
  selector: 'app-listing-employer',
  templateUrl: './listing-employer.component.html',
  styleUrls: ['./listing-employer.component.css']
})
export class ListingEmployerComponent implements OnInit {


  public employers: EmployerReponseModel[] = [];
  constructor(
    private employerService: EmployerService,
  ) { }

  ngOnInit(): void {
    this.getEmployer();


  }
  getEmployer(){
    this.employerService.get(LIST_EMPLOYERS).then((response:any)=>{
      this.employers = response.data;
      console.log(this.employers)
    }
    )
  }

  deleteEmployer(item: any){
    console.log(item)
    this.employerService.delete(`${DELETE_EMPLOYER}/${item.id}`)
      .then((response:any)=>{
      console.log('response', response)
      this.getEmployer();

    })
  }

}
