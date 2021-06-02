import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FornecedorModel } from 'src/app/shared/model/fornecedor.model';
import { AlertModalService } from 'src/app/shared/services/alert-modal.service';
import { FornecedorService } from './service/fornecedor.service';

@Component({
  selector: 'app-fornecedor',
  templateUrl: './fornecedor.component.html',
  styleUrls: ['./fornecedor.component.css']
})
export class FornecedorComponent implements OnInit {

  constructor(private service:FornecedorService,private router:Router, private formBuilder: FormBuilder,private alertService:AlertModalService) { }

  EditRowId: any = '';
  fornecedorForm: FormGroup;
  fornecedores:Array<FornecedorModel>
  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.fornecedores=data
    })
    this.fornecedorForm = this.formBuilder.group({
      nomeFornecedor: ['', [Validators.required]],
      emailFornecedor: ['', [Validators.required]],
      telefoneFornecedor: ['', [Validators.required, Validators.pattern('^[0-9]')]]
    });
  }

  cadastrarFornecedor(){
    this.router.navigateByUrl('cadastrofornecedor')
  }

  delete(fornecedor:FornecedorModel){
    this.service.removerFornecedor(fornecedor.id).subscribe(data => {
      this.ngOnInit()
    })
    }

  edit(fornecedor:FornecedorModel){
    this.EditRowId = fornecedor.id
  }

  editIncorrect() {
    this.EditRowId = -2
    this.fornecedorForm.get('nomeFornecedor').setValue("");
    this.fornecedorForm.get('precoFornecedor').setValue("");
  }
  editCorrect(fornecedor: FornecedorModel) {
    fornecedor.nome = this.fornecedorForm.get('nomeFornecedor').value
    fornecedor.email = this.fornecedorForm.get('emailFornecedor').value
    fornecedor.telefone = this.fornecedorForm.get('telefoneFornecedor').value

    this.service.updatefornecedor(fornecedor).subscribe(data => {
      this.EditRowId = -2
      this.fornecedorForm.get('nomeFornecedor').setValue("");
      this.fornecedorForm.get('precoFornecedor').setValue("");
      this.alertService.showSucess('Alterado com sucesso');
      this.ngOnInit()
    },err =>{
      this.alertService.showAlertDanger(err.error.message)
    })
  }
}
