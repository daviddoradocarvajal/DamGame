package dam.gala.damgame.model;

import dam.gala.damgame.utils.GameUtil;

/**
 * Pregunta
 * @author 2º DAM - IES Antonio Gala
 * @version 1.0
 */
public class Question {
    private String enunciado;
    private int complejidad;
    private int tipo;
    private CharSequence[]respuestas;
    private Integer[] respuestasCorrectas;
    private int puntos;
    private int curso;
    private int asignatura;
    private int numero;
    //TODO este constructor es provisional, habrá que quitarlo cuando se tengan las preguntas
    //de las preguntas
    public Question(){

    }
    /**
     * Construye una pregunta a partir de las propiedades indicadas como parámetros
     * @param enunciado Enunciado de la pregunta
     * @param complejidad Complejidad de la pregunta (ALTA O BAJA)
     * @param tipo Tipo de pregunta (respuesta simple o respuesta múltiple)
     */
    public Question(int numero,int curso, int asignatura, String enunciado, int complejidad
            , int tipo){
        this.enunciado=enunciado;
        this.complejidad = complejidad;
        this.tipo = tipo;
        this.puntos = complejidad ==
                GameUtil.PREGUNTA_COMPLEJIDAD_ALTA?GameUtil.PUNTOS_PREGUNTA_COMPLEJA:
                GameUtil.PUNTOS_PREGUNTA_SENCILLA;
        this.asignatura = asignatura;
        this.numero = numero;
        this.curso = curso;
    }

    //-----------------------------------------------------------------------------------------
    //Métodos getter y setter para propiedades la pregunta
    //-----------------------------------------------------------------------------------------
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public CharSequence[] getRespuestas() {
        return respuestas;
    }

    public Integer[] getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public int getPuntos() {
        return puntos;
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

    public void setRespuestas(CharSequence[] respuestas) {
        this.respuestas = respuestas;
    }

    public void setRespuestasCorrectas(Integer[] respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }
}
