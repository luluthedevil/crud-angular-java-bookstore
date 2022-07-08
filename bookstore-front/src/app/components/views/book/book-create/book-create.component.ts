import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book.model';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-create',
  templateUrl: './book-create.component.html',
  styleUrls: ['./book-create.component.css']
})
export class BookCreateComponent implements OnInit {

  id_cat: string = '';

  book: Book = {
    id: '',
    title: '',
    author_name: '',
    text: ''
  };

  title = new FormControl('', [Validators.minLength(3)]);
  author_name = new FormControl('', [Validators.minLength(3)]);
  text = new FormControl('', [Validators.minLength(20)]);

  constructor(
    private service: BookService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id_cat = this.route.snapshot.paramMap.get('id_cat')!;
  }

  create(): void {
    this.service.create(this.book, this.id_cat).subscribe((response) => {
      this.router.navigate([`category/${this.id_cat}/books`]);
      console.log(response);
      this.service.message('Book created successfully!');
    }, err => {
      this.router.navigate([`category/${this.id_cat}/books`]);
      console.log(err);
      this.service.message('There wan an error when creating book');
    });
  }

  getMessage() {
    if(this.title.invalid) {
      return 'TITLE field MUST be between 3 and 100 characters long';
    }
    if(this.author_name.invalid) {
      return 'AUTHOR NAME field MUST be between 3 and 100 characters long';
    }
    if(this.text.invalid) {
      return 'TEXT field MUST be between 20 and 2000 characters long';
    }
    return false;
  }

  cancel(): void {
    this.router.navigate([`category/${this.id_cat}/books`]);
  }

}
