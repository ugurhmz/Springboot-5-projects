package com.ugurhmz.controller;


import com.ugurhmz.dto.DeviceDTO;
import com.ugurhmz.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/device")
@RequiredArgsConstructor
public class DeviceController {


    private final DeviceService deviceService;

    // SAVE DEVICE
    @PostMapping
    public ResponseEntity<DeviceDTO> saveDevice(@RequestBody DeviceDTO deviceDTO) {
        return new ResponseEntity<>(deviceService.saveDevice(deviceDTO), HttpStatus.CREATED);
    }


    // GET ALL DEVICE
    @GetMapping("/all-devices")
    public ResponseEntity<List<DeviceDTO>> getAllDevices(Pageable pageable){
            return ResponseEntity.ok(deviceService.paginationWithPageable(pageable));
    }


    // DELETE DEVICE
    @DeleteMapping("/{id}")
    public  ResponseEntity<Boolean> deleteDevice(@PathVariable("id") Long id){
        Boolean deleteStatus = deviceService.deleteDevice(id);

        return ResponseEntity.ok(deleteStatus);
    }

}


















