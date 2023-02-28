import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ADD_EMPLOYER } from 'src/app/shared/_elements/api_constante';
import { EmployerRequestModel } from 'src/app/shared/_models/requests/employer-request.model';
import { EmployerService } from 'src/app/shared/_services/employerService';
import { NotificationService } from 'src/app/shared/_services/notification.service';

@Component({
  selector: 'app-ajout-employer',
  templateUrl: './ajout-employer.component.html',
  styleUrls: ['./ajout-employer.component.css']
})
export class AjoutEmployerComponent implements OnInit {

  public isLoggedIn = false;
  public isLoginFailed = false;
  public formEmployer!: FormGroup;
  public submitted!: boolean;
  public isLoading!: boolean;

  constructor(
    private employerService: EmployerService,
    private notif: NotificationService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    ) { }

  ngOnInit(): void {
    this.initFormEmployer();
  }
  get f() { return this.formEmployer.controls; }

  private initFormEmployer() {
    this.formEmployer = this.fb.group({
        nom: ['', Validators.required],
        matricule: ['', Validators.required],
        adresse:[''],
        date_debut:[''],
        date_fin:[''],
        date_naissance:[''],
        id:[''],
        lieu_naissance:[''],
        nationalite:[''],
        nbr_enfant:[''],
        numero:[''],
        photo:[''],
        poste:['', Validators.required],
        prenom:[''],
        profession:['', Validators.required],
        sexe:[''],
        statut_matrimoniale:[''],
        type_contrat:['', Validators.required],
        ville_exertion:['', Validators.required],


    });
}
  addEmployer(){
    this.submitted = true;
    this.isLoading = true;
    if (this.formEmployer.invalid) {
        this.isLoading = !this.isLoading;
        return;
    }
    let dto;
    dto = new EmployerRequestModel(
      this.f.adresse.value,
      this.f.date_debut.value,
      this.f.date_fin.value,
      this.f.date_naissance.value,
      this.f.id.value,
      this.f.lieu_naissance.value,
      this.f.matricule.value,
      this.f.nationalite.value,
      this.f.nbr_enfant.value,
      this.f.nom.value,
      this.f.numero.value,
      this.f.photo.value,
      this.f.poste.value,
      this.f.prenom.value,
      this.f.profession.value,
      this.f.sexe.value,
      this.f.statut_matrimoniale.value,
      this.f.type_contrat.value,
      this.f.ville_exertion.value
      )
    this.employerService.post(ADD_EMPLOYER,dto )
    .then((response: any) =>{
    console.log('response', response)
    this.isLoading = !this.isLoading;
    this.notif.success('Ajout avec sucsess ')
    if (this.notif ){
      this.router.navigate(['/listing-employer']).then(() => {});
  }
    },err => {
      console.log(err)
      this.notif.danger('Echec lors de ajout');
      this.isLoading = !this.isLoading;
      this.isLoginFailed = true;
  })


}
}
