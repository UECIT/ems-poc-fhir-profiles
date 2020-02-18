package org.hl7.fhir.dstu3.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class CareConnectIdentifierTest {

  @Test
  public void system() {
    CareConnectIdentifier identifier = new CareConnectIdentifier();
    identifier.setSystem("identsystem");

    assertThat(identifier.getSystem(), is("identsystem"));
    assertThat(identifier.getSystemElement().getValue(), is("identsystem"));
  }

  @Test
  public void systemEl() {
    CareConnectIdentifier identifier = new CareConnectIdentifier();
    identifier.setSystemElement(new UriType("identsystem"));

    assertThat(identifier.getSystem(), is("identsystem"));
    assertThat(identifier.getSystemElement().getValue(), is("identsystem"));
  }

  @Test
  public void value() {
    CareConnectIdentifier identifier = new CareConnectIdentifier();
    identifier.setValue("val");

    assertThat(identifier.getValue(), is("val"));
    assertThat(identifier.getValueElement().getValue(), is("val"));
  }

  @Test
  public void valueEl() {
    CareConnectIdentifier identifier = new CareConnectIdentifier();
    identifier.setValueElement(new StringType("val"));

    assertThat(identifier.getValue(), is("val"));
    assertThat(identifier.getValueElement().getValue(), is("val"));
  }

  @Test
  public void assigner() {
    CareConnectIdentifier identifier = new CareConnectIdentifier();
    identifier.setAssigner(new Reference("assignerRef"));

    assertThat(identifier.getAssigner().getReference(), is("assignerRef"));
  }
}