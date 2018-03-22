package workshop.model;

public enum Departamento {
    ADMINISTRATIVO("Administrativo"),
    FINANCEIRO("Financeiro"),
    RH("RH"),
    COMERCIAL("Comercial"),
    OPERACIONAL("Operacional");

    private String departamento;

    Departamento(String departamento) {
        this.departamento = departamento;
    }

    public String get() {
        return departamento;
    }

    @Override
    public String toString() {
        return departamento;
    }
}
