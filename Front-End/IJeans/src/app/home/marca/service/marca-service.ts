import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { MarcaModel } from "src/app/shared/model/marca.model";

@Injectable({
  providedIn: 'root'
})

export class MarcaService {

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get<Array<MarcaModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.commarcas");
  }

  cadastrarMarca(marca) {
    return this.http.post<MarcaModel>('ec2-18-230-6-253.sa-east-1.compute.amazonaws.commarcas', marca);
  }

  delete(id) {
    return this.http.delete<MarcaModel>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.commarcas/" + id)
  }

  alterar(marca) {
    return this.http.put<MarcaModel>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.commarcas", marca);
  }

  findByNome(nome) {
    return this.http.get<Array<MarcaModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comfornecedor/nome/" + nome);
  }

}
