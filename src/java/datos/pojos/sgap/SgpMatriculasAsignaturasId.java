package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpMatriculasAsignaturasId generated by hbm2java
 */
public class SgpMatriculasAsignaturasId  implements java.io.Serializable {


     private byte id;
     private int curposId;
     private int edicionId;
     private String personaId;
     private int asignaturaId;

    public SgpMatriculasAsignaturasId() {
    }

    public SgpMatriculasAsignaturasId(byte id, int curposId, int edicionId, String personaId, int asignaturaId) {
       this.id = id;
       this.curposId = curposId;
       this.edicionId = edicionId;
       this.personaId = personaId;
       this.asignaturaId = asignaturaId;
    }
   
    public byte getId() {
        return this.id;
    }
    
    public void setId(byte id) {
        this.id = id;
    }
    public int getCurposId() {
        return this.curposId;
    }
    
    public void setCurposId(int curposId) {
        this.curposId = curposId;
    }
    public int getEdicionId() {
        return this.edicionId;
    }
    
    public void setEdicionId(int edicionId) {
        this.edicionId = edicionId;
    }
    public String getPersonaId() {
        return this.personaId;
    }
    
    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }
    public int getAsignaturaId() {
        return this.asignaturaId;
    }
    
    public void setAsignaturaId(int asignaturaId) {
        this.asignaturaId = asignaturaId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpMatriculasAsignaturasId) ) return false;
		 SgpMatriculasAsignaturasId castOther = ( SgpMatriculasAsignaturasId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getCurposId()==castOther.getCurposId())
 && (this.getEdicionId()==castOther.getEdicionId())
 && ( (this.getPersonaId()==castOther.getPersonaId()) || ( this.getPersonaId()!=null && castOther.getPersonaId()!=null && this.getPersonaId().equals(castOther.getPersonaId()) ) )
 && (this.getAsignaturaId()==castOther.getAsignaturaId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getCurposId();
         result = 37 * result + this.getEdicionId();
         result = 37 * result + ( getPersonaId() == null ? 0 : this.getPersonaId().hashCode() );
         result = 37 * result + this.getAsignaturaId();
         return result;
   }   


}


