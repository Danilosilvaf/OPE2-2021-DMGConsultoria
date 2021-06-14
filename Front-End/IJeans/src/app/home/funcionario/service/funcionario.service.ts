
import { Injectable, Output, Input, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FuncionarioModel } from 'src/app/shared/model/funcionario.model';



@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {
 

  constructor(private http: HttpClient) {}

  findAll(){
    return this.http.get<Array<FuncionarioModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comfuncionarios");
  }
  cadastraFuncionario(funcionario){
    return this.http.post<FuncionarioModel>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comfuncionarios",funcionario);
  }
  delete(funcionario){
    return this.http.delete<FuncionarioModel>(`ec2-18-230-6-253.sa-east-1.compute.amazonaws.comfuncionarios/${funcionario.id}`);
  }
  alteraFuncionario(funcionario){
    return this.http.put<FuncionarioModel>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comfuncionarios",funcionario);
  }

  findByNome(nome){
    return this.http.get<Array<FuncionarioModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comfornecedor/nome/" + nome);
  }
}
