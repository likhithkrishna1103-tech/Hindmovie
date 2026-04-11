package k8;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7295b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f7296c;

    public l(i iVar, String str) {
        this.f7296c = iVar;
        t7.v.d(str);
        this.f7294a = str;
    }

    public final List a() {
        Cursor cursorQuery;
        i iVar = this.f7296c;
        ArrayList arrayList = new ArrayList();
        String strValueOf = String.valueOf(this.f7295b);
        String str = this.f7294a;
        Cursor cursor = null;
        try {
            try {
                cursorQuery = iVar.w1().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{str, strValueOf}, null, null, "rowid", "1000");
            } catch (SQLiteException e10) {
                iVar.g().A.b(p0.v1(str), e10, "Data loss. Error querying raw events batch. appId");
                if (0 != 0) {
                    cursor.close();
                }
            }
            if (!cursorQuery.moveToFirst()) {
                List list = Collections.EMPTY_LIST;
                cursorQuery.close();
                return list;
            }
            do {
                long j5 = cursorQuery.getLong(0);
                long j8 = cursorQuery.getLong(3);
                boolean z2 = cursorQuery.getLong(5) == 1;
                byte[] blob = cursorQuery.getBlob(4);
                if (j5 > this.f7295b) {
                    this.f7295b = j5;
                }
                try {
                    com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) s0.D1(com.google.android.gms.internal.measurement.f3.A(), blob);
                    String string = cursorQuery.getString(1);
                    if (string == null) {
                        string = "";
                    }
                    e3Var.e();
                    com.google.android.gms.internal.measurement.f3.v((com.google.android.gms.internal.measurement.f3) e3Var.f3052v, string);
                    long j10 = cursorQuery.getLong(2);
                    e3Var.e();
                    com.google.android.gms.internal.measurement.f3.x(j10, (com.google.android.gms.internal.measurement.f3) e3Var.f3052v);
                    arrayList.add(new j(j5, j8, z2, (com.google.android.gms.internal.measurement.f3) e3Var.c()));
                } catch (IOException e11) {
                    iVar.g().A.b(p0.v1(str), e11, "Data loss. Failed to merge raw event. appId");
                }
            } while (cursorQuery.moveToNext());
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
