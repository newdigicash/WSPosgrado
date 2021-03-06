package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpTrabajoPersonasId generated by hbm2java
 */
public class SgpTrabajoPersonasId  implements java.io.Serializable {


     private int tratitId;
     private int curposId;
     private String personaId;

    public SgpTrabajoPersonasId() {
    }

    public SgpTrabajoPersonasId(int tratitId, int curposId, String personaId) {
       this.tratitId = tratitId;
       this.curposId = curposId;
       this.personaId = personaId;
    }
   
    public int getTratitId() {
        return this.tratitId;
    }
    
    public void setTratitId(int tratitId) {
        this.tratitId = tratitId;
    }
    public int getCurposId() {
        return this.curposId;
    }
    
    public void setCurposId(int curposId) {
        this.curposId = curposId;
    }
    public String getPersonaId() {
        return this.personaId;
    }
    
    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpTrabajoPersonasId) ) return false;
		 SgpTrabajoPersonasId castOther = ( SgpTrabajoPersonasId ) other; 
         
		 return (this.getTratitId()==castOther.getTratitId())
 && (this.getCurposId()==castOther.getCurposId())
 && ( (this.getPersonaId()==castOther.getPersonaId()) || ( this.getPersonaId()!=null && castOther.getPersonaId()!=null && this.getPersonaId().equals(castOther.getPersonaId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getTratitId();
         result = 37 * result + this.getCurposId();
         result = 37 * result + ( getPersonaId() == null ? 0 : this.getPersonaId().hashCode() );
         return result;
   }   


}


