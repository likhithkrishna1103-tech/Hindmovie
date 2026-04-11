package e8;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import k4.b0;
import k4.c1;
import k4.s;
import ua.i0;
import v1.g0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements g, c1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f3837v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3838w;

    public /* synthetic */ f(long j4, x7.i iVar) {
        this.f3837v = j4;
        this.f3838w = iVar;
    }

    @Override // e8.g, ta.f
    public Object apply(Object obj) {
        x7.i iVar = (x7.i) this.f3838w;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f3837v));
        String str = iVar.f14434a;
        u7.d dVar = iVar.f14436c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(h8.a.a(dVar))}) < 1) {
            contentValues.put("backend_name", iVar.f14434a);
            contentValues.put("priority", Integer.valueOf(h8.a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    @Override // k4.c1
    public Object i(b0 b0Var, s sVar, int i) {
        return b0Var.q(sVar, i0.o((g0) this.f3838w), 0, this.f3837v);
    }

    public /* synthetic */ f(g0 g0Var, long j4) {
        this.f3838w = g0Var;
        this.f3837v = j4;
    }
}
