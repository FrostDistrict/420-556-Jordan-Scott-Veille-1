import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export class GenericCrudService<T, K> {

  constructor(
    protected http: HttpClient,
    protected url: string
  ) { }

  save(t: T): Observable<T> {
    return this.http.post<T>(this.url + '/save', t);
  }

  getAll(): Observable<T[]> {
    return this.http.get<T[]>(this.url + '/getAll');
  }

  getById(id: K): Observable<T> {
    return this.http.get<T>(this.url+ "/get"+ id);
  }

  update(id: K, t: T): Observable<T> {
    return this.http.put<T>(this.url+ "/update"+id, t);
  }

  deleteById(id: K): Observable<T> {
    return this.http.delete<T>(this.url+ "/delete?id="+ id);
  }
}
