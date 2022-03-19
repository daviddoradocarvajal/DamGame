package dam.gala.damgame.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import dam.gala.damgame.model.Answer;
import dam.gala.damgame.model.Question;
import dam.gala.damgame.utils.GameUtil;

/**
 * Gestor de datos de las preguntas
 */
public class DatabaseManager {
    private SQLiteDatabase sqLiteDatabase;
    public DatabaseManager(DatabaseHelper databaseHelper){
        this.sqLiteDatabase = databaseHelper.getWritableDatabase();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Answer> answers = new ArrayList<>();
        Question question=null;
        Answer answer = null;

        Cursor qCursorQ = sqLiteDatabase.rawQuery("SELECT * FROM PREGUNTA",
                null);

        while(qCursorQ.moveToNext()) {
            question = new Question(qCursorQ.getInt(0), //numero
                    qCursorQ.getInt(1), //curso
                    qCursorQ.getInt(2), //asignatura
                    qCursorQ.getString(3), //enunciado
                    qCursorQ.getInt(4), //complejidad
                    qCursorQ.getInt(5)); //tipo
            questions.add(question);
        }
        qCursorQ.close();

        Cursor qCursorA = sqLiteDatabase.rawQuery("SELECT * FROM RESPUESTA;",
                null);

        while(qCursorA.moveToNext()) {
            answer = new Answer(qCursorA.getInt(0), //numero_pregunta
                    qCursorA.getInt(1), //curso
                    qCursorA.getInt(2), //asignatura
                    qCursorA.getInt(3), //numero
                    qCursorA.getString(4), //respuesta
                    qCursorA.getInt(5) //correcta
            );
            answers.add(answer);
        }
        qCursorA.close();

        for(Question q:questions){
            CharSequence[] ans= (CharSequence[]) answers.stream().filter(a -> a.getNumeroPregunta()==q.getNumero()
                    && a.getAsignatura()==q.getAsignatura() &&
                    a.getCurso()==q.getCurso()).map(Answer::getRespuesta).toArray(String[]::new);

            q.setRespuestas(ans);

            Integer[] ansOk= (Integer[]) answers.stream().filter(a -> a.getNumeroPregunta()==q.getNumero()
                    && a.getAsignatura()==q.getAsignatura() &&
                    a.getCurso()==q.getCurso()).map(Answer::getCorrecta).toArray(Integer[]::new);
            q.setRespuestasCorrectas(ansOk);
        }

        return questions;
    }
}