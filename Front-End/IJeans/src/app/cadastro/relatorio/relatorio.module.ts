import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { SharedModule } from "src/app/shared/shared.module";
import { RelatorioRoutingModule } from "./relatorio-routing.module";
import { RelatorioComponent } from "./relatorio.component";


@NgModule({
    declarations: [
        RelatorioComponent,
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        BrowserModule,
        RelatorioRoutingModule,
        FormsModule,
        SharedModule
    ],
    providers: []
})

export class RelatorioModule {

}
