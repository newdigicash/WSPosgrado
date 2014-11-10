package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpInstitucionesCursoId generated by hbm2java
 */
public class SgpInstitucionesCursoId  implements java.io.Serializable {


     private int placurId;
     private int curposId;
     private int institucionId;

    public SgpInstitucionesCursoId() {
    }

    public SgpInstitucionesCursoId(int placurId, int curposId, int institucionId) {
       this.placurId = placurId;
       this.curposId = curposId;
       this.institucionId = institucionId;
    }
   
    public int getPlacurId() {
        return this.placurId;
    }
    
    public void setPlacurId(int placurId) {
        this.placurId = placurId;
    }
    public int getCurposId() {
        return this.curposId;
    }
    
    public void setCurposId(int curposId) {
        this.curposId = curposId;
    }
    public int getInstitucionId() {
        return this.institucionId;
    }
    
    public void setInstitucionId(int institucionId) {
        this.institucionId = institucionId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpInstitucionesCursoId) ) return false;
		 SgpInstitucionesCursoId castOther = ( SgpInstitucionesCursoId ) other; 
         
		 return (this.getPlacurId()==castOther.getPlacurId())
 && (this.getCurposId()==castOther.getCurposId())
 && (this.getInstitucionId()==castOther.getInstitucionId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPlacurId();
         result = 37 * result + this.getCurposId();
         result = 37 * result + this.getInstitucionId();
         return result;
   }   


}


