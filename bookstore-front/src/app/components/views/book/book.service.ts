import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Book } from './book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  findAllByCategory(id_cat: string): Observable<Book[]> {
    const url = `${this.baseUrl}/books?category=${id_cat}`;
    return this.http.get<Book[]>(url);
  }

}
