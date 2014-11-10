package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpEvaluacionesEstadosId generated by hbm2java
 */
public class SgpEvaluacionesEstadosId  implements java.io.Serializable {


     private byte id;
     private int forevaId;

    public SgpEvaluacionesEstadosId() {
    }

    public SgpEvaluacionesEstadosId(byte id, int forevaId) {
       this.id = id;
       this.forevaId = forevaId;
    }
   
    public byte getId() {
        return this.id;
    }
    
    public void setId(byte id) {
        this.id = id;
    }
    public int getForevaId() {
        return this.forevaId;
    }
    
    public void setForevaId(int forevaId) {
        this.forevaId = forevaId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpEvaluacionesEstadosId) ) return false;
		 SgpEvaluacionesEstadosId castOther = ( SgpEvaluacionesEstadosId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getForevaId()==castOther.getForevaId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getForevaId();
         return result;
   }   


}

