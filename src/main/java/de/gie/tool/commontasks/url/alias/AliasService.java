package de.gie.tool.commontasks.url.alias;

import de.gie.tool.commontasks.url.alias.model.Alias;
import de.gie.tool.commontasks.url.alias.model.AliasDTO;
import de.gie.tool.commontasks.url.alias.model.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Bussiness logic
 */
@Service
public class AliasService {

    private final AliasRepository aliasRepository;

    @Autowired
    public AliasService(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }

    public List<Alias> getAliases(){
        return aliasRepository.findAll();
    }

    public Boolean add(AliasDTO aliasDTO){

        // check if aliasName already there
        if (aliasRepository.findByAliasName(aliasDTO.getAliasName()).size() != 0 ) {
            return false;
        }

        Alias newAlias = new Alias(aliasDTO.getLongUrl(), aliasDTO.getAliasName(), aliasDTO.getDuration());
        return aliasRepository.save(newAlias) != null;
    }

    public boolean delete(){
        return false;
    }

    public String getLongUrl(String shortName){
        List<Alias> foundedAliases = aliasRepository.findByAliasName(shortName);
        if (foundedAliases.size() != 1){
            return null;
        }

        return foundedAliases.get(0).getLongUrl();
    }


}
