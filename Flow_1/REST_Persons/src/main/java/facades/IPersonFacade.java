package facades;

import dtos.PersonDTO;
import errorhandling.PersonNotFoundException;

import java.util.List;

public interface IPersonFacade {
    public PersonDTO add(PersonDTO personDTO);
    public PersonDTO delete(Long id) throws PersonNotFoundException;
    public PersonDTO get(Long id);
    public List<PersonDTO> getAll();
    public PersonDTO edit(PersonDTO personDTO) throws PersonNotFoundException;
}
