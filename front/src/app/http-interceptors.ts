import {HttpRequest, HttpHandlerFn} from "@angular/common/http";
import {environment} from "../environments/environment";

export function basicAuthInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn) {
    const newRequest = req.clone({
        headers: req.headers.append("Authorization", `Basic ${btoa( `${environment.apiUser}:${environment.apiPassword}`)}`)
    }) ;

    return next(newRequest) ;
}