package com.ugurhmz.services;


import com.ugurhmz.dto.PersonDTO;
import com.ugurhmz.model.Address;
import com.ugurhmz.model.Person;
import com.ugurhmz.repository.AddressRepository;
import com.ugurhmz.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;
    private final AddressRepository addressRepo;



    // SAVE
    @Transactional  // Tek seferder db'ye ya uygular, ya uygulamaz.
    public PersonDTO save(PersonDTO personDTO) {

        Person person = new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());

        final Person personDB = personRepo.save(person);

        List<Address> addressesList = new ArrayList<>();

        personDTO.getAddressesStringList().forEach(item -> {
                Address address = new Address();
                address.setPersonAdress(item);
                address.setAddressType(Address.AddressType.OTHER);
                address.setEnabled(true);
                address.setPerson(personDB);
                addressesList.add(address);
        });

        addressRepo.saveAll(addressesList);
        personDTO.setId(personDB.getId());

        return personDTO;
    }



    // READ ALL
    public List<PersonDTO> findAll(){

       List<Person> personDBList =   personRepo.findAll();
       List<PersonDTO> personDTOS = new ArrayList<>();


       // dto çevirme
       personDBList.forEach(i -> {

           PersonDTO personDTO = new PersonDTO();
           personDTO.setId(i.getId());
           personDTO.setFirstName(i.getFirstName());
           personDTO.setLastName(i.getLastName());

           personDTO.setAddressesStringList(i.getAddressesOfPersons().stream()
                    .map(Address::getPersonAdress).collect(Collectors.toList()));

           personDTOS.add(personDTO);
       });

       return personDTOS;
    }

    // DELETE
    public void delete(Long id) {

    }

/*
    // READ ALL WITH PAGE
    Page<PersonDTO>   findPageAll(Pageable pageable){

    }
*/

}
