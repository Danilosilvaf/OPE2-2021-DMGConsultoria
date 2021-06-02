import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { MarcaService } from "src/app/home/marca/service/marca-service";
import { AlertModalService } from "src/app/shared/services/alert-modal.service";

@Component({
  selector: 'app-cadastramarca',
  templateUrl: './cadastro-marca.component.html',
  styleUrls: ['./cadastro-marca.component.css']
})

export class CadastrarMarcaComponent {
  cadastraMarcaForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private service: MarcaService, private router: Router, private alertService: AlertModalService) {
  }

  ngOnInit() {
    this.cadastraMarcaForm = this.formBuilder.group({
      nome: ['', [Validators.required]]
    });
  }

  onSubmit() {
    if (this.cadastraMarcaForm.get('nome').valid) {
      let marca = {
        nome: this.cadastraMarcaForm.value.nome,
        status: true
      }

      this.service.cadastrarMarca(marca).subscribe(data => {
        this.alertService.showSucess('Marca Cadastrada')
        this.router.navigateByUrl('home');
      }, err => {
        this.alertService.showAlertDanger(err.error.message)
      });
    } else {
      this.alertService.showAlertDanger('Dados Incorretos')
    }
  }

  isErrorCampo(nomeCampo) {
    return (!this.cadastraMarcaForm.get(nomeCampo).valid && this.cadastraMarcaForm.get(nomeCampo).touched);
  }

  voltarHome() {
    this.router.navigateByUrl("home")
  }
}
