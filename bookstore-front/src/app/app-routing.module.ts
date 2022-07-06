import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryReadComponent } from './components/views/category/category-read/category-read.component';
import { HomeComponent } from './components/views/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'category',
    component: CategoryReadComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
