package app.cricfy.tv.room.db;

import android.content.Context;
import b6.f;
import com.bumptech.glide.c;
import w4.q;
import w4.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppDatabase extends t {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile AppDatabase f1573k;

    public static AppDatabase r(Context context) {
        if (f1573k == null) {
            synchronized (AppDatabase.class) {
                try {
                    if (f1573k == null) {
                        q qVarG = c.g(context.getApplicationContext(), AppDatabase.class, "favorites_db");
                        qVarG.f13983n = false;
                        qVarG.f13984o = true;
                        f1573k = (AppDatabase) qVarG.a();
                    }
                } finally {
                }
            }
        }
        return f1573k;
    }

    public abstract f q();
}
