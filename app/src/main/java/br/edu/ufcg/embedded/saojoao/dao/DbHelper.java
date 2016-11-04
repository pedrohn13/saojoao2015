package br.edu.ufcg.embedded.saojoao.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Pedro on 18/05/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String EVENTO = "EVENTO";
    public static final String DIA = "dia";
    public static final String NOME = "nome";
    public static final String FAVORITO = "favorito";
    private static final int DB_VERSION = 9;
    private static final String DB_NAME = "APP_BD";

    public static final String CINCO_JUN = "05/06/2015";
    public static final String SEIS_JUN = "06/06/2015";
    public static final String SETE_JUN = "07/06/2015";
    public static final String OITO_JUN = "08/06/2015";
    public static final String NOVE_JUN = "09/06/2015";
    public static final String DEZ_JUN = "10/06/2015";
    public static final String ONZE_JUN = "11/06/2015";
    public static final String DOZE_JUN = "12/06/2015";
    public static final String TREZE_JUN = "13/06/2015";
    public static final String QUATORZE_JUN = "14/06/2015";
    public static final String QUINZE_JUN = "15/06/2015";
    public static final String DEZESEIS_JUN = "16/06/2015";
    public static final String DEZESSETE_JUN = "17/06/2015";
    public static final String DEZOITO_JUN = "18/06/2015";
    public static final String DEZENOVE_JUN = "19/06/2015";
    public static final String VINTE_JUN = "20/06/2015";
    public static final String VINTE_UM_JUN = "21/06/2015";
    public static final String VINTE_DOIS_JUN = "22/06/2015";
    public static final String VINTE_TRES_JUN = "23/06/2015";
    public static final String VINTE_QUATRO_JUN = "24/06/2015";
    public static final String VINTE_CINCO_JUN = "25/06/2015";
    public static final String VINTE_SEIS_JUN = "26/06/2015";
    public static final String VINTE_SETE_JUN = "27/06/2015";
    public static final String VINTE_OITO_JUN = "28/06/2015";
    public static final String VINTE_NOVE_JUN = "29/06/2015";
    public static final String TRINTA_JUN = "30/06/2015";
    public static final String UM_JUL = "01/07/2015";
    public static final String DOIS_JUL = "02/07/2015";
    public static final String TRES_JUL = "03/07/2015";
    public static final String QUATRO_JUL = "04/07/2015";
    public static final String CINCO_JUL = "05/07/2015";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        createTables(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int oldVersion, int newVersion) {
        dropTables(dataBase);
        createTables(dataBase);
    }

    private void createTables(SQLiteDatabase dataBase) {
        Log.i(DB_NAME, "Criando Tabelas do Banco de Dados");
        dataBase.execSQL("CREATE TABLE " + EVENTO + "(_id integer primary key autoincrement, " + NOME + " text, " + DIA + " text, " + FAVORITO + " integer);");
        insertEventos(dataBase);
    }

    private void dropTables(SQLiteDatabase dataBase) {
        Log.i(DB_NAME, "Removendo Tabelas do Banco de Dados");
        dataBase.execSQL("DROP TABLE IF EXISTS " + EVENTO);
    }

    private void insertEventos(SQLiteDatabase dataBase) {
        dataBase.execSQL(createInsertEventoQuery("Biliu de Campina", CINCO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Jairo Madruga", CINCO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Luan e Forró Estilizado", CINCO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Os Três do Nordeste", CINCO_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Trio Os Caba de Lampião", SEIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Erika Marques", SEIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Tom Oliveira", SEIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Flávio José", SEIS_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Culé de Chá", SETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Banda Palov", SETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Gabriel Diniz", SETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Felipe Lemos", SETE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("", OITO_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Sandra Belê", NOVE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Eloisa Olinto", NOVE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Lara Amélia", NOVE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Galã pense numa farra", DEZ_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Forrozão Karkará", DEZ_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Ramon Schinayder", DEZ_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Jurandir da Feira", ONZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Assisão", ONZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Vinicius e Sobral", ONZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Cavaleiros do Forró", ONZE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Os Nonatos", DOZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Alexandre Tan", DOZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Geovane Júnior", DOZE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Os Três do Nordeste", TREZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Capilé", TREZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Coroné Grilo", TREZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Forró Bakana", TREZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("João Marcelo e Juliano", TREZE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Diogo Cirne", QUATORZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Edgley Miguel", QUATORZE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Dorgival Dantas", QUATORZE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("", QUINZE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Impacto X", DEZESEIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Forró Kent", DEZESEIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Forró Instigação", DEZESEIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Levada Mix", DEZESEIS_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Fabiano Guimarães", DEZESSETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Afrodite", DEZESSETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Aviões do Forró", DEZESSETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Forró pra Curtir", DEZESSETE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Raniere Gomes", DEZOITO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Cicinho Lima", DEZOITO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Bonde do Brasil", DEZOITO_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Poeta Francinaldo", DEZENOVE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Nando Cordel", DEZENOVE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Amazan", DEZENOVE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Iohannes Forró do Imperador", DEZENOVE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Pinto do Acordeon", VINTE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Genival Lacerda", VINTE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Os Gonzagas", VINTE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Forró do Chefe", VINTE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Joverlaine e Mania de Sertanejo", VINTE_UM_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Novinho da Paraíba", VINTE_UM_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("GG e Banda Forró do Gordinho", VINTE_UM_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Forró da Barka", VINTE_UM_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Orquestra Sanfônica Balaio Nordeste", VINTE_DOIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Luisinho Cartaxo", VINTE_DOIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Beto Brito", VINTE_DOIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Tribo Cordel", VINTE_DOIS_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Antônio Barros e Cecéu & Mayra", VINTE_TRES_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Tony Dumond", VINTE_TRES_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Elba Ramalho", VINTE_TRES_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Capilé", VINTE_TRES_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Biliu de Campina", VINTE_QUATRO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Chico Sales", VINTE_QUATRO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Mara Pavanely", VINTE_QUATRO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Saia Justa", VINTE_QUATRO_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Zé Calixto", VINTE_CINCO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Netinho Lins", VINTE_CINCO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Banda Magia", VINTE_CINCO_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Candeeiro Natural", VINTE_SEIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Edmar Miguel", VINTE_SEIS_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Espora de Ouro", VINTE_SEIS_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Forró Sacaneado", VINTE_SETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Shilton Fernandes", VINTE_SETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("João Lima", VINTE_SETE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Banda Encantus", VINTE_SETE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Feitiço de Menina", VINTE_OITO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Renata Arruda", VINTE_OITO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Alceu Valença", VINTE_OITO_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Solteirões do Forró", VINTE_OITO_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Coco Seco", VINTE_NOVE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Chambinho", VINTE_NOVE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Gente Boa", VINTE_NOVE_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Forrozão das Antigas", VINTE_NOVE_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("CAE Helena Holanda", TRINTA_JUN, 0));
        dataBase.execSQL(createInsertEventoQuery("Pe. Fábio de Melo", TRINTA_JUN, 0));

        dataBase.execSQL(createInsertEventoQuery("Marcos Freire e Banda", UM_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Matheus Filipe e Forró Ousado", UM_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Bruno Melo", UM_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Desejo de Menina", UM_JUL, 0));

        dataBase.execSQL(createInsertEventoQuery("Euzébio Rocha", DOIS_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Vates e Viola", DOIS_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Magníficos", DOIS_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Cabruêra", DOIS_JUL, 0));

        dataBase.execSQL(createInsertEventoQuery("Inaudete Amorim", TRES_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Edra Veras", TRES_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Coleguinhas", TRES_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Geraldinho Lins", TRES_JUL, 0));

        dataBase.execSQL(createInsertEventoQuery("Coroné Grilo", QUATRO_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Forró Zueira", QUATRO_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Waldonys", QUATRO_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Saia Rodada", QUATRO_JUL, 0));

        dataBase.execSQL(createInsertEventoQuery("Raiany Stefanny", CINCO_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Forró da Manha", CINCO_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Garota Safada", CINCO_JUL, 0));
        dataBase.execSQL(createInsertEventoQuery("Leon Lima", CINCO_JUL, 0));

    }

    private String createInsertEventoQuery(String nome, String timeStamp, Integer favorito) {
        return "INSERT INTO " + EVENTO + "(" + NOME + "," + DIA + "," + FAVORITO + ") VALUES('" + nome + "','" + timeStamp + "'," + favorito + ");";
    }
}
