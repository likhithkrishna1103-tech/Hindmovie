package dd;

import a2.g0;
import aa.c1;
import aa.j0;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Base64;
import android.util.Log;
import c2.w;
import com.google.firebase.messaging.FirebaseMessaging;
import ea.e0;
import ea.q;
import ea.r;
import ea.v;
import ea.y;
import g4.b0;
import g4.d1;
import g4.l0;
import g4.m0;
import g4.m1;
import g4.q1;
import g4.s;
import g4.s0;
import g4.t;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import o2.d0;
import o2.k0;
import o2.z;
import p1.g1;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements l0, q, k7.b, j7.e, s1.h, r2.m, o8.a, o8.g, o8.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4141u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f4142v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4143w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4144x;

    public /* synthetic */ e(m0 m0Var, m1 m1Var, Bundle bundle, ResultReceiver resultReceiver) {
        this.f4141u = 1;
        this.f4142v = m0Var;
        this.f4143w = bundle;
        this.f4144x = resultReceiver;
    }

    @Override // s1.h
    public void accept(Object obj) {
        aa.l0 l0Var = (aa.l0) this.f4142v;
        ((k0) obj).g(l0Var.f705v, (d0) this.f4143w, (z) this.f4144x);
    }

    @Override // j7.e
    public Object apply(Object obj) throws Throwable {
        long jInsert;
        Cursor cursor;
        f7.c cVar;
        int i = this.f4141u;
        int i10 = 5;
        int i11 = 4;
        int i12 = 3;
        f7.c cVar2 = f7.c.f4797x;
        int i13 = 2;
        int i14 = 1;
        Object obj2 = this.f4144x;
        Object obj3 = this.f4143w;
        int i15 = 0;
        j7.g gVar = (j7.g) this.f4142v;
        switch (i) {
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                c7.i iVar = (c7.i) obj3;
                c7.n nVar = iVar.f2554c;
                String str = iVar.f2552a;
                c7.j jVar = (c7.j) obj2;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                long jSimpleQueryForLong = gVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * gVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong();
                j7.a aVar = gVar.f6823x;
                if (jSimpleQueryForLong >= aVar.f6809a) {
                    gVar.F(1L, cVar2, str);
                    return -1L;
                }
                Long lD = j7.g.d(sQLiteDatabase, jVar);
                if (lD != null) {
                    jInsert = lD.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", jVar.f2560a);
                    contentValues.put("priority", Integer.valueOf(m7.a.a(jVar.f2562c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr = jVar.f2561b;
                    if (bArr != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int i16 = aVar.f6813e;
                byte[] bArr2 = nVar.f2571b;
                boolean z2 = bArr2.length <= i16;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", str);
                contentValues2.put("timestamp_ms", Long.valueOf(iVar.f2555d));
                contentValues2.put("uptime_ms", Long.valueOf(iVar.f2556e));
                contentValues2.put("payload_encoding", nVar.f2570a.f14890a);
                contentValues2.put("code", iVar.f2553b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z2));
                contentValues2.put("payload", z2 ? bArr2 : new byte[0]);
                contentValues2.put("product_id", iVar.f2557g);
                contentValues2.put("pseudonymous_id", iVar.f2558h);
                contentValues2.put("experiment_ids_clear_blob", iVar.i);
                contentValues2.put("experiment_ids_encrypted_blob", iVar.f2559j);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z2) {
                    int iCeil = (int) Math.ceil(((double) bArr2.length) / ((double) i16));
                    for (int i17 = 1; i17 <= iCeil; i17++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i17 - 1) * i16, Math.min(i17 * i16, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i17));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(iVar.f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                ArrayList arrayList = (ArrayList) obj3;
                c7.j jVar2 = (c7.j) obj2;
                Cursor cursor2 = (Cursor) obj;
                while (cursor2.moveToNext()) {
                    long j5 = cursor2.getLong(0);
                    int i18 = cursor2.getInt(7) != 0 ? i14 : 0;
                    c7.h hVar = new c7.h();
                    hVar.f2550h = new HashMap();
                    String string = cursor2.getString(i14);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    hVar.f2544a = string;
                    hVar.f = Long.valueOf(cursor2.getLong(i13));
                    hVar.f2549g = Long.valueOf(cursor2.getLong(3));
                    if (i18 != 0) {
                        String string2 = cursor2.getString(4);
                        hVar.f2548e = new c7.n(string2 == null ? j7.g.f6819z : new z6.c(string2), cursor2.getBlob(5));
                    } else {
                        String string3 = cursor2.getString(4);
                        z6.c cVar3 = string3 == null ? j7.g.f6819z : new z6.c(string3);
                        Cursor cursorQuery = gVar.a().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j5)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList2 = new ArrayList();
                            int length = 0;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(0);
                                arrayList2.add(blob);
                                length += blob.length;
                                break;
                            }
                            byte[] bArr3 = new byte[length];
                            int i19 = 0;
                            int length2 = 0;
                            while (i19 < arrayList2.size()) {
                                byte[] bArr4 = (byte[]) arrayList2.get(i19);
                                cursor = cursorQuery;
                                try {
                                    ArrayList arrayList3 = arrayList2;
                                    System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
                                    length2 += bArr4.length;
                                    i19++;
                                    cursorQuery = cursor;
                                    arrayList2 = arrayList3;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            }
                            cursorQuery.close();
                            hVar.f2548e = new c7.n(cVar3, bArr3);
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                        }
                    }
                    if (!cursor2.isNull(6)) {
                        hVar.f2546c = Integer.valueOf(cursor2.getInt(6));
                    }
                    if (!cursor2.isNull(8)) {
                        hVar.f2547d = Integer.valueOf(cursor2.getInt(8));
                    }
                    if (!cursor2.isNull(9)) {
                        hVar.f2545b = cursor2.getString(9);
                    }
                    if (!cursor2.isNull(10)) {
                        hVar.i = cursor2.getBlob(10);
                    }
                    if (!cursor2.isNull(11)) {
                        hVar.f2551j = cursor2.getBlob(11);
                    }
                    arrayList.add(new j7.b(j5, jVar2, hVar.c()));
                    i13 = 2;
                    i14 = 1;
                }
                return null;
            default:
                HashMap map = (HashMap) obj3;
                ub.o oVar = (ub.o) obj2;
                ArrayList arrayList4 = (ArrayList) oVar.f12870x;
                Cursor cursor3 = (Cursor) obj;
                gVar.getClass();
                while (cursor3.moveToNext()) {
                    String string4 = cursor3.getString(i15);
                    int i20 = cursor3.getInt(1);
                    f7.c cVar4 = f7.c.f4795v;
                    if (i20 != 0) {
                        if (i20 == 1) {
                            cVar4 = f7.c.f4796w;
                        } else if (i20 == 2) {
                            cVar = cVar2;
                        } else if (i20 == i12) {
                            cVar4 = f7.c.f4798y;
                        } else if (i20 == i11) {
                            cVar4 = f7.c.f4799z;
                        } else if (i20 == i10) {
                            cVar4 = f7.c.A;
                        } else if (i20 == 6) {
                            cVar4 = f7.c.B;
                        } else {
                            cf.l.l("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i20));
                        }
                        cVar = cVar4;
                    } else {
                        cVar = cVar4;
                    }
                    long j8 = cursor3.getLong(2);
                    if (!map.containsKey(string4)) {
                        map.put(string4, new ArrayList());
                    }
                    ((List) map.get(string4)).add(new f7.d(j8, cVar));
                    i15 = 0;
                    i10 = 5;
                    i11 = 4;
                    i12 = 3;
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    int i21 = f7.e.f4803c;
                    new ArrayList();
                    arrayList4.add(new f7.e((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                }
                long jG = gVar.f6821v.g();
                SQLiteDatabase sQLiteDatabaseA = gVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                    try {
                        cursorRawQuery.moveToNext();
                        f7.g gVar2 = new f7.g(cursorRawQuery.getLong(0), jG);
                        cursorRawQuery.close();
                        sQLiteDatabaseA.setTransactionSuccessful();
                        sQLiteDatabaseA.endTransaction();
                        oVar.f12869w = gVar2;
                        oVar.f12871y = new f7.b(new f7.f(gVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * gVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong(), j7.a.f.f6809a));
                        oVar.f12868v = (String) gVar.f6824y.get();
                        return new f7.a((f7.g) oVar.f12869w, Collections.unmodifiableList(arrayList4), (f7.b) oVar.f12871y, (String) oVar.f12868v);
                    } catch (Throwable th3) {
                        cursorRawQuery.close();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    sQLiteDatabaseA.endTransaction();
                    throw th4;
                }
        }
    }

    @Override // o8.a
    public Object b(o8.o oVar) {
        yb.e eVar;
        URL url;
        switch (this.f4141u) {
            case 10:
                o8.h hVar = (o8.h) this.f4142v;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f4143w;
                rc.b bVar = (rc.b) this.f4144x;
                if (oVar.j()) {
                    hVar.c(oVar.h());
                } else if (oVar.g() != null) {
                    hVar.b(oVar.g());
                } else if (atomicBoolean.getAndSet(true)) {
                    ((o8.o) ((rc.b) bVar.f11562v).f11562v).o(null);
                }
                return t1.k(null);
            case 11:
            default:
                yb.m mVar = (yb.m) this.f4142v;
                o8.o oVar2 = (o8.o) this.f4143w;
                o8.o oVar3 = (o8.o) this.f4144x;
                if (!oVar2.j()) {
                    return t1.j(new xb.c("Firebase Installations failed to get installation auth token for config update listener connection.", oVar2.g()));
                }
                if (!oVar3.j()) {
                    return t1.j(new xb.c("Firebase Installations failed to get installation ID for config update listener connection.", oVar3.g()));
                }
                try {
                    try {
                        url = new URL(mVar.c(mVar.f14633l));
                        break;
                    } catch (MalformedURLException unused) {
                        Log.e("FirebaseRemoteConfig", "URL is malformed");
                        url = null;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    mVar.j(httpURLConnection, (String) oVar3.h(), ((ob.a) oVar2.h()).f9480a);
                    return t1.k(httpURLConnection);
                } catch (IOException e10) {
                    return t1.j(new xb.c("Failed to open HTTP stream connection", e10));
                }
            case 12:
                xb.b bVar2 = (xb.b) this.f4142v;
                o8.o oVar4 = (o8.o) this.f4143w;
                o8.o oVar5 = (o8.o) this.f4144x;
                if (!oVar4.j() || oVar4.h() == null) {
                    return t1.k(Boolean.FALSE);
                }
                yb.e eVar2 = (yb.e) oVar4.h();
                return (oVar5.j() && (eVar = (yb.e) oVar5.h()) != null && eVar2.f14593c.equals(eVar.f14593c)) ? t1.k(Boolean.FALSE) : bVar2.f14339e.e(eVar2).e(bVar2.f14337c, new xb.a(bVar2));
        }
    }

    @Override // o8.e
    public void c(Object obj) {
        z0.i iVar = (z0.i) this.f4142v;
        o8.o oVar = (o8.o) this.f4143w;
        qa.b bVar = (qa.b) this.f4144x;
        try {
            yb.e eVar = (yb.e) oVar.h();
            if (eVar != null) {
                ((Executor) iVar.f14763c).execute(new zb.a(bVar, ((pb.c) iVar.f14762b).d(eVar), 1));
            }
        } catch (xb.d e10) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e10);
        }
    }

    @Override // g4.l0
    public void d(s sVar) {
        m0 m0Var = (m0) this.f4142v;
        Bundle bundle = (Bundle) this.f4143w;
        ResultReceiver resultReceiver = (ResultReceiver) this.f4144x;
        b0 b0Var = m0Var.f5115g;
        if (bundle == null) {
            Bundle bundle2 = Bundle.EMPTY;
        }
        v vVarN = b0Var.n(sVar);
        if (resultReceiver != null) {
            vVarN.f(new g0(vVarN, 18, resultReceiver), r.f4628u);
        }
    }

    @Override // r2.m
    public c1 g(int i, g1 g1Var, int[] iArr) {
        r2.j jVar = (r2.j) this.f4142v;
        String str = (String) this.f4143w;
        String str2 = (String) this.f4144x;
        aa.g0 g0VarN = j0.n();
        for (int i10 = 0; i10 < g1Var.f9762a; i10++) {
            g0VarN.a(new r2.l(i, g1Var, i10, jVar, iArr[i10], str, str2));
        }
        return g0VarN.g();
    }

    @Override // k7.b
    public Object h() {
        h7.a aVar = (h7.a) this.f4142v;
        c7.j jVar = (c7.j) this.f4143w;
        c7.i iVar = (c7.i) this.f4144x;
        j7.g gVar = (j7.g) aVar.f5959d;
        gVar.getClass();
        z6.d dVar = jVar.f2562c;
        String str = iVar.f2552a;
        String str2 = jVar.f2560a;
        String strT = cf.l.t("SQLiteEventStore");
        if (Log.isLoggable(strT, 3)) {
            Log.d(strT, "Storing event with priority=" + dVar + ", name=" + str + " for destination " + str2);
        }
        ((Long) gVar.v(new e(gVar, iVar, jVar, 5))).getClass();
        aVar.f5956a.C(jVar, 1, false);
        return null;
    }

    @Override // o8.g
    public o8.o r(Object obj) {
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f4142v;
        String str = (String) this.f4143w;
        ub.p pVar = (ub.p) this.f4144x;
        String str2 = (String) obj;
        o4.c cVarC = FirebaseMessaging.c(firebaseMessaging.f3576b);
        ga.g gVar = firebaseMessaging.f3575a;
        gVar.a();
        String strD = "[DEFAULT]".equals(gVar.f5347b) ? "" : gVar.d();
        String strB = firebaseMessaging.i.b();
        synchronized (cVarC) {
            String strA = ub.p.a(System.currentTimeMillis(), str2, strB);
            if (strA != null) {
                SharedPreferences.Editor editorEdit = ((SharedPreferences) cVarC.f9349u).edit();
                editorEdit.putString(strD + "|T|" + str + "|*", strA);
                editorEdit.commit();
            }
        }
        if (pVar == null || !str2.equals(pVar.f12873a)) {
            ga.g gVar2 = firebaseMessaging.f3575a;
            gVar2.a();
            if ("[DEFAULT]".equals(gVar2.f5347b)) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    StringBuilder sb2 = new StringBuilder("Invoking onNewToken for app: ");
                    gVar2.a();
                    sb2.append(gVar2.f5347b);
                    Log.d("FirebaseMessaging", sb2.toString());
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", str2);
                new ub.i(firebaseMessaging.f3576b).b(intent);
            }
        }
        return t1.k(str2);
    }

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i) {
        this.f4141u = i;
        this.f4142v = obj;
        this.f4143w = obj2;
        this.f4144x = obj3;
    }

    @Override // ea.q, j7.e
    public y apply(Object obj) {
        int i = this.f4141u;
        int i10 = 10;
        Object obj2 = this.f4144x;
        Object obj3 = this.f4143w;
        Object obj4 = this.f4142v;
        switch (i) {
            case 2:
                b0 b0Var = (b0) obj4;
                Handler handler = b0Var.f4965l;
                g0 g0Var = new g0(b0Var, (s) obj3, new a2.g1(b0Var, (s0) obj2, (t) obj, 5));
                q1 q1Var = new q1(0);
                int i11 = s1.b0.f11647a;
                e0 e0Var = new e0();
                s1.b0.S(handler, new a2.g1(e0Var, g0Var, q1Var, i10));
                return e0Var;
            default:
                b0 b0Var2 = (b0) obj4;
                s sVar = (s) obj3;
                List list = (List) obj;
                Handler handler2 = b0Var2.f4965l;
                g0 g0Var2 = new g0(b0Var2, sVar, new w(b0Var2, (d1) obj2, sVar, list, 6));
                q1 q1Var2 = new q1(0);
                int i12 = s1.b0.f11647a;
                e0 e0Var2 = new e0();
                s1.b0.S(handler2, new a2.g1(e0Var2, g0Var2, q1Var2, i10));
                return e0Var2;
        }
    }
}
