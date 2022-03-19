package dam.gala.damgame.model;

public class Answer {
    private int numeroPregunta;
    private int curso;
    private int asignatura;
    private int numero;
    private String respuesta;
    private int correcta;

    public Answer(int numeroPregunta, int curso, int asignatura, int numero, String respuesta, int correcta) {
        this.numeroPregunta = numeroPregunta;
        this.curso = curso;
        this.asignatura = asignatura;
        this.numero = numero;
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    public int getNumeroPregunta() {
        return numeroPregunta;
    }

    public int getCurso() {
        return curso;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public int getNumero() {
        return numero;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public int getCorrecta() {
        return correcta;
    }
}
