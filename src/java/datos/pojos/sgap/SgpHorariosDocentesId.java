package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA



/**
 * SgpHorariosDocentesId generated by hbm2java
 */
public class SgpHorariosDocentesId  implements java.io.Serializable {


     private int id;
     private int horofeId;
     private int curposId;
     private int edicionId;
     private int asignaturaId;
     private int grupo;

    public SgpHorariosDocentesId() {
    }

    public SgpHorariosDocentesId(int id, int horofeId, int curposId, int edicionId, int asignaturaId, int grupo) {
       this.id = id;
       this.horofeId = horofeId;
       this.curposId = curposId;
       this.edicionId = edicionId;
       this.asignaturaId = asignaturaId;
       this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
   
    public int getHorofeId() {
        return this.horofeId;
    }
    
    public void setHorofeId(int horofeId) {
        this.horofeId = horofeId;
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
    public int getAsignaturaId() {
        return this.asignaturaId;
    }
    
    public void setAsignaturaId(int asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SgpHorariosDocentesId) ) return false;
		 SgpHorariosDocentesId castOther = ( SgpHorariosDocentesId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getHorofeId()==castOther.getHorofeId())
 && (this.getCurposId()==castOther.getCurposId())
 && (this.getEdicionId()==castOther.getEdicionId())
 && (this.getAsignaturaId()==castOther.getAsignaturaId())
 && (this.getGrupo()==castOther.getGrupo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getHorofeId();
         result = 37 * result + this.getCurposId();
         result = 37 * result + this.getEdicionId();
         result = 37 * result + this.getAsignaturaId();
         result = 37 * result + this.getGrupo();
         return result;
   }   


}

