package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.ClinicalImpression;
import org.hl7.fhir.dstu3.model.CodeType;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Condition;
import org.hl7.fhir.dstu3.model.DiagnosticReport;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.dstu3.model.EpisodeOfCare;
import org.hl7.fhir.dstu3.model.Group;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.Binding;
import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import datatypes.Annotation;
import datatypes.Identifier;

@ResourceDef(name="Condition", 
			 profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Condition-1")
public class CareConnectCondition extends Condition {

	private static final long serialVersionUID = 1L;
	
	@Child(name="episodisity", type={CodeableConcept.class}, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-ConditionEpisode-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="first | new | review | flare | end")
	@Binding(valueSet="https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-ConditionEpisodicity-1")
    private CodeableConcept episodisity;
	
    @Child(name="identifier", type={Identifier.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true
    )
    @Description(
    	shortDefinition="External Ids for this condition", 
    	formalDefinition=
    		"This records identifiers associated with this condition that are defined "+ 
	    	"by business processes and/or used to refer to it when a direct URL reference to the resource " +
	    	"itself is not appropriate (e.g. in CDA documents, or in written / printed documentation)." 
	)
    protected List<Identifier> identifier;
    
    /**
     * The verification status to support the clinical status of the condition.
     * This has been removed from the Care Connect model demonstrated by min=0 and max=0 
     */
    @Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-ver-status")
    @Child(
    	name="verificationStatus", type={CodeType.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=0, modifier=true, summary=true
    )
    @Description(
    	shortDefinition="provisional | differential | confirmed | refuted | entered-in-error | unknown", 
    	formalDefinition="The verification status to support the clinical status of the condition."
    )
    protected Enumeration<ConditionVerificationStatus> verificationStatus;

    /**
     * A category assigned to the condition.
     */
    @Binding(valueSet="https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-ConditionCategory-1")
    @Child(
    	name="category", type={CodeableConcept.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false
    )
    @Description(
    	shortDefinition="problem-list-item | encounter-diagnosis | presenting-complaint", 
    	formalDefinition="A category assigned to the condition." 
    )
    protected List<CodeableConcept> category;
    
    /**
     * Indicates the patient or group who the condition record is associated with.
     */
    @Child(
    	name="subject", type={CareConnectPatient.class, Group.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
    )
    @Description(
    	shortDefinition="Who has the condition?", 
    	formalDefinition="Indicates the patient or group who the condition record is associated with." 
    )
    protected Reference subject;

    /**
     * Encounter during which the condition was first asserted.
     */
    @Child(
    	name="context", type={CareConnectEncounter.class, EpisodeOfCare.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
    )
    @Description(
    	shortDefinition="Encounter or episode when condition first asserted", 
    	formalDefinition="Encounter during which the condition was first asserted." 
    )
    protected Reference context;
    
    /**
     * Individual who is making the condition statement.
     */
    @Child(
    	name="asserter", 
    	type={CareConnectPractitioner.class, CareConnectPatient.class, RelatedPerson.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
    )
    @Description(
    	shortDefinition="Person who asserts this condition", 
    	formalDefinition="Individual who is making the condition statement." 
    )
    protected Reference asserter;
    
    /**
     * Clinical stage or grade of a condition. May include formal severity assessments.
     */
    @Child(name="stage", type={}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
    @Description(
    	shortDefinition="Stage/grade, usually assessed formally", 
    	formalDefinition="Clinical stage or grade of a condition. May include formal severity assessments." 
    )
    protected ConditionStageComponent stage;
    
    /**
     * Additional information about the Condition. This is a general notes/comments entry  for description of the Condition, its diagnosis and prognosis.
     */
    @Child(
    		name="note", type={Annotation.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Additional information about the Condition", 
    	formalDefinition=
    		"Additional information about the Condition. This is a general notes/comments entry " +
    		"for description of the Condition, its diagnosis and prognosis." 
    )
    protected List<Annotation> note;
    
    @Block()
    public static class ConditionStageComponent extends org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent {

		private static final long serialVersionUID = 1L;
		
		/**
         * Reference to a formal record of the evidence on which the staging assessment is based.
         */
        @Child(
        	name="assessment", 
        	type={ClinicalImpression.class, DiagnosticReport.class, Observation.class}, // TODO use CareConnectObservation
        	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(
        	shortDefinition="Formal record of assessment", 
        	formalDefinition="Reference to a formal record of the evidence on which the staging assessment is based." 
        )
        protected List<Reference> assessment;
        
    }
}
