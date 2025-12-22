public interface DeviceCatalogService {
    DeviceCatalogItem create(DeviceCatalogItem item);
    DeviceCatalogItem updateActive(Long id, Boolean active);
    List<DeviceCatalogItem> getAll();
}