
package eu.erasmuswithoutpaper.mobility.entity;

import eu.erasmuswithoutpaper.iia.entity.MobilityType;
import eu.erasmuswithoutpaper.internal.StandardDateConverter;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.johnzon.mapper.JohnzonConverter;

@Entity
@NamedQueries({
    @NamedQuery(name = Mobility.findAll, query = "SELECT m FROM Mobility m"),
})
public class Mobility implements Serializable {

    private static final String PREFIX = "eu.erasmuswithoutpaper.mobility.entity.Mobility.";
    public static final String findAll = PREFIX + "all";
    
    @Id
    @GeneratedValue(generator="system-uuid")
    String id;
    
    private int mobilityRevision;
    private String iiaId;
    private String cooperationConditionId;
    private String sendingInstitutionId;
    private String sendingOrganizationUnitId;
    private String receivingInstitutionId;
    private String receivingOrganizationUnitId;
    private String personId;
    
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "mobility_type_id", referencedColumnName = "id")
    private MobilityType mobilityType;
    
    private MobilityStatus status;
    
    @JohnzonConverter(StandardDateConverter.class)
    @Temporal(TemporalType.DATE)
    private Date plannedArrivalDate;
    
    @JohnzonConverter(StandardDateConverter.class)
    @Temporal(TemporalType.DATE)
    private Date plannedDepartureDate;
    
    private String iscedCode;
    private int eqfLevel;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "learning_agreement")
    private LearningAgreement learningAgreement;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMobilityRevision() {
        return mobilityRevision;
    }

    public void setMobilityRevision(int mobilityRevision) {
        this.mobilityRevision = mobilityRevision;
    }

    public String getIiaId() {
        return iiaId;
    }

    public void setIiaId(String iiaId) {
        this.iiaId = iiaId;
    }

    public String getCooperationConditionId() {
        return cooperationConditionId;
    }

    public void setCooperationConditionId(String cooperationConditionId) {
        this.cooperationConditionId = cooperationConditionId;
    }
    
    public String getSendingInstitutionId() {
        return sendingInstitutionId;
    }

    public void setSendingInstitutionId(String sendingInstitutionId) {
        this.sendingInstitutionId = sendingInstitutionId;
    }

    public String getReceivingInstitutionId() {
        return receivingInstitutionId;
    }

    public void setReceivingInstitutionId(String receivingInstitutionId) {
        this.receivingInstitutionId = receivingInstitutionId;
    }

    public String getSendingOrganizationUnitId() {
        return sendingOrganizationUnitId;
    }

    public void setSendingOrganizationUnitId(String sendingOrganizationUnitId) {
        this.sendingOrganizationUnitId = sendingOrganizationUnitId;
    }

    public String getReceivingOrganizationUnitId() {
        return receivingOrganizationUnitId;
    }

    public void setReceivingOrganizationUnitId(String receivingOrganizationUnitId) {
        this.receivingOrganizationUnitId = receivingOrganizationUnitId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public MobilityType getMobilityType() {
        return mobilityType;
    }

    public void setMobilityType(MobilityType mobilityType) {
        this.mobilityType = mobilityType;
    }

    public MobilityStatus getStatus() {
        return status;
    }

    public void setStatus(MobilityStatus status) {
        this.status = status;
    }

    public Date getPlannedArrivalDate() {
        return plannedArrivalDate;
    }

    public void setPlannedArrivalDate(Date plannedArrivalDate) {
        this.plannedArrivalDate = plannedArrivalDate;
    }

    public Date getPlannedDepartureDate() {
        return plannedDepartureDate;
    }

    public void setPlannedDepartureDate(Date plannedDepartureDate) {
        this.plannedDepartureDate = plannedDepartureDate;
    }

    public String getIscedCode() {
        return iscedCode;
    }

    public void setIscedCode(String iscedCode) {
        this.iscedCode = iscedCode;
    }

    public int getEqfLevel() {
        return eqfLevel;
    }

    public void setEqfLevel(int eqfLevel) {
        this.eqfLevel = eqfLevel;
    }

    public LearningAgreement getLearningAgreement() {
        return learningAgreement;
    }

    public void setLearningAgreement(LearningAgreement learningAgreement) {
        this.learningAgreement = learningAgreement;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mobility other = (Mobility) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
