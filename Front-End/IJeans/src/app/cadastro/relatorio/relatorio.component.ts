import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AlertModalService } from "src/app/shared/services/alert-modal.service";
import { RelatorioService } from "./service/RelatorioService.component";


@Component({
    selector: 'app-ralatorio',
    templateUrl: './relatorio.component.html',
    styleUrls: ['./relatorio.component.css']
  })

export class RelatorioComponent{    

    cadastraMarcaForm: FormGroup;

    constructor(private formBuilder: FormBuilder, private service: RelatorioService, private router: Router, private alertService: AlertModalService) {
    }

    ngOnInit() {
        this.cadastraMarcaForm = this.formBuilder.group({
          nome: ['', [Validators.required]]
        });
      }
    
      onSubmit() {
        if (this.cadastraMarcaForm.get('nome').valid) {
          this.service.realizarEnvio(this.cadastraMarcaForm.value.nome).subscribe(data => {
            if(data == null){
              this.alertService.showSucess('Email Enviado')
              this.router.navigateByUrl('home');
            }
          }, err => {
            this.alertService.showAlertDanger(err.error.message)
          });
        } else {
          this.alertService.showAlertDanger('Email Incorreto')
        }
      }
    
      isErrorCampo(nomeCampo) {
        return (!this.cadastraMarcaForm.get(nomeCampo).valid && this.cadastraMarcaForm.get(nomeCampo).touched);
      }
    
      voltarHome() {
        this.router.navigateByUrl("home")
      }

}