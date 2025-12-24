import { ApplicationConfig, provideBrowserGlobalErrorListeners, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import {CacheMode, provideNgxHateoasClient} from "@lagoshny/ngx-hateoas-client";

import { routes } from './app.routes';
import {provideProtractorTestingSupport} from "@angular/platform-browser";
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {HousingLocationResource} from "./housing-location";

export const appConfig: ApplicationConfig = {
  providers: [
    provideProtractorTestingSupport(),
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(
        withInterceptors([basicAuthInterceptor])
    ),
    provideNgxHateoasClient({
      useTypes: {
        resources: [HousingLocationResource]
      },
      http: {
        rootUrl: "http://localhost:8080/"
      },
      cache: {
        enabled: true,
        mode: CacheMode.ALWAYS,
        lifeTime: 3600 * 1000
      }
    })
  ]
};
