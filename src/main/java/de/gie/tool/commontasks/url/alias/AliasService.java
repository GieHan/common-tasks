package de.gie.tool.commontasks.url.alias;

import de.gie.tool.commontasks.url.alias.model.Alias;
import de.gie.tool.commontasks.url.alias.model.AliasDTO;
import de.gie.tool.commontasks.url.alias.model.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if (!aliasRepository.findByAliasName(aliasDTO.getAliasName()).isEmpty()) {
            return false;
        }

        Alias newAlias          = new Alias(aliasDTO.getLongUrl(), aliasDTO.getAliasName(), aliasDTO.getDuration());
        Optional<Alias> created = Optional.of(aliasRepository.save(newAlias));
        return  created.isPresent();
    }

    public boolean delete(){
        return false;
    }

    public Optional<String> getLongUrl(String shortName){
        List<Alias> foundedAliases = aliasRepository.findByAliasName(shortName);
        if (foundedAliases.size() != 1){
            return Optional.empty();
        }

        return Optional.ofNullable(foundedAliases.get(0).getLongUrl());
    }


}
