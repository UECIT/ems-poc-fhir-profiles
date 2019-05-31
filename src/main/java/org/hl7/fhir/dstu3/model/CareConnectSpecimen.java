package org.hl7.fhir.dstu3.model;

import java.util.List;

import org.hl7.fhir.dstu3.model.BackboneElement;
import org.hl7.fhir.dstu3.model.Device;
import org.hl7.fhir.dstu3.model.Group;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Specimen;
import org.hl7.fhir.dstu3.model.Substance;
import org.hl7.fhir.dstu3.model.UriType;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="Specimen", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Specimen-1")
public class CareConnectSpecimen extends Specimen {

	private static final long serialVersionUID=1L;

	@Child(name="identifier", type={CareConnectIdentifier.class}, 
		order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Identifier", formalDefinition="Id for specimen." )
    protected List<CareConnectIdentifier> identifier;
	
    @Child(name="accessionIdentifier", type={CareConnectIdentifier.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Identifier assigned by the lab", 
    	formalDefinition="The identifier assigned by the lab when accessioning specimen(s). " + 
    		"This is not necessarily the same as the specimen identifier, depending on local lab procedures." 
    )
    protected CareConnectIdentifier accessionIdentifier;
    
    @Child(name="subject", type={CareConnectPatient.class, Group.class, Device.class, Substance.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Where the specimen came from. This may be from the patient(s) or from the environment or a device", 
    	formalDefinition="Where the specimen came from. This may be from the patient(s) or from the environment or a device." 
    )
    protected Reference subject;
    
    @Child(name="parent", type={CareConnectSpecimen.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Specimen from which this specimen originated", 
    	formalDefinition="Reference to the parent (source) specimen which is used when the specimen " +
    		"was either derived from or a component of another specimen." )
    protected List<Reference> parent;
    
    @Child(name="request", type={CareConnectProcedureRequest.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Why the specimen was collected", 
    	formalDefinition="Details concerning a test or procedure request that required a specimen to be collected." 
    )
    protected List<Reference> request;
    
    @Child(name="collection", order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Collection details", formalDefinition="Details concerning the specimen collection." )
    protected SpecimenCollectionComponent collection;
    
    @Child(name = "container", order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Direct container of specimen (tube/slide, etc.)", 
    	formalDefinition="The container holding the specimen.  The recursive nature of containers; " +
    		"i.e. blood in tube in tray in rack is not addressed here." 
    )
    protected List<SpecimenContainerComponent> container;
    
    @Block()
    public static class SpecimenCollectionComponent 
    		extends org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent {

		private static final long serialVersionUID=1L;
    	
		@Child(name="fastingStatus", order=Child.ORDER_UNKNOWN, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
	    @Description(
	    	shortDefinition="Active or inactive ingredient", 
	    	formalDefinition="Identifies a particular constituent of interest in the product." 
	    )
	    protected List<FastingStatus> fastingStatus;
	    
		@Child(name="collector", type={CareConnectPractitioner.class}, 
			order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
        @Description(
        	shortDefinition="Who collected the specimen", formalDefinition="Person who collected the specimen.")
        protected Reference collector;
    }
    
    @Block()
    public static class FastingStatus extends BackboneElement {

		private static final long serialVersionUID=1L;
		
		@Child(name="descriptionId")
		private org.hl7.fhir.dstu3.model.Extension descriptionId;
		
		@Child(name="descriptionDisplay")
		private org.hl7.fhir.dstu3.model.Extension descriptionDisplay;
		
		private static final UriType url=new UriType(
				"https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-coding-sctdescid");
		
		@Override
		public BackboneElement copy() {
			FastingStatus copy = new FastingStatus();
			copy.id = id;
			copy.descriptionId = descriptionId;
			copy.descriptionDisplay = descriptionDisplay;
			
			return copy;
		}
    }
    
    @Block()
    public static class SpecimenContainerComponent 
    		extends org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent {

		private static final long serialVersionUID = 1L;
    	
		@Child(name = "identifier", type = {CareConnectIdentifier.class}, 
			order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(
        	shortDefinition="Id for the container", 
        	formalDefinition="Id for container. There may be multiple; a manufacturer's bar code, " +
        		"lab assigned identifier, etc. The container ID may differ from the specimen id in some circumstances." 
        )
        protected List<CareConnectIdentifier> identifier;
    }
}
