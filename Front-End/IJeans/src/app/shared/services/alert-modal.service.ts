import { Injectable } from "@angular/core";
import { BsModalRef, BsModalService } from "ngx-bootstrap/modal";
import { AlertModalComponent } from "../components/alert-modal/alert-modal.component";

@Injectable({
    providedIn: 'root'
})
export class AlertModalService {

    constructor(private modalService:BsModalService){}
    
    showAlertDanger(message: string){
        const bsModalRef:BsModalRef = this.modalService.show(AlertModalComponent)
        bsModalRef.content.type = 'danger';
        bsModalRef.content.message=message;
    }

    showSucess(message: string){
        const bsModalRef:BsModalRef = this.modalService.show(AlertModalComponent)
        bsModalRef.content.type = 'sucess';
        bsModalRef.content.message=message;
    }
}