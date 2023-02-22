import { Injectable } from "@angular/core";
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class employerService {

  constructor(
    private http: HttpClient
  ) { }
 public get(url:string, dto:string) {

  return this.http.get(url).toPromise();
 }

//  public post(url:string){
//   return this.http.post(url,dto).toPromise();
//  }
}



