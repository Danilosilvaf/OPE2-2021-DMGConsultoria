
import { Injectable, Output, Input, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { EnvService } from 'src/app/env.service';
import { StorageService } from 'src/app/shared/services/storage.service';
import { LocalUserModel } from 'src/app/shared/model/local-user.model';
import { AlertModalService } from 'src/app/shared/services/alert-modal.service';



@Injectable({
  providedIn: 'root'
})
export class ServiceLoginService {
  private isAuth: boolean;
  private isAdministrador: boolean;


  isMostrarMenu: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor(private router: Router,
    private http: HttpClient,
    private alertService:AlertModalService,
    private envService: EnvService,
    private storageService: StorageService
    
  ) {
    this.isMostrarMenu.emit(false);
  }
  //verifica os campos email e senha na API e retorna se true ou false

  fazerLogin(login: { login: string, senha: string }) {


     this.http.post<LocalUserModel>(`${this.envService.urlAPI}/autenticacao`, login).subscribe(
      (data) => {
        if(data.login != null){
          this.router.navigateByUrl("/home");
          this.storageService.setLocalUser(login)
          console.log(this.storageService.getLocalUser())
        }else{
          // alert("Erro")
          this.alertService.showAlertDanger("Erro")
        }
      }
    );
  }

  isAutenticado() {

    let localUser: LocalUserModel = this.storageService.getLocalUser();
    console.log(localUser)
    if (localUser == null) {
      this.isAuth = false;
    } else  {
      this.isAuth = true;
    }
    //console.log(localUser);

    return this.isAuth;
  }


  logout() {
    this.storageService.setLocalUser(null);
    this.isAuth = false;
    return this.isAuth;
  }

  /** pegar um novo token válido com data de expiração válida  */
  
  isAdmin() {
    return false
  }
}