package resources;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.BackboneElement;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.Binding;
import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
import datatypes.NHSNumberIdentifier;

@ResourceDef(name = "Patient", profile = "https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Patient-1")
public class CareConnectPatient extends Patient {

	private static final long serialVersionUID = 1L;

	@Child(name = "identifier", type = {
			NHSNumberIdentifier.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "An identifier for this patient", formalDefinition = "An identifier for this patient.")
	protected List<NHSNumberIdentifier> identifier = new ArrayList<>();

	public Patient addIdentifier(NHSNumberIdentifier identifier) {
		this.identifier.add(identifier);
		return super.addIdentifier(identifier);
	}

	public NHSNumberIdentifier getIdentifierFirstRep() {
		return identifier.get(0);
	}

	@Child(name = "ethnicCategory")
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-EthnicCategory-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "This extension is constrained to represent the ethnic category for a patient")
	private CodeableConcept ethnicCategory;

	@Child(name = "religiousAffiliation")
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-ReligiousAffiliation-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "This extension is constrained to represent the religious affiliation for a patient.")
	private CodeableConcept religiousAffiliation;

	@Child(name = "patient-cadavericDonor")
	@Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-cadavericDonor", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Flag indicating whether the patient authorized the donation of body parts after death.")
	private BooleanType cadavericDonor;

	@Child(name = "residentialStatus")
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-ResidentialStatus-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "This extension is constrained to represent the residential status for a patient.")
	private CodeableConcept residentialStatus;

	@Child(name = "treatmentCategory")
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-TreatmentCategory-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "This extension is constrained to represent the treatment category for a patient.")
	private CodeableConcept treatmentCategory;

	@Child(name = "nhsCommunication")
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "This extension is constrained to support the communication preferences for a resource in the NHS.")
	private NhsCommunicationExtension nhsCommunication;

	@Block
	public static class NhsCommunicationExtension extends BackboneElement {

		private static final long serialVersionUID = 2L;

		@Child(name = "language")
		private org.hl7.fhir.dstu3.model.Extension language;

		@Child(name = "preferred")
		private org.hl7.fhir.dstu3.model.Extension preferred;

		@Child(name = "modeOfCommunication")
		private org.hl7.fhir.dstu3.model.Extension modeOfCommunication;

		@Child(name = "communicationProficiency")
		private org.hl7.fhir.dstu3.model.Extension communicationProficiency;

		@Child(name = "interpreterRequired")
		private org.hl7.fhir.dstu3.model.Extension interpreterRequired;

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
			return super.isEmpty() && ElementUtil.isEmpty(language, preferred, modeOfCommunication,
					communicationProficiency, interpreterRequired);
		}

		// Getters and Setters
		public org.hl7.fhir.dstu3.model.Extension getLanguage() {
			return language;
		}

		public void setLanguage(org.hl7.fhir.dstu3.model.Extension language) {
			this.language = language;
		}

		public org.hl7.fhir.dstu3.model.Extension getPreferred() {
			return preferred;
		}

		public void setPreferred(org.hl7.fhir.dstu3.model.Extension preferred) {
			this.preferred = preferred;
		}

		public org.hl7.fhir.dstu3.model.Extension getModeOfCommunication() {
			return modeOfCommunication;
		}

		public void setModeOfCommunication(org.hl7.fhir.dstu3.model.Extension modeOfCommunication) {
			this.modeOfCommunication = modeOfCommunication;
		}

		public org.hl7.fhir.dstu3.model.Extension getCommunicationProficiency() {
			return communicationProficiency;
		}

		public void setCommunicationProficiency(org.hl7.fhir.dstu3.model.Extension communicationProficiency) {
			this.communicationProficiency = communicationProficiency;
		}

		public org.hl7.fhir.dstu3.model.Extension getInterpreterRequired() {
			return interpreterRequired;
		}

		public void setInterpreterRequired(org.hl7.fhir.dstu3.model.Extension interpreterRequired) {
			this.interpreterRequired = interpreterRequired;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	}

//	@Child(name = "birthDate", type = {BirthDateType.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
//    @Description(shortDefinition="The date of birth for the individual", formalDefinition="The date of birth for the individual." )
//	private DateType birthDate;
//	
//    public CareConnectPatient setBirthDate(Date birthDate) { 
//    	this.birthDate = new BirthDateType().setBirthTime(new DateTimeType(birthDate));
//        return this;
//    }

	@Child(name = "birthPlace")
	@Extension(url = "http://hl7.org/fhir/StructureDefinition/birthPlace", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The registered place of birth of the patient. A sytem may use "
			+ "the address.text if they don't store the birthPlace address in discrete elements.")
	private Address birthPlace;

	// TODO REFERENCETYPE - figure out how to represent/constrain this.
	@Child(name = "nominatedPharmacy")
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NominatedPharmacy-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "This extension is constrained to represent a patient's nominated pharmacy.")
	private Reference nominatedPharmacy;

	// TODO EXTENSION WITH EXTENSIONS - figure out how to define.
	@Child(name = "deathNotificationStatus")
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-DeathNotificationStatus-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "This extension is constrained to represent a patient’s death notification "
			+ "(as held on Personal Demographics Service (PDS)).")
	private DeathNotificationStatusExtension deathNotificationStatus;

	@Block
	public static class DeathNotificationStatusExtension extends BackboneElement {

		private static final long serialVersionUID = 3L;

		@Child(name = "deathNotificationStatus")
		@Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-DeathNotificationStatus-1")
		private CodeableConcept deathNotificationStatus;

		@Child(name = "systemEffectiveDate")
		private BooleanType systemEffectiveDate;

		@Override
		public BackboneElement copy() {
			DeathNotificationStatusExtension copy = new DeathNotificationStatusExtension();
			copy.deathNotificationStatus = deathNotificationStatus;
			copy.systemEffectiveDate = systemEffectiveDate;
			return copy;
		}

		@Override
		public boolean isEmpty() {
			return super.isEmpty() && ElementUtil.isEmpty(deathNotificationStatus, systemEffectiveDate);
		}

		// Getters and setters
		public CodeableConcept getDeathNotificationStatus() {
			return deathNotificationStatus;
		}

		public void setDeathNotificationStatus(CodeableConcept deathNotificationStatus) {
			this.deathNotificationStatus = deathNotificationStatus;
		}

		public BooleanType getSystemEffectiveDate() {
			return systemEffectiveDate;
		}

		public void setSystemEffectiveDate(BooleanType systemEffectiveDate) {
			this.systemEffectiveDate = systemEffectiveDate;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	}

	@Child(name = "generalPractitioner", type = { CareConnectOrganization.class,
			CareConnectPractitioner.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
	@Description(shortDefinition = "Patient's nominated primary care provider", formalDefinition = "Patient's nominated primary care provider.")
	protected List<Reference> generalPractitioner = new ArrayList<>();

	@Override
	public List<Reference> getGeneralPractitioner() {
		return generalPractitioner;
	}

	@Override
	public Patient addGeneralPractitioner(Reference reference) {
		generalPractitioner.add(reference);
		return super.addGeneralPractitioner(reference);
	}

	@Child(name = "managingOrganization", type = {
			CareConnectOrganization.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = true)
	@Description(shortDefinition = "Organization that is the custodian of the patient record", formalDefinition = "Organization that is the custodian of the patient record.")
	protected Reference managingOrganization;

	// Getters and setters
	public CodeableConcept getEthnicCategory() {
		return ethnicCategory;
	}

	public void setEthnicCategory(CodeableConcept ethnicCategory) {
		this.ethnicCategory = ethnicCategory;
	}

	public CodeableConcept getReligiousAffiliation() {
		return religiousAffiliation;
	}

	public void setReligiousAffiliation(CodeableConcept religiousAffiliation) {
		this.religiousAffiliation = religiousAffiliation;
	}

	public BooleanType getCadavericDonor() {
		return cadavericDonor;
	}

	public void setCadavericDonor(BooleanType cadavericDonor) {
		this.cadavericDonor = cadavericDonor;
	}

	public CodeableConcept getResidentialStatus() {
		return residentialStatus;
	}

	public void setResidentialStatus(CodeableConcept residentialStatus) {
		this.residentialStatus = residentialStatus;
	}

	public CodeableConcept getTreatmentCategory() {
		return treatmentCategory;
	}

	public void setTreatmentCategory(CodeableConcept treatmentCategory) {
		this.treatmentCategory = treatmentCategory;
	}

	public NhsCommunicationExtension getNhsCommunication() {
		return nhsCommunication;
	}

	public void setNhsCommunication(NhsCommunicationExtension nhsCommunication) {
		this.nhsCommunication = nhsCommunication;
	}

	public Address getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(Address birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Reference getNominatedPharmacy() {
		return nominatedPharmacy;
	}

	public void setNominatedPharmacy(Reference nominatedPharmacy) {
		this.nominatedPharmacy = nominatedPharmacy;
	}

	public DeathNotificationStatusExtension getDeathNotificationStatus() {
		return deathNotificationStatus;
	}

	public void setDeathNotificationStatus(DeathNotificationStatusExtension deathNotificationStatus) {
		this.deathNotificationStatus = deathNotificationStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty()
				&& ElementUtil.isEmpty(ethnicCategory, religiousAffiliation, cadavericDonor, residentialStatus,
						treatmentCategory, nhsCommunication, birthPlace, nominatedPharmacy, deathNotificationStatus);
	}

}
