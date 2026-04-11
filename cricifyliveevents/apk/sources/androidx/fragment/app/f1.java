package androidx.fragment.app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Surface;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.av1.Dav1dDecoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import k4.o1;
import v1.l1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f1 implements p0.b, f8.b, e2.g, a3.h, y1.m, z1.s, hb.e, k4.a0, k4.c1, y1.h, k4.a1, hc.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f985v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f986w;

    public /* synthetic */ f1(int i, Object obj) {
        this.f985v = i;
        this.f986w = obj;
    }

    @Override // y1.m
    public void a(Object obj) {
        switch (this.f985v) {
            case 9:
                ((v1.u0) obj).i((l1) this.f986w);
                break;
            case 10:
                ((v1.u0) obj).p((v1.c) this.f986w);
                break;
            case 11:
                ((v1.u0) obj).A((x1.c) this.f986w);
                break;
            case 12:
                ((v1.u0) obj).j(((g2.d0) this.f986w).f4651v.f4698j0);
                break;
            case 13:
                ((v1.u0) obj).r((v1.l0) this.f986w);
                break;
            case 14:
            case 15:
            default:
                s2.y yVar = (s2.y) this.f986w;
                h2.k kVar = (h2.k) obj;
                kVar.getClass();
                kVar.f5532w = yVar.f11367a;
                break;
            case 16:
                ((h2.k) obj).f5524o = (v1.p0) this.f986w;
                break;
            case 17:
                g2.f fVar = (g2.f) this.f986w;
                h2.k kVar2 = (h2.k) obj;
                kVar2.f5534y += fVar.f4673g;
                kVar2.f5535z += fVar.f4672e;
                break;
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        switch (this.f985v) {
            case 25:
                ((k4.h1) obj).f((v1.q0) this.f986w);
                break;
            default:
                ((k4.h1) obj).k((Surface) this.f986w);
                break;
        }
    }

    @Override // k4.a0
    public void b(k4.r rVar, int i) {
        rVar.k(i, (v1.s0) this.f986w);
    }

    @Override // z1.s
    public void c(long j4, y1.t tVar) {
        switch (this.f985v) {
            case 19:
                a3.b.d(j4, tVar, ((h4.d0) this.f986w).f5581c);
                break;
            default:
                a3.b.e(j4, tVar, ((h4.d0) this.f986w).f5581c);
                break;
        }
    }

    @Override // a3.h
    public long d(long j4) {
        a3.v vVar = (a3.v) this.f986w;
        return y1.a0.j((j4 * ((long) vVar.f235e)) / 1000000, 0L, vVar.f238j - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x05b1 A[Catch: Exception -> 0x05de, TryCatch #0 {Exception -> 0x05de, blocks: (B:115:0x04b0, B:117:0x0585, B:118:0x058a, B:120:0x05b1, B:122:0x05b9, B:124:0x05c7, B:126:0x05cd, B:128:0x05d6, B:129:0x05da), top: B:155:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x05e9  */
    @Override // hb.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(dd.c r57) {
        /*
            Method dump skipped, instruction units count: 1687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.f1.e(dd.c):java.lang.Object");
    }

    @Override // e2.g
    public void f(e2.h hVar) {
        ((Dav1dDecoder) this.f986w).releaseOutputBuffer((VideoDecoderOutputBuffer) hVar);
    }

    @Override // f8.b
    public Object g() {
        SQLiteDatabase sQLiteDatabaseA;
        int i = this.f985v;
        Object obj = this.f986w;
        switch (i) {
            case 3:
                e8.i iVar = (e8.i) ((e8.c) obj);
                iVar.getClass();
                int i10 = a8.a.f338e;
                nc.p pVar = new nc.p();
                pVar.f9070b = null;
                pVar.f9071c = new ArrayList();
                pVar.f9072d = null;
                pVar.f9069a = "";
                HashMap map = new HashMap();
                sQLiteDatabaseA = iVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    a8.a aVar = (a8.a) e8.i.J(sQLiteDatabaseA.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new c8.b(iVar, map, pVar, 3));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return aVar;
                } finally {
                }
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                e8.i iVar2 = (e8.i) ((e8.d) obj);
                long jL = iVar2.f3842w.l() - iVar2.f3844y.f3830d;
                sQLiteDatabaseA = iVar2.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(jL)};
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            iVar2.z(cursorRawQuery.getInt(0), a8.c.f345x, cursorRawQuery.getString(1));
                        } catch (Throwable th) {
                            cursorRawQuery.close();
                            throw th;
                        }
                    }
                    cursorRawQuery.close();
                    int iDelete = sQLiteDatabaseA.delete("events", "timestamp_ms < ?", strArr);
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    return Integer.valueOf(iDelete);
                } finally {
                }
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                e8.i iVar3 = (e8.i) ((e8.c) ((d8.j) obj).i);
                sQLiteDatabaseA = iVar3.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    sQLiteDatabaseA.compileStatement("DELETE FROM log_event_dropped").execute();
                    sQLiteDatabaseA.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + iVar3.f3842w.l()).execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                nc.p pVar2 = (nc.p) obj;
                Iterator it = ((Iterable) ((e8.i) ((e8.d) pVar2.f9070b)).q(new a3.m(7))).iterator();
                while (it.hasNext()) {
                    ((androidx.emoji2.text.v) pVar2.f9071c).C((x7.i) it.next(), 1, false);
                }
                return null;
        }
    }

    @Override // k4.a1
    public void h(k4.h1 h1Var, k4.s sVar) {
        ((y1.h) this.f986w).accept(h1Var);
    }

    @Override // k4.c1
    public Object i(k4.b0 b0Var, k4.s sVar, int i) {
        int i10 = this.f985v;
        Object obj = this.f986w;
        switch (i10) {
            case 24:
                return b0Var.l(sVar, (ua.i0) obj);
            default:
                k4.a1 a1Var = (k4.a1) obj;
                ya.u uVar = ya.u.f15014w;
                if (!b0Var.j()) {
                    a1Var.h(b0Var.f6924t, sVar);
                    k4.d1.R(b0Var, sVar, i, new o1(0));
                }
                return ya.u.f15014w;
        }
    }

    @Override // hc.a
    public void j(hc.b bVar) {
        kb.a aVar = (kb.a) this.f986w;
        aVar.getClass();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics native component now available.", null);
        }
        aVar.f7394b.set((kb.a) bVar.get());
    }

    @Override // p0.b
    public void onCancel() {
        e1 e1Var = (e1) this.f986w;
        ge.i.e(e1Var, "this$0");
        e1Var.a();
    }

    public /* synthetic */ f1(h2.a aVar, Object obj, int i) {
        this.f985v = i;
        this.f986w = obj;
    }

    public /* synthetic */ f1(h2.a aVar, s2.t tVar, s2.y yVar, IOException iOException, boolean z10) {
        this.f985v = 18;
        this.f986w = yVar;
    }
}
