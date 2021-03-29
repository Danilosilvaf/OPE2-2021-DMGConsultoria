import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { CadastroFuncionarioRoutingModule } from "./cadastro-funcionario-routing.module";
import { CadastrarFuncionarioComponent } from "./cadastro-funcionario.component";


@NgModule({
    declarations: [
        CadastrarFuncionarioComponent,
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        BrowserModule,
        CadastroFuncionarioRoutingModule,
        FormsModule
    ],

    providers: []

})

export class CadastroFuncionarioModule{
    
}
