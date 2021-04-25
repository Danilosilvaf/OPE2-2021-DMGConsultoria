import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { MarcaModel } from "src/app/shared/model/marca.model";

@Injectable({
    providedIn: 'root'
  })
  export class MarcaService {
   
  
    constructor(private http: HttpClient) {}
  
    findAll(){
      return this.http.get<Array<MarcaModel>>("http://localhost:8080/marcas");
    }
    
    
  }