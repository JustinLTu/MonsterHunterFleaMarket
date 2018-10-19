import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { HomeComponent } from './home/home.component';
import { PformComponent } from './pform/pform.component';
import { SearchComponent } from './search/search.component';
import { BidformComponent } from './bidform/bidform.component';

const routes: Routes = [
  {path: 'welcome', component: LoginComponent },
  {path: 'signup', component: SignUpComponent},
  {path: '', redirectTo: 'welcome', pathMatch: 'full' },
  {path: 'home', component: HomeComponent },
  {path: 'posttrade', component: PformComponent },
  {path: 'search', component: SearchComponent },
  {path: 'bids', component: BidformComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {

 }
