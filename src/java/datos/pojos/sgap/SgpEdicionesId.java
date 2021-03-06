package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpEdicionesId generated by hbm2java
 */
public class SgpEdicionesId  implements java.io.Serializable {


     private int id;
     private int curposId;

    public SgpEdicionesId() {
    }

    public SgpEdicionesId(int id, int curposId) {
       this.id = id;
       this.curposId = curposId;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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
		 if ( !(other instanceof SgpEdicionesId) ) return false;
		 SgpEdicionesId castOther = ( SgpEdicionesId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getCurposId()==castOther.getCurposId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getCurposId();
         return result;
   }   


}


