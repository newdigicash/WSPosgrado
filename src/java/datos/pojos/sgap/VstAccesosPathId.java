package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA


/**
 * VstAccesosPath generated by hbm2java
 */
public class VstAccesosPathId  implements java.io.Serializable {
     
    private String personaId;    
    private Integer dependenciaId;    
    private Integer curposId;
       
    public VstAccesosPathId() {
    }

    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public Integer getDependenciaId() {
        return dependenciaId;
    }

    public void setDependenciaId(Integer dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    public Integer getCurposId() {
        return curposId;
    }

    public void setCurposId(Integer curposId) {
        this.curposId = curposId;
    }
    
    public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VstAccesosPathId) ) return false;
		 VstAccesosPathId castOther = ( VstAccesosPathId ) other; 
         
		 return (this.getPersonaId().equals(castOther.getPersonaId())) 
                         && (this.getCurposId()==castOther.getCurposId())
                         && (this.getDependenciaId()==castOther.getDependenciaId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPersonaId() == null ? 0 : this.getPersonaId().hashCode() );
         result = 37 * result + this.getDependenciaId();
         result = 37 * result + this.getCurposId();
         return result;
   }   
}


