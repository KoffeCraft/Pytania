package com.lusia.pytania;

public class Pytanie {
    private int idobrazka;
    private String trescPytania;
    private boolean odpowiedz;
    private String podpowiedz;
    private boolean czyOdpOk;

    public Pytanie(int idobrazka, String trescPytania, boolean odpowiedz, String podpowiedz) {
        this.idobrazka = idobrazka;
        this.trescPytania = trescPytania;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
        this.czyOdpOk = false;
    }

    public int getIdobrazka() {
        return idobrazka;
    }

    public void setIdobrazka(int idobrazka) {
        this.idobrazka = idobrazka;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(boolean odpowiedz) {
        this.odpowiedz = odpowiedz;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public void setPodpowiedz(String podpowiedz) {
        this.podpowiedz = podpowiedz;
    }

    public void setCzyOdpOk(boolean czyOdpOk) {
        this.czyOdpOk = czyOdpOk;
    }
}
