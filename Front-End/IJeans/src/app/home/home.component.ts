import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls:['./home.component.css']
  })

export class HomeComponent {
    constructor(private router: Router) {
        
    }
    
    displayProduto = 'none'
    displayFornecedor = 'none'
    displayFuncionario = 'none'
    displayMarca = 'none'
    displayEstoque='block'


    produtos(){
      this.displayProduto='block'
      this.displayFornecedor='none'
      this.displayFuncionario='none'
      this.displayMarca = 'none'
      this.displayEstoque='none'
    } 
    fonecedores(){
      this.displayProduto='none'
      this.displayFornecedor='block'
      this.displayFuncionario='none'
      this.displayMarca = 'none'
      this.displayEstoque='none'
    }
    funcionarios(){
      this.displayProduto='none'
      this.displayFornecedor='none'
      this.displayFuncionario='block'
      this.displayMarca = 'none'
      this.displayEstoque='none'
    }
    marcas(){
      this.displayProduto='none'
      this.displayFornecedor='none'
      this.displayFuncionario='none'
      this.displayMarca = 'block'
      this. displayEstoque='none'
    }
    estoques(){
      this.displayProduto='none'
      this.displayFornecedor='none'
      this.displayFuncionario='none'
      this.displayMarca = 'none'
      this. displayEstoque='block'
    }
}