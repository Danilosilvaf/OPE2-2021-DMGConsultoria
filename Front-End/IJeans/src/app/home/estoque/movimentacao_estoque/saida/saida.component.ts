import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { ProdutoService } from "src/app/home/produto/service/service-produto.service";



@Component({
  selector: 'app-saida',
  templateUrl: './saida.component.html',
  styleUrls: ['./saida.component.css']
})


export class SaidaComponent {

  cadastraProdutoForm: FormGroup;
  

  constructor(private formBuilder: FormBuilder, private service: ProdutoService, private router: Router,  private route: ActivatedRoute) {
  }

  produtoNome;
  produtoQuantidade;
  produtoMarca;
  produtoTipo;
  produtoTamanho;
  produtoValor;

  id;

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
      quantidade: ['', [Validators.required, Validators.pattern('^[0-9]')],],
      tipoProduto:['', [Validators.required]]

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
        marca: this.produtoMarca,
        tipo_produto: this.produtoTipo,
        tamanho: this.produtoTamanho
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


