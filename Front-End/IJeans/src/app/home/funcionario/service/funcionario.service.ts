
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
    return this.http.post<String>("http://localhost:8080/funcionarios",funcionario);
  }
  
}