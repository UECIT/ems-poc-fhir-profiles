package org.hl7.fhir.dstu3.model;

import org.hl7.fhir.dstu3.model.SimpleQuantity;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;

@DatatypeDef(name="Quantity")
public class TextQuantity extends SimpleQuantity {

	private static final long serialVersionUID = 1L;
	
	@Child(name="quantityText", order=Child.ORDER_UNKNOWN, min=0, max=1, modifier=false, summary=true)
	@Description(shortDefinition="This Extension resource is constrained to support the textual representation of a medication structured quantity.")
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-MedicationQuantityText-1", definedLocally=false, isModifier=false)
	protected org.hl7.fhir.dstu3.model.Extension quantityText;
}
