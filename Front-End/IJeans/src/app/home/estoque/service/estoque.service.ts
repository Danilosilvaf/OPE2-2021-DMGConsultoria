
import { Injectable, Output, Input, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EstoqueModel } from 'src/app/shared/model/estoque.model';



@Injectable({
  providedIn: 'root'
})
export class EstoqueService {
 

  constructor(private http: HttpClient) {}

  
  cadastrarEstoqueJaExistente(estoque){
    return this.http.post<EstoqueModel>('http://localhost:8080/estoque',estoque);
  }
 
  
}