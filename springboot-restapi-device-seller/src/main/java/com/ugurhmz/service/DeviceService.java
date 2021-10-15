package com.ugurhmz.service;


import com.ugurhmz.dto.DeviceDTO;
import com.ugurhmz.model.Device;
import com.ugurhmz.repository.DeviceRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
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


    // FIND ALL DEVICES
    public List<DeviceDTO> findAllDevices(){
       return deviceRepository.findAll().stream().map( device -> modelMapper.map( device, DeviceDTO.class)).collect(Collectors.toList());
    }




    // DELETE DEVICE
    @SneakyThrows
    @Transactional
    public void deleteUser(Long id)  {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found!!"));
        deviceRepository.deleteById(device.getId());

    }

}
