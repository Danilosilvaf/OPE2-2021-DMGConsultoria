import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FuncionarioModel } from 'src/app/shared/model/funcionario.model';
import { AlertModalService } from 'src/app/shared/services/alert-modal.service';
import { StorageService } from 'src/app/shared/services/storage.service';
import { FuncionarioService } from './service/funcionario.service';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})



export class FuncionarioComponent implements OnInit {

EditRowId: any = '';
funcionarioForm: FormGroup;

  constructor(private service: FuncionarioService, private router:Router,private formBuilder: FormBuilder,private alertService:AlertModalService,private localStorage:StorageService) { }

  
  funcionarios:Array<FuncionarioModel>;
  funcionariosAtuais:Array<FuncionarioModel>;

  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.funcionarios=data
      this.funcionariosAtuais=data
    });

    this.funcionarioForm = this.formBuilder.group({
      nomeFuncionario: ['', [Validators.required]],
      loginFuncionario: ['', [Validators.required]],
      emailFuncionario:['',[Validators.required]]

    });

  }

  CadastrarFuncionario(){
    this.router.navigateByUrl('cadastrofuncionario')
  }
  delete(funcionario:FuncionarioModel){

    if(this.localStorage.getLocalUser().login == "admin"){
      this.service.delete(funcionario).subscribe(data => {
        this.ngOnInit();
      })
    }else{
      this.alertService.showAlertDanger("Usuário sem permissão.")
    }

  }

  editIncorrect() {
    this.EditRowId = -2
    this.funcionarioForm.get('nomeFuncionario').setValue("");
    this.funcionarioForm.get('loginFuncionario').setValue("");
    this.funcionarioForm.get('emailFuncionario').setValue("");
  }

  editCorrect(funcionario: FuncionarioModel) {
    
    funcionario.nome = this.funcionarioForm.get('nomeFuncionario').value
    funcionario.login = this.funcionarioForm.get('loginFuncionario').value
    funcionario.email = this.funcionarioForm.get('emailFuncionario').value

    this.service.alteraFuncionario(funcionario).subscribe(data => {
      console.log(data)
      this.EditRowId = -2
      this.funcionarioForm.get('nomeFuncionario').setValue("");
      this.funcionarioForm.get('loginFuncionario').setValue("");
      this.funcionarioForm.get('emailFuncionario').setValue("");
      this.alertService.showSucess('Alterado com sucesso')
      this.ngOnInit()
    },err =>{
      this.alertService.showAlertDanger(err.error.message)
    })
  }

  edit(funcionario:FuncionarioModel){
    if(this.localStorage.getLocalUser().login == "admin"){
    this.EditRowId = funcionario.id
    }else{
      this.alertService.showAlertDanger("Usuário sem permissão.")
    }
  }

  buscarFuncionario(nome) {
    if (nome === "") {
      this.funcionariosAtuais = this.funcionarios
    }
    else {
      this.service.findByNome(nome).subscribe(data => {
        this.funcionariosAtuais = data
      })
    }
  }
}
