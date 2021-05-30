import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Subject } from "rxjs";
import { ProdutoService } from "src/app/home/produto/service/service-produto.service";
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

  constructor(private formBuilder: FormBuilder, private service: ProdutoService, private router: Router,  private route: ActivatedRoute) {
  }

  marcas: Array<MarcaModel>
  marca: MarcaModel
  tamanhos: Array<TamanhoModel>
  tamanho: TamanhoModel
  tipoProdutos: Array<TipoProduto>
  tipoProduto: TipoProduto
  


   

  produtoNome;
  produtoQuantidade;
  produtoMarca;
  produtoTipo;
  produtoTamanho;
  produtoValor;

  ngOnInit() {

    this.route.params.subscribe(params => this.id = params['id']);

    
    if(this.id != null || this.id != undefined || this.id != ""){
       this.service.findById(this.id).subscribe(data => {
         console.log(data)
        this.produtoNome=data['nome'];
        this.produtoQuantidade=data['quantidade_estoque'];
        this.produtoMarca=data['marca']['nome'];
        this.produtoTipo=data['tipo_produto']['nome'];
        this.produtoTamanho=data['tamanho']['id'];
        this.produtoValor=data['preco_atual'];
        
      })
    }


  
   

    this.cadastraProdutoForm = this.formBuilder.group({
      nome: ['', [Validators.required]],
      valor: ['', [Validators.required, Validators.pattern('^[0-9]')]],
      quantidade: ['', [Validators.required, Validators.pattern('^[0-9]')],]
    });
   
  }


  

  onSubmit() {
    // Verifica ao enviar se os dados informados são validos
    if (
      this.cadastraProdutoForm.get('nome').valid &&
      this.cadastraProdutoForm.get('valor').valid &&
      this.cadastraProdutoForm.get('quantidade').valid
    ) {
      let produto = {
        nome: this.cadastraProdutoForm.value.nome,
        preco_atual: this.cadastraProdutoForm.value.valor,
        quantidade_estoque: this.cadastraProdutoForm.value.quantidade,
        marca: this.marca,
        tipo_produto: this.tipoProduto,
        tamanho: this.tamanho.id
      }


      this.service.cadastrarProduto(produto).subscribe(data => {
        if (data.id != null) {
          alert("produto cadastrado com sucesso")
          this.router.navigateByUrl('home');
        } else {
          alert("produto ja cadastrado");
        }
      })
    } else {
      alert('Dados Incorretos')
    }
  }



  voltarHome() {
    this.router.navigateByUrl("home")
  }

  isErrorCampo(nomeCampo) {
    return (!this.cadastraProdutoForm.get(nomeCampo).valid && this.cadastraProdutoForm.get(nomeCampo).touched);
  }
}


