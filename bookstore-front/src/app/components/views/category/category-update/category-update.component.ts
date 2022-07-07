import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../category.model';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-category-update',
  templateUrl: './category-update.component.html',
  styleUrls: ['./category-update.component.css']
})
export class CategoryUpdateComponent implements OnInit {

  category: Category = {
    id: '',
    name: '',
    description: ''
  }

  constructor(private service: CategoryService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.category.id = this.route.snapshot.paramMap.get('id')!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.category.id!).subscribe((response) => {
      this.category.name = response.name;
      this.category.description = response.description;
    });
  }

  update(): void {
    this.service.update(this.category).subscribe((response) => {
      console.log(response);
      this.router.navigate(['category']);
      this.service.message("Category was updated successufully");
    }, err => {
      this.service.message("Fill the fields correctly");
    });
  }

  cancel(): void {
    this.router.navigate(['category']);
  }

}
