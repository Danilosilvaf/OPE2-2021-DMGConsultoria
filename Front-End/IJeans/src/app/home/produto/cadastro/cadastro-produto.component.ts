import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { ProdutoModel } from "src/app/shared/model/produto.model";
import { ProdutoService } from "../service/service-produto.service";


@Component({
    selector: 'app-cadastraproduto',
    templateUrl: './cadastro-produto.component.html',
    styleUrls: ['./cadastro-produto.component.css']
  })


export class CadastrarProdutosComponent{

  cadastraProdutoForm : FormGroup;

  constructor(private formBuilder :  FormBuilder, private service : ProdutoService) {
  }

  ngOnInit() {
    
    this.cadastraProdutoForm = this.formBuilder.group( { 
      nome : [ '',[Validators.required]  ], 
      marca : [ '' , [Validators.required] ],
      tamanho : [ '' , [Validators.required] ],
      valor : [ '' , [Validators.required] ],
      quantidade : [ '' , [Validators.required] ]

    });
  }

  onSubmit(){
    // Verifica ao enviar se os dados informados são validos
    // let login = {login : this.loginForm.value.login, senha : this.loginForm.value.senha};
    
    let produto =  {
      nome:this.cadastraProdutoForm.value.nome,
      preco_atual:this.cadastraProdutoForm.value.valor,
      quantidade_estoque:this.cadastraProdutoForm.value.quantidade,
      marca:{
          id:1,
          nome:"Nike"
        },
        tipo_produto:{
          "id":1,
          "nome":"Camiseta"
        },"tamanho":{
          "id":"GG"
      }}
      this.service.cadastrarProduto(produto).subscribe(data => {
        console.log(data)
      })
    }
    
   
  }


