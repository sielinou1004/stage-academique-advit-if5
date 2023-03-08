import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ADD_SANCTIONS } from 'src/app/shared/_elements/api_constante';
import { SanctionRequestModel } from 'src/app/shared/_models/requests/sanction-request.model';
import { EmployerReponseModel } from 'src/app/shared/_models/responses/employer-response.model';
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
  ) {}

  ngOnInit(): void {
    this.initFormSanction(null)
  }

  public initFormSanction(data: any){
    this.formSanction =this.fb.group({
    nom: [data ? data.nom :  ''],
    type_sanction:[data ? data.type_sanction: ''],
    lieu_recrutememnt:[data ? data.lieu_recrutememnt: ''],
    debut_sanction:[data ? data.debut_sanction: ''],
    fin_sanction:[data ? data.fin_periode_essaie: ''],
    description:[data ? data.description: ''],
    id_Employer:[data ? data.id_Employer: ''],
    id:[data ? data.id: null ],
    })
  }

  get f() { return this.formSanction.controls; }

  addEmployer(){
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
      this.f.lieu_recrutememnt.value,
      this.f.debut_sanction.value,
      this.f.fin_sanction.value,
      this.f.description.value,
      this.f.id.value,

      )
      console.log('avant', dto)
    this.sanctionService.post(ADD_SANCTIONS,dto )
    .then((response: any) =>{
    console.log('response', response)
    this.isLoading = !this.isLoading;
    this.notif.success('Ajout avec sucsess ')
    if (this.notif ){
      // this.router.navigate(['/listing-employer']).then(() => {});
  }
    },err => {
      console.log(err)
      this.notif.danger('Echec lors de ajout');
      this.isLoading = !this.isLoading;
      this.isLoginFailed = true;
  })

}
}
