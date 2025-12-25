
// package com.example.demo.service;

// import com.example.demo.model.DeviceCatalogItem;
// import java.util.List;

// public interface DeviceCatalogService {

//     DeviceCatalogItem create(DeviceCatalogItem item);

//     DeviceCatalogItem getById(Long id);

//     List<DeviceCatalogItem> getAll();

//     DeviceCatalogItem update(Long id, DeviceCatalogItem item);

//     void delete(Long id);
// }
// public interface DeviceCatalogService {
//     DeviceCatalogItem createItem(DeviceCatalogItem item);
//     List<DeviceCatalogItem> getAllItems();
//     DeviceCatalogItem updateActiveStatus(Long id, boolean active);
// // }
// package com.example.demo.service;

// import com.example.demo.model.DeviceCatalogItem;
// import java.util.List;

// public interface DeviceCatalogService {

//     DeviceCatalogItem create(DeviceCatalogItem item);

//     List<DeviceCatalogItem> getAll();

//     DeviceCatalogItem deactivate(Long id);
// }
package com.example.demo.service;

import com.example.demo.model.DeviceCatalogItem;
import java.util.List;

public interface DeviceCatalogService {

    DeviceCatalogItem createItem(DeviceCatalogItem item);

    List<DeviceCatalogItem> getAllItems();

    DeviceCatalogItem updateActiveStatus(Long id, boolean active);
}
