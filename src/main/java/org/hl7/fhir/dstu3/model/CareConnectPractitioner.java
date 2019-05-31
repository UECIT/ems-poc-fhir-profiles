package org.hl7.fhir.dstu3.model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.dstu3.model.BackboneElement;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Practitioner;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;

@ResourceDef(name="Practitioner", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Practitioner-1")
public class CareConnectPractitioner extends Practitioner {

	private static final long serialVersionUID = 1L;
	
	@Child(name="identifier", order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=true, summary=true)
    @Description(shortDefinition="Practitioner identifiers")
    protected List<org.hl7.fhir.dstu3.model.CareConnectIdentifier> identifier = new ArrayList<>();
	
	public Practitioner addIdentifier(org.hl7.fhir.dstu3.model.CareConnectIdentifier identifier) {
		this.identifier.add(identifier);
		return this;
	}

    @Child(name = "nhsCommunication")
    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally=false, isModifier=false)
    protected NhsCommunicationExtension nhsCommunication;
	
    public NhsCommunicationExtension getNhsCommunication() {
		return nhsCommunication;
	}
	public void setNhsCommunication(NhsCommunicationExtension nhsCommunication) {
		this.nhsCommunication = nhsCommunication;
	}

	@Block
    public static class NhsCommunicationExtension extends BackboneElement {
    	
		private static final long serialVersionUID = 2L;
		
		@Child(name="language") 
		@Extension(url="https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-HumanLanguage-1", definedLocally = false, isModifier = false)
		private CodeableConcept language;
		
		@Child(name="preferred")  
		@Extension(url="preferred", definedLocally = false, isModifier = false)
		private BooleanType preferred;
		
		@Child(name="modeOfCommunication")
		@Extension(url="https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-LanguageAbilityMode-1", definedLocally = false, isModifier = false)
		private CodeableConcept modeOfCommunication;
		
		@Child(name="communicationProficiency")  
		@Extension(url="https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-LanguageAbilityProficiency-1", definedLocally = false, isModifier = false)
		private CodeableConcept communicationProficiency;
		
		@Child(name="interpreterRequired")  
		@Extension(url="interpreterRequired", definedLocally = false, isModifier = false)
		private BooleanType interpreterRequired;
		
		@Override
		public BackboneElement copy() {
			NhsCommunicationExtension copy = new NhsCommunicationExtension();
            copy.language = language;
            copy.preferred = preferred;
            copy.modeOfCommunication = modeOfCommunication;
            copy.communicationProficiency = communicationProficiency;
            copy.interpreterRequired = interpreterRequired;
            return copy;
		}
		
		@Override
        public boolean isEmpty() {
            return super.isEmpty() && ElementUtil.isEmpty(language, preferred, modeOfCommunication, communicationProficiency, interpreterRequired);
        }

		// Getters and Setters
		public CodeableConcept getLanguage() {
			return language;
		}

		public void setLanguage(CodeableConcept language) {
			this.language = language;
		}

		public BooleanType getPreferred() {
			return preferred;
		}

		public void setPreferred(BooleanType preferred) {
			this.preferred = preferred;
		}

		public CodeableConcept getModeOfCommunication() {
			return modeOfCommunication;
		}

		public void setModeOfCommunication(CodeableConcept modeOfCommunication) {
			this.modeOfCommunication = modeOfCommunication;
		}

		public CodeableConcept getCommunicationProficiency() {
			return communicationProficiency;
		}

		public void setCommunicationProficiency(CodeableConcept communicationProficiency) {
			this.communicationProficiency = communicationProficiency;
		}

		public BooleanType getInterpreterRequired() {
			return interpreterRequired;
		}

		public void setInterpreterRequired(BooleanType interpreterRequired) {
			this.interpreterRequired = interpreterRequired;
		}
		
	}
}
