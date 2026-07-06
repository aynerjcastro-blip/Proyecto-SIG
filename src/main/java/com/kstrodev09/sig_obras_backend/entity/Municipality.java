package com.kstrodev09.sig_obras_backend.entity;

public class Municipality {
    private Long id;
    private String name;
    private String department;
    private String daneCode;

    public Municipality() {
    }

    public Municipality(Long id, String name, String department, String daneCode) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.daneCode = daneCode;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDaneCode() {
        return daneCode;
    }

    public void setDaneCode(String daneCode) {
        this.daneCode = daneCode;
    }

    //Builder estatico (Reemplaza @Builder de lombok)
    public static class Builder {
        private Long id;
        private String name;
        private String department;
        private String daneCode;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder daneCode(String daneCode) {
            this.daneCode = daneCode;
            return this;
        }

        public Municipality build() {
            return new Municipality(id, name, department, daneCode);
        }
    }

    //Metodo toString para mostrar la información del municipio
    @Override
    public String toString() {
        return "Municipality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", daneCode='" + daneCode + '\'' +
                '}';
    }
    

}
