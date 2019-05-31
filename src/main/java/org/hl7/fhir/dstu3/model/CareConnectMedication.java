package org.hl7.fhir.dstu3.model;

import java.util.List;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Medication;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Substance;
import org.hl7.fhir.dstu3.model.Type;

import ca.uhn.fhir.model.api.annotation.Binding;
import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="Medication", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Medication-1")
public class CareConnectMedication extends Medication {

	private static final long serialVersionUID = 1L;

	@Child(name="code", type={CodeableConcept.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Codes that identify this medication", 
    	formalDefinition="A code (or set of codes) that specify this medication, or a textual description " +
    		"if no code is available. Usage note: This could be a standard medication code such as a code from " +
    		"RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems."
    )
    @Binding(valueSet="https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-MedicationCode-1 ")
    protected CodeableConcept code;
	
    @Child(name = "manufacturer", type = {CareConnectOrganization.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Manufacturer of the item", 
    	formalDefinition="Describes the details of the manufacturer of the medication product.  " +
    		"This is not intended to represent the distributor of a medication product." 
    )
    protected Reference manufacturer;
    
    @Child(name = "form", type = {CodeableConcept.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="powder | tablets | capsule +", formalDefinition="Describes the form of the item.  Powder; tablets; capsule." )
    @Binding(valueSet="https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-MedicationForm-1")
    protected CodeableConcept form;
    
    @Child(name = "ingredient", type = {}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Active or inactive ingredient", formalDefinition="Identifies a particular constituent of interest in the product." )
    protected List<MedicationIngredientComponent> ingredient;
    
    @Block()
    public static class MedicationIngredientComponent extends org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent {

		private static final long serialVersionUID = 1L;
		
		@Child(name = "item", type = {CodeableConcept.class, Reference.class, Substance.class, CareConnectMedication.class}, 
			order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=false)
        @Description(
        	shortDefinition="The product contained", 
        	formalDefinition="The actual ingredient - either a substance (simple ingredient) or another medication." 
        )
        protected Type item;
    }
}
