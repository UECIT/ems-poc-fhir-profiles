package org.hl7.fhir.dstu3.model;

import java.util.List;

import org.hl7.fhir.dstu3.model.CarePlan;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Device;
import org.hl7.fhir.dstu3.model.DeviceRequest;
import org.hl7.fhir.dstu3.model.EpisodeOfCare;
import org.hl7.fhir.dstu3.model.Group;
import org.hl7.fhir.dstu3.model.ImmunizationRecommendation;
import org.hl7.fhir.dstu3.model.NutritionOrder;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.ProcedureRequest;
import org.hl7.fhir.dstu3.model.QuestionnaireResponse;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.ReferralRequest;
import org.hl7.fhir.dstu3.model.RelatedPerson;
import org.hl7.fhir.dstu3.model.Sequence;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="Observation", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Observation-1")
public class CareConnectObservation extends Observation {

	private static final long serialVersionUID = 1L;
	
	@Child(name="identifier", type={CareConnectIdentifier.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="An identifier for this observation.")
    protected List<CareConnectIdentifier> identifier;
	
	@Child(name="basedOn", type={
		CarePlan.class, DeviceRequest.class, ImmunizationRecommendation.class, 
		CareConnectMedicationRequest.class, NutritionOrder.class, ProcedureRequest.class, ReferralRequest.class}, 
		order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfills plan, proposal or order", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this event." )
    protected List<Reference> basedOn;
	
    @Child(name="code", type={CodeableConcept.class}, order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(
		shortDefinition="Type of observation (code / type)", 
		formalDefinition="Describes what was observed. Sometimes this is called the observation \"name\"." 
    )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-ObservationType-1 ")
    protected CodeableConcept code;
    
    @Override
	public Observation setCode(CodeableConcept value) {
		super.setCode(value);
		code = value;
		return this;
	}
    
    @Override
	public CodeableConcept getCode() {
		return code == null ? super.getCode() : code;
	}

    @Child(name="subject", type={CareConnectPatient.class, Group.class, Device.class, CareConnectLocation.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who and/or what this is about", formalDefinition="The patient, or group of patients, location, or device whose characteristics (direct or indirect) are described by the observation and into whose record the observation is placed.  Comments: Indirect characteristics may be those of a specimen, fetus, donor,  other observer (for example a relative or EMT), or any observation made about the subject." )
    protected Reference subject;
    
    @Child(name="context", type={CareConnectEncounter.class, EpisodeOfCare.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
    @Description(
    	shortDefinition="Healthcare event during which this observation is made", 
    	formalDefinition="The healthcare event  (e.g. a patient and healthcare provider interaction) " +
    		"during which this observation is made." 
    )
    protected Reference context;
    
    @Child(name="performer", type={
    	CareConnectPractitioner.class, CareConnectOrganization.class, CareConnectPatient.class, RelatedPerson.class},
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="Who is responsible for the observation", 
    	formalDefinition="Who was responsible for asserting the observed value as \"true\"." 
    )
    protected List<Reference> performer;
    
    @Child(name = "related", type = {}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="Resource related to this observation", 
    	formalDefinition="A  reference to another resource (usually another Observation) " +
    		"whose relationship is defined by the relationship type code." 
    )
    protected List<ObservationRelatedComponent> related;

    @Block()
    public static class ObservationRelatedComponent extends org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent {
    	
		private static final long serialVersionUID = 1L;
    	
		@Child(name = "target", type = {CareConnectObservation.class, QuestionnaireResponse.class, Sequence.class}, 
			order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
        @Description(
        	shortDefinition="Resource that is related to this one", 
        	formalDefinition="A reference to the observation or [[[QuestionnaireResponse]]] resource that is related to this observation." 
        )
        protected Reference target;
    }
}
