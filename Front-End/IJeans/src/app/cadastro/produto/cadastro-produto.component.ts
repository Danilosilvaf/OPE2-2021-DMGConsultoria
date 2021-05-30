import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { MarcaModel } from "src/app/shared/model/marca.model";
import { ProdutoModel } from "src/app/shared/model/produto.model";
import { TamanhoModel } from "src/app/shared/model/tamanho.model";
import { TipoProduto } from "src/app/shared/model/tipo.model";
import { AlertModalService } from "src/app/shared/services/alert-modal.service";
import { ProdutoService } from "../../home/produto/service/service-produto.service";


@Component({
  selector: 'app-cadastraproduto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css']
})


export class CadastrarProdutosComponent {

  cadastraProdutoForm: FormGroup;
  

  constructor(private formBuilder: FormBuilder, private service: ProdutoService, private router: Router,private alertService:AlertModalService) {
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
    this.service.findAllMarcas().subscribe(data => {
      this.marcas = data
      this.marca = data[0]
    })
    this.service.findAllTipoProduto().subscribe(data => {
      this.tipoProdutos = data
      this.tipoProduto = data[0]
      this.service.findByTipoProduto(this.tipoProduto.id).subscribe(data => {
        this.tamanhos = data
        this.tamanho = data[0]
      })
    })
    // this.service.findAllTamanhos().subscribe(data => {
    //   this.tamanhos = data
    //   this.tamanho= data[0]
    // })


  }

  selectMarca(marca) {
      this.marca = marca
  }
  selectTamanho(tamanho) {
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
          this.alertService.showSucess("produto cadastrado com sucesso")
          this.router.navigateByUrl('home');
        } else {
          this.alertService.showAlertDanger("produto ja cadastrado")
        }
      })
    } else {
      this.alertService.showAlertDanger('Dados Incorretos')
    }
  }



  voltarHome() {
    this.router.navigateByUrl("home")
  }

  isErrorCampo(nomeCampo) {
    return (!this.cadastraProdutoForm.get(nomeCampo).valid && this.cadastraProdutoForm.get(nomeCampo).touched);
  }
}


