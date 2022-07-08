import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book.model';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-delete',
  templateUrl: './book-delete.component.html',
  styleUrls: ['./book-delete.component.css']
})
export class BookDeleteComponent implements OnInit {

  id_cat: string = '';

  book: Book = {
    id: '',
    title: '',
    author_name: '',
    text: ''
  };

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

  delete(): void {
    this.service.delete(this.book.id!).subscribe((response) => {
      console.log(response);
      this.service.message('Book was deleted successfully!');
      this.router.navigate([`category/${this.id_cat}/books`]);
    }, err => {
      console.log(err);
      this.service.message('There wan an error when deleting book, try again later...');
      this.router.navigate([`category/${this.id_cat}/books`]);
    });
  }

  cancel(): void {
    this.router.navigate([`category/${this.id_cat}/books`]);
  }

}
