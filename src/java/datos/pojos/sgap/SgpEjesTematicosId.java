package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpEjesTematicosId generated by hbm2java
 */
public class SgpEjesTematicosId  implements java.io.Serializable {


     private int id;
     private int placurId;
     private int curposId;

    public SgpEjesTematicosId() {
    }

    public SgpEjesTematicosId(int id, int placurId, int curposId) {
       this.id = id;
       this.placurId = placurId;
       this.curposId = curposId;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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
		 if ( !(other instanceof SgpEjesTematicosId) ) return false;
		 SgpEjesTematicosId castOther = ( SgpEjesTematicosId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getPlacurId()==castOther.getPlacurId())
 && (this.getCurposId()==castOther.getCurposId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getPlacurId();
         result = 37 * result + this.getCurposId();
         return result;
   }   


}


