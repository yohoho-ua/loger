package domain;


public class Catalog {
    private String uuid;
    private String name;
    private String parentUuid;

    public Catalog() {
    }

    public Catalog(String uuid, String name, String parentUuid) {
        this.uuid = uuid;
        this.name = name;
        this.parentUuid = parentUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }
}
