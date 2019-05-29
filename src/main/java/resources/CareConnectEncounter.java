package resources;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Configuration;
import org.hl7.fhir.dstu3.model.Encounter;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.Binding;
import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import datatypes.Identifier;

@ResourceDef(name = "Encounter", profile = "https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Encounter-1")
public class CareConnectEncounter extends Encounter {

	private static final long serialVersionUID = 1L;

	/**
	 * Identifier(s) by which this encounter is known.
	 */
	@Child(name = "identifier", type = {
			Identifier.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "External Ids for this encounter", formalDefinition = "This records identifiers associated with this condition that are defined "
			+ "by business processes and/or used to refer to it when a direct URL reference to the resource "
			+ "itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).")
	protected List<Identifier> identifier;

	@Child(name = "encounterTransport", order = Child.ORDER_UNKNOWN, min = 0, max = 1, modifier = false, summary = true)
	@Description(shortDefinition = "Encounter transport")
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-EncounterTransport-1", definedLocally = false, isModifier = false)
	protected EncounterTransport encounterTransport;

	@Child(name = "outcomeOfAttendance", order = Child.ORDER_UNKNOWN, min = 0, max = 1, modifier = false, summary = true)
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-OutcomeOfAttendance-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "1 | 2 | 3")
	@Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-OutcomeOfAttendance-1")
	private CodeableConcept outcomeOfAttendance;

	@Child(name = "emergencyCareDischargeStatus", order = Child.ORDER_UNKNOWN, min = 0, max = 1, modifier = false, summary = true)
	@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-EmergencyCareDischargeStatus-1", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "1 | 2 | 3")
	@Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-EmergencyCareDischargeStatus-1")
	private CodeableConcept emergencyCareDischargeStatus;

	/**
	 * Details about the admission to a healthcare service.
	 */
	@Child(name = "hospitalization", order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
	@Description(shortDefinition = "Details about the admission to a healthcare service", formalDefinition = "Details about the admission to a healthcare service.")
	protected EncounterHospitalizationComponent hospitalization;

	/**
	 * The list of people responsible for providing the service.
	 */
	@Child(name = "participant", order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "List of participants involved in the encounter", formalDefinition = "The list of people responsible for providing the service.")
	protected List<EncounterParticipantComponent> participant;

	/**
	 * The list of diagnosis relevant to this encounter.
	 */
	@Child(name = "diagnosis", order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "The list of diagnosis relevant to this encounter", formalDefinition = "The list of diagnosis relevant to this encounter.")
	protected List<DiagnosisComponent> diagnosis;

	/**
	 * List of locations where the patient has been during this encounter.
	 */
	@Child(name = "location", order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
	@Description(shortDefinition = "List of locations where the patient has been", formalDefinition = "List of locations where  the patient has been during this encounter.")
	protected List<EncounterLocationComponent> location;

	public Encounter addLocation(EncounterLocationComponent t) { // 3
		if (t == null)
			return this;
		if (this.location == null)
			this.location = new ArrayList<EncounterLocationComponent>();
		this.location.add(t);
		super.addLocation(t);
		return this;
	}

	/**
	 * @return The first repetition of repeating field {@link #location}, creating
	 *         it if it does not already exist
	 */
	public EncounterLocationComponent getLocationFirstRep() {
		return location.get(0);
	}

	/**
	 * An organization that is in charge of maintaining the information of this
	 * Encounter (e.g. who maintains the report or the master service catalog item,
	 * etc.). This MAY be the same as the organization on the Patient record,
	 * however it could be different. This MAY not be not the Service Delivery
	 * Location's Organization.
	 */
	@Child(name = "serviceProvider", type = {
			CareConnectOrganization.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
	@Description(shortDefinition = "The custodian organization of this Encounter record", formalDefinition = "An organization that is in charge of maintaining the information of this "
			+ "Encounter (e.g. who maintains the report or the master service catalog item, etc.). "
			+ "This MAY be the same as the organization on the Patient record, "
			+ "however it could be different. This MAY not be not the Service Delivery Location's Organization.")
	protected Reference serviceProvider;

	/**
	 * Another Encounter of which this encounter is a part of (administratively or
	 * in time).
	 */
	@Child(name = "partOf", type = {
			CareConnectEncounter.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
	@Description(shortDefinition = "Another Encounter this encounter is part of", formalDefinition = "Another Encounter of which this encounter is a part of (administratively or in time).")
	protected Reference partOf;

	@Block()
	public static class ClassHistoryComponent extends org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent {

		private static final long serialVersionUID = 1L;
		/**
		 * inpatient | outpatient | ambulatory | emergency +.
		 */
		@Binding(valueSet = "http://hl7.org/fhir/ValueSet/v3-ActEncounterCode")
		@Child(name = "class", type = {
				Coding.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "inpatient | outpatient | ambulatory | emergency +", formalDefinition = "inpatient | outpatient | ambulatory | emergency +.")
		protected Coding class_;
	}

	@Block()
	public static class EncounterParticipantComponent extends Encounter.EncounterParticipantComponent {

		private static final long serialVersionUID = 1L;

		/**
		 * Persons involved in the encounter other than the patient.
		 */
		@Child(name = "individual", type = { CareConnectPractitioner.class,
				CareConnectRelatedPerson.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = true)
		@Description(shortDefinition = "Persons involved in the encounter other than the patient", formalDefinition = "Persons involved in the encounter other than the patient.")
		protected Reference individual;
	}

	@Block()
	public static class DiagnosisComponent extends Encounter.DiagnosisComponent {

		private static final long serialVersionUID = 1L;

		/**
		 * Reason the encounter takes place, as specified using information from another
		 * resource. For admissions, this is the admission diagnosis. The indication
		 * will typically be a Condition (with other resources referenced in the
		 * evidence.detail), or a Procedure.
		 */
		@Child(name = "condition", type = { CareConnectCondition.class,
				CareConnectProcedure.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "Reason the encounter takes place (resource)", formalDefinition = "Reason the encounter takes place, as specified using information from another resource. "
				+ "For admissions, this is the admission diagnosis. The indication will typically be a "
				+ "Condition (with other resources referenced in the evidence.detail), or a Procedure.")
		protected Reference condition;
	}

	@Block()
	public static class EncounterHospitalizationComponent extends Encounter.EncounterHospitalizationComponent {

		private static final long serialVersionUID = 1L;

		@Child(name = "admissionMethod", order = Child.ORDER_UNKNOWN, min = 1, max = 1, modifier = false, summary = true)
		@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-AdmissionMethod-1", definedLocally = false, isModifier = false)
		@Description(shortDefinition = "11 | 12 | 13 | 21 | 22 | 23 | 24 | 25 | 28 | 2A | 2B | 2C | 2D | 31 | 32 | 81 | 82 | 83")
		@Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-AdmissionMethod-1")
		protected CodeableConcept admissionMethod;

		@Child(name = "dischargeMethod", order = Child.ORDER_UNKNOWN, min = 1, max = 1, modifier = false, summary = true)
		@Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-DischargeMethod-1", definedLocally = false, isModifier = false)
		@Description(shortDefinition = "1 | 2 | 3 | 4 | 5 | 6 | 7")
		@Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-DischargeMethod-1")
		protected CodeableConcept dischargeMethod;

		@Child(name = "identifier", type = {
				Identifier.class }, order = Child.ORDER_UNKNOWN, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
		@Description(shortDefinition = "External Id for this admission", formalDefinition = "This records identifiers associated with this condition that are defined "
				+ "by business processes and/or used to refer to it when a direct URL reference to the resource "
				+ "itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).")
		protected Identifier preAdmissionIdentifier;

		/**
		 * The location from which the patient came before admission.
		 */
		@Child(name = "origin", type = {
				CareConnectLocation.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "The location from which the patient came before admission", formalDefinition = "The location from which the patient came before admission.")
		protected Reference origin;

		/**
		 * From where patient was admitted (physician referral, transfer).
		 */
		@Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-SourceOfAdmission-1")
		@Child(name = "admitSource", type = {
				CodeableConcept.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "From where patient was admitted (physician referral, transfer)", formalDefinition = "From where patient was admitted (physician referral, transfer).")
		protected CodeableConcept admitSource;

		/**
		 * Location to which the patient is discharged.
		 */
		@Child(name = "destination", type = {
				CareConnectLocation.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "Location to which the patient is discharged", formalDefinition = "Location to which the patient is discharged.")
		protected Reference destination;

		/**
		 * Category or kind of location after discharge.
		 */
		@Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-DischargeDestination-1")
		@Child(name = "dischargeDisposition", type = {
				CodeableConcept.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "Category or kind of location after discharge", formalDefinition = "Category or kind of location after discharge.")
		protected CodeableConcept dischargeDisposition;

		public CodeableConcept getAdmissionMethod() {
			return admissionMethod;
		}

		public void setAdmissionMethod(CodeableConcept admissionMethod) {
			this.admissionMethod = admissionMethod;
		}

		public CodeableConcept getDischargeMethod() {
			return dischargeMethod;
		}

		public void setDischargeMethod(CodeableConcept dischargeMethod) {
			this.dischargeMethod = dischargeMethod;
		}

		public Identifier getPreAdmissionIdentifier() {
			return preAdmissionIdentifier;
		}

		public void setPreAdmissionIdentifier(Identifier preAdmissionIdentifier) {
			this.preAdmissionIdentifier = preAdmissionIdentifier;
		}
	}

	@Block()
	public static class EncounterLocationComponent extends Encounter.EncounterLocationComponent {

		private static final long serialVersionUID = 1L;

		/**
		 * The location where the encounter takes place.
		 */
		@Child(name = "location", type = {
				CareConnectLocation.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "Location the encounter takes place", formalDefinition = "The location where the encounter takes place.")
		protected Reference location;

		public EncounterLocationComponent() {
			super();
		}

		public EncounterLocationComponent(Reference location) {
			super(location);
			this.location = location;
			setLocationTarget((CareConnectLocation)location.getResource());
		}

		public Reference getLocation() {
			if (this.location == null)
				if (Configuration.errorOnAutoCreate())
					throw new Error("Attempt to auto-create EncounterLocationComponent.location");
				else if (Configuration.doAutoCreate())
					this.location = new Reference(); // cc
			return this.location;
		}
		
		public EncounterLocationComponent setLocation(Reference value)  { 
			this.location = value;
			super.setLocation(value);
			return this;
		}
	}
}
