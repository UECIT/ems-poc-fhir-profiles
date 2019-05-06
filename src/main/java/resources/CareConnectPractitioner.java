package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.BackboneElement;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;

@ResourceDef(name="Practitioner", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Practitioner-1")
public class CareConnectPractitioner extends Practitioner {

	private static final long serialVersionUID = 1L;
	
	@Child(name = "sdsUserID", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Organization-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="Organizations are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the organization.", formalDefinition="An identifier for this patient." )
    protected List<Identifier> sdsUserID;
	
	@Child(name = "sdsRoleProfileID", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Organization-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="Organizations are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the organization.", formalDefinition="ODS Site code to identify the organisation at site level" )
    protected List<Identifier> sdsRoleProfileID;
	
	@Child(name="nhsCommunication")  
    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="Communication preferences including a list of Languages which may be used for communication")
    private Reference nhsCommunication;
	
	@Block
    public static class NhsCommunicationExtension extends BackboneElement {
		
		private static final long serialVersionUID = 2L;
		
		@Child(name="language")  
	    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally=false, isModifier=false)
		private CodeableConcept language;
		
		@Child(name="preferred")  
	    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally=false, isModifier=false)
		private BooleanType preferred;
		
		@Child(name="modeOfCommunication")  
	    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally=false, isModifier=false)
		private CodeableConcept modeOfCommunication;
		
		@Child(name="communicationProficiency")  
	    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally=false, isModifier=false)
		private CodeableConcept communicationProficiency;
		
		@Child(name="interpreterRequired")  
	    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally=false, isModifier=false)
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
	}
}
