import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { LocalUserModel } from "../shared/model/local-user.model";
import { StorageService } from "../shared/services/storage.service";
import { ServiceLoginService } from "./service/service-login.service";



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls:['./login.component.css']
})

export class LoginComponent{
 
  loginForm : FormGroup;
  usuario : LocalUserModel;

  constructor(private formBuilder :  FormBuilder,
    private localStorage:StorageService,
    private serviceLogin:ServiceLoginService
    ) {

   }

  
  ngOnInit() {
    this.localStorage.setLocalUser(null);
// declaração das variaveis para a validação dos campos login e senha 
    this.loginForm = this.formBuilder.group( { 
      login : [ '',[Validators.required]  ], 
      senha : [ '' , [Validators.required] ] 
    });
  }
  onSubmit(){
    

    //Verifica ao enviar se os dados informados são validos
    let login = {login : this.loginForm.value.login, senha : this.loginForm.value.senha};
    
    return this.serviceLogin.fazerLogin(login);
  }

  //campo para validar se os campos forem devidamente preenchidos para habilitação do botão
 isErrorCampo(nomeCampo){
    return (!this.loginForm.get(nomeCampo).valid && this.loginForm.get(nomeCampo).touched ); 
  }
  //metodo para verificar se os dados de Autenticidade estão de acordo, recebe um boolean
  isErrorLogin(){
    return this.serviceLogin.isAutenticado();
          
  }

}


