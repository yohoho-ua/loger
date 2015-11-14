package domain;

import java.util.Date;


public class Note {
    private int id;
    private String uuid;
    private String title;
    private Date date_created;
    private Date date_updated;
    private String owner;
    private String catalog;
    private String content;

    public Note() {
    }

    public Note(int id, String uuid, String title, Date date_created, Date date_updated, String owner, String catalog, String content) {
        this.id = id;
        this.uuid = uuid;
        this.title = title;
        this.date_created = date_created;
        this.date_updated = date_updated;
        this.owner = owner;
        this.catalog = catalog;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //temp method for testing purposes


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Note{");
        sb.append("id=").append(id);
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", date_created=").append(date_created);
        sb.append(", date_updated=").append(date_updated);
        sb.append(", owner='").append(owner).append('\'');
        sb.append(", catalog='").append(catalog).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
