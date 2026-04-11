package i7;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import b7.s;
import c7.j;
import g4.u0;
import java.util.HashMap;
import o8.o;
import wa.k1;
import yb.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements k7.b, j7.e, nb.a, o8.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ long f6461u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6462v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f6463w;

    public /* synthetic */ f(Object obj, long j5, Object obj2) {
        this.f6462v = obj;
        this.f6461u = j5;
        this.f6463w = obj2;
    }

    @Override // j7.e
    public Object apply(Object obj) {
        String str = (String) this.f6462v;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i = ((f7.c) this.f6463w).f4800u;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
        try {
            boolean z2 = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j5 = this.f6461u;
            if (z2) {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j5 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i));
            contentValues.put("events_dropped_count", Long.valueOf(j5));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // o8.a
    public Object b(o oVar) {
        return ((g) this.f6462v).b(oVar, this.f6461u, (HashMap) this.f6463w);
    }

    @Override // nb.a
    public void c(nb.b bVar) {
        ((qa.a) bVar.get()).d((String) this.f6462v, this.f6461u, (k1) this.f6463w);
    }

    @Override // k7.b
    public Object h() {
        s sVar = (s) this.f6462v;
        j jVar = (j) this.f6463w;
        j7.d dVar = (j7.d) sVar.f1900c;
        long jG = ((l7.a) sVar.f1903g).g() + this.f6461u;
        j7.g gVar = (j7.g) dVar;
        gVar.getClass();
        gVar.v(new u0(jG, jVar));
        return null;
    }

    public /* synthetic */ f(Object obj, Object obj2, long j5) {
        this.f6462v = obj;
        this.f6463w = obj2;
        this.f6461u = j5;
    }
}
