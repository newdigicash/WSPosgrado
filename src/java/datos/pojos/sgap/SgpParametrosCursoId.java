package datos.pojos.sgap;
// Generated 23/04/2012 09:23:45 AM by Hibernate Tools 3.2.1.GA

public class SgpParametrosCursoId implements java.io.Serializable {

    private int id;
    private int curposId;
    private int edicionId;
    private int perlecId;
    private int paramteroId;

    public SgpParametrosCursoId() {
    }

    public SgpParametrosCursoId(int id, int curposId, int edicionId, int perlecId, int paramteroId) {
        this.id = id;
        this.curposId = curposId;
        this.edicionId = edicionId;
        this.perlecId = perlecId;
        this.paramteroId = paramteroId;
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

    public int getEdicionId() {
        return this.edicionId;
    }

    public void setEdicionId(int edicionId) {
        this.edicionId = edicionId;
    }

    public int getPerlecId() {
        return this.perlecId;
    }

    public void setPerlecId(int perlecId) {
        this.perlecId = perlecId;
    }

    public int getParamteroId() {
        return this.paramteroId;
    }

    public void setParamteroId(int paramteroId) {
        this.paramteroId = paramteroId;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof SgpParametrosCursoId)) {
            return false;
        }
        SgpParametrosCursoId castOther = (SgpParametrosCursoId) other;

        return (this.getId() == castOther.getId())
                && (this.getCurposId() == castOther.getCurposId())
                && (this.getEdicionId() == castOther.getEdicionId())
                && (this.getPerlecId() == castOther.getPerlecId())
                && (this.getParamteroId() == castOther.getParamteroId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getId();
        result = 37 * result + this.getCurposId();
        result = 37 * result + this.getEdicionId();
        result = 37 * result + this.getPerlecId();
        result = 37 * result + this.getParamteroId();
        return result;
    }
}
