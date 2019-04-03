package gov.va.api.health.urgentcare.api;

import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.urgentcare.api.resources.OperationOutcome;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface CoverageEligibilityResponseApi {
  /* @Operation(
      summary = "Coverage Eligibility Response Read",
      description =
          "https://www.hl7.org/fhir/R4/coverageeligibilityresponse.html",
      tags = {"CoverageEligibilityResponse"}
  )
  @GET
  @Path("CoverageEligibilityResponse/{id}")
  @ApiResponse(
      responseCode = "200",
      description = "Record found",
      content =
      @Content(
          mediaType = "application/fhir+json",
          schema = @Schema(implementation = CoverageEligibilityResponse.class)
      )
  )
  @ApiResponse(
      responseCode = "404",
      description = "Not found",
      content =
      @Content(
          mediaType = "application/json+fhir",
          schema = @Schema(implementation = OperationOutcome.class)
      )
  )
  @ApiResponse(
      responseCode = "400",
      description = "Bad request",
      content =
      @Content(
          mediaType = "application/json+fhir",
          schema = @Schema(implementation = OperationOutcome.class)
      )
  )
  Coverage coverageEligibilityResponseRead(
      @Parameter(in = ParameterIn.PATH, name = "id", required = true) String id); */

  @Operation(
    summary = "Coverage Eligibility Response Search",
    description = "https://www.hl7.org/fhir/R4/coverageeligibilityresponse.html",
    tags = {"CoverageEligibilityResponse"}
  )
  @GET
  @Path("CoverageEligibilityResponse")
  @ApiResponse(
    responseCode = "200",
    description = "Record found",
    content =
        @Content(
          mediaType = "application/json+fhir",
          schema = @Schema(implementation = CoverageEligibilityResponse.Bundle.class)
        )
  )
  @ApiResponse(
    responseCode = "404",
    description = "Not found",
    content =
        @Content(
          mediaType = "application/json+fhir",
          schema = @Schema(implementation = OperationOutcome.class)
        )
  )
  @ApiResponse(
    responseCode = "400",
    description = "Bad request",
    content =
        @Content(
          mediaType = "application/json+fhir",
          schema = @Schema(implementation = OperationOutcome.class)
        )
  )
  CoverageEligibilityResponse.Bundle coverageEligibilityResponseSearch(
      @Parameter(in = ParameterIn.QUERY, required = true, name = "patient") String id,
      @Parameter(in = ParameterIn.QUERY, name = "page") @DefaultValue("1") int page,
      @Parameter(in = ParameterIn.QUERY, name = "_count") @DefaultValue("15") int count);
}
