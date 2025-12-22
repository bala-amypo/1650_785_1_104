// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.IssuedDeviceRecord;
// public interface IssuedDeviceRecordService {
//     IssuedDeviceRecord issue(IssuedDeviceRecord record);
//     IssuedDeviceRecord returnDevice(Long id);
//     List<IssuedDeviceRecord> getByEmployee(Long employeeId);
// }package com.example.demo.service;

// import com.example.demo.model.IssuedDeviceRecord;
// import java.util.List;

// public interface IssuedDeviceRecordService {
//     IssuedDeviceRecord issueDevice(IssuedDeviceRecord record);
//     void returnDevice(Long id);  // must be void
//     List<IssuedDeviceRecord> getAll();
//     List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId);
// }
package com.example.demo.service;

import com.example.demo.model.IssuedDeviceRecord;

import java.util.List;

public interface IssuedDeviceRecordService {
    IssuedDeviceRecord issueDevice(IssuedDeviceRecord record);
    void returnDevice(Long id);  // void type
    List<IssuedDeviceRecord> getAll();
    List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId);
}
