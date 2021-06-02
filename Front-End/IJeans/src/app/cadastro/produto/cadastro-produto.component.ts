import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { FornecedorService } from "src/app/home/fornecedor/service/fornecedor.service";
import { FornecedorModel } from "src/app/shared/model/fornecedor.model";
import { MarcaModel } from "src/app/shared/model/marca.model";
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
  

  constructor(private formBuilder: FormBuilder, private service: ProdutoService, private router: Router,private alertService:AlertModalService, private fornecedorService:FornecedorService) {
  }

  marcas: Array<MarcaModel>
  marca: MarcaModel
  tamanhos: Array<TamanhoModel>
  tamanho: TamanhoModel
  tipoProdutos: Array<TipoProduto>
  tipoProduto: TipoProduto
  tipoProdutoControl:FormControl

  fornecedores:Array<FornecedorModel>
  fornecedor:FornecedorModel;
  
  idTipoProduto="1";

  ngOnInit() {

    this.tipoProdutoControl = new FormControl('valid', [
      Validators.required,
      Validators.pattern('valid'),
    ]);

    this.cadastraProdutoForm = this.formBuilder.group({
      nome: ['', [Validators.required]],
      valorCompra: ['', [Validators.required, Validators.pattern('^-?[0-9\.]+$')]],
      valorVenda: ['', [Validators.required, Validators.pattern('^-?[0-9\.]+$')]],
      quantidade: ['', [Validators.required, Validators.pattern('^-?[0-9]+$')],]
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
    
    this.fornecedorService.findAll().subscribe(data =>{
      this.fornecedores = data
      this.fornecedor = data[0]
    })


  }

  selectFornecedor(fornecedor){
    this.fornecedores.forEach(data =>{
      if(data.nome === fornecedor)
        this.fornecedor = data
      })
  }
  selectMarca(marca) {
    this.marcas.forEach(data =>{
      if(data.nome === marca)
        this.marca = data
      })
  }
  selectTamanho(tamanho) {
    this.tamanhos.forEach(data =>{
      if(data.id === tamanho)
        this.tamanho = data
      })
  }
  selectTipoProduto(tipo) {
    this.tipoProdutos.forEach(data =>{
      if(data.nome === tipo)
      this.tipoProduto = data
      })
      console.log(this.tipoProduto.id)
    this.service.findByTipoProduto(this.tipoProduto.id).subscribe(data => {
      this.tamanhos = data
      this.tamanho = data[0]
    })
  }

  onSubmit() {
    // Verifica ao enviar se os dados informados são validos
    if (
      this.cadastraProdutoForm.get('nome').valid &&
      this.cadastraProdutoForm.get('valorVenda').valid &&
      this.cadastraProdutoForm.get('quantidade').valid &&
      this.cadastraProdutoForm.get('valorCompra').valid 
    ) {
      let produto = {
        nome: this.cadastraProdutoForm.value.nome,
        preco_atual: this.cadastraProdutoForm.value.valorVenda,
        quantidade_estoque: this.cadastraProdutoForm.value.quantidade,
        marca: this.marca,
        tipo_produto: this.tipoProduto,
        tamanho: this.tamanho,
        status:true
      }

     


      let movimentacao ={
        status:true,
        precoCompra:this.cadastraProdutoForm.value.valorCompra,
        produto:produto,
        fornecedor:this.fornecedor     
      }
      this.service.cadastrarProduto(movimentacao).subscribe(data => {
        if(data == null){
          this.alertService.showSucess("Entrada de produto cadastrada com sucesso")
          this.router.navigateByUrl('home')
        }

      },err =>{
        this.alertService.showAlertDanger(err.error.message)
      }
        )
      // this.service.cadastrarProduto(produto).subscribe(data => {
      //   if (data.id != null) {
      //     this.alertService.showSucess("produto cadastrado com sucesso")
      //     this.router.navigateByUrl('home');
      //   } else {
      //     this.alertService.showAlertDanger("produto ja cadastrado")
      //   }
      // })
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


