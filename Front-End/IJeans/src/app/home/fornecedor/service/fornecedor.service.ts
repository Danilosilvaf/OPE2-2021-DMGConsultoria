
import { Injectable, Output, Input, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FornecedorModel } from 'src/app/shared/model/fornecedor.model';



@Injectable({
  providedIn: 'root'
})
export class FornecedorService {

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get<Array<FornecedorModel>>("http://ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:8080/fornecedor");
  }

  cadastrarFornecedor(fornecedor) {
    return this.http.post<FornecedorModel>('http://ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:8080/fornecedor', fornecedor);
  }

  updatefornecedor(fornecedor) {
    return this.http.put<FornecedorModel>('http://ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:8080/fornecedor', fornecedor);
  }

  removerFornecedor(fornecedor) {
    return this.http.delete<FornecedorModel>('http://ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:8080/fornecedor/' + fornecedor);
  }

  findByNome(nome) {
    return this.http.get<Array<FornecedorModel>>("http://ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:8080/fornecedor/nome/" + nome);
  }

}
