function setEnv(): void
{
    const fs = require("fs") ;
    const colors = require("colors") ;

    const targetPath: string = "./src/environments/environment.ts";
    require("dotenv").config({
        path: "./src/environments/.env"
    }) ;

    const envConfigFile = `export const environment = {
          apiBaseUrl: '${process.env["API_BASE_URL"]}',
          apiUser: '${process.env["API_USER"]}',
          apiPassword: '${process.env["API_PASSWORD"]}',
          production: true,
        };` ;

    console.log(colors.magenta('The file `environment.ts` will be written with the following content: \n')) ;

    fs.writeFile(targetPath, envConfigFile, (err: unknown): void =>
    {
        if (err)
        {
            console.error(err) ;
            throw err;
        }
        else {
            console.log(colors.magenta(`Angular environment.ts file generated correctly at ${targetPath} \n`)) ;
        }
    }) ;
}

setEnv() ;