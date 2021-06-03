import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })

export class RelatorioService{

    constructor(private http: HttpClient) {}



    realizarEnvio(email){
       return this.http.get<String>("http://localhost:8080/estoque/relatorio/"+email);
    }
}