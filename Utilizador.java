
public class Utilizador {
    private String email;
    private String nome;
    private String password;
    private String morada;
    private String dataNascimento;

    public Utilizador() {
        email = "";
        nome = "";
        password = "";
        morada = "";
        dataNascimento = "";
    }

    public Utilizador(String email, String nom, String pass, String mor, String dataN) {
        this.email = email;
        this.nome = nom;
        this.password = pass;
        this.morada = mor;
        this.dataNascimento = dataN;
    }

    public Utilizador(Utilizador a) {
        email = a.getEmail();
        nome = a.getNome();
        password = a.getPassword();
        morada = a.getMorada();
        dataNascimento = a.getDataNascimento();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public String getMorada() {
        return morada;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setMorada(String m) {
        this.morada = m;
    }

    public void setDataNascimento(String data) {
        this.dataNascimento = data;
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Utilizador ac = (Utilizador) o;
        return ac.getEmail() == email && ac.getNome() == nome && ac.getPassword() == password
                && ac.getMorada() == morada && ac.getDataNascimento() == dataNascimento;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Email: " + email);
        s.append("Nome: " + nome);
        s.append("Password: " + password);
        s.append("Morada: " + morada);
        s.append("Data de Nascimento: " + dataNascimento);
        return s.toString();

    }

}
