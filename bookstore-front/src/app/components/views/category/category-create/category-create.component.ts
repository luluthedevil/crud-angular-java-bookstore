import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../category.model';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {

  category: Category = {
    name: '',
    description: ''
  }

  constructor(private service: CategoryService, private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    this.service.create(this.category).subscribe((response) => {
      console.log(response);
      this.router.navigate(['category']);
      this.service.message("Category was created successufully!");
    }, err => {
      for(let element of err.error.errors) {
        this.service.message(element.message);
      }
    });
  }

  cancel(): void {
    this.router.navigate(['category']);
  }

}
