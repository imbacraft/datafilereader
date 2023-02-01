package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Header {

  private static char recordIdentifier = '#';
  private String dataFileIdentifier;
  private double specificationVersion;
  private LocalDate dateOfGeneration;
  private LocalTime time;
  private LocalDate startDate;
  private LocalDate endDate;

  public Header(
      String dataFileIdentifier,
      double specificationVersion,
      LocalDate dateOfGeneration,
      LocalTime time,
      LocalDate startDate,
      LocalDate endDate) {
    this.dataFileIdentifier = dataFileIdentifier;
    this.specificationVersion = specificationVersion;
    this.dateOfGeneration = dateOfGeneration;
    this.time = time;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public static char getRecordIdentifier() {
    return recordIdentifier;
  }

  public static void setRecordIdentifier(char recordIdentifier) {
    Header.recordIdentifier = recordIdentifier;
  }

  public static char getRecordidentifier() {
    return recordIdentifier;
  }

  public String getDataFileIdentifier() {
    return dataFileIdentifier;
  }

  public void setDataFileIdentifier(String dataFileIdentifier) {
    this.dataFileIdentifier = dataFileIdentifier;
  }

  public double getSpecificationVersion() {
    return specificationVersion;
  }

  public void setSpecificationVersion(double specificationVersion) {
    this.specificationVersion = specificationVersion;
  }

  public LocalDate getDateOfGeneration() {
    return dateOfGeneration;
  }

  public void setDateOfGeneration(LocalDate dateOfGeneration) {
    this.dateOfGeneration = dateOfGeneration;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "Header [recordIdentifier="
        + recordIdentifier
        + ", dataFileIdentifier="
        + dataFileIdentifier
        + ", specificationVersion="
        + specificationVersion
        + ", dateOfGeneration="
        + dateOfGeneration
        + ", time="
        + time
        + ", startDate="
        + startDate
        + ", endDate="
        + endDate
        + "]";
  }
}
