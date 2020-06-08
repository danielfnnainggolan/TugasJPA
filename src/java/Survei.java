
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

// https://stackoverflow.com/questions/22658185/java-lang-classnotfoundexception-javax-faces-webapp-facesservlet
// https://stackoverflow.com/questions/15113628/java-lang-classnotfoundexception-javax-servlet-jsp-jstl-core-config
@ManagedBean
public class Survei {
    private String namaDepan, namaBelakang, alamat, kotaKab, provinsiNeBag, email;
    private Date tanggalSurvei;

    private String radioButtonInput, dropdownInput, Komentar;
    private String[] checkBoxInput;

    private String kodePos, nomorTelepon;
    private boolean isFormFilled = false;

    public boolean getIsFormFilled() {
        return isFormFilled;
    }

    public void setIsFormFilled(boolean formFilled) {
        this.isFormFilled = formFilled;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String[] getCheckBoxInput() {
        return checkBoxInput;
    }

    public String getRadioButtonInput() {
        return radioButtonInput;
    }

    public String getDropdownInput() {
        return dropdownInput;
    }

    public String getKomentar() {
        return Komentar == null ? "Tidak ada tambahan" : Komentar;
    }

    public void setCheckBoxInput(String[] checkBoxInput) {
        this.checkBoxInput = checkBoxInput;
    }

    public void setRadioButtonInput(String radioButtonInput) {
        this.radioButtonInput = radioButtonInput;
    }

    public void setKomentar(String commentInput) {
        this.Komentar = Komentar;
    }
    ///////////////////////////////////////////////////////
    public Date getTanggalSurvei() {
        if (tanggalSurvei == null) {
            tanggalSurvei = new Date();
        }
        return tanggalSurvei;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKotaKab() {
        return kotaKab;
    }

    public String getProvinsiNeBag() {
        return provinsiNeBag;
    }

    public String getEmail() {
        return email;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setKotaKab(String kotaKab) {
        this.kotaKab = kotaKab;
    }

    public void setProvinsiNeBag(String provinsiNeBag) {
        this.provinsiNeBag = provinsiNeBag;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTanggalSurvei(Date tanggalSurvei) {
        this.tanggalSurvei = tanggalSurvei;
    }
    /////////////////////////////////////////////////////

    public String submitData() {
        // Validasi Tanggal
        Date today = new Date();
        if (!DateUtils.isSameDay(today, this.tanggalSurvei)) {
            FacesMessage errorMessage = new FacesMessage("Tanggal harus sesuai tanggal hari ini!");
            errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, errorMessage);
            return(null);
        }
        this.isFormFilled = true;
        return("form-result");
    }

}
