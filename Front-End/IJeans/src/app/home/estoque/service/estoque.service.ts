
import { Injectable, Output, Input, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EstoqueModel } from 'src/app/shared/model/estoque.model';
import { ProdutoModel } from 'src/app/shared/model/produto.model';



@Injectable({
  providedIn: 'root'
})
export class EstoqueService {
 

  constructor(private http: HttpClient) {}

  
  cadastrarEstoqueJaExistente(estoque){
    return this.http.post<EstoqueModel>('ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:5000/estoque',estoque);
  }
  
  findByNome(nome){
    return this.http.get<Array<ProdutoModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:5000/fornecedor/nome/" + nome);
  }
  
}
