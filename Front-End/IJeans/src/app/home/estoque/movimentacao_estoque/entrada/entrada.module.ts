import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { SharedModule } from "src/app/shared/shared.module";
import { EntradaRoutingModule } from "./entrada-routing.module";
import { EntradaComponent } from "./entrada.component";


@NgModule({
    declarations: [
        EntradaComponent,
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        BrowserModule,
        EntradaRoutingModule,
        FormsModule,
        SharedModule
    ],

    providers: []

})

export class EntradaModule{
    
}
