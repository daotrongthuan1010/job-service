package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.dto.address.AddressDTO;
import com.job.future.jobservice.repository.repositoryIpm.AddressAPIExternal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceIpm {



    private final AddressAPIExternal apiExternal;

    public void save(String searchKeyword){

        List<AddressDTO> addressDTOS = apiExternal.getAddress(searchKeyword);
        System.out.println(addressDTOS);


    }




}
