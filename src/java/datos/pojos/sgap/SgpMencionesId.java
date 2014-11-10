package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpMencionesId generated by hbm2java
 */
public class SgpMencionesId  implements java.io.Serializable {


     private int id;
     private int mallaId;
     private int placurId;
     private int curposId;

    public SgpMencionesId() {
    }

    public SgpMencionesId(int id, int mallaId, int placurId, int curposId) {
       this.id = id;
       this.mallaId = mallaId;
       this.placurId = placurId;
       this.curposId = curposId;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpMencionesId) ) return false;
		 SgpMencionesId castOther = ( SgpMencionesId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getMallaId()==castOther.getMallaId())
 && (this.getPlacurId()==castOther.getPlacurId())
 && (this.getCurposId()==castOther.getCurposId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getMallaId();
         result = 37 * result + this.getPlacurId();
         result = 37 * result + this.getCurposId();
         return result;
   }   


}


