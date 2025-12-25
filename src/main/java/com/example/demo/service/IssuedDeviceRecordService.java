
// package com.example.demo.service;

// import com.example.demo.model.IssuedDeviceRecord;

// import java.util.List;

// public interface IssuedDeviceRecordService {

//     int countActiveDeviceForEmployee(Long employeeId);

//     List<IssuedDeviceRecord> getDevicesByEmployeeId(Long employeeId);

//     IssuedDeviceRecord issueDevice(IssuedDeviceRecord record);

//     void deactivateDevice(Long id);
// // }
// public interface IssuedDeviceRecordService {
//     IssuedDeviceRecord returnDevice(Long id);
// }
package com.example.demo.service;

import com.example.demo.model.IssuedDeviceRecord;
import java.util.List;

public interface IssuedDeviceRecordService {

    IssuedDeviceRecord issueDevice(IssuedDeviceRecord record);

    IssuedDeviceRecord updateStatus(Long id, String status);

    IssuedDeviceRecord getById(Long id);

    List<IssuedDeviceRecord> getAllRecords();
}
