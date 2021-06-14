import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { MarcaModel } from "src/app/shared/model/marca.model";

@Injectable({
  providedIn: 'root'
})

export class MarcaService {

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get<Array<MarcaModel>>("http://ec2-18-230-75-94.sa-east-1.compute.amazonaws.com:8080/marcas");
  }

  cadastrarMarca(marca) {
    return this.http.post<MarcaModel>('http://ec2-18-230-75-94.sa-east-1.compute.amazonaws.com:8080/marcas', marca);
  }

  delete(id) {
    return this.http.delete<MarcaModel>("http://ec2-18-230-75-94.sa-east-1.compute.amazonaws.com:8080/marcas/" + id)
  }

  alterar(marca) {
    return this.http.put<MarcaModel>("http://ec2-18-230-75-94.sa-east-1.compute.amazonaws.com:8080/marcas", marca);
  }

  findByNome(nome) {
    return this.http.get<Array<MarcaModel>>("http://ec2-18-230-75-94.sa-east-1.compute.amazonaws.com:8080/fornecedor/nome/" + nome);
  }

}
