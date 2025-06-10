public class Reader {
    public String name;
    public String idCard;
    public String email;
    public Reader(String name, String idCard, String email) {
        this.name = name;
        this.idCard = idCard;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getIdCard() {
        return idCard;
    }
    public String getEmail() {
        return email;
    }
    public String toString() {
        return "Lector: " + name + " | Carnet: " + idCard + " | Email: " + email;
    }
}


