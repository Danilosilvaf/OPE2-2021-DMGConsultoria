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
    
    displayProduto = 'block'
    displayFornecedor = 'none'
    displayFuncionario = 'none'
    displayMarca = 'none'


    produtos(){
      this.displayProduto='block'
      this.displayFornecedor='none'
      this.displayFuncionario='none'
      this.displayMarca = 'none'
    } 
    fonecedores(){
      this.displayProduto='none'
      this.displayFornecedor='block'
      this.displayFuncionario='none'
      this.displayMarca = 'none'
    }
    funcionarios(){
      this.displayProduto='none'
      this.displayFornecedor='none'
      this.displayFuncionario='block'
      this.displayMarca = 'none'
    }
    marcas(){
      this.displayProduto='none'
      this.displayFornecedor='none'
      this.displayFuncionario='none'
      this.displayMarca = 'block'
    }
}