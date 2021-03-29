import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { FornecedorService } from "src/app/home/fornecedor/service/fornecedor.service";




@Component({
  selector: 'app-cadastrafornecedor',
  templateUrl: './fornecedor-cadastro.component.html',
  styleUrls: ['./fornecedor-cadastro.component.css']
})

export class CadastroFornecedorComponent {
  cadastraFornecedorForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private service: FornecedorService, private router: Router) {
  }

  ngOnInit() {

    this.cadastraFornecedorForm = this.formBuilder.group({
      nome: ['', [Validators.required]],
      telefone: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  onSubmit() {
    let fornecedor = {
      nome: this.cadastraFornecedorForm.value.nome,
      email: this.cadastraFornecedorForm.value.email,
      telefone: this.cadastraFornecedorForm.value.telefone
    }


    this.service.cadastrarFornecedor(fornecedor).subscribe(data => {
        alert('Fornecedor Cadastrado')
        this.router.navigateByUrl('home');
    });

  }

}