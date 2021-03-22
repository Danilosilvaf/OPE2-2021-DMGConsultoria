import { Component, OnInit } from '@angular/core';
import { FornecedorModel } from 'src/app/shared/model/fornecedor.model';
import { FornecedorService } from './service/fornecedor.service';

@Component({
  selector: 'app-fornecedor',
  templateUrl: './fornecedor.component.html',
  styleUrls: ['./fornecedor.component.css']
})
export class FornecedorComponent implements OnInit {

  constructor(private service:FornecedorService) { }

  fornecedores:Array<FornecedorModel>
  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.fornecedores=data
    })
  }

}
