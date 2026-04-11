package f9;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4414v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ w4 f4415w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ a2 f4416x;

    public /* synthetic */ t1(a2 a2Var, w4 w4Var, int i) {
        this.f4414v = i;
        this.f4415w = w4Var;
        this.f4416x = a2Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f4414v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a2 a2Var = this.f4416x;
                a2Var.f4001d.w();
                a2Var.f4001d.T(this.f4415w);
                break;
            case 1:
                a2 a2Var2 = this.f4416x;
                a2Var2.f4001d.w();
                q4 q4Var = a2Var2.f4001d;
                q4Var.a0().m1();
                q4Var.i0();
                w4 w4Var = this.f4415w;
                o8.u.g(w4Var);
                String str = w4Var.f4462v;
                o8.u.d(str);
                int i = 0;
                if (q4Var.Z().w1(null, f0.A0)) {
                    q4Var.A0().getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int iU1 = q4Var.Z().u1(null, f0.f4133j0);
                    q4Var.Z();
                    long jLongValue = jCurrentTimeMillis - ((Long) f0.f4119e.a(null)).longValue();
                    while (i < iU1 && q4Var.E(null, jLongValue)) {
                        i++;
                    }
                } else {
                    q4Var.Z();
                    long jIntValue = ((Integer) f0.f4138l.a(null)).intValue();
                    while (i < jIntValue && q4Var.E(str, 0L)) {
                        i++;
                    }
                }
                if (q4Var.Z().w1(null, f0.B0)) {
                    q4Var.a0().m1();
                    q4Var.D();
                }
                n4 n4Var = q4Var.E;
                int iC = q4.a.c(w4Var.Z);
                n4Var.m1();
                if (iC == 2 && !n4.p1(str)) {
                    l1 l1Var = n4Var.f4215x.f4353v;
                    q4.P(l1Var);
                    com.google.android.gms.internal.measurement.f2 f2VarY1 = l1Var.y1(str);
                    if (f2VarY1 != null && f2VarY1.D() && !f2VarY1.E().q().isEmpty()) {
                        q4Var.C().J.b(str, "[sgtm] Going background, trigger client side upload. appId");
                        q4Var.A0().getClass();
                        q4Var.m(str, System.currentTimeMillis());
                        break;
                    }
                }
                break;
            case 2:
                a2 a2Var3 = this.f4416x;
                a2Var3.f4001d.w();
                q4 q4Var2 = a2Var3.f4001d;
                q4Var2.a0().m1();
                q4Var2.i0();
                w4 w4Var2 = this.f4415w;
                o8.u.d(w4Var2.f4462v);
                q4Var2.X(w4Var2);
                break;
            case 3:
                a2 a2Var4 = this.f4416x;
                a2Var4.f4001d.w();
                q4 q4Var3 = a2Var4.f4001d;
                if (q4Var3.T != null) {
                    ArrayList arrayList = new ArrayList();
                    q4Var3.U = arrayList;
                    arrayList.addAll(q4Var3.T);
                }
                n nVar = q4Var3.f4355x;
                q4.P(nVar);
                r1 r1Var = (r1) nVar.f307w;
                w4 w4Var3 = this.f4415w;
                String str2 = w4Var3.f4462v;
                o8.u.g(str2);
                o8.u.d(str2);
                nVar.m1();
                nVar.n1();
                try {
                    SQLiteDatabase sQLiteDatabaseB2 = nVar.b2();
                    String[] strArr = {str2};
                    int iDelete = sQLiteDatabaseB2.delete("apps", "app_id=?", strArr) + sQLiteDatabaseB2.delete("events", "app_id=?", strArr) + sQLiteDatabaseB2.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseB2.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseB2.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseB2.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseB2.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseB2.delete("queue", "app_id=?", strArr) + sQLiteDatabaseB2.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseB2.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseB2.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseB2.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseB2.delete("upload_queue", "app_id=?", strArr);
                    if (r1Var.f4366y.w1(null, f0.f4131i1)) {
                        iDelete += sQLiteDatabaseB2.delete("no_data_mode_events", "app_id=?", strArr);
                    }
                    if (iDelete > 0) {
                        w0 w0Var = r1Var.A;
                        r1.g(w0Var);
                        w0Var.J.c(str2, Integer.valueOf(iDelete), "Reset analytics data. app, records");
                    }
                } catch (SQLiteException e9) {
                    w0 w0Var2 = r1Var.A;
                    r1.g(w0Var2);
                    w0Var2.B.c(w0.u1(str2), e9, "Error resetting analytics data. appId, error");
                }
                if (w4Var3.C) {
                    q4Var3.T(w4Var3);
                }
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                a2 a2Var5 = this.f4416x;
                a2Var5.f4001d.w();
                q4 q4Var4 = a2Var5.f4001d;
                q4Var4.a0().m1();
                q4Var4.i0();
                w4 w4Var4 = this.f4415w;
                o8.u.d(w4Var4.f4462v);
                q4Var4.j0(w4Var4);
                q4Var4.k0(w4Var4);
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                q4 q4Var5 = this.f4416x.f4001d;
                q4Var5.w();
                q4Var5.k0(this.f4415w);
                break;
            default:
                q4 q4Var6 = this.f4416x.f4001d;
                q4Var6.w();
                q4Var6.j0(this.f4415w);
                break;
        }
    }
}
