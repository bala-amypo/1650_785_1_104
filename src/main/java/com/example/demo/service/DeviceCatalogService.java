public interface DeviceCatalogService {
    DeviceCatalogItem save(DeviceCatalogItem d);
    List<DeviceCatalogItem> findAll();
}