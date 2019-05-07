package datatypes;

import datatypes.Identifier;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.UriType;
import org.hl7.fhir.instance.model.api.ICompositeType;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import resources.CareConnectOrganization;

@DatatypeDef(name = "identifier")
@Block
public class Identifier extends org.hl7.fhir.dstu3.model.Identifier implements ICompositeType {

	private static final long serialVersionUID = 1L;

	/**
     * Establishes the namespace for the value - that is, a URL that describes a set values that are unique.
     */
    @Child(name="system", order=Child.REPLACE_PARENT, min=1, max=1, modifier=true, summary=true)
    @Description(
    	shortDefinition="The namespace for the identifier value", 
    	formalDefinition="Establishes the namespace for the value - " +
    					 "that is, a URL that describes a set values that are unique." 
    )
    protected UriType system;
    
    @Override
    public Identifier setSystem(String system) {
    	this.system = new UriType(system);
    	return this;
    }

    /**
     * The portion of the identifier typically relevant to the user and which is unique within the context of the system.
     */
    @Child(name="value", order=Child.REPLACE_PARENT, min=1, max=1, modifier=true, summary=true)
    @Description(
    	shortDefinition="The value that is unique", 
    	formalDefinition="The portion of the identifier typically relevant to the user " +
    				     "and which is unique within the context of the system." 
    )
    protected StringType value;
    
    @Override
    public Identifier setValue(String value) {
    	this.value = new StringType(value);
    	return this;
    }
    
    /**
     * Organization that issued/manages the identifier.
     */
    @Child(
    	name="assigner", type={CareConnectOrganization.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
    )
    @Description(
		shortDefinition="Organization that issued id (may be just text)", 
		formalDefinition="Organization that issued/manages the identifier." 
	)
    protected Reference assigner;
    
    @Override
    public Identifier setAssigner(Reference assigner) {
    	this.assigner = assigner;
    	return this;
    }
    
    @Override
    public Reference getAssigner() {
    	return assigner;
    }
}
