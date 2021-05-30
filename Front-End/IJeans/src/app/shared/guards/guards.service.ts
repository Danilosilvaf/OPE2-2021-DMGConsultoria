import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceLoginService } from 'src/app/login/service/service-login.service';

@Injectable({
  providedIn: 'root'
})
export class GuardsService {

  constructor(
    private serviceLogin : ServiceLoginService, 
    private router : Router
    ) { }

  canActivate(){    
    let serviceLogin = this.serviceLogin.isAutenticado();


    if(!serviceLogin){

      //this.dialogService.showError("Acesso não autorizado");
      alert("Acesso não autorizado")
      
      this.router.navigate(['']); 

    }

    return serviceLogin;

  }

  }

