import { Component } from "@angular/core";
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls:['./login.component.css']
})

export class LoginComponent{

  constructor(private http: HttpClient){}

  private url : string = "http://localhost:8080/login";

  private teste = {
    "login":"a",
    "senha":"aasd"
}
  
  login(){
    this.http.post(this.url,this.teste).subscribe(resultado => {
      console.log(resultado)
    })
  }

 
  
  }




