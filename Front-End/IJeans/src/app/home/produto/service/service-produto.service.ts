
import { Injectable, Output, Input, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoModel } from 'src/app/shared/model/produto.model';
import { MarcaModel } from 'src/app/shared/model/marca.model';
import { TamanhoModel } from 'src/app/shared/model/tamanho.model';
import { TipoProduto } from 'src/app/shared/model/tipo.model';



@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
 

  constructor(private http: HttpClient) {}

  findAll(){
    return this.http.get<Array<ProdutoModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comprodutos");
  }
  findById(id){
    return this.http.get<ProdutoModel>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comprodutos/"+id);
  }
  cadastrarProduto(body){
    return this.http.post("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comestoque/novoProduto",body);
  }
  findByTipoProduto(tipo){
    return this.http.get<Array<TamanhoModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comtamanhos/"+tipo)
  }
  findAllMarcas(){
    return this.http.get<Array<MarcaModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.commarcas/")
  }
  findAllTamanhos(){
    return this.http.get<Array<TamanhoModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comtamanhos")
  }
  findAllTipoProduto(){
    return this.http.get<Array<TipoProduto>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comtipoProdutos")
  }

  updateProduto(body){
    return this.http.put<TipoProduto>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comprodutos",body)
  }
  removeProduto(id){
    return this.http.delete<TipoProduto>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comprodutos/"+id)
  }

  findByNome(nome){
    return this.http.get<Array<ProdutoModel>>("ec2-18-230-6-253.sa-east-1.compute.amazonaws.comprodutos/nome/" + nome);
  }

}
