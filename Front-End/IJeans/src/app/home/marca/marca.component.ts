import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
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

    EditRowId: any = '';
marcaForm: FormGroup;
  
    constructor(private service: MarcaService,private router:Router,private formBuilder: FormBuilder) { }
    
    ngOnInit(): void {
        this.service.findAll().subscribe(data => {
          this.marcas=data;
        })


        this.marcaForm = this.formBuilder.group({
          nomeMarca: ['', [Validators.required]]
        });
    }

    CadastrarMarca(){

    }
    delete(marca:MarcaModel){
      this.service.delete(marca.id).subscribe(data => {
        this.ngOnInit();
      })
  
    }
  
    editIncorrect() {
      this.EditRowId = -2
      this.marcaForm.get('nomeMarca').setValue("");
      
    }
  
    editCorrect(marca: MarcaModel) {
      marca.nome = this.marcaForm.get('nomeMarca').value
      
      this.service.alterar(marca).subscribe(data => {
        this.EditRowId = -2
        this.marcaForm.get('nomeMarca').setValue("");
        
        
      })
    }
  
    edit(marca:MarcaModel){
      this.EditRowId = marca.id
    }

}

