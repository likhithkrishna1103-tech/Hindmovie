package f9;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f4261c;

    public l(n nVar, String str) {
        this.f4261c = nVar;
        o8.u.d(str);
        this.f4259a = str;
        this.f4260b = -1L;
    }

    public final List a() {
        List list;
        n nVar = this.f4261c;
        ArrayList arrayList = new ArrayList();
        String strValueOf = String.valueOf(this.f4260b);
        String str = this.f4259a;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = nVar.b2().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{str, strValueOf}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j4 = cursorQuery.getLong(0);
                        long j7 = cursorQuery.getLong(3);
                        boolean z10 = cursorQuery.getLong(5) == 1;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j4 > this.f4260b) {
                            this.f4260b = j4;
                        }
                        try {
                            com.google.android.gms.internal.measurement.a3 a3Var = (com.google.android.gms.internal.measurement.a3) a1.Z1(com.google.android.gms.internal.measurement.b3.z(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            a3Var.b();
                            ((com.google.android.gms.internal.measurement.b3) a3Var.f2470w).F(string);
                            long j10 = cursorQuery.getLong(2);
                            a3Var.b();
                            ((com.google.android.gms.internal.measurement.b3) a3Var.f2470w).G(j10);
                            arrayList.add(new k(j4, j7, z10, (com.google.android.gms.internal.measurement.b3) a3Var.e()));
                        } catch (IOException e9) {
                            w0 w0Var = ((r1) nVar.f307w).A;
                            r1.g(w0Var);
                            w0Var.B.c(w0.u1(str), e9, "Data loss. Failed to merge raw event. appId");
                        }
                    } while (cursorQuery.moveToNext());
                } else {
                    list = Collections.EMPTY_LIST;
                }
            } catch (SQLiteException e10) {
                w0 w0Var2 = ((r1) nVar.f307w).A;
                r1.g(w0Var2);
                w0Var2.B.c(w0.u1(str), e10, "Data loss. Error querying raw events batch. appId");
                list = arrayList;
            }
            return list;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public l(n nVar, String str, long j4) {
        this.f4261c = nVar;
        o8.u.d(str);
        this.f4259a = str;
        this.f4260b = nVar.X1("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j4)}, -1L);
    }
}
