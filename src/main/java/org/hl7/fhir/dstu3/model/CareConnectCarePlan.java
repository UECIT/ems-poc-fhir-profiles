package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
import java.util.ArrayList;
import java.util.List;

@ResourceDef(name="CarePlan", profile=CareConnectCarePlan.PROFILE)
public class CareConnectCarePlan extends CarePlan {

	private static final long serialVersionUID = 1L;

	static final String PROFILE = "https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-CarePlan-1";

	public CareConnectCarePlan() {
		super();
		this.setMeta(new Meta().addProfile(PROFILE));
	}

	@Child(name = "identifier", type = {
			CareConnectIdentifier.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "An identifier for this care plan.")
	protected List<CareConnectIdentifier> identifier;

	@Child(name = "basedOn", type = {
			CareConnectCarePlan.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "Fulfills care plan", formalDefinition = "A care plan that is fulfilled in whole or in part by this care plan.")
	protected List<Reference> basedOn;

	@Child(name = "replaces", type = {
			CareConnectCarePlan.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "CarePlan replaced by this CarePlan", formalDefinition = "Completed or terminated care plan whose function is taken by this new care plan.")
	protected List<Reference> replaces;

	@Child(name = "partOf", type = {
			CareConnectCarePlan.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "Part of referenced CarePlan", formalDefinition = "A larger care plan of which this particular care plan is a component or step.")
	protected List<Reference> partOf;

	@Child(name = "subject", type = { CareConnectPatient.class,
			Group.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = true)
	@Description(shortDefinition = "Who care plan is for", formalDefinition = "Identifies the patient or group whose intended care is described by the plan.")
	protected Reference subject;

	/**
	 * @return {@link #subject} (Identifies the patient or group whose intended care is described by the plan.)
	 */
	@Override
	public Reference getSubject() {
		if (this.subject == null)
			if (Configuration.errorOnAutoCreate())
				throw new Error("Attempt to auto-create CarePlan.subject");
			else if (Configuration.doAutoCreate())
				this.subject = new Reference(); // cc
		return this.subject;
	}

	@Override
	public boolean hasSubject() {
		return this.subject != null && !this.subject.isEmpty();
	}

	/**
	 * @param value {@link #subject} (Identifies the patient or group whose intended care is described by the plan.)
	 */
	@Override
	public CarePlan setSubject(Reference value)  {
		this.subject = value;
		return this;
	}

	@Child(name = "context", type = { CareConnectEncounter.class, CareConnectEpisodeOfCare.class },
		order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = true)
	@Description(shortDefinition = "Created in context of", formalDefinition = "Identifies the original context in which this particular CarePlan was created.")
	protected Reference context;

	/**
	 * @return {@link #context} (Identifies the original context in which this particular CarePlan was created.)
	 */
	public Reference getContext() {
		if (this.context == null)
			if (Configuration.errorOnAutoCreate())
				throw new Error("Attempt to auto-create CarePlan.context");
			else if (Configuration.doAutoCreate())
				this.context = new Reference(); // cc
		return this.context;
	}

	public boolean hasContext() {
		return this.context != null && !this.context.isEmpty();
	}

	/**
	 * @param value {@link #context} (Identifies the original context in which this particular CarePlan was created.)
	 */
	public CarePlan setContext(Reference value)  {
		this.context = value;
		return this;
	}

	@Child(name = "author", type = { CareConnectPatient.class, CareConnectPractitioner.class,
			CareConnectRelatedPerson.class, CareConnectOrganization.class,
			CareConnectCareTeam.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "Who is responsible for contents of the plan", formalDefinition = "Identifies the individual(s) or ogranization who is responsible for the content of the care plan.")
	protected List<Reference> author;

	@Child(name = "careTeam", type = {
			CareConnectCareTeam.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
	@Description(shortDefinition = "Who's involved in plan?", formalDefinition = "Identifies all people and organizations who are expected to be involved in the care envisioned by this plan.")
	protected List<Reference> careTeam;

	@Child(name = "addresses", type = {
			CareConnectCondition.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
	@Description(shortDefinition = "Health issues this plan addresses", formalDefinition = "Identifies the conditions/problems/concerns/diagnoses/etc. whose management and/or mitigation are handled by this plan.")
	protected List<Reference> addresses;

	@Child(name = "activity", type = {}, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
	@Description(shortDefinition = "Action to occur as part of plan", formalDefinition = "Identifies a planned action to occur as part of the plan.  For example, a medication to be used, lab tests to perform, self-monitoring, education, etc.")
	protected List<CarePlan.CarePlanActivityComponent> activity = new ArrayList<>();

	
	public List<CarePlan.CarePlanActivityComponent> getActivity() {
		List<CarePlan.CarePlanActivityComponent> combinedList = new ArrayList<>();
		combinedList.addAll(activity);
		combinedList.addAll(super.getActivity());
		
		return combinedList;
	}
	
	@Block()
	public static class CarePlanActivityComponent extends org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent {

		private static final long serialVersionUID = 1L;
		
		@Child(name = "progress", type = {CareConnectAnnotation.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Comments about the activity status/progress", formalDefinition="Notes about the adherence/status/progress of the activity." )
        protected List<CareConnectAnnotation> progress;
		
		@Child(name = "reference", type = {Appointment.class, CommunicationRequest.class, DeviceRequest.class, 
			CareConnectMedicationRequest.class, NutritionOrder.class, Task.class, CareConnectProcedureRequest.class, 
			ReferralRequest.class, VisionPrescription.class, RequestGroup.class}, 
			order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Activity details defined in specific resource", formalDefinition="The details of the proposed activity represented in a specific resource." )
        protected Reference reference;
		
		@Child(name = "detail", type = {}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="In-line definition of activity", formalDefinition="A simple summary of a planned activity suitable for a general care plan system (e.g. form driven) that doesn't know about specific resources such as procedure etc." )
        protected CarePlanActivityDetailComponent detail;

	}
	
	 @Block()
	 public static class CarePlanActivityDetailComponent extends org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent {

		private static final long serialVersionUID = 1L;
		 
		@Child(name = "reasonReference", type = {
				CareConnectCondition.class }, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
		@Description(shortDefinition = "Condition triggering need for activity", formalDefinition = "Provides the health condition(s) that drove the inclusion of this particular activity as part of the plan.")
		protected List<Reference> reasonReference;

		@Child(name = "location", type = {
				CareConnectLocation.class }, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "Where it should happen", formalDefinition = "Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.")
		protected Reference location;

		@Child(name = "performer", type = { CareConnectPractitioner.class, CareConnectOrganization.class, CareConnectRelatedPerson.class, CareConnectPatient.class,
				CareConnectCareTeam.class }, order = 12, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
		@Description(shortDefinition = "Who will be responsible?", formalDefinition = "Identifies who's expected to be involved in the activity.")
		protected List<Reference> performer;
	 }

	@Override
	public boolean equalsDeep(Base other_) {
		if (!super.equalsDeep(other_))
			return false;
		if (!(other_ instanceof CareConnectCarePlan))
			return false;
		CareConnectCarePlan o = (CareConnectCarePlan) other_;
		return super.equalsDeep(o)
				&& compareDeep(context, o.context, true)
				&& compareDeep(subject, o.subject, true);
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil
				.isEmpty( context, subject);
	}
}
