import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookCreateComponent } from './components/views/book/book-create/book-create.component';
import { BookReadAllComponent } from './components/views/book/book-read-all/book-read-all.component';
import { CategoryCreateComponent } from './components/views/category/category-create/category-create.component';
import { CategoryDeleteComponent } from './components/views/category/category-delete/category-delete.component';
import { CategoryReadComponent } from './components/views/category/category-read/category-read.component';
import { CategoryUpdateComponent } from './components/views/category/category-update/category-update.component';
import { HomeComponent } from './components/views/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'category',
    component: CategoryReadComponent
  },
  {
    path: 'category/create',
    component: CategoryCreateComponent
  },
  {
    path: 'category/delete/:id',
    component: CategoryDeleteComponent
  },
  {
    path: 'category/update/:id',
    component: CategoryUpdateComponent
  },
  {
    path: 'category/:id_cat/books',
    component: BookReadAllComponent
  },
  {
    path: 'category/:id_cat/books/create',
    component: BookCreateComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
