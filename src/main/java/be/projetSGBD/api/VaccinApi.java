/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package be.projetSGBD.api;

import java.math.BigDecimal;
import be.projetSGBD.model.Vaccin;
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
@Api(value = "Vaccin", description = "the Vaccin API")
public interface VaccinApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/addVaccin : Create the vaccin
     * Create the vaccin
     *
     * @param vaccin vaccin object (optional)
     * @return created (status code 201)
     */
    @ApiOperation(value = "Create the vaccin", nickname = "createVaccin", notes = "Create the vaccin", tags={ "Vaccin", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "created") })
    @RequestMapping(value = "/api/v1/addVaccin",
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Vaccin> createVaccin(@ApiParam(value = "vaccin object"  )  @Valid @RequestBody(required = false) Vaccin vaccin) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/vaccin/{idVaccin} : Delete the vaccin
     * Deletes the vaccin
     *
     * @param idVaccin vaccin id (required)
     * @return successful operation (status code 204)
     *         or Given user ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Delete the vaccin", nickname = "deleteVaccin", notes = "Deletes the vaccin", tags={ "Vaccin", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "successful operation"),
        @ApiResponse(code = 404, message = "Given user ID doesn't exist") })
    @RequestMapping(value = "/api/v1/vaccin/{idVaccin}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteVaccin(@ApiParam(value = "vaccin id",required=true) @PathVariable("idVaccin") Long idVaccin) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/vaccin/{idVaccin} : Returns the vaccin
     * Returns the vaccin
     *
     * @param idVaccin vaccin Identifier (required)
     * @return successful operation (status code 200)
     *         or Given user ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Returns the vaccin", nickname = "getVaccinByIdVaccin", notes = "Returns the vaccin", tags={ "Vaccin", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 404, message = "Given user ID doesn't exist") })
    @RequestMapping(value = "/api/v1/vaccin/{idVaccin}",
        method = RequestMethod.GET)
    default ResponseEntity<Vaccin> getVaccinByIdVaccin(@ApiParam(value = "vaccin Identifier",required=true) @PathVariable("idVaccin") Integer idVaccin) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
