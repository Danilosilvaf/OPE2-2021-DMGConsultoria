import { Component, OnInit } from '@angular/core';
import { FuncionarioModel } from 'src/app/shared/model/funcionario.model';
import { FuncionarioService } from './service/funcionario.service';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})
export class FuncionarioComponent implements OnInit {

  constructor(private service: FuncionarioService) { }

  funcionarios:Array<FuncionarioModel>;
  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.funcionarios=data
    });
  }

}
