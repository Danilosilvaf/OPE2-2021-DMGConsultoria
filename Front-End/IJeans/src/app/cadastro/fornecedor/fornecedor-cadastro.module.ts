import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { CadastroFornecedorRoutingModule } from "./fornecedor-cadastro-routing.module";
import { CadastroFornecedorComponent } from "./fornecedor-cadastro.component";

@NgModule({
    declarations: [
        CadastroFornecedorComponent,
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        BrowserModule,
        CadastroFornecedorRoutingModule,
        FormsModule
    ],

    providers: []

})

export class CadastroFornecedorModule{
    
}
