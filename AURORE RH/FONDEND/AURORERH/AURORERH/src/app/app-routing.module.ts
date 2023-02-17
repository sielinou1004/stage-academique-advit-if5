import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { OdersComponent } from './oders/oders.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  {path:'', component:DashboardComponent },
  { path: 'home', component:HomeComponent },
  { path: 'product', component:ProductComponent},
  { path: 'oders' , component:OdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


}
