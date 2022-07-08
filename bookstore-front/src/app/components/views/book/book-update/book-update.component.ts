import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book.model';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-update',
  templateUrl: './book-update.component.html',
  styleUrls: ['./book-update.component.css']
})
export class BookUpdateComponent implements OnInit {

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
    this.book.id = this.route.snapshot.paramMap.get('id')!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.book.id!).subscribe((response) => {
      this.book = response;
    });
  }

  update(): void {
    this.service.update(this.book).subscribe((response) => {
      this.router.navigate([`category/${this.id_cat}/books`]);
      console.log(response);
      this.service.message('Book was updated successfully!');
    }, err => {
      console.log(err);
      this.router.navigate([`category/${this.id_cat}/books`]);
      this.service.message('There wan an error when updating book');
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
