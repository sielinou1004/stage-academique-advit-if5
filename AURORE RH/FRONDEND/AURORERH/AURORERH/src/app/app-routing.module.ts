import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ListingEmployerComponent } from './Pages/listing-employer/listing-employer.component';

const routes: Routes = [
 {path:'', component:DashboardComponent },
  {path:'listing-employer', component:ListingEmployerComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


}
