package de.gie.tool.commontasks.url.alias;


import de.gie.tool.commontasks.general.exception.ApiRequestException;
import de.gie.tool.commontasks.url.alias.model.AliasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/alias")
public class AliasController {

    private final AliasService aliasService;

    @Autowired
    public AliasController(AliasService aliasService) {

        this.aliasService = aliasService;
    }

//    @GetMapping
    public ResponseEntity<HttpHeaders> redirect(String name){
        HttpHeaders httpHeaders = new HttpHeaders();
        Optional<String> longUrl          = aliasService.getLongUrl(name);


        if (longUrl.isEmpty()){
            throw new ApiRequestException("No alias for " + name, HttpStatus.NOT_FOUND);
        }

        try {
            URI redirectionURI      = new URI(longUrl.get());
            httpHeaders.setLocation(redirectionURI);
        } catch (URISyntaxException e) {
            throw new ApiRequestException("Something wrong with URI", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @PostMapping
    public ResponseEntity<AliasDTO> addAliases(@Validated @RequestBody AliasDTO aliasDTO){
        if (!aliasService.add(aliasDTO)){
            throw new ApiRequestException("Alias name (" + aliasDTO.getAliasName() + "), is already taken", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(aliasDTO, HttpStatus.OK);
    }

}
