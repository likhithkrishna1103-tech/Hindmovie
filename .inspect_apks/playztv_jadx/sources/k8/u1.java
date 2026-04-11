package k8;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.e9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a4 f7435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f7436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o1 f7437c;

    public u1(o1 o1Var, a4 a4Var, Bundle bundle) {
        this.f7435a = a4Var;
        this.f7436b = bundle;
        this.f7437c = o1Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        List list;
        x3 x3Var = this.f7437c.f7348d;
        x3Var.d0();
        x3Var.x().p1();
        e9.a();
        e eVarS = x3Var.S();
        String str = this.f7435a.f7076u;
        if (!eVarS.A1(str, w.H0) || str == null) {
            return new ArrayList();
        }
        Bundle bundle = this.f7436b;
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    x3Var.g().A.d("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        i iVar = x3Var.f7546w;
                        x3.y(iVar);
                        int i10 = intArray[i];
                        long j5 = longArray[i];
                        t7.v.d(str);
                        iVar.p1();
                        iVar.t1();
                        try {
                            int iDelete = iVar.w1().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i10), String.valueOf(j5)});
                            iVar.g().I.e("Pruned " + iDelete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i10), Long.valueOf(j5));
                        } catch (SQLiteException e10) {
                            iVar.g().A.b(p0.v1(str), e10, "Error pruning trigger URIs. appId");
                        }
                    }
                }
            }
        }
        i iVar2 = x3Var.f7546w;
        x3.y(iVar2);
        t7.v.d(str);
        iVar2.p1();
        iVar2.t1();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = iVar2.w1().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new r3(cursorQuery.getInt(2), cursorQuery.getLong(1), string));
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    list = arrayList;
                } else {
                    cursorQuery.close();
                    list = arrayList;
                }
            } catch (SQLiteException e11) {
                iVar2.g().A.b(p0.v1(str), e11, "Error querying trigger uris. appId");
                List list2 = Collections.EMPTY_LIST;
                list = list2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                    list = list2;
                }
            }
            return list;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
