import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DELETE_EMPLOYER, LIST_EMPLOYERS, READBYID_EMPLOYER, UPDATE_EMPLOYER } from 'src/app/shared/_elements/api_constante';
import { EmployerReponseModel } from 'src/app/shared/_models/responses/employer-response.model';
import { EmployerService } from 'src/app/shared/_services/employerService';
import { NotificationService } from 'src/app/shared/_services/notification.service';
import Swal from 'sweetalert2'
import { AjoutEmployerComponent } from '../ajout-employer/ajout-employer.component';

@Component({
  selector: 'app-listing-employer',
  templateUrl: './listing-employer.component.html',
  styleUrls: ['./listing-employer.component.css']
})
export class ListingEmployerComponent implements OnInit {

  public isLoading!: boolean;
  public employers: EmployerReponseModel[] = [];
  public id!: any;

  constructor(
    private employerService: EmployerService,
    private notif: NotificationService,
    private router: Router,
    private route: ActivatedRoute,
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
    Swal.fire({
      title: 'Êtes-vous sure?',
      text: "Vous ne pourrez pas revenir en arrière !",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Oui, supprimez !'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Supprimé!',
          'Employer supprimé.',
          'success'
        )
        this.employerService.delete(`${DELETE_EMPLOYER}/${item.id}`)
        .then((response:any)=>{
        console.log('response', response)
        this.getEmployer();

      })
      }
      else {
        Swal.fire(
          'Annulé!',
          'Employer non supprimé.',
          'error'
        )}
    })
  }

  goTo(){
    this.router.navigate(['/ajout-employer'])
  }

  recupId(employer: EmployerReponseModel){
    this.router.navigate(['/ajout-employer/', employer.id])
  }
}
