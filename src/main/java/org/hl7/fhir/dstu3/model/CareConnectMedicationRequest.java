package org.hl7.fhir.dstu3.model;

import java.util.List;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="MedicationRequest", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-MedicationRequest-1")
public class CareConnectMedicationRequest extends MedicationRequest {

	private static final long serialVersionUID=1L;

	@Child(name="repeatInformation", order=Child.ORDER_UNKNOWN, min=0, max=1, modifier=false, summary=true)
	@Description(shortDefinition="Indicates the specific repeat information of a medication item.")
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-MedicationRepeatInformation-1", definedLocally=false, isModifier=false)
	protected RepeatInformationExtension repeatInformation;
	
	@Child(name="statusReason", order=Child.ORDER_UNKNOWN, min=0, max=1, modifier=false, summary=true)
	@Description(shortDefinition="To record the reason the medication (plan or order) was stopped and the date this occurred.")
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-MedicationStatusReason-1", definedLocally=false, isModifier=false)
	protected MedicationStatusReasonExtension statusReason;
	
	@Child(name="prescriptionType", order=Child.ORDER_UNKNOWN, min=0, max=1, modifier=false, summary=true)
	@Description(shortDefinition="To record the type of prescription.")
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-PrescriptionType-1", definedLocally=false, isModifier=false)
	protected org.hl7.fhir.dstu3.model.Extension prescriptionType;
	
	@Child(name="identifier", type={CareConnectIdentifier.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
	@Description(shortDefinition="External Ids for this medication request")
	protected List<CareConnectIdentifier> identifier;
	
	@Child(name="basedOn", type={CarePlan.class, CareConnectMedicationRequest.class, ProcedureRequest.class, ReferralRequest.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="What request fulfills", 
    	formalDefinition="A plan or request that is fulfilled in whole or in part by this medication request." 
    )
    protected List<Reference> basedOn;
	
	@Child(name = "groupIdentifier", type = {CareConnectIdentifier.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Composite request this is part of", 
    	formalDefinition="A shared identifier common to all requests that were authorized more or less " +
    		"simultaneously by a single author, representing the identifier of the requisition or prescription." 
    )
    protected CareConnectIdentifier groupIdentifier;
	
	@Child(name="medication", type={CareConnectMedication.class}, 
		order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Medication to be taken", 
    	formalDefinition="Identifies the medication being requested. This is a link to a resource that represents the medication " +
    		"which may be the details of the medication or simply an attribute carrying a code that identifies the medication from a known list of medications." 
    )
    protected Type medication;
	
    @Child(name="subject", type={CareConnectPatient.class, Group.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Who or group medication request is for", 
    	formalDefinition="A link to a resource representing the person or set of individuals to whom the medication will be given." 
    )
    protected Reference subject;
    
    @Child(name="context", type={CareConnectEncounter.class, EpisodeOfCare.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
    @Description(
    	shortDefinition="Created during encounter/admission/stay", 
    	formalDefinition="A link to an encounter, or episode of care, that identifies the particular " +
    		"occurrence or set occurrences of contact between patient and health care provider." 
    )
    protected Reference context;
    
    @Child(name="requester", order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/What requested the Request", formalDefinition="The individual, organization or device that initiated the request and has responsibility for its activation." )
    protected MedicationRequestRequesterComponent requester;
    
    @Child(name = "recorder", type={CareConnectPractitioner.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
    @Description(
    	shortDefinition="Person who entered the request", 
    	formalDefinition="The person who entered the order on behalf of another individual for example " +
    		"in the case of a verbal or a telephone order." 
    )
    protected Reference recorder;
    
    @Child(name = "reasonReference", type = {CareConnectCondition.class, CareConnectObservation.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Condition or Observation that supports why the prescription is being written", 
    	formalDefinition="Condition or observation that supports why the medication was ordered." )
    protected List<Reference> reasonReference;
    
    @Child(name="note", type={CareConnectAnnotation.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Information about the prescription", 
    	formalDefinition="Extra information about the prescription that could not be conveyed by the other attributes." 
    )
    protected List<CareConnectAnnotation> note;

    @Child(name = "dispenseRequest", type = {}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Medication supply authorization", formalDefinition="Indicates the specific details for the dispense or medication supply part of a medication request (also known as a Medication Prescription or Medication Order).  Note that this information is not always sent with the order.  There may be in some settings (e.g. hospitals) institutional or system support for completing the dispense details in the pharmacy department." )
    protected MedicationRequestDispenseRequestComponent dispenseRequest;
	
	@Block
	public static class RepeatInformationExtension extends BackboneElement {

		private static final long serialVersionUID=1L;
		
		@Child(name="numberOfRepeatPrescriptionsAllowed")
		private org.hl7.fhir.dstu3.model.Extension numberOfRepeatPrescriptionsAllowed;
		
		@Child(name="numberOfRepeatPrescriptionsIssued")
		private org.hl7.fhir.dstu3.model.Extension numberOfRepeatPrescriptionsIssued;
		
		@Child(name="authorisationExpiryDate")
		private org.hl7.fhir.dstu3.model.Extension authorisationExpiryDate;
		
		private static final UriType url=new UriType(
				"https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-MedicationRepeatInformation-1");
		
		@Override
		public RepeatInformationExtension copy() {
			RepeatInformationExtension copy=new RepeatInformationExtension();
			copy.id = this.id;
			copy.numberOfRepeatPrescriptionsAllowed = this.numberOfRepeatPrescriptionsAllowed;
			copy.numberOfRepeatPrescriptionsIssued = this.numberOfRepeatPrescriptionsIssued;
			copy.authorisationExpiryDate = this.authorisationExpiryDate;
			
			return copy;
		}
	}
	
	@Block
	public static class MedicationStatusReasonExtension extends BackboneElement {

		private static final long serialVersionUID=1L;
		
		@Child(name="statusReason")
		private org.hl7.fhir.dstu3.model.Extension statusReason;
		
		@Child(name="statusChangeDate")
		private org.hl7.fhir.dstu3.model.Extension statusChangeDate;
		
		private static final UriType url=new UriType(
				"https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-MedicationStatusReason-1");
		
		@Override
		public MedicationStatusReasonExtension copy() {
			MedicationStatusReasonExtension copy = new MedicationStatusReasonExtension();
			copy.id = this.id;
			copy.statusReason = this.statusReason;
			copy.statusChangeDate = this.statusChangeDate;
			
			return copy;
		}
	}
	
	@Block()
    public static class MedicationRequestRequesterComponent 
    		extends org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestRequesterComponent {

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
	
	@Block()
    public static class MedicationRequestDispenseRequestComponent 
    		extends org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent {

		private static final long serialVersionUID = 1L;	
		
		@Child(name = "quantity", type = {TextQuantity.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
        @Description(
        	shortDefinition="Amount of medication to supply per dispense", 
        	formalDefinition="The amount that is to be dispensed for one fill." )
        protected TextQuantity quantity;
		
		@Child(name = "expectedSupplyDuration", type = {MandatoryDuration.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
        @Description(
        	shortDefinition="Number of days supply per dispense", 
        	formalDefinition="Identifies the period time over which the supplied product " +
        		"is expected to be used, or the length of time the dispense is expected to last." 
        )
        protected MandatoryDuration expectedSupplyDuration;
	}
}
