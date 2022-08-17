package de.gie.tool.commontasks.general;

import de.gie.tool.commontasks.url.alias.AliasController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Root path controller
 */
@RestController
@RequestMapping
public class GeneralController {

    private AliasController aliasController;

    @Autowired
    public GeneralController(AliasController aliasController) {
        this.aliasController = aliasController;
    }


    @GetMapping(path = "/{name}")
    public ResponseEntity<HttpHeaders> goToUrl(@PathVariable String name){
        return aliasController.redirect(name);
    }

}
