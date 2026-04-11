package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2630b;

    public /* synthetic */ t(Object obj, Object obj2) {
        this.f2629a = obj;
        this.f2630b = obj2;
    }

    public Object a() {
        Uri uri;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        String string;
        i4 i4Var = (i4) this.f2629a;
        String str = (String) this.f2630b;
        Context context = (Context) i4Var.f2483x;
        context.getClass();
        ContentResolver contentResolver = context.getContentResolver();
        o.t3 t3Var = x3.f2718a;
        if (contentResolver == null) {
            t3Var.getClass();
            throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
        }
        synchronized (t3Var) {
            try {
                if (((HashMap) t3Var.f9368w) == null) {
                    ((AtomicBoolean) t3Var.f9367v).set(false);
                    t3Var.f9368w = new HashMap(16, 1.0f);
                    t3Var.B = new Object();
                    contentResolver.registerContentObserver(y3.f2731a, true, new a4(t3Var));
                } else if (((AtomicBoolean) t3Var.f9367v).getAndSet(false)) {
                    ((HashMap) t3Var.f9368w).clear();
                    ((HashMap) t3Var.f9369x).clear();
                    ((HashMap) t3Var.f9370y).clear();
                    ((HashMap) t3Var.f9371z).clear();
                    ((HashMap) t3Var.A).clear();
                    t3Var.B = new Object();
                }
                Object obj = t3Var.B;
                String str2 = null;
                if (((HashMap) t3Var.f9368w).containsKey(str)) {
                    String str3 = (String) ((HashMap) t3Var.f9368w).get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return str2;
                }
                try {
                    uri = y3.f2731a;
                    contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    try {
                    } finally {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                } catch (b4 unused) {
                }
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    throw new b4("Unable to acquire ContentProviderClient");
                }
                try {
                    Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                    try {
                        if (cursorQuery == null) {
                            throw new b4("ContentProvider query returned null cursor");
                        }
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(1);
                            cursorQuery.close();
                        } else {
                            cursorQuery.close();
                            string = null;
                        }
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        synchronized (t3Var) {
                            try {
                                if (obj == t3Var.B) {
                                    ((HashMap) t3Var.f9368w).put(str, string);
                                }
                            } finally {
                            }
                        }
                        if (string != null) {
                            return string;
                        }
                        return null;
                    } finally {
                    }
                } catch (RemoteException e9) {
                    throw new b4("ContentProvider query failed", e9);
                }
            } finally {
            }
        }
    }

    public void b(s sVar) {
        ArrayList arrayList = sVar.f2589a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((HashMap) this.f2629a).put(Integer.valueOf(((w) obj).f2705v).toString(), sVar);
        }
    }

    public n c(b6.f fVar, n nVar) {
        n5.a.c0(fVar);
        if (!(nVar instanceof o)) {
            return nVar;
        }
        o oVar = (o) nVar;
        ArrayList arrayList = oVar.f2559w;
        String str = oVar.f2558v;
        HashMap map = (HashMap) this.f2629a;
        return (map.containsKey(str) ? (s) map.get(str) : (s) this.f2630b).a(str, fVar, arrayList);
    }

    public void d(b6.f fVar, androidx.emoji2.text.v vVar) {
        y4 y4Var = new y4(vVar);
        TreeMap treeMap = (TreeMap) this.f2629a;
        for (Integer num : treeMap.keySet()) {
            b bVarClone = ((b) vVar.f889x).clone();
            n nVarE = ((m) treeMap.get(num)).e(fVar, Collections.singletonList(y4Var));
            int iY = nVarE instanceof g ? n5.a.Y(((g) nVarE).f2450v.doubleValue()) : -1;
            if (iY == 2 || iY == -1) {
                vVar.f889x = bVarClone;
            }
        }
        TreeMap treeMap2 = (TreeMap) this.f2630b;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            n nVarE2 = ((m) treeMap2.get((Integer) it.next())).e(fVar, Collections.singletonList(y4Var));
            if (nVarE2 instanceof g) {
                n5.a.Y(((g) nVarE2).f2450v.doubleValue());
            }
        }
    }

    public t(int i) {
        switch (i) {
            case 3:
                this.f2629a = new TreeMap();
                this.f2630b = new TreeMap();
                break;
            default:
                this.f2629a = new HashMap();
                this.f2630b = new s(6);
                s sVar = new s(0);
                w wVar = w.A;
                ArrayList arrayList = sVar.f2589a;
                arrayList.add(wVar);
                arrayList.add(w.B);
                arrayList.add(w.C);
                arrayList.add(w.D);
                arrayList.add(w.E);
                arrayList.add(w.F);
                arrayList.add(w.G);
                b(sVar);
                s sVar2 = new s(1);
                w wVar2 = w.R;
                ArrayList arrayList2 = sVar2.f2589a;
                arrayList2.add(wVar2);
                arrayList2.add(w.f2680e0);
                arrayList2.add(w.f2681f0);
                arrayList2.add(w.f2682g0);
                arrayList2.add(w.f2683h0);
                arrayList2.add(w.f2685j0);
                arrayList2.add(w.f2686k0);
                arrayList2.add(w.f2690p0);
                b(sVar2);
                s sVar3 = new s(2);
                w wVar3 = w.f2701y;
                ArrayList arrayList3 = sVar3.f2589a;
                arrayList3.add(wVar3);
                arrayList3.add(w.H);
                arrayList3.add(w.I);
                arrayList3.add(w.J);
                arrayList3.add(w.O);
                arrayList3.add(w.L);
                arrayList3.add(w.P);
                arrayList3.add(w.T);
                arrayList3.add(w.f2684i0);
                arrayList3.add(w.f2695u0);
                arrayList3.add(w.f2700x0);
                arrayList3.add(w.A0);
                arrayList3.add(w.B0);
                b(sVar3);
                s sVar4 = new s(3);
                w wVar4 = w.f2699x;
                ArrayList arrayList4 = sVar4.f2589a;
                arrayList4.add(wVar4);
                arrayList4.add(w.o0);
                arrayList4.add(w.f2692r0);
                b(sVar4);
                s sVar5 = new s(4);
                w wVar5 = w.U;
                ArrayList arrayList5 = sVar5.f2589a;
                arrayList5.add(wVar5);
                arrayList5.add(w.V);
                arrayList5.add(w.W);
                arrayList5.add(w.X);
                arrayList5.add(w.Y);
                arrayList5.add(w.Z);
                arrayList5.add(w.f2676a0);
                arrayList5.add(w.F0);
                b(sVar5);
                s sVar6 = new s(5);
                w wVar6 = w.f2697w;
                ArrayList arrayList6 = sVar6.f2589a;
                arrayList6.add(wVar6);
                arrayList6.add(w.Q);
                arrayList6.add(w.f2687l0);
                arrayList6.add(w.f2688m0);
                arrayList6.add(w.f2689n0);
                arrayList6.add(w.f2693s0);
                arrayList6.add(w.f2694t0);
                arrayList6.add(w.f2696v0);
                arrayList6.add(w.f2698w0);
                arrayList6.add(w.f2704z0);
                b(sVar6);
                s sVar7 = new s(7);
                w wVar7 = w.f2703z;
                ArrayList arrayList7 = sVar7.f2589a;
                arrayList7.add(wVar7);
                arrayList7.add(w.K);
                arrayList7.add(w.M);
                arrayList7.add(w.N);
                arrayList7.add(w.S);
                arrayList7.add(w.f2677b0);
                arrayList7.add(w.f2678c0);
                arrayList7.add(w.f2679d0);
                arrayList7.add(w.f2691q0);
                arrayList7.add(w.f2702y0);
                arrayList7.add(w.C0);
                arrayList7.add(w.D0);
                arrayList7.add(w.E0);
                b(sVar7);
                break;
        }
    }
}
