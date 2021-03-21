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
    produtoBoolean = true
    fornecedorBoolean = false
    funcionarioBoolean = false

    displayProduto = 'block'
    displayFornecedor = 'none'
    displayFuncionario = 'none'


    produtos(){
      this.displayProduto='block'
      this.displayFornecedor='none'
      this.displayFuncionario='none'
    } 
    fonecedores(){
      this.displayProduto='none'
      this.displayFornecedor='block'
      this.displayFuncionario='none'
    }
    funcionarios(){
      this.displayProduto='none'
      this.displayFornecedor='none'
      this.displayFuncionario='block'
    }
}