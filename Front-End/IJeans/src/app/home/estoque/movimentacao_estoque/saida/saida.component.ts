import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ProdutoService } from "src/app/home/produto/service/service-produto.service";
import { MarcaModel } from "src/app/shared/model/marca.model";
import { TamanhoModel } from "src/app/shared/model/tamanho.model";
import { TipoProduto } from "src/app/shared/model/tipo.model";


@Component({
  selector: 'app-saida',
  templateUrl: './saida.component.html',
  styleUrls: ['./saida.component.css']
})


export class SaidaComponent {

  cadastraProdutoForm: FormGroup;
  

  constructor(private formBuilder: FormBuilder, private service: ProdutoService, private router: Router) {
  }

  marcas: Array<MarcaModel>
  marca: MarcaModel
  tamanhos: Array<TamanhoModel>
  tamanho: TamanhoModel
  tipoProdutos: Array<TipoProduto>
  tipoProduto: TipoProduto
  tipoProdutoControl:FormControl
  
  idTipoProduto="1";

  ngOnInit() {

    this.tipoProdutoControl = new FormControl('valid', [
      Validators.required,
      Validators.pattern('valid'),
    ]);

    this.cadastraProdutoForm = this.formBuilder.group({
      nome: ['', [Validators.required]],
      valor: ['', [Validators.required, Validators.pattern('^[0-9]')]],
      quantidade: ['', [Validators.required, Validators.pattern('^[0-9]')],],
      tipoProduto:['', [Validators.required]]

    });

  }

  selectMarca(marca) {
    console.log(marca)
    this.marca = marca
  }
  selectTamanho(tamanho) {
    console.log(tamanho)
    this.tamanho = tamanho
  }
  selectTipoProduto(tipo:TipoProduto) {
    this.tipoProduto = tipo

    if(this.idTipoProduto === "1"){
      this.idTipoProduto = "2"
    }else{
      this.idTipoProduto = "1"
    }
    this.service.findByTipoProduto(this.idTipoProduto).subscribe(data => {
      this.tamanhos = data
      this.tamanho = data[0]
    })
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


