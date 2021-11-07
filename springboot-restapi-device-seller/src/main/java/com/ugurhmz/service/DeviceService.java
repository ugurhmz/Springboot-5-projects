package com.ugurhmz.service;


import com.ugurhmz.dto.DeviceDTO;
import com.ugurhmz.model.Device;
import com.ugurhmz.repository.DeviceRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;




    // SAVE DEVICE
    public DeviceDTO saveDevice(DeviceDTO deviceDTO) {
        Device device =  modelMapper.map(deviceDTO, Device.class);

        device.setCreationTime(LocalDateTime.now());
        return modelMapper.map(deviceRepository.save(device), DeviceDTO.class);

    }


    // PAGINATION ALL DEVICES
    public List<DeviceDTO> paginationWithPageable(Pageable pageable) {
        //1- Listeyi komple al.
        Page<Device>  pageDevicesList = deviceRepository.findAll(pageable);


        //2- Listeyi stream ile akışa sok, dtoya çevir,  sonrada dto liste dönüştür.
        List<DeviceDTO> deviceDTOS = pageDevicesList.stream().map( device -> modelMapper.map(device, DeviceDTO.class)).collect(Collectors.toList());


        return deviceDTOS;
    }


    // DELETE DEVICE
    @SneakyThrows
    @Transactional
    public Boolean deleteDevice(Long id)  {
        Optional<Device>  getDeviceByIdForDelete = deviceRepository.findById(id);

        if(getDeviceByIdForDelete.isPresent()){
            deviceRepository.deleteById(id);
            return true;
        }

        return false;
    }


}
