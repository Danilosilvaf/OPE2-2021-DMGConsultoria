import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { FuncionarioService } from "src/app/home/funcionario/service/funcionario.service";


@Component({
    selector: 'app-cadastrafuncionario',
    templateUrl: './cadastro-funcionario.component.html',
    styleUrls: ['./cadastro-funcionario.component.css']
  })


export class CadastrarFuncionarioComponent{
    
  cadastraFuncionarioForm : FormGroup;

  constructor(private formBuilder :  FormBuilder, private service: FuncionarioService,private router: Router){}
  ngOnInit() {
    
    this.cadastraFuncionarioForm = this.formBuilder.group( { 
      login : [ '',[Validators.required]  ], 
      nome : [ '',[Validators.required]  ], 
      senha : [ '' , [Validators.required] ],
      resenha : [ '' , [Validators.required] ],
      email : [ '' , [Validators.required,Validators.email] ]
          });
  }
  onSubmit(){

    if( this.cadastraFuncionarioForm.value.senha != this.cadastraFuncionarioForm.value.resenha){
      alert("senhas devem ser iguais");
    }else{
      let funcionario = {
          login: this.cadastraFuncionarioForm.value.login ,
          senha: this.cadastraFuncionarioForm.value.senha,
          nome: this.cadastraFuncionarioForm.value.nome,
          email: this.cadastraFuncionarioForm.value.email
      }
      this.service.cadastraFuncionario(funcionario).subscribe(data =>{
        if(data.id != null  ){
          alert('funcionario cadastrada com sucesso')
          this.router.navigateByUrl('home');
        }else{
          alert("funcionario ja cadastrado")
        }
      })
    }

  }
}