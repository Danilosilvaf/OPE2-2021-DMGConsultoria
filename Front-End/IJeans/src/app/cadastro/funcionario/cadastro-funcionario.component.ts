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
    let regexEmail = 
    this.cadastraFuncionarioForm = this.formBuilder.group( { 
      login : [ '',[Validators.required,Validators.minLength(4)]  ], 
      nome : [ '',[Validators.required,Validators.minLength(4)]  ], 
      senha : [ '' , [Validators.required,Validators.minLength(5)] ],
      resenha : [ '' , [Validators.required,Validators.minLength(5)] ],
      email : [ '' , [Validators.required,Validators.pattern(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/)] ]
          });
  }
  onSubmit(){

    if(
      this.cadastraFuncionarioForm.get('login').valid &&
      this.cadastraFuncionarioForm.get('senha').valid &&
      this.cadastraFuncionarioForm.get('nome').valid &&
      this.cadastraFuncionarioForm.get('resenha').valid &&
      this.cadastraFuncionarioForm.get('email').valid){
        if( this.cadastraFuncionarioForm.value.senha != this.cadastraFuncionarioForm.value.resenha){
          this.isErrorCampo('senha')
          this.isErrorCampo('resenha')
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

      }else{
        alert('Dados incorretos')
      }

    

  }

  voltarHome() {
    this.router.navigateByUrl("home")
  }


  isErrorCampo(nomeCampo){
    return (!this.cadastraFuncionarioForm.get(nomeCampo).valid && this.cadastraFuncionarioForm.get(nomeCampo).touched ); 
  }
 
}
