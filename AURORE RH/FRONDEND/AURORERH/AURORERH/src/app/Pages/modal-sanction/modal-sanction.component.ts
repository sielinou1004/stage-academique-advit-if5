import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ADD_SANCTIONS, LIST_EMPLOYERS } from 'src/app/shared/_elements/api_constante';
import { SanctionRequestModel } from 'src/app/shared/_models/requests/sanction-request.model';
import { EmployerReponseModel } from 'src/app/shared/_models/responses/employer-response.model';
import { EmployerService } from 'src/app/shared/_services/employerService';
import { NotificationService } from 'src/app/shared/_services/notification.service';
import { SanctionService } from 'src/app/shared/_services/sanctionService';


@Component({
  selector: 'app-modal-sanction',
  templateUrl: './modal-sanction.component.html',
  styleUrls: ['./modal-sanction.component.css']
})
export class ModalSanctionComponent implements OnInit {

  public formSanction!: FormGroup;
  public submitted!: boolean;
  public isLoading!: boolean;
  public isLoggedIn = false;
  public isLoginFailed = false;
  public employers: EmployerReponseModel[] = [];
  id: any;


  constructor(
    private sanctionService: SanctionService,
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,
    private notif: NotificationService,
    private employerService: EmployerService,
    private dialogRef: MatDialogRef<ModalSanctionComponent>,
    @Inject(MAT_DIALOG_DATA) data: any
  ) {}

  ngOnInit(): void {
    this.initFormSanction(null)
    this.getEmployer();
  }

  public initFormSanction(data: any){
    this.formSanction =this.fb.group({
    nom: [data ? data.nom :  ''],
    type_sanction:[data ? data.type_sanction: ''],
    debut_sanction:[data ? data.debut_sanction: ''],
    fin_sanction:[data ? data.fin_periode_essaie: ''],
    description:[data ? data.description: ''],
    id_Employer:[data ? data.id_Employer: ''],
    id:[data ? data.id: null ],
    })
  }

  get f() { return this.formSanction.controls; }

  addSanction(){
    this.submitted = true;
    this.isLoading = true;
    if (this.formSanction.invalid) {
        this.isLoading = !this.isLoading;
        return;
    }
    console.log('f',this.f)
    console.log( 'fb',this.fb)
    let dto;
    dto = new SanctionRequestModel(
      this.f.nom.value,
      this.f. type_sanction.value,
      this.f.debut_sanction.value,
      this.f.fin_sanction.value,
      this.f.description.value,
      this.f.id.value,
      this.f.id_Employer.value

      )
      console.log('avant', dto)
    this.sanctionService.post(ADD_SANCTIONS,dto )
    .then((response: any) =>{
    console.log('response', response)
    this.isLoading = !this.isLoading;
    this.notif.success('Ajout avec sucsess ')
    if (this.notif ){
   
  }
    },err => {
      console.log(err)
      this.notif.danger('Echec lors de ajout');
      this.isLoading = !this.isLoading;
      this.isLoginFailed = true;
  })

}

getEmployer(){
  this.employerService.get(LIST_EMPLOYERS).then((response:any)=>{
    this.employers = response.data;
    console.log(this.employers)
  }
  )
}
}
