package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Device;
import org.hl7.fhir.dstu3.model.Group;
import org.hl7.fhir.dstu3.model.Medication;
import org.hl7.fhir.dstu3.model.MedicationAdministration;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Procedure;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.RelatedPerson;
import org.hl7.fhir.dstu3.model.Substance;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import datatypes.Annotation;
import datatypes.Identifier;

public class CareConnectProcedure extends Procedure {

	private static final long serialVersionUID = 1L;

	@Child(
		name="anaestheticIssues", type={CodeableConcept.class, Reference.class}, 
		order=3, min=0, max=1, modifier=false, summary=true
	)
    @Description(shortDefinition="Anaesthetic issues")
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-AnaestheticIssues-1", definedLocally=false, isModifier=false)
    protected Extension anaestheticIssues;

    /**
     * This records identifiers associated with this procedure that are defined by business processes 
     * and/or used to refer to it when a direct URL reference to the resource itself is not appropriate 
     * (e.g. in CDA documents, or in written / printed documentation).
     */
    @Child(name="identifier", type={Identifier.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="External Identifiers for this procedure", 
    	formalDefinition=
    		"This records identifiers associated with this procedure that are defined by " +
    		"business processes and/or used to refer to it when a direct URL reference to the " +
    		"resource itself is not appropriate (e.g. in CDA documents, or in written / printed documentation)." 
    )
    protected List<Identifier> identifier;
    
    /**
     * A larger event of which this particular procedure is a component or step.
     */
    @Child(
    	name="partOf", type={CareConnectProcedure.class, Observation.class, MedicationAdministration.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true
    )
    @Description(//TODO Use CareConnectObservation
    	shortDefinition="Part of referenced event", 
    	formalDefinition="A larger event of which this particular procedure is a component or step." 
    )
    protected List<Reference> partOf;
    
    /**
     * The person, animal or group on which the procedure was performed.
     */
    @Child(
    	name="subject", type={CareConnectPatient.class, Group.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
    )
    @Description(
    	shortDefinition="Who the procedure was performed on", 
    	formalDefinition="The person, animal or group on which the procedure was performed." 
    )
    protected Reference subject;

    /**
     * The encounter during which the procedure was performed.
     */
    @Child(
    	name="context", type={CareConnectEncounter.class, CareConnectEpisodeOfCare.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
    )
    @Description(
    	shortDefinition="Encounter or episode associated with the procedure", 
    	formalDefinition="The encounter during which the procedure was performed." 
    )
    protected Reference context;
    
    /**
     * Limited to 'real' people rather than equipment.
     */
    @Child(name="performer", order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="The people who performed the procedure", 
    	formalDefinition="Limited to 'real' people rather than equipment." 
    )
    protected List<ProcedurePerformerComponent> performer;
    
    /**
     * The location where the procedure actually happened.  E.g. a newborn at home, a tracheostomy at a restaurant.
     */
    @Child(name="location", type={CareConnectLocation.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Where the procedure happened", 
    	formalDefinition=
    		"The location where the procedure actually happened. " +
    		"E.g. a newborn at home, a tracheostomy at a restaurant." 
    )
    protected Reference location;

    /**
     * The condition that is the reason why the procedure was performed.
     */
    @Child(
    	name="reasonReference", type={CareConnectCondition.class, Observation.class}, //TODO Use CareConnectObservation
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true
    )
    @Description(
    	shortDefinition="Condition that is the reason the procedure performed", 
    	formalDefinition="The condition that is the reason why the procedure was performed." 
    )
    protected List<Reference> reasonReference;
    
    /**
     * Any complications that occurred during the procedure, or in the immediate post-performance period.
     */
    @Child(name="complicationDetail", type={CareConnectCondition.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="A condition that is a result of the procedure", 
    	formalDefinition=
    		"Any complications that occurred during the procedure, " +
    		"or in the immediate post-performance period." 
    )
    protected List<Reference> complicationDetail;
    
    /**
     * Any other notes about the procedure.  E.g. the operative notes.
     */
    @Child(name="note", type={Annotation.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Additional information about the procedure", 
    	formalDefinition="Any other notes about the procedure.  E.g. the operative notes." 
    )
    protected List<Annotation> note;
    
    /**
     * Identifies medications, devices and any other substance used as part of the procedure.
     */
    @Child(
    	name="usedReference", type={Device.class, Medication.class, Substance.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false
    )
    @Description( //TODO Use CareConnectMedication
    	shortDefinition="Items used during procedure", 
    	formalDefinition="Identifies medications, devices and any other substance used as part of the procedure." 
    )
    protected List<Reference> usedReference;
    
    @Block()
    public static class ProcedurePerformerComponent extends Procedure.ProcedurePerformerComponent {

		private static final long serialVersionUID = 1L;

		/**
         * The practitioner who was involved in the procedure.
         */
        @Child(
        	name="actor", type={CareConnectPractitioner.class, CareConnectOrganization.class, 
        	CareConnectPatient.class, RelatedPerson.class, Device.class}, 
        	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
        )
        @Description(
        	shortDefinition="The reference to the practitioner", 
        	formalDefinition="The practitioner who was involved in the procedure." 
        )
        protected Reference actor;

        /**
         * The organization the device or practitioner was acting on behalf of.
         */
        @Child(name="onBehalfOf", type={CareConnectOrganization.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
        @Description(
        	shortDefinition="Organization the device or practitioner was acting for", 
        	formalDefinition="The organization the device or practitioner was acting on behalf of." 
        )
        protected Reference onBehalfOf;
    }
}
