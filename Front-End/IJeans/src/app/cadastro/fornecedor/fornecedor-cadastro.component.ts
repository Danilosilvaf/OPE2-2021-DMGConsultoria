import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { FornecedorService } from "src/app/home/fornecedor/service/fornecedor.service";
import { AlertModalService } from "src/app/shared/services/alert-modal.service";




@Component({
  selector: 'app-cadastrafornecedor',
  templateUrl: './fornecedor-cadastro.component.html',
  styleUrls: ['./fornecedor-cadastro.component.css']
})

export class CadastroFornecedorComponent {
  cadastraFornecedorForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private service: FornecedorService, private router: Router,private alertService:AlertModalService) {
  }

  ngOnInit() {

    this.cadastraFornecedorForm = this.formBuilder.group({
      nome: ['', [Validators.required]],
      telefone: ['', [Validators.required]],
      email: ['', [Validators.required,Validators.pattern(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/)] ]
    });
  }

  onSubmit() {

    if(this.cadastraFornecedorForm.get('nome').valid && this.cadastraFornecedorForm.get('email').valid  && this.cadastraFornecedorForm.get('telefone').valid ){
      let fornecedor = {
        nome: this.cadastraFornecedorForm.value.nome,
        email: this.cadastraFornecedorForm.value.email,
        telefone: this.cadastraFornecedorForm.value.telefone,
        status:true
      }
      
  
      this.service.cadastrarFornecedor(fornecedor).subscribe(data => {
          this.alertService.showSucess('Fornecedor Cadastrado')
          this.router.navigateByUrl('home');
      },err =>{
        this.alertService.showAlertDanger(err.error.message)
      });
    }else{
      this.alertService.showAlertDanger('Dados Incorretos')
    }

   

  }
  isErrorCampo(nomeCampo){
    return (!this.cadastraFornecedorForm.get(nomeCampo).valid && this.cadastraFornecedorForm.get(nomeCampo).touched ); 
  }

  voltarHome() {
    this.router.navigateByUrl("home")
  }
  
}