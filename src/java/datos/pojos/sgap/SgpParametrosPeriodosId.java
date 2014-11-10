package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpParametrosPeriodosId generated by hbm2java
 */
public class SgpParametrosPeriodosId  implements java.io.Serializable {


     private int perlecId;
     private int parametroId;

    public SgpParametrosPeriodosId() {
    }

    public SgpParametrosPeriodosId(int perlecId, int parametroId) {
       this.perlecId = perlecId;
       this.parametroId = parametroId;
    }
   
    public int getPerlecId() {
        return this.perlecId;
    }
    
    public void setPerlecId(int perlecId) {
        this.perlecId = perlecId;
    }
    public int getParametroId() {
        return this.parametroId;
    }
    
    public void setParametroId(int parametroId) {
        this.parametroId = parametroId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpParametrosPeriodosId) ) return false;
		 SgpParametrosPeriodosId castOther = ( SgpParametrosPeriodosId ) other; 
         
		 return (this.getPerlecId()==castOther.getPerlecId())
 && (this.getParametroId()==castOther.getParametroId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPerlecId();
         result = 37 * result + this.getParametroId();
         return result;
   }   


}

