package ejercicio4;

public class ReservaTestable extends Reserva{
    private String validLogin;
    private String validPassword;

    private Usuario validUser;


    public void setValidLogin(String validLogin){
        this.validLogin = validLogin;
    }

    public void setValidPassword(String validPassword){
        this.validPassword = validPassword;
    }

    public void setValidUser(Usuario validUser){
        this.validUser =  validUser;
    }


}
