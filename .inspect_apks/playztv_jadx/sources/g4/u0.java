package g4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u0 implements e1, j7.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ long f5229u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f5230v;

    public /* synthetic */ u0(long j5, c7.j jVar) {
        this.f5229u = j5;
        this.f5230v = jVar;
    }

    @Override // j7.e
    public Object apply(Object obj) {
        c7.j jVar = (c7.j) this.f5230v;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f5229u));
        String str = jVar.f2560a;
        z6.d dVar = jVar.f2562c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(m7.a.a(dVar))}) < 1) {
            contentValues.put("backend_name", jVar.f2560a);
            contentValues.put("priority", Integer.valueOf(m7.a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    @Override // g4.e1
    public Object g(b0 b0Var, s sVar, int i) {
        return b0Var.q(sVar, aa.j0.v((p1.g0) this.f5230v), 0, this.f5229u);
    }

    public /* synthetic */ u0(p1.g0 g0Var, long j5) {
        this.f5230v = g0Var;
        this.f5229u = j5;
    }
}
