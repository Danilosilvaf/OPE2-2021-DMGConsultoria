import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { SharedModule } from "src/app/shared/shared.module";
import { CadastroMarcaRoutingModule } from "./cadastro-marca-routing.module";
import { CadastrarMarcaComponent } from "./cadastro-marca.component";


@NgModule({
    declarations: [
        CadastrarMarcaComponent,
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        BrowserModule,
        CadastroMarcaRoutingModule,
        FormsModule,
        SharedModule
    ],
    providers: []
})

export class CadastroMarcaModule {

}
