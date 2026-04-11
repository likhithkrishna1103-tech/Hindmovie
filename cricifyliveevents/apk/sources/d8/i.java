package d8;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import j9.p;
import java.util.HashMap;
import qb.k1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements f8.b, e8.g, hc.a, j9.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f3548v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3549w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3550x;

    public /* synthetic */ i(Object obj, long j4, Object obj2) {
        this.f3549w = obj;
        this.f3548v = j4;
        this.f3550x = obj2;
    }

    @Override // e8.g, ta.f
    public Object apply(Object obj) {
        String str = (String) this.f3549w;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i = ((a8.c) this.f3550x).f348v;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
        try {
            boolean z10 = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j4 = this.f3548v;
            if (z10) {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j4 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i));
            contentValues.put("events_dropped_count", Long.valueOf(j4));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // j9.a
    public Object c(p pVar) {
        return ((rc.g) this.f3549w).b(pVar, this.f3548v, (HashMap) this.f3550x);
    }

    @Override // f8.b
    public Object g() {
        j jVar = (j) this.f3549w;
        x7.i iVar = (x7.i) this.f3550x;
        e8.d dVar = (e8.d) jVar.f3553c;
        long jL = ((g8.a) jVar.f3556g).l() + this.f3548v;
        e8.i iVar2 = (e8.i) dVar;
        iVar2.getClass();
        iVar2.q(new e8.f(jL, iVar));
        return null;
    }

    @Override // hc.a
    public void j(hc.b bVar) {
        ((kb.a) bVar.get()).d((String) this.f3549w, this.f3548v, (k1) this.f3550x);
    }

    public /* synthetic */ i(Object obj, Object obj2, long j4) {
        this.f3549w = obj;
        this.f3550x = obj2;
        this.f3548v = j4;
    }
}
