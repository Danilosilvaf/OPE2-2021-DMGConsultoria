import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FornecedorModel } from 'src/app/shared/model/fornecedor.model';
import { FornecedorService } from './service/fornecedor.service';

@Component({
  selector: 'app-fornecedor',
  templateUrl: './fornecedor.component.html',
  styleUrls: ['./fornecedor.component.css']
})
export class FornecedorComponent implements OnInit {

  constructor(private service:FornecedorService,private router:Router) { }

  fornecedores:Array<FornecedorModel>
  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.fornecedores=data
    })
  }

  cadastrarFornecedor(){
    this.router.navigateByUrl('cadastrofornecedor')
  }

  delete(fornecedor:FornecedorModel){
    console.log(fornecedor)
  }

  edit(fornecedor:FornecedorModel){
    console.log(fornecedor)
  }
}
