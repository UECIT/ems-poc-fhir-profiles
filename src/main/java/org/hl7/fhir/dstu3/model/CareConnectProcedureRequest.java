package org.hl7.fhir.dstu3.model;

import java.util.List;

import org.hl7.fhir.dstu3.model.Device;
import org.hl7.fhir.dstu3.model.EpisodeOfCare;
import org.hl7.fhir.dstu3.model.Group;
import org.hl7.fhir.dstu3.model.ProcedureRequest;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="ProcedureRequest", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-ProcedureRequest-1")
public class CareConnectProcedureRequest extends ProcedureRequest {

	private static final long serialVersionUID = 1L;

	@Child(name="identifier", type={CareConnectIdentifier.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
	@Description(shortDefinition="External Ids for this procedure request")
	protected List<CareConnectIdentifier> identifier;
	
	@Child(name = "requisition", type = {CareConnectIdentifier.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Composite Request ID", 
    	formalDefinition="A shared identifier common to all procedure or diagnostic requests that were authorized " +
    		"more or less simultaneously by a single author, representing the composite or group identifier." 
    )
    protected CareConnectIdentifier requisition;
	
	@Child(name = "subject", type = {CareConnectPatient.class, Group.class, CareConnectLocation.class, Device.class}, 
		order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Individual the service is ordered for", 
    	formalDefinition="On whom or what the procedure or diagnostic is to be performed. " +
    		"This is usually a human patient, but can also be requested on animals, groups of humans or animals, " +
    		"devices such as dialysis machines, or even locations (typically for environmental scans)." 
    )
    protected Reference subject;
	
	@Child(name = "context", type = {CareConnectEncounter.class, EpisodeOfCare.class}, 
		order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Encounter or Episode during which request was created", 
    	formalDefinition="An encounter or episode of care that provides additional " +
    		"information about the healthcare context in which this request is made." 
    )
    protected Reference context;
	
	@Child(name="requester", order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/What requested the Request", formalDefinition="The individual, organization or device that initiated the request and has responsibility for its activation." )
    protected ProcedureRequestRequesterComponent requester;
	
	@Child(name = "performer", type = {CareConnectPractitioner.class, CareConnectOrganization.class, CareConnectPatient.class, 
		Device.class, RelatedPerson.class, CareConnectHealthcareService.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Requested perfomer", 
    	formalDefinition="The desired perfomer for doing the diagnostic testing.  For example, the surgeon, dermatopathologist, endoscopist, etc." 
    )
    protected Reference performer;
	
	@Child(name = "reasonReference", type = {CareConnectCondition.class, CareConnectObservation.class}, 
		order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="Explanation/Justification for test", 
    	formalDefinition="Indicates another resource that provides a justification for why this diagnostic " +
    		"investigation is being requested.   May relate to the resources referred to in supportingInformation." 
    )
    protected List<Reference> reasonReference;
	
    @Child(name = "supportingInfo", type = {CareConnectOrganization.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Additional clinical information", 
    	formalDefinition="Additional clinical information about the patient or specimen that may influence the " +
    		"procedure or diagnostics or their interpretations. This information includes diagnosis, " +
    		"clinical findings and other observations.  In laboratory ordering these are typically referred to as "+
    		"\"ask at order entry questions (AOEs)\".  This includes observations explicitly requested by the " +
    		"producer (filler) to provide context or supporting information needed to complete the order. " +
    		"For example,  reporting the amount of inspired oxygen for blood gas measurements." 
    )
    protected List<Reference> supportingInfo;
	
    @Child(name="specimen", type={CareConnectSpecimen.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="Procedure Samples", 
    	formalDefinition="One or more specimens that the laboratory procedure will use." 
    )
    protected List<Reference> specimen;
    
	@Block()
    public static class ProcedureRequestRequesterComponent 
    		extends org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestRequesterComponent {

		private static final long serialVersionUID = 1L;
		
        @Child(name="agent", type={CareConnectPractitioner.class, CareConnectOrganization.class, CareConnectPatient.class, 
        	RelatedPerson.class, Device.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
        @Description(
        	shortDefinition="Who ordered the initial medication(s)", 
        	formalDefinition="The healthcare professional responsible for authorizing the initial prescription." 
        )
        protected Reference agent;

        @Child(name="onBehalfOf", type={CareConnectOrganization.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
        @Description(
        	shortDefinition="Organization agent is acting for", 
        	formalDefinition="The organization the device or practitioner was acting on behalf of." 
        )
        protected Reference onBehalfOf;
	}
}
