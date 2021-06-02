import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProdutoModel } from 'src/app/shared/model/produto.model';
import { AlertModalService } from 'src/app/shared/services/alert-modal.service';
import { ProdutoService } from './service/service-produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

  EditRowId: any = '';
  produtoForm: FormGroup;
  constructor(private service: ProdutoService, private router: Router, private formBuilder: FormBuilder,private alertService:AlertModalService) { }
  produtos: Array<ProdutoModel>;

  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.produtos = data
    });

    this.produtoForm = this.formBuilder.group({
      nomeProduto: ['', [Validators.required]],
      precoProduto: ['', [Validators.required, Validators.pattern('^[0-9]')]]

    });

  }

  cadastrarProduto() {
    this.router.navigateByUrl('cadastroproduto')
  }
  delete(produto: ProdutoModel) {
    this.service.removeProduto(produto.id).subscribe(data => {
      this.ngOnInit()
    })
  }

  editIncorrect() {
    this.EditRowId = -2
    this.produtoForm.get('nomeProduto').setValue("");
    this.produtoForm.get('precoProduto').setValue("");
  }
  editCorrect(produto: ProdutoModel) {
    produto.nome = this.produtoForm.get('nomeProduto').value
    produto.preco_atual = this.produtoForm.get('precoProduto').value
    this.service.updateProduto(produto).subscribe(data => {
      this.EditRowId = -2
      this.produtoForm.get('nomeProduto').setValue("");
      this.produtoForm.get('precoProduto').setValue("");
      this.alertService.showSucess('Alterado com sucesso')
      this.ngOnInit()
    },err =>{
      this.alertService.showAlertDanger(err.error.message)
    })
  }
  edit(produto: ProdutoModel) {
    this.EditRowId = produto.id
    
  }

}
