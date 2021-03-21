import { Component, OnInit } from '@angular/core';
import { ProdutoModel } from 'src/app/shared/model/produto.model';
import { ProdutoService } from './service/service-produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

  constructor(private service:ProdutoService) { }
  produtos:Array<ProdutoModel>;
  ngOnInit(): void {
    
     this.service.findAll().subscribe(data => {
      this.produtos = data
    });
  }

}
