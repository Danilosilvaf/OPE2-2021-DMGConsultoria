import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })

export class RelatorioService{

    constructor(private http: HttpClient) {}



    realizarEnvio(email){
       return this.http.get<String>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.com:8080//estoque/relatorio/"+email);
    }
}