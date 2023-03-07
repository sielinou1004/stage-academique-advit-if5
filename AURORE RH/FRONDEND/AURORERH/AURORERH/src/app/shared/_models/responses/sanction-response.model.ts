import { EmployerReponseModel } from "./employer-response.model";

export class SanctionResponseModel{
  constructor(
    public id: number,

    public nom: string,

    public  type_sanction: string,

    public  debut_sanction: Date,

    public  fin_sanction: Date,

    public  description: string,

    public  employerResponseDTO: EmployerReponseModel,

  ){}
  }
