package c8;

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
import androidx.emoji2.text.n;
import com.google.firebase.messaging.FirebaseMessaging;
import e8.g;
import e8.i;
import j9.f;
import j9.h;
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
import k4.b0;
import k4.b1;
import k4.k0;
import k4.k1;
import k4.l0;
import k4.o1;
import k4.r0;
import k4.s;
import k4.t;
import nb.w;
import nc.q;
import rc.e;
import rc.j;
import s2.c0;
import s2.i0;
import s2.y;
import ua.f0;
import ua.z0;
import v1.g1;
import v2.k;
import v2.l;
import y1.a0;
import ya.p;
import ya.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements f8.b, g, k0, p, h, j9.a, y1.h, f, l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2114v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f2115w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f2116x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f2117y;

    public /* synthetic */ b(i iVar, Object obj, x7.i iVar2, int i) {
        this.f2114v = i;
        this.f2117y = iVar;
        this.f2115w = obj;
        this.f2116x = iVar2;
    }

    @Override // j9.h
    public j9.p B(Object obj) {
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f2117y;
        String str = (String) this.f2116x;
        q qVar = (q) this.f2115w;
        String str2 = (String) obj;
        l4.a aVarC = FirebaseMessaging.c(firebaseMessaging.f3039b);
        ab.g gVar = firebaseMessaging.f3038a;
        gVar.a();
        String strD = "[DEFAULT]".equals(gVar.f391b) ? "" : gVar.d();
        String strA = firebaseMessaging.i.a();
        synchronized (aVarC) {
            String strA2 = q.a(System.currentTimeMillis(), str2, strA);
            if (strA2 != null) {
                SharedPreferences.Editor editorEdit = ((SharedPreferences) aVarC.f7697v).edit();
                editorEdit.putString(strD + "|T|" + str + "|*", strA2);
                editorEdit.commit();
            }
        }
        if (qVar == null || !str2.equals(qVar.f9074a)) {
            ab.g gVar2 = firebaseMessaging.f3038a;
            gVar2.a();
            if ("[DEFAULT]".equals(gVar2.f391b)) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    StringBuilder sb = new StringBuilder("Invoking onNewToken for app: ");
                    gVar2.a();
                    sb.append(gVar2.f391b);
                    Log.d("FirebaseMessaging", sb.toString());
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", str2);
                new nc.h(firebaseMessaging.f3039b).b(intent);
            }
        }
        return vf.g.A(str2);
    }

    @Override // j9.f
    public void a(Object obj) {
        nc.p pVar = (nc.p) this.f2117y;
        j9.p pVar2 = (j9.p) this.f2116x;
        kb.b bVar = (kb.b) this.f2115w;
        try {
            e eVar = (e) pVar2.h();
            if (eVar != null) {
                ((Executor) pVar.f9071c).execute(new sc.a(bVar, ((w) pVar.f9070b).D(eVar), 1));
            }
        } catch (qc.d e9) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e9);
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        f3.a aVar = (f3.a) this.f2117y;
        ((i0) obj).K(aVar.f3935w, (c0) this.f2116x, (y) this.f2115w);
    }

    @Override // e8.g, ta.f
    public Object apply(Object obj) throws Throwable {
        long jInsert;
        Cursor cursor;
        a8.c cVar;
        int i = this.f2114v;
        int i10 = 5;
        int i11 = 4;
        int i12 = 3;
        a8.c cVar2 = a8.c.f346y;
        int i13 = 2;
        int i14 = 1;
        Object obj2 = this.f2115w;
        Object obj3 = this.f2116x;
        int i15 = 0;
        i iVar = (i) this.f2117y;
        switch (i) {
            case 1:
                x7.h hVar = (x7.h) obj2;
                x7.l lVar = hVar.f14428c;
                String str = hVar.f14426a;
                x7.i iVar2 = (x7.i) obj3;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                long jSimpleQueryForLong = iVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * iVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong();
                e8.a aVar = iVar.f3844y;
                if (jSimpleQueryForLong >= aVar.f3827a) {
                    iVar.z(1L, cVar2, str);
                    return -1L;
                }
                Long lG = i.g(sQLiteDatabase, iVar2);
                if (lG != null) {
                    jInsert = lG.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", iVar2.f14434a);
                    contentValues.put("priority", Integer.valueOf(h8.a.a(iVar2.f14436c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr = iVar2.f14435b;
                    if (bArr != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int i16 = aVar.f3831e;
                byte[] bArr2 = lVar.f14443b;
                boolean z10 = bArr2.length <= i16;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", str);
                contentValues2.put("timestamp_ms", Long.valueOf(hVar.f14429d));
                contentValues2.put("uptime_ms", Long.valueOf(hVar.f14430e));
                contentValues2.put("payload_encoding", lVar.f14442a.f12280a);
                contentValues2.put("code", hVar.f14427b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z10));
                contentValues2.put("payload", z10 ? bArr2 : new byte[0]);
                contentValues2.put("product_id", hVar.f14431g);
                contentValues2.put("pseudonymous_id", hVar.f14432h);
                contentValues2.put("experiment_ids_clear_blob", hVar.i);
                contentValues2.put("experiment_ids_encrypted_blob", hVar.f14433j);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z10) {
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
                for (Map.Entry entry : Collections.unmodifiableMap(hVar.f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case 2:
                ArrayList arrayList = (ArrayList) obj2;
                x7.i iVar3 = (x7.i) obj3;
                Cursor cursor2 = (Cursor) obj;
                while (cursor2.moveToNext()) {
                    long j4 = cursor2.getLong(0);
                    int i18 = cursor2.getInt(7) != 0 ? i14 : 0;
                    u5.a aVar2 = new u5.a();
                    aVar2.f = new HashMap();
                    String string = cursor2.getString(i14);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    aVar2.f12213b = string;
                    aVar2.f12216e = Long.valueOf(cursor2.getLong(i13));
                    aVar2.f12212a = Long.valueOf(cursor2.getLong(3));
                    if (i18 != 0) {
                        String string2 = cursor2.getString(4);
                        aVar2.f12215d = new x7.l(string2 == null ? i.A : new u7.c(string2), cursor2.getBlob(5));
                    } else {
                        String string3 = cursor2.getString(4);
                        u7.c cVar3 = string3 == null ? i.A : new u7.c(string3);
                        Cursor cursorQuery = iVar.a().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j4)}, null, null, "sequence_num");
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
                            aVar2.f12215d = new x7.l(cVar3, bArr3);
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                        }
                    }
                    if (!cursor2.isNull(6)) {
                        aVar2.f12214c = Integer.valueOf(cursor2.getInt(6));
                    }
                    if (!cursor2.isNull(8)) {
                        aVar2.f12217g = Integer.valueOf(cursor2.getInt(8));
                    }
                    if (!cursor2.isNull(9)) {
                        aVar2.f12218h = cursor2.getString(9);
                    }
                    if (!cursor2.isNull(10)) {
                        aVar2.i = cursor2.getBlob(10);
                    }
                    if (!cursor2.isNull(11)) {
                        aVar2.f12219j = cursor2.getBlob(11);
                    }
                    arrayList.add(new e8.b(j4, iVar3, aVar2.b()));
                    i13 = 2;
                    i14 = 1;
                }
                return null;
            default:
                HashMap map = (HashMap) obj3;
                nc.p pVar = (nc.p) obj2;
                ArrayList arrayList4 = (ArrayList) pVar.f9071c;
                Cursor cursor3 = (Cursor) obj;
                iVar.getClass();
                while (cursor3.moveToNext()) {
                    String string4 = cursor3.getString(i15);
                    int i20 = cursor3.getInt(1);
                    a8.c cVar4 = a8.c.f344w;
                    if (i20 != 0) {
                        if (i20 == 1) {
                            cVar4 = a8.c.f345x;
                        } else if (i20 == 2) {
                            cVar = cVar2;
                        } else if (i20 == i12) {
                            cVar4 = a8.c.f347z;
                        } else if (i20 == i11) {
                            cVar4 = a8.c.A;
                        } else if (i20 == i10) {
                            cVar4 = a8.c.B;
                        } else if (i20 == 6) {
                            cVar4 = a8.c.C;
                        } else {
                            vf.g.t("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i20));
                        }
                        cVar = cVar4;
                    } else {
                        cVar = cVar4;
                    }
                    long j7 = cursor3.getLong(2);
                    if (!map.containsKey(string4)) {
                        map.put(string4, new ArrayList());
                    }
                    ((List) map.get(string4)).add(new a8.d(j7, cVar));
                    i15 = 0;
                    i10 = 5;
                    i11 = 4;
                    i12 = 3;
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    int i21 = a8.e.f351c;
                    new ArrayList();
                    arrayList4.add(new a8.e((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                }
                long jL = iVar.f3842w.l();
                SQLiteDatabase sQLiteDatabaseA = iVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                    try {
                        cursorRawQuery.moveToNext();
                        a8.g gVar = new a8.g(cursorRawQuery.getLong(0), jL);
                        cursorRawQuery.close();
                        sQLiteDatabaseA.setTransactionSuccessful();
                        sQLiteDatabaseA.endTransaction();
                        pVar.f9070b = gVar;
                        pVar.f9072d = new a8.b(new a8.f(iVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * iVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong(), e8.a.f.f3827a));
                        pVar.f9069a = (String) iVar.f3845z.get();
                        return new a8.a((a8.g) pVar.f9070b, Collections.unmodifiableList(arrayList4), (a8.b) pVar.f9072d, (String) pVar.f9069a);
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

    @Override // v2.l
    public z0 b(int i, g1 g1Var, int[] iArr) {
        v2.i iVar = (v2.i) this.f2117y;
        String str = (String) this.f2116x;
        String str2 = (String) this.f2115w;
        f0 f0VarJ = ua.i0.j();
        for (int i10 = 0; i10 < g1Var.f12702a; i10++) {
            f0VarJ.a(new k(i, g1Var, i10, iVar, iArr[i10], str, str2));
        }
        return f0VarJ.g();
    }

    @Override // j9.a
    public Object c(j9.p pVar) {
        e eVar;
        URL url;
        switch (this.f2114v) {
            case 9:
                j9.i iVar = (j9.i) this.f2117y;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f2116x;
                pc.c cVar = (pc.c) this.f2115w;
                if (pVar.j()) {
                    iVar.c(pVar.h());
                } else if (pVar.g() != null) {
                    iVar.b(pVar.g());
                } else if (atomicBoolean.getAndSet(true)) {
                    ((j9.p) ((pc.c) cVar.f10180v).f10180v).m(null);
                }
                return vf.g.A(null);
            case 10:
                qc.b bVar = (qc.b) this.f2117y;
                j9.p pVar2 = (j9.p) this.f2116x;
                j9.p pVar3 = (j9.p) this.f2115w;
                if (!pVar2.j() || pVar2.h() == null) {
                    return vf.g.A(Boolean.FALSE);
                }
                e eVar2 = (e) pVar2.h();
                return (pVar3.j() && (eVar = (e) pVar3.h()) != null && eVar2.f10942c.equals(eVar.f10942c)) ? vf.g.A(Boolean.FALSE) : bVar.f10790e.e(eVar2).e(bVar.f10788c, new qc.a(bVar));
            default:
                j jVar = (j) this.f2117y;
                j9.p pVar4 = (j9.p) this.f2116x;
                j9.p pVar5 = (j9.p) this.f2115w;
                if (!pVar4.j()) {
                    return vf.g.z(new qc.c("Firebase Installations failed to get installation auth token for config update listener connection.", pVar4.g()));
                }
                if (!pVar5.j()) {
                    return vf.g.z(new qc.c("Firebase Installations failed to get installation ID for config update listener connection.", pVar5.g()));
                }
                try {
                    try {
                        url = new URL(jVar.c(jVar.f10975n));
                        break;
                    } catch (MalformedURLException unused) {
                        Log.e("FirebaseRemoteConfig", "URL is malformed");
                        url = null;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    jVar.l(httpURLConnection, (String) pVar5.h(), ((ic.a) pVar4.h()).f6414a);
                    return vf.g.A(httpURLConnection);
                } catch (IOException e9) {
                    return vf.g.z(new qc.c("Failed to open HTTP stream connection", e9));
                }
        }
    }

    @Override // k4.k0
    public void d(s sVar) {
        l0 l0Var = (l0) this.f2117y;
        Bundle bundle = (Bundle) this.f2116x;
        ResultReceiver resultReceiver = (ResultReceiver) this.f2115w;
        b0 b0Var = l0Var.f7060g;
        if (bundle == null) {
            Bundle bundle2 = Bundle.EMPTY;
        }
        u uVarN = b0Var.n(sVar);
        if (resultReceiver != null) {
            uVarN.h(new androidx.fragment.app.d(23, uVarN, resultReceiver), ya.q.f15009v);
        }
    }

    @Override // f8.b
    public Object g() {
        c cVar = (c) this.f2117y;
        x7.i iVar = (x7.i) this.f2116x;
        x7.h hVar = (x7.h) this.f2115w;
        i iVar2 = (i) cVar.f2121d;
        iVar2.getClass();
        u7.d dVar = iVar.f14436c;
        String str = hVar.f14426a;
        String str2 = iVar.f14434a;
        String strG = vf.g.G("SQLiteEventStore");
        if (Log.isLoggable(strG, 3)) {
            Log.d(strG, "Storing event with priority=" + dVar + ", name=" + str + " for destination " + str2);
        }
        ((Long) iVar2.q(new b(iVar2, (Object) hVar, iVar, 1))).getClass();
        cVar.f2118a.C(iVar, 1, false);
        return null;
    }

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i) {
        this.f2114v = i;
        this.f2117y = obj;
        this.f2116x = obj2;
        this.f2115w = obj3;
    }

    public /* synthetic */ b(l0 l0Var, k1 k1Var, Bundle bundle, ResultReceiver resultReceiver) {
        this.f2114v = 5;
        this.f2117y = l0Var;
        this.f2116x = bundle;
        this.f2115w = resultReceiver;
    }

    @Override // e8.g, ta.f
    public ya.w apply(Object obj) {
        int i = this.f2114v;
        int i10 = 9;
        Object obj2 = this.f2115w;
        Object obj3 = this.f2116x;
        Object obj4 = this.f2117y;
        switch (i) {
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                b0 b0Var = (b0) obj4;
                Handler handler = b0Var.f6916l;
                androidx.fragment.app.d dVar = new androidx.fragment.app.d(b0Var, (s) obj3, new n(b0Var, (r0) obj2, (t) obj, 5));
                o1 o1Var = new o1(0);
                int i11 = a0.f14551a;
                ya.c0 c0Var = new ya.c0();
                a0.S(handler, new n(c0Var, dVar, o1Var, i10));
                return c0Var;
            default:
                b0 b0Var2 = (b0) obj4;
                s sVar = (s) obj3;
                List list = (List) obj;
                Handler handler2 = b0Var2.f6916l;
                androidx.fragment.app.d dVar2 = new androidx.fragment.app.d(b0Var2, sVar, new a(b0Var2, (b1) obj2, sVar, list, 7));
                o1 o1Var2 = new o1(0);
                int i12 = a0.f14551a;
                ya.c0 c0Var2 = new ya.c0();
                a0.S(handler2, new n(c0Var2, dVar2, o1Var2, i10));
                return c0Var2;
        }
    }
}
