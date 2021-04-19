import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FuncionarioModel } from 'src/app/shared/model/funcionario.model';
import { FuncionarioService } from './service/funcionario.service';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})



export class FuncionarioComponent implements OnInit {

  constructor(private service: FuncionarioService, private router:Router) { }

  
  funcionarios:Array<FuncionarioModel>;

  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.funcionarios=data
    });
  }

  CadastrarFuncionario(){
    this.router.navigateByUrl('cadastrofuncionario')
  }
  delete(funcionario:FuncionarioModel){
    this.service.delete(funcionario).subscribe(data => {
      console.log(data)
    })

  }

  edit(funcionario:FuncionarioModel){
  }
}
