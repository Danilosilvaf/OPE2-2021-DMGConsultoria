
import { Injectable, Output, Input, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FornecedorModel } from 'src/app/shared/model/fornecedor.model';



@Injectable({
  providedIn: 'root'
})
export class FornecedorService {

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get<Array<FornecedorModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:5000/fornecedor");
  }

  cadastrarFornecedor(fornecedor) {
    return this.http.post<FornecedorModel>('ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:5000/fornecedor', fornecedor);
  }

  updatefornecedor(fornecedor) {
    return this.http.put<FornecedorModel>('ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:5000/fornecedor', fornecedor);
  }

  removerFornecedor(fornecedor) {
    return this.http.delete<FornecedorModel>('ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:5000/fornecedor/' + fornecedor);
  }

  findByNome(nome) {
    return this.http.get<Array<FornecedorModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:5000/fornecedor/nome/" + nome);
  }

}
