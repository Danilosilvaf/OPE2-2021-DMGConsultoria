import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceLoginService } from 'src/app/login/service/service-login.service';
import { AlertModalService } from '../services/alert-modal.service';

@Injectable({
  providedIn: 'root'
})
export class GuardsService {

  constructor(
    private serviceLogin : ServiceLoginService, 
    private router : Router,
    private alertService: AlertModalService
    ) { }

  canActivate(){    
    let serviceLogin = this.serviceLogin.isAutenticado();


    if(!serviceLogin){

      this.alertService.showAlertDanger('Acesso não permitido, Por favor efetuar o login')
      
      this.router.navigate(['']); 

    }

    return serviceLogin;

  }

  }

