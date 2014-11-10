package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpAsignaturasMallasId generated by hbm2java
 */
public class SgpAsignaturasMallasId  implements java.io.Serializable {


     private int mallaId;
     private int placurId;
     private int curposId;
     private int asignaturaId;

    public SgpAsignaturasMallasId() {
    }

    public SgpAsignaturasMallasId(int mallaId, int placurId, int curposId, int asignaturaId) {
       this.mallaId = mallaId;
       this.placurId = placurId;
       this.curposId = curposId;
       this.asignaturaId = asignaturaId;
    }
   
    public int getMallaId() {
        return this.mallaId;
    }
    
    public void setMallaId(int mallaId) {
        this.mallaId = mallaId;
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
    public int getAsignaturaId() {
        return this.asignaturaId;
    }
    
    public void setAsignaturaId(int asignaturaId) {
        this.asignaturaId = asignaturaId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpAsignaturasMallasId) ) return false;
		 SgpAsignaturasMallasId castOther = ( SgpAsignaturasMallasId ) other; 
         
		 return (this.getMallaId()==castOther.getMallaId())
 && (this.getPlacurId()==castOther.getPlacurId())
 && (this.getCurposId()==castOther.getCurposId())
 && (this.getAsignaturaId()==castOther.getAsignaturaId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMallaId();
         result = 37 * result + this.getPlacurId();
         result = 37 * result + this.getCurposId();
         result = 37 * result + this.getAsignaturaId();
         return result;
   }   


}

