/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package be.projetSGBD.api;

import java.math.BigDecimal;
import be.projetSGBD.model.Planning;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
@Api(value = "Planning", description = "the Planning API")
public interface PlanningApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/addPlanning : Create the Planning
     * Create the Planning
     *
     * @param planning Planning object (optional)
     * @return created (status code 201)
     */
    @ApiOperation(value = "Create the Planning", nickname = "createPlanning", notes = "Create the Planning", tags={ "Planning", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "created") })
    @RequestMapping(value = "/api/v1/addPlanning",
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Planning> createPlanning(@ApiParam(value = "Planning object"  )  @Valid @RequestBody(required = false) Planning planning) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/planning/{idPlanning} : Delete the Planning
     * Deletes the Planning
     *
     * @param idPlanning Planning id (required)
     * @return successful operation (status code 204)
     *         or Given user ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Delete the Planning", nickname = "deletePlanning", notes = "Deletes the Planning", tags={ "Planning", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "successful operation"),
        @ApiResponse(code = 404, message = "Given user ID doesn't exist") })
    @RequestMapping(value = "/api/v1/planning/{idPlanning}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deletePlanning(@ApiParam(value = "Planning id",required=true) @PathVariable("idPlanning") long idPlanning) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/planning/{idPlanning} : Returns the Planning
     * Returns the Planning
     *
     * @param idPlanning Planning Identifier (required)
     * @return successful operation (status code 200)
     *         or Given user ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Returns the Planning", nickname = "getPlanningByIdPlanning", notes = "Returns the Planning", tags={ "Planning", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 404, message = "Given user ID doesn't exist") })
    @RequestMapping(value = "/api/v1/planning/{idPlanning}",
        method = RequestMethod.GET)
    default ResponseEntity<Planning> getPlanningByIdPlanning(@ApiParam(value = "Planning Identifier",required=true) @PathVariable("idPlanning") long idPlanning) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
