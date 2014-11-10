package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpRegistrosAportesId generated by hbm2java
 */
public class SgpRegistrosAportesId  implements java.io.Serializable {


     private int regcabId;
     private int forevaId;
     private byte posColumnaNota;

    public SgpRegistrosAportesId() {
    }

    public SgpRegistrosAportesId(int regcabId, int forevaId, byte posColumnaNota) {
       this.regcabId = regcabId;
       this.forevaId = forevaId;
       this.posColumnaNota = posColumnaNota;
    }
   
    public int getRegcabId() {
        return this.regcabId;
    }
    
    public void setRegcabId(int regcabId) {
        this.regcabId = regcabId;
    }
    public int getForevaId() {
        return this.forevaId;
    }
    
    public void setForevaId(int forevaId) {
        this.forevaId = forevaId;
    }
    public byte getPosColumnaNota() {
        return this.posColumnaNota;
    }
    
    public void setPosColumnaNota(byte posColumnaNota) {
        this.posColumnaNota = posColumnaNota;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpRegistrosAportesId) ) return false;
		 SgpRegistrosAportesId castOther = ( SgpRegistrosAportesId ) other; 
         
		 return (this.getRegcabId()==castOther.getRegcabId())
 && (this.getForevaId()==castOther.getForevaId())
 && (this.getPosColumnaNota()==castOther.getPosColumnaNota());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getRegcabId();
         result = 37 * result + this.getForevaId();
         result = 37 * result + this.getPosColumnaNota();
         return result;
   }   


}

