import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainComponent } from './main/main.component';
import { AffichEmployerComponent } from './Pages/affich-employer/affich-employer.component';
import { AjoutEmployerComponent } from './Pages/ajout-employer/ajout-employer.component';
import { ListingEmployerComponent } from './Pages/listing-employer/listing-employer.component';
import { LoginComponent } from './session/login/login.component';
import { UserGuardService } from './shared/_helpers/user-guard.service';

const routes: Routes = [
{path:'session/login', component:LoginComponent},
{
  path:'', component:MainComponent, canActivate: [UserGuardService],
  children:[
    {path:'', component:DashboardComponent},
    {path:'listing-employer', component:ListingEmployerComponent },
    {path: 'ajout-employer', component:AjoutEmployerComponent},
    {path: 'ajout-employer/:id', component:AjoutEmployerComponent},
    {path: 'affich-employer/:id',component:AffichEmployerComponent}
  ]
},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
