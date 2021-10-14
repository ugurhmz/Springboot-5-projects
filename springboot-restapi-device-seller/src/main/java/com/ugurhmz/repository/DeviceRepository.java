package com.ugurhmz.repository;


import com.ugurhmz.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
