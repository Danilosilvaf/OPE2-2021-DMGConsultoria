
import { Injectable, Output, Input, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FuncionarioModel } from 'src/app/shared/model/funcionario.model';



@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {
 

  constructor(private http: HttpClient) {}

  findAll(){
    return this.http.get<Array<FuncionarioModel>>("http://localhost:8080/funcionarios");
  }
  cadastraFuncionario(funcionario){
    return this.http.post<FuncionarioModel>("http://localhost:8080/funcionarios",funcionario);
  }
  delete(funcionario){
    return this.http.delete<FuncionarioModel>(`http://localhost:8080/funcionarios/${funcionario.id}`);
  }
  alteraFuncionario(funcionario){
    return this.http.put<FuncionarioModel>("http://localhost:8080/funcionarios",funcionario);
  }
  
}