import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { MarcaModel } from "src/app/shared/model/marca.model";
import { ProdutoModel } from "src/app/shared/model/produto.model";
import { TamanhoModel } from "src/app/shared/model/tamanho.model";
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

  marcas: Array<MarcaModel>
  tamanhos:Array<TamanhoModel>
  tamanho:TamanhoModel
  marca:MarcaModel

  ngOnInit() {
    
    this.cadastraProdutoForm = this.formBuilder.group( { 
      nome : [ '',[Validators.required]  ], 
      // marca : [ '' , [Validators.required] ],
      // tamanho : [ '' , [Validators.required] ],
      valor : [ '' , [Validators.required] ],
      quantidade : [ '' , [Validators.required] ]

    });
    this.service.findAllMarcas().subscribe(data =>{
      this.marcas =  data
      this.marca = data[0]
    })

  }
  
  selectMarca(marca){
    console.log(marca)
    this.marca=marca
  }
  selectTamanho(tamanho){
    this.tamanho=tamanho
  }

  onSubmit(){
    // Verifica ao enviar se os dados informados são validos
    // let login = {login : this.loginForm.value.login, senha : this.loginForm.value.senha};
    console.log(this.cadastraProdutoForm.value.marca.nome)
    let produto =  {
      nome:this.cadastraProdutoForm.value.nome,
      preco_atual:this.cadastraProdutoForm.value.valor,
      quantidade_estoque:this.cadastraProdutoForm.value.quantidade,
      marca:this.marca,
        tipo_produto:{
          "id":1,
          "nome":"Camiseta"
        },tamanho:this.tamanho
      }
      this.service.cadastrarProduto(produto).subscribe(data => {
        console.log(data)
      })
    }
    
   
  }


