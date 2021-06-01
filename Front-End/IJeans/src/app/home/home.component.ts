import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { ServiceLoginService } from "../login/service/service-login.service";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls:['./home.component.css']
  })

export class HomeComponent {
    constructor(private router: Router, private serviceLogin: ServiceLoginService) {
        
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
    logout(){
      this.serviceLogin.logout();
      this.router.navigateByUrl('');
    }
}
