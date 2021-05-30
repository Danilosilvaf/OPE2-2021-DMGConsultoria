import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Subject } from "rxjs";
import { FornecedorService } from "src/app/home/fornecedor/service/fornecedor.service";
import { ProdutoService } from "src/app/home/produto/service/service-produto.service";
import { FornecedorModel } from "src/app/shared/model/fornecedor.model";
import { MarcaModel } from "src/app/shared/model/marca.model";
import { ProdutoModel } from "src/app/shared/model/produto.model";
import { TamanhoModel } from "src/app/shared/model/tamanho.model";
import { TipoProduto } from "src/app/shared/model/tipo.model";


@Component({
  selector: 'app-entrada',
  templateUrl: './entrada.component.html',
  styleUrls: ['./entrada.component.css']
})


export class EntradaComponent {

  cadastraProdutoForm: FormGroup;
  id;

  constructor(private formBuilder: FormBuilder, private service: ProdutoService, private router: Router,  private route: ActivatedRoute,private serviceFornecedor:FornecedorService) {
  }

 


  fornecedores:Array<FornecedorModel> 

  produtoNome;
  produtoQuantidade;
  produtoMarca;
  produtoTipo;
  produtoTamanho;
  produtoValor;
  produto;

  fornecedor:FornecedorModel
  ngOnInit() {

    this.route.params.subscribe(params => this.id = params['id']);

    this.serviceFornecedor.findAll().subscribe(data =>{
      this.fornecedores = data
      this.fornecedor = this.fornecedores[0]
    });
    
    if(this.id != null || this.id != undefined || this.id != ""){
       this.service.findById(this.id).subscribe(data => {
        this.produtoNome=data['nome'];
        this.produtoQuantidade;
        this.produtoMarca=data['marca']['nome'];
        this.produtoTipo=data['tipo_produto']['nome'];
        this.produtoTamanho=data['tamanho']['id'];
        this.produtoValor;
        this.produto=data
      })
    }

    this.cadastraProdutoForm = this.formBuilder.group({
      nome: ['', [Validators.required]],
      valor: ['', [Validators.required, Validators.pattern('^-?[0-9\.]+$')]],
      quantidade: ['', [Validators.required, Validators.pattern('^-?[0-9\.]+$')],]
    });
   
  }

  selectFornecedor(fornecedor){
      this.fornecedores.forEach(data =>{
        if(data.nome === fornecedor)
        this.fornecedor = data;
      })
  }
  

  onSubmit() {
    
    if (
      (this.cadastraProdutoForm.get('valor').valid &&
      this.cadastraProdutoForm.get('quantidade').valid) 
    ) 
    {
      if( this.cadastraProdutoForm.get('quantidade').value >0 && this.cadastraProdutoForm.get('valor').value >0){
        let movimentacao = {
          quantidade: this.cadastraProdutoForm.get('quantidade').value,
          status: true,
          preco: this.cadastraProdutoForm.get('valor').value,
          produto: this.produto,
          fornecedor: this.fornecedor,
        }
  
        console.log(movimentacao)
      }
    }
    alert("Dados Incorretos")
  }


  voltarHome() {
    this.router.navigateByUrl("home")
  }

  isErrorCampo(nomeCampo) {
    return (!this.cadastraProdutoForm.get(nomeCampo).valid && this.cadastraProdutoForm.get(nomeCampo).touched);
  }
}


