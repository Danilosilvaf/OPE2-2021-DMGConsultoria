import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { MarcaModel } from "src/app/shared/model/marca.model";
import { MarcaService } from "./service/marca-service";

@Component({
    selector: 'app-marca',
    templateUrl: './marca.component.html',
    styleUrls: ['./marca.component.css']
  })
  
  
  
  export class MarcaComponent implements OnInit {

    marcas:Array<MarcaModel>
  
    constructor(private service: MarcaService,private router:Router) { }
    
    ngOnInit(): void {
        this.service.findAll().subscribe(data => {
          this.marcas=data;
          console.log(data)
        })
    }

    CadastrarMarca(){

    }

}

