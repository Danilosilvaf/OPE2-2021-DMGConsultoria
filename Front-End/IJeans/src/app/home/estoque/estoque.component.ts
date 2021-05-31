import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { ProdutoModel } from "src/app/shared/model/produto.model";
import { ProdutoService } from "../produto/service/service-produto.service";
import { EstoqueService } from "./service/estoque.service";

@Component({
    selector: 'app-estoque',
    templateUrl: './estoque.component.html',
    styleUrls: ['./estoque.component.css']
  })
  export class EstoqueComponent implements OnInit {
 

    produtos: Array<ProdutoModel>;
    constructor(private service: ProdutoService, private router: Router, private formBuilder: FormBuilder){}
    ngOnInit(): void {
      this.service.findAll().subscribe(data => {
        this.produtos = data
      });
    }

    cadastrarProduto() {
      this.router.navigateByUrl('cadastroproduto')
    }

    realizarEntrada(id){
      this.router.navigateByUrl('entrada/'+id)
    }
    realizarVenda(id){
      this.router.navigateByUrl('saida/'+id)
    }
}