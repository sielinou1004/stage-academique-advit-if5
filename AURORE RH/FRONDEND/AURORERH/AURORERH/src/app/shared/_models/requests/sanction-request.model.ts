export class SanctionRequestModel{
constructor(
  public  id: number,

  public  nom: string,

  public  type_sanction: string,

  public  debut_sanction: Date,

  public  fin_sanction: Date,

  public  description: string,

  public  id_Employer: number,

){}

}
