package ub;

import a2.g0;
import aa.c1;
import aa.h0;
import aa.j0;
import aa.o0;
import android.app.Notification;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.n0;
import androidx.fragment.app.q0;
import androidx.fragment.app.u0;
import androidx.fragment.app.z0;
import cc.e0;
import com.google.android.gms.internal.measurement.c4;
import com.google.android.gms.internal.measurement.m4;
import com.google.android.gms.internal.measurement.x5;
import com.google.android.gms.internal.measurement.y3;
import com.google.android.gms.internal.measurement.z9;
import e6.f0;
import g4.b0;
import g4.h1;
import g4.l1;
import g4.m1;
import g4.n1;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k8.k1;
import p1.p0;
import p1.s0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements m0.b, t3.m, e7.b {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static o f12866z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12867u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f12868v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f12869w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f12870x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f12871y;

    public /* synthetic */ o(ViewGroup viewGroup, Object obj, View view, View view2, Object obj2, int i) {
        this.f12867u = i;
        this.f12868v = obj;
        this.f12869w = view;
        this.f12870x = view2;
        this.f12871y = obj2;
    }

    public static void Q(long j5, HashMap map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j5) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    public static final Message a(o oVar, ArrayList arrayList, int i) {
        Object obj;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            if (((Message) obj2).what == i) {
                arrayList2.add(obj2);
            }
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Message) obj;
    }

    public static synchronized o z() {
        try {
            if (f12866z == null) {
                f12866z = new o(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f12866z;
    }

    public p0 A(g4.s sVar) {
        synchronized (this.f12868v) {
            try {
                return ((g4.f) ((s.e) this.f12870x).get(sVar)) != null ? null : null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public h1 B(g4.s sVar) {
        synchronized (this.f12868v) {
            try {
                return ((g4.f) ((s.e) this.f12870x).get(sVar)) != null ? null : null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public l1 C(g4.s sVar) {
        g4.f fVar;
        synchronized (this.f12868v) {
            fVar = (g4.f) ((s.e) this.f12870x).get(sVar);
        }
        if (fVar != null) {
            return fVar.f4997b;
        }
        return null;
    }

    public boolean D(Context context) {
        if (((Boolean) this.f12870x) == null) {
            this.f12870x = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!((Boolean) this.f12869w).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f12870x).booleanValue();
    }

    public boolean E(Context context) {
        if (((Boolean) this.f12869w) == null) {
            this.f12869w = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!((Boolean) this.f12869w).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f12869w).booleanValue();
    }

    public boolean F(g4.s sVar) {
        boolean z2;
        synchronized (this.f12868v) {
            z2 = ((s.e) this.f12870x).get(sVar) != null;
        }
        return z2;
    }

    public boolean G(g4.s sVar, int i) {
        g4.f fVar;
        synchronized (this.f12868v) {
            fVar = (g4.f) ((s.e) this.f12870x).get(sVar);
        }
        b0 b0Var = (b0) ((WeakReference) this.f12871y).get();
        return fVar != null && fVar.f5000e.a(i) && b0Var != null && b0Var.f4973t.w().a(i);
    }

    public boolean H(g4.s sVar, int i) {
        g4.f fVar;
        synchronized (this.f12868v) {
            fVar = (g4.f) ((s.e) this.f12870x).get(sVar);
        }
        if (fVar != null) {
            n1 n1Var = fVar.f4999d;
            n1Var.getClass();
            s1.d.a("Use contains(Command) for custom command", i != 0);
            Iterator<E> it = n1Var.f5141a.iterator();
            while (it.hasNext()) {
                if (((m1) it.next()).f5134a == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean I(g4.s sVar, m1 m1Var) {
        g4.f fVar;
        synchronized (this.f12868v) {
            fVar = (g4.f) ((s.e) this.f12870x).get(sVar);
        }
        if (fVar == null) {
            return false;
        }
        o0 o0Var = fVar.f4999d.f5141a;
        m1Var.getClass();
        return o0Var.contains(m1Var);
    }

    public void J(u0 u0Var) {
        androidx.fragment.app.v vVar = u0Var.f1374c;
        String str = vVar.f1398z;
        HashMap map = (HashMap) this.f12869w;
        if (map.get(str) != null) {
            return;
        }
        map.put(vVar.f1398z, u0Var);
        if (vVar.W) {
            if (vVar.V) {
                ((q0) this.f12871y).c(vVar);
            } else {
                ((q0) this.f12871y).f(vVar);
            }
            vVar.W = false;
        }
        if (n0.G(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + vVar);
        }
    }

    public void K(u0 u0Var) {
        androidx.fragment.app.v vVar = u0Var.f1374c;
        if (vVar.V) {
            ((q0) this.f12871y).f(vVar);
        }
        if (((u0) ((HashMap) this.f12869w).put(vVar.f1398z, null)) != null && n0.G(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + vVar);
        }
    }

    public boolean L(l.a aVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f12868v).onActionItemClicked(s(aVar), new m.r((Context) this.f12869w, (k0.a) menuItem));
    }

    public boolean M(l.a aVar, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f12868v;
        l.e eVarS = s(aVar);
        s.i iVar = (s.i) this.f12871y;
        Menu zVar = (Menu) iVar.get(menu);
        if (zVar == null) {
            zVar = new m.z((Context) this.f12869w, (m.k) menu);
            iVar.put(menu, zVar);
        }
        return callback.onCreateActionMode(eVarS, zVar);
    }

    public void N() {
        byte[] bArr = ve.b.f13497a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.f12871y).iterator();
                be.h.d(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    ye.e eVar = (ye.e) it.next();
                    if (((ArrayDeque) this.f12869w).size() >= 64) {
                        break;
                    }
                    if (eVar.f14714v.get() < 5) {
                        it.remove();
                        eVar.f14714v.incrementAndGet();
                        arrayList.add(eVar);
                        ((ArrayDeque) this.f12869w).add(eVar);
                    }
                }
                T();
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ye.e eVar2 = (ye.e) arrayList.get(i);
            ExecutorService executorServiceK = k();
            eVar2.getClass();
            ye.h hVar = eVar2.f14715w;
            byte[] bArr2 = ve.b.f13497a;
            try {
                try {
                    ((ThreadPoolExecutor) executorServiceK).execute(eVar2);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    hVar.i(interruptedIOException);
                    eVar2.f14713u.d(interruptedIOException);
                    hVar.f14718u.f13040u.p(eVar2);
                }
            } catch (Throwable th2) {
                hVar.f14718u.f13040u.p(eVar2);
                throw th2;
            }
        }
    }

    public void O(Message message) {
        LinkedBlockingDeque linkedBlockingDeque = (LinkedBlockingDeque) this.f12870x;
        if (!linkedBlockingDeque.offer(message)) {
            Log.d("SessionLifecycleClient", "Failed to enqueue message " + message.what + ". Dropping.");
            return;
        }
        Log.d("SessionLifecycleClient", "Queued message " + message.what + ". Queue size " + linkedBlockingDeque.size());
    }

    public void P(g4.s sVar) {
        synchronized (this.f12868v) {
            try {
                g4.f fVar = (g4.f) ((s.e) this.f12870x).remove(sVar);
                if (fVar == null) {
                    return;
                }
                ((s.e) this.f12869w).remove(fVar.f4996a);
                fVar.f4997b.d();
                b0 b0Var = (b0) ((WeakReference) this.f12871y).get();
                if (b0Var == null || b0Var.j()) {
                    return;
                }
                s1.b0.S(b0Var.f4965l, new g4.b(b0Var, sVar, 0));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized int T() {
        return ((ArrayDeque) this.f12869w).size() + ((ArrayDeque) this.f12870x).size();
    }

    public e2.b U(List list) {
        e2.b bVar;
        HashMap map = (HashMap) this.f12870x;
        ArrayList arrayListG = g(list);
        if (arrayListG.size() < 2) {
            return (e2.b) aa.q.j(arrayListG, null);
        }
        Collections.sort(arrayListG, new c4.d(2));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i10 = ((e2.b) arrayListG.get(0)).f4297c;
        int i11 = 0;
        while (true) {
            if (i11 >= arrayListG.size()) {
                break;
            }
            e2.b bVar2 = (e2.b) arrayListG.get(i11);
            if (i10 == bVar2.f4297c) {
                arrayList.add(new Pair(bVar2.f4296b, Integer.valueOf(bVar2.f4298d)));
                i11++;
            } else if (arrayList.size() == 1) {
                return (e2.b) arrayListG.get(0);
            }
        }
        e2.b bVar3 = (e2.b) map.get(arrayList);
        if (bVar3 != null) {
            return bVar3;
        }
        List listSubList = arrayListG.subList(0, arrayList.size());
        int i12 = 0;
        for (int i13 = 0; i13 < listSubList.size(); i13++) {
            i12 += ((e2.b) listSubList.get(i13)).f4298d;
        }
        int iNextInt = ((Random) this.f12871y).nextInt(i12);
        int i14 = 0;
        while (true) {
            if (i >= listSubList.size()) {
                bVar = (e2.b) aa.q.k(listSubList);
                break;
            }
            bVar = (e2.b) listSubList.get(i);
            i14 += bVar.f4298d;
            if (iNextInt < i14) {
                break;
            }
            i++;
        }
        map.put(arrayList, bVar);
        return bVar;
    }

    public void V(int i) {
        ArrayList arrayList = new ArrayList();
        ((LinkedBlockingDeque) this.f12870x).drainTo(arrayList);
        Message messageObtain = Message.obtain(null, i, 0, 0);
        be.h.d(messageObtain, "obtain(null, messageCode, 0, 0)");
        arrayList.add(messageObtain);
        ke.x.j(ke.x.a((rd.h) this.f12868v), null, new e0(this, arrayList, null, 1), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc A[Catch: NumberFormatException | JSONException -> 0x0108, NumberFormatException | JSONException -> 0x0108, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x0108, blocks: (B:9:0x002f, B:21:0x005b, B:21:0x005b, B:23:0x0063, B:23:0x0063, B:25:0x0070, B:25:0x0070, B:27:0x0082, B:27:0x0082, B:28:0x008b, B:28:0x008b, B:46:0x00fc, B:46:0x00fc, B:29:0x0090, B:29:0x0090, B:31:0x0098, B:31:0x0098, B:33:0x00a5, B:33:0x00a5, B:35:0x00b7, B:35:0x00b7, B:36:0x00c0, B:36:0x00c0, B:37:0x00c4, B:37:0x00c4, B:39:0x00cc, B:39:0x00cc, B:40:0x00d4, B:40:0x00d4, B:42:0x00dc, B:42:0x00dc, B:43:0x00e8, B:43:0x00e8, B:45:0x00f0, B:45:0x00f0), top: B:64:0x002f, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle W() {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.o.W():android.os.Bundle");
    }

    public com.google.android.gms.internal.measurement.n X(com.google.android.gms.internal.measurement.e eVar) {
        com.google.android.gms.internal.measurement.n nVarL0 = com.google.android.gms.internal.measurement.n.f3106a;
        Iterator itY = eVar.y();
        while (itY.hasNext()) {
            nVarL0 = ((h4.z) this.f12869w).l0(this, eVar.r(((Integer) itY.next()).intValue()));
            if (nVarL0 instanceof com.google.android.gms.internal.measurement.h) {
                break;
            }
        }
        return nVarL0;
    }

    public com.google.android.gms.internal.measurement.n Y(com.google.android.gms.internal.measurement.n nVar) {
        return ((h4.z) this.f12869w).l0(this, nVar);
    }

    public com.google.android.gms.internal.measurement.n Z(String str) {
        o oVar = this;
        do {
            HashMap map = (HashMap) oVar.f12870x;
            if (map.containsKey(str)) {
                return (com.google.android.gms.internal.measurement.n) map.get(str);
            }
            oVar = (o) oVar.f12868v;
        } while (oVar != null);
        throw new IllegalArgumentException(e6.j.m(str, " is not defined"));
    }

    public com.google.android.gms.internal.measurement.n a0(o oVar, y3... y3VarArr) {
        com.google.android.gms.internal.measurement.n nVarA = com.google.android.gms.internal.measurement.n.f3106a;
        for (y3 y3Var : y3VarArr) {
            nVarA = m4.a(y3Var);
            c4.j((o) this.f12870x);
            if ((nVarA instanceof com.google.android.gms.internal.measurement.q) || (nVarA instanceof com.google.android.gms.internal.measurement.o)) {
                nVarA = ((h4.z) this.f12868v).l0(oVar, nVarA);
            }
        }
        return nVarA;
    }

    public void b(Object obj, g4.s sVar, n1 n1Var, s0 s0Var) {
        synchronized (this.f12868v) {
            try {
                g4.s sVarX = x(obj);
                if (sVarX == null) {
                    ((s.e) this.f12869w).put(obj, sVar);
                    ((s.e) this.f12870x).put(sVar, new g4.f(obj, new l1(), n1Var, s0Var));
                } else {
                    g4.f fVar = (g4.f) ((s.e) this.f12870x).get(sVarX);
                    s1.d.h(fVar);
                    fVar.f4999d = n1Var;
                    fVar.f5000e = s0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public o b0() {
        return new o(this, (h4.z) this.f12869w);
    }

    public void c(androidx.fragment.app.v vVar) {
        if (((ArrayList) this.f12868v).contains(vVar)) {
            throw new IllegalStateException("Fragment already added: " + vVar);
        }
        synchronized (((ArrayList) this.f12868v)) {
            ((ArrayList) this.f12868v).add(vVar);
        }
        vVar.F = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c0(android.os.Bundle r18) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.o.c0(android.os.Bundle):void");
    }

    public void d(j4.d dVar) {
        if (((LinkedHashSet) this.f12871y).add(dVar)) {
            ((j4.e) this.f12869w).a(this, dVar, -1);
        }
    }

    public void d0(String str, com.google.android.gms.internal.measurement.n nVar) {
        HashMap map = (HashMap) this.f12870x;
        if (((HashMap) this.f12871y).containsKey(str)) {
            return;
        }
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    public void e(j4.h hVar, int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException(e6.j.l("Unsupported priority value: ", i).toString());
        }
        if (((LinkedHashSet) this.f12871y).add(hVar)) {
            ((j4.e) this.f12869w).a(this, hVar, i);
        }
    }

    public boolean e0(String str) {
        o oVar = this;
        while (!((HashMap) oVar.f12870x).containsKey(str)) {
            oVar = (o) oVar.f12868v;
            if (oVar == null) {
                return false;
            }
        }
        return true;
    }

    public void f(g4.s sVar, int i, g4.e eVar) {
        synchronized (this.f12868v) {
            try {
                g4.f fVar = (g4.f) ((s.e) this.f12870x).get(sVar);
                if (fVar != null) {
                    s0 s0Var = fVar.f5001g;
                    s0Var.getClass();
                    f0 f0Var = new f0(3);
                    f0Var.e(s0Var.f10058a);
                    f0Var.d(i);
                    fVar.f5001g = new s0(f0Var.f());
                    fVar.f4998c.add(eVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f0(String str, com.google.android.gms.internal.measurement.n nVar) {
        HashMap map;
        o oVar = this;
        while (true) {
            map = (HashMap) oVar.f12870x;
            o oVar2 = (o) oVar.f12868v;
            if (map.containsKey(str) || oVar2 == null || !oVar2.e0(str)) {
                break;
            } else {
                oVar = oVar2;
            }
        }
        if (((HashMap) oVar.f12871y).containsKey(str)) {
            return;
        }
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    public ArrayList g(List list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = (HashMap) this.f12868v;
        Q(jElapsedRealtime, map);
        HashMap map2 = (HashMap) this.f12869w;
        Q(jElapsedRealtime, map2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            e2.b bVar = (e2.b) list.get(i);
            if (!map.containsKey(bVar.f4296b) && !map2.containsKey(Integer.valueOf(bVar.f4297c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // md.a
    public Object get() {
        return new o((Executor) ((md.a) this.f12868v).get(), (j7.d) ((md.a) this.f12869w).get(), (a7.b) ((a7.b) this.f12870x).get(), (k7.c) ((md.a) this.f12871y).get(), 15);
    }

    @Override // t3.m
    public /* synthetic */ t3.d h(byte[] bArr, int i, int i10) {
        int i11 = this.f12867u;
        return e6.j.a(this, bArr, i10);
    }

    public void i(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((s.i) this.f12869w).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                i(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public void j(j4.d dVar, j4.b bVar) {
        j4.e eVar = (j4.e) this.f12869w;
        eVar.getClass();
        if (eVar.f6784g != 0) {
            return;
        }
        c.z zVarC = eVar.c(-1);
        eVar.f = zVarC;
        eVar.f6784g = -1;
        eVar.f6785h = dVar;
        if (bVar != null) {
            if (zVarC != null) {
                zVarC.f2206d.getClass();
            }
            ne.n nVar = eVar.f6779a;
            j4.g gVar = new j4.g(bVar);
            nVar.getClass();
            nVar.f(null, gVar);
        }
    }

    public synchronized ExecutorService k() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            if (((ThreadPoolExecutor) this.f12868v) == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                String str = ve.b.f13502g + " Dispatcher";
                be.h.e(str, "name");
                this.f12868v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new ve.a(str, false));
            }
            threadPoolExecutor = (ThreadPoolExecutor) this.f12868v;
            be.h.b(threadPoolExecutor);
        } catch (Throwable th) {
            throw th;
        }
        return threadPoolExecutor;
    }

    public androidx.fragment.app.v l(String str) {
        u0 u0Var = (u0) ((HashMap) this.f12869w).get(str);
        if (u0Var != null) {
            return u0Var.f1374c;
        }
        return null;
    }

    @Override // t3.m
    public int m() {
        switch (this.f12867u) {
        }
        return 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
    @Override // t3.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(byte[] r43, int r44, int r45, t3.l r46, s1.h r47) {
        /*
            Method dump skipped, instruction units count: 1218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.o.n(byte[], int, int, t3.l, s1.h):void");
    }

    public androidx.fragment.app.v o(String str) {
        for (u0 u0Var : ((HashMap) this.f12869w).values()) {
            if (u0Var != null) {
                androidx.fragment.app.v vVarO = u0Var.f1374c;
                if (!str.equals(vVarO.f1398z)) {
                    vVarO = vVarO.O.f1312c.o(str);
                }
                if (vVarO != null) {
                    return vVarO;
                }
            }
        }
        return null;
    }

    @Override // m0.b
    public void onCancel() {
        View view = (View) this.f12868v;
        view.clearAnimation();
        ((ViewGroup) this.f12869w).endViewTransition(view);
        ((androidx.fragment.app.g) this.f12870x).d();
        if (n0.G(2)) {
            Log.v("FragmentManager", "Animation from operation " + ((z0) this.f12871y) + " has been cancelled.");
        }
    }

    public void p(ye.e eVar) {
        eVar.f14714v.decrementAndGet();
        ArrayDeque arrayDeque = (ArrayDeque) this.f12869w;
        synchronized (this) {
            if (!arrayDeque.remove(eVar)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        N();
    }

    public void q(g4.f fVar) {
        b0 b0Var = (b0) ((WeakReference) this.f12871y).get();
        if (b0Var == null) {
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        while (atomicBoolean.get()) {
            atomicBoolean.set(false);
            final g4.e eVar = (g4.e) fVar.f4998c.poll();
            if (eVar == null) {
                fVar.f = false;
                return;
            }
            final AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
            final g4.f fVar2 = fVar;
            s1.b0.S(b0Var.f4965l, new g0(b0Var, x(fVar.f4996a), new Runnable() { // from class: g4.d
                @Override // java.lang.Runnable
                public final void run() {
                    eVar.run().f(new c2.w(this.f4986u, atomicBoolean2, fVar2, atomicBoolean, 2), ea.r.f4628u);
                }
            }));
            atomicBoolean2.set(false);
            fVar = fVar2;
        }
    }

    public void r(final g4.s sVar) {
        synchronized (this.f12868v) {
            try {
                g4.f fVar = (g4.f) ((s.e) this.f12870x).get(sVar);
                if (fVar == null) {
                    return;
                }
                final s0 s0Var = fVar.f5001g;
                fVar.f5001g = s0.f10056b;
                fVar.f4998c.add(new g4.e(sVar, s0Var) { // from class: g4.c

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ s f4983b;

                    @Override // g4.e
                    public final ea.y run() {
                        b0 b0Var = (b0) ((WeakReference) this.f4982a.f12871y).get();
                        if (b0Var != null) {
                            b0Var.p(this.f4983b);
                        }
                        return ea.v.f4633v;
                    }
                });
                if (fVar.f) {
                    return;
                }
                fVar.f = true;
                q(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t3.m
    public /* synthetic */ void reset() {
        int i = this.f12867u;
    }

    public l.e s(l.a aVar) {
        ArrayList arrayList = (ArrayList) this.f12870x;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            l.e eVar = (l.e) arrayList.get(i);
            if (eVar != null && eVar.f7763b == aVar) {
                return eVar;
            }
        }
        l.e eVar2 = new l.e((Context) this.f12869w, aVar);
        arrayList.add(eVar2);
        return eVar2;
    }

    public ArrayList t() {
        ArrayList arrayList = new ArrayList();
        for (u0 u0Var : ((HashMap) this.f12869w).values()) {
            if (u0Var != null) {
                arrayList.add(u0Var);
            }
        }
        return arrayList;
    }

    public ArrayList u() {
        ArrayList arrayList = new ArrayList();
        for (u0 u0Var : ((HashMap) this.f12869w).values()) {
            if (u0Var != null) {
                arrayList.add(u0Var.f1374c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public s0 v(g4.s sVar) {
        synchronized (this.f12868v) {
            try {
                g4.f fVar = (g4.f) ((s.e) this.f12870x).get(sVar);
                if (fVar == null) {
                    return null;
                }
                return fVar.f5000e;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j0 w() {
        j0 j0VarR;
        synchronized (this.f12868v) {
            j0VarR = j0.r(((s.e) this.f12869w).values());
        }
        return j0VarR;
    }

    public g4.s x(Object obj) {
        g4.s sVar;
        synchronized (this.f12868v) {
            sVar = (g4.s) ((s.e) this.f12869w).get(obj);
        }
        return sVar;
    }

    public List y() {
        ArrayList arrayList;
        if (((ArrayList) this.f12868v).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.f12868v)) {
            arrayList = new ArrayList((ArrayList) this.f12868v);
        }
        return arrayList;
    }

    public /* synthetic */ o(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f12867u = i;
        this.f12868v = obj;
        this.f12869w = obj2;
        this.f12870x = obj3;
        this.f12871y = obj4;
    }

    public o(o oVar, h4.z zVar) {
        this.f12867u = 9;
        this.f12870x = new HashMap();
        this.f12871y = new HashMap();
        this.f12868v = oVar;
        this.f12869w = zVar;
    }

    public o(rd.h hVar) {
        this.f12867u = 7;
        this.f12868v = hVar;
        this.f12870x = new LinkedBlockingDeque(20);
        this.f12871y = new cc.s0(this);
    }

    public o(a2.f0 f0Var) {
        this.f12867u = 17;
        this.f12868v = f0Var;
        this.f12869w = new j4.e();
        new LinkedHashSet();
        this.f12870x = new LinkedHashSet();
        this.f12871y = new LinkedHashSet();
    }

    public o(List list) {
        int i;
        this.f12867u = 4;
        this.f12868v = new s1.u();
        this.f12869w = new s1.u();
        b4.a aVar = new b4.a();
        this.f12870x = aVar;
        String strTrim = new String((byte[]) list.get(0), StandardCharsets.UTF_8).trim();
        int i10 = s1.b0.f11647a;
        for (String str : strTrim.split("\\r?\\n", -1)) {
            if (str.startsWith("palette: ")) {
                String[] strArrSplit = str.substring(9).split(",", -1);
                aVar.f1809d = new int[strArrSplit.length];
                for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                    int[] iArr = aVar.f1809d;
                    try {
                        i = Integer.parseInt(strArrSplit[i11].trim(), 16);
                    } catch (RuntimeException unused) {
                        i = 0;
                    }
                    iArr[i11] = i;
                }
            } else if (str.startsWith("size: ")) {
                String[] strArrSplit2 = str.substring(6).trim().split("x", -1);
                if (strArrSplit2.length == 2) {
                    try {
                        aVar.f1810e = Integer.parseInt(strArrSplit2[0]);
                        aVar.f = Integer.parseInt(strArrSplit2[1]);
                        aVar.f1807b = true;
                    } catch (RuntimeException e10) {
                        s1.b.q("VobsubParser", "Parsing IDX failed", e10);
                    }
                }
            }
        }
    }

    private final /* synthetic */ void R() {
    }

    private final /* synthetic */ void S() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(e0.m mVar) {
        Bundle bundle;
        int i;
        ArrayList arrayList;
        Bundle bundle2;
        int i10;
        this.f12867u = 11;
        new ArrayList();
        this.f12871y = new Bundle();
        this.f12870x = mVar;
        Context context = mVar.f4256a;
        ArrayList arrayList2 = mVar.f4273t;
        ArrayList arrayList3 = mVar.f4258c;
        ArrayList arrayList4 = mVar.f4259d;
        this.f12868v = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f12869w = e0.o.a(context, mVar.f4270q);
        } else {
            this.f12869w = new Notification.Builder(context);
        }
        Notification notification = mVar.f4272s;
        Context context2 = null;
        ((Notification.Builder) this.f12869w).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(mVar.f4260e).setContentText(mVar.f).setContentInfo(null).setContentIntent(mVar.f4261g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(mVar.i).setProgress(0, 0, false);
        Notification.Builder builder = (Notification.Builder) this.f12869w;
        IconCompat iconCompat = mVar.f4262h;
        builder.setLargeIcon(iconCompat == null ? null : iconCompat.f(context));
        ((Notification.Builder) this.f12869w).setSubText(null).setUsesChronometer(false).setPriority(mVar.f4263j);
        ArrayList arrayList5 = mVar.f4257b;
        int size = arrayList5.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList5.get(i11);
            i11++;
            e0.g gVar = (e0.g) obj;
            int i12 = Build.VERSION.SDK_INT;
            if (gVar.f4247b == null && (i10 = gVar.f4250e) != 0) {
                gVar.f4247b = IconCompat.b(i10);
            }
            IconCompat iconCompat2 = gVar.f4247b;
            boolean z2 = gVar.f4248c;
            Bundle bundle3 = gVar.f4246a;
            ArrayList arrayList6 = arrayList5;
            ArrayList arrayList7 = arrayList3;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompat2 != null ? iconCompat2.f(context2) : context2, gVar.f, gVar.f4251g);
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android.support.allowGeneratedReplies", z2);
            if (i12 >= 24) {
                e0.n.b(builder2, z2);
            }
            bundle2.putInt("android.support.action.semanticAction", 0);
            if (i12 >= 28) {
                e0.p.a(builder2);
            }
            if (i12 >= 29) {
                e0.d.d(builder2);
            }
            if (i12 >= 31) {
                e0.q.a(builder2);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", gVar.f4249d);
            builder2.addExtras(bundle2);
            ((Notification.Builder) this.f12869w).addAction(builder2.build());
            arrayList5 = arrayList6;
            arrayList3 = arrayList7;
            context2 = null;
        }
        ArrayList arrayList8 = arrayList3;
        Bundle bundle4 = mVar.f4267n;
        if (bundle4 != null) {
            ((Bundle) this.f12871y).putAll(bundle4);
        }
        int i13 = Build.VERSION.SDK_INT;
        ((Notification.Builder) this.f12869w).setShowWhen(mVar.f4264k);
        ((Notification.Builder) this.f12869w).setLocalOnly(mVar.f4266m);
        ((Notification.Builder) this.f12869w).setGroup(null);
        ((Notification.Builder) this.f12869w).setSortKey(null);
        ((Notification.Builder) this.f12869w).setGroupSummary(false);
        ((Notification.Builder) this.f12869w).setCategory(null);
        ((Notification.Builder) this.f12869w).setColor(mVar.f4268o);
        ((Notification.Builder) this.f12869w).setVisibility(mVar.f4269p);
        ((Notification.Builder) this.f12869w).setPublicVersion(null);
        ((Notification.Builder) this.f12869w).setSound(notification.sound, notification.audioAttributes);
        if (i13 < 28) {
            if (arrayList8 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList8.size());
                Iterator it = arrayList8.iterator();
                if (it.hasNext()) {
                    throw l4.a.k(it);
                }
            }
            if (arrayList != null) {
                if (arrayList2 == null) {
                    arrayList2 = arrayList;
                } else {
                    s.f fVar = new s.f(arrayList2.size() + arrayList.size());
                    fVar.addAll(arrayList);
                    fVar.addAll(arrayList2);
                    arrayList2 = new ArrayList(fVar);
                }
            }
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int size2 = arrayList2.size();
            int i14 = 0;
            while (i14 < size2) {
                Object obj2 = arrayList2.get(i14);
                i14++;
                ((Notification.Builder) this.f12869w).addPerson((String) obj2);
            }
        }
        if (arrayList4.size() > 0) {
            if (mVar.f4267n == null) {
                mVar.f4267n = new Bundle();
            }
            Bundle bundle5 = mVar.f4267n.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            for (int i15 = 0; i15 < arrayList4.size(); i15++) {
                String string = Integer.toString(i15);
                e0.g gVar2 = (e0.g) arrayList4.get(i15);
                Bundle bundle8 = new Bundle();
                if (gVar2.f4247b == null && (i = gVar2.f4250e) != 0) {
                    gVar2.f4247b = IconCompat.b(i);
                }
                IconCompat iconCompat3 = gVar2.f4247b;
                Bundle bundle9 = gVar2.f4246a;
                bundle8.putInt("icon", iconCompat3 != null ? iconCompat3.c() : 0);
                bundle8.putCharSequence("title", gVar2.f);
                bundle8.putParcelable("actionIntent", gVar2.f4251g);
                if (bundle9 != null) {
                    bundle = new Bundle(bundle9);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", gVar2.f4248c);
                bundle8.putBundle("extras", bundle);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", gVar2.f4249d);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(string, bundle8);
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (mVar.f4267n == null) {
                mVar.f4267n = new Bundle();
            }
            mVar.f4267n.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) this.f12871y).putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 24) {
            ((Notification.Builder) this.f12869w).setExtras(mVar.f4267n);
            e0.n.c((Notification.Builder) this.f12869w);
        }
        if (i16 >= 26) {
            e0.o.b((Notification.Builder) this.f12869w);
            e0.o.d((Notification.Builder) this.f12869w);
            e0.o.e((Notification.Builder) this.f12869w);
            e0.o.f((Notification.Builder) this.f12869w);
            e0.o.c((Notification.Builder) this.f12869w);
            if (!TextUtils.isEmpty(mVar.f4270q)) {
                ((Notification.Builder) this.f12869w).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i16 >= 28) {
            Iterator it2 = arrayList8.iterator();
            if (it2.hasNext()) {
                throw l4.a.k(it2);
            }
        }
        if (i16 >= 29) {
            e0.d.b((Notification.Builder) this.f12869w, mVar.f4271r);
            e0.d.c((Notification.Builder) this.f12869w);
        }
    }

    public o(b0 b0Var) {
        this.f12867u = 13;
        this.f12869w = new s.e(0);
        this.f12870x = new s.e(0);
        this.f12868v = new Object();
        this.f12871y = new WeakReference(b0Var);
    }

    public o(Typeface typeface, f1.b bVar) {
        int i;
        int i10;
        int i11;
        int i12;
        this.f12867u = 1;
        this.f12871y = typeface;
        this.f12868v = bVar;
        this.f12870x = new androidx.emoji2.text.v(1024);
        int iA = bVar.a(6);
        if (iA != 0) {
            int i13 = iA + bVar.f4691u;
            i = ((ByteBuffer) bVar.f4694x).getInt(((ByteBuffer) bVar.f4694x).getInt(i13) + i13);
        } else {
            i = 0;
        }
        this.f12869w = new char[i * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i14 = iA2 + bVar.f4691u;
            i10 = ((ByteBuffer) bVar.f4694x).getInt(((ByteBuffer) bVar.f4694x).getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        for (int i15 = 0; i15 < i10; i15++) {
            androidx.emoji2.text.y yVar = new androidx.emoji2.text.y(this, i15);
            f1.a aVarB = yVar.b();
            int iA3 = aVarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) aVarB.f4694x).getInt(iA3 + aVarB.f4691u) : 0, (char[]) this.f12869w, i15 * 2);
            f1.a aVarB2 = yVar.b();
            int iA4 = aVarB2.a(16);
            if (iA4 != 0) {
                int i16 = iA4 + aVarB2.f4691u;
                i11 = ((ByteBuffer) aVarB2.f4694x).getInt(((ByteBuffer) aVarB2.f4694x).getInt(i16) + i16);
            } else {
                i11 = 0;
            }
            cf.l.g("invalid metadata codepoint length", i11 > 0);
            androidx.emoji2.text.v vVar = (androidx.emoji2.text.v) this.f12870x;
            f1.a aVarB3 = yVar.b();
            int iA5 = aVarB3.a(16);
            if (iA5 != 0) {
                int i17 = iA5 + aVarB3.f4691u;
                i12 = ((ByteBuffer) aVarB3.f4694x).getInt(((ByteBuffer) aVarB3.f4694x).getInt(i17) + i17);
            } else {
                i12 = 0;
            }
            vVar.a(yVar, 0, i12 - 1);
        }
    }

    public o(Context context, View view) {
        this.f12867u = 24;
        int i = g.a.popupMenuStyle;
        this.f12869w = view;
        m.k kVar = new m.k(context);
        this.f12868v = kVar;
        kVar.f8209e = new u5.d(22, this);
        m.u uVar = new m.u(context, kVar, view, false, i, 0);
        this.f12870x = uVar;
        uVar.f = 0;
        uVar.f8273j = new m.t(1, this);
    }

    public o(k8.z0 z0Var, String str) {
        this.f12867u = 18;
        this.f12871y = z0Var;
        t7.v.d(str);
        this.f12868v = str;
        if (((k1) z0Var.f2454v).A.A1(null, k8.w.f7492k1)) {
            this.f12869w = new Bundle();
        } else {
            this.f12869w = new Bundle();
        }
    }

    public o(int i) {
        this.f12867u = i;
        switch (i) {
            case 3:
                this.f12868v = new ArrayList();
                this.f12869w = new HashMap();
                this.f12870x = new HashMap();
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                this.f12868v = new p0.d(10);
                this.f12869w = new s.i(0);
                this.f12870x = new ArrayList();
                this.f12871y = new HashSet();
                break;
            case 8:
                h4.z zVar = new h4.z(8, false);
                zVar.f5867v = new HashMap();
                zVar.f5868w = new com.google.android.gms.internal.measurement.s(6);
                com.google.android.gms.internal.measurement.s sVar = new com.google.android.gms.internal.measurement.s(0);
                com.google.android.gms.internal.measurement.g0 g0Var = com.google.android.gms.internal.measurement.g0.f3006z;
                ArrayList arrayList = sVar.f3185a;
                arrayList.add(g0Var);
                arrayList.add(com.google.android.gms.internal.measurement.g0.A);
                arrayList.add(com.google.android.gms.internal.measurement.g0.B);
                arrayList.add(com.google.android.gms.internal.measurement.g0.C);
                arrayList.add(com.google.android.gms.internal.measurement.g0.D);
                arrayList.add(com.google.android.gms.internal.measurement.g0.E);
                arrayList.add(com.google.android.gms.internal.measurement.g0.F);
                zVar.n0(sVar);
                com.google.android.gms.internal.measurement.s sVar2 = new com.google.android.gms.internal.measurement.s(1);
                com.google.android.gms.internal.measurement.g0 g0Var2 = com.google.android.gms.internal.measurement.g0.Q;
                ArrayList arrayList2 = sVar2.f3185a;
                arrayList2.add(g0Var2);
                arrayList2.add(com.google.android.gms.internal.measurement.g0.f2981d0);
                arrayList2.add(com.google.android.gms.internal.measurement.g0.f2982e0);
                arrayList2.add(com.google.android.gms.internal.measurement.g0.f2983f0);
                arrayList2.add(com.google.android.gms.internal.measurement.g0.f2984g0);
                arrayList2.add(com.google.android.gms.internal.measurement.g0.f2986i0);
                arrayList2.add(com.google.android.gms.internal.measurement.g0.f2987j0);
                arrayList2.add(com.google.android.gms.internal.measurement.g0.f2991o0);
                zVar.n0(sVar2);
                com.google.android.gms.internal.measurement.s sVar3 = new com.google.android.gms.internal.measurement.s(2);
                com.google.android.gms.internal.measurement.g0 g0Var3 = com.google.android.gms.internal.measurement.g0.f3002x;
                ArrayList arrayList3 = sVar3.f3185a;
                arrayList3.add(g0Var3);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.G);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.H);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.I);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.N);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.K);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.O);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.S);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.f2985h0);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.f2996t0);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.f3001w0);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.f3007z0);
                arrayList3.add(com.google.android.gms.internal.measurement.g0.A0);
                zVar.n0(sVar3);
                com.google.android.gms.internal.measurement.s sVar4 = new com.google.android.gms.internal.measurement.s(3);
                com.google.android.gms.internal.measurement.g0 g0Var4 = com.google.android.gms.internal.measurement.g0.f3000w;
                ArrayList arrayList4 = sVar4.f3185a;
                arrayList4.add(g0Var4);
                arrayList4.add(com.google.android.gms.internal.measurement.g0.f2990n0);
                arrayList4.add(com.google.android.gms.internal.measurement.g0.f2993q0);
                zVar.n0(sVar4);
                com.google.android.gms.internal.measurement.s sVar5 = new com.google.android.gms.internal.measurement.s(4);
                com.google.android.gms.internal.measurement.g0 g0Var5 = com.google.android.gms.internal.measurement.g0.T;
                ArrayList arrayList5 = sVar5.f3185a;
                arrayList5.add(g0Var5);
                arrayList5.add(com.google.android.gms.internal.measurement.g0.U);
                arrayList5.add(com.google.android.gms.internal.measurement.g0.V);
                arrayList5.add(com.google.android.gms.internal.measurement.g0.W);
                arrayList5.add(com.google.android.gms.internal.measurement.g0.X);
                arrayList5.add(com.google.android.gms.internal.measurement.g0.Y);
                arrayList5.add(com.google.android.gms.internal.measurement.g0.Z);
                arrayList5.add(com.google.android.gms.internal.measurement.g0.E0);
                zVar.n0(sVar5);
                com.google.android.gms.internal.measurement.s sVar6 = new com.google.android.gms.internal.measurement.s(5);
                com.google.android.gms.internal.measurement.g0 g0Var6 = com.google.android.gms.internal.measurement.g0.f2998v;
                ArrayList arrayList6 = sVar6.f3185a;
                arrayList6.add(g0Var6);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.P);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.f2988k0);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.l0);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.f2989m0);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.f2994r0);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.f2995s0);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.f2997u0);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.f2999v0);
                arrayList6.add(com.google.android.gms.internal.measurement.g0.f3005y0);
                zVar.n0(sVar6);
                com.google.android.gms.internal.measurement.s sVar7 = new com.google.android.gms.internal.measurement.s(7);
                com.google.android.gms.internal.measurement.g0 g0Var7 = com.google.android.gms.internal.measurement.g0.f3004y;
                ArrayList arrayList7 = sVar7.f3185a;
                arrayList7.add(g0Var7);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.J);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.L);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.M);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.R);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.f2978a0);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.f2979b0);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.f2980c0);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.f2992p0);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.f3003x0);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.B0);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.C0);
                arrayList7.add(com.google.android.gms.internal.measurement.g0.D0);
                zVar.n0(sVar7);
                this.f12868v = zVar;
                o oVar = new o((o) null, zVar);
                this.f12870x = oVar;
                this.f12869w = oVar.b0();
                x5 x5Var = new x5();
                HashMap map = new HashMap();
                x5Var.f3235a = map;
                this.f12871y = x5Var;
                oVar.f0("require", new z9(x5Var));
                map.put("internal.platform", new com.google.android.gms.internal.measurement.k1());
                oVar.f0("runtime.counter", new com.google.android.gms.internal.measurement.g(Double.valueOf(0.0d)));
                break;
            case 10:
                Random random = new Random();
                this.f12870x = new HashMap();
                this.f12871y = random;
                this.f12868v = new HashMap();
                this.f12869w = new HashMap();
                break;
            case 12:
                break;
            case 14:
                this.f12868v = new s.e(0);
                this.f12869w = new SparseArray();
                this.f12870x = new s.g();
                this.f12871y = new s.e(0);
                break;
            case 28:
                this.f12871y = new ArrayDeque();
                this.f12869w = new ArrayDeque();
                this.f12870x = new ArrayDeque();
                break;
            case 29:
                this.f12868v = new s1.u();
                this.f12869w = new s1.u();
                this.f12870x = new w3.a();
                break;
            default:
                this.f12868v = null;
                this.f12869w = null;
                this.f12870x = null;
                this.f12871y = new ArrayDeque();
                break;
        }
    }

    public o(Context context, ActionMode.Callback callback) {
        this.f12867u = 23;
        this.f12869w = context;
        this.f12868v = callback;
        this.f12870x = new ArrayList();
        this.f12871y = new s.i(0);
    }

    public o(c1 c1Var, t1.j jVar, p2.c cVar, t1.j jVar2) {
        Object objR;
        this.f12867u = 27;
        if (c1Var != null) {
            objR = j0.r(c1Var);
        } else {
            h0 h0Var = j0.f690v;
            objR = c1.f650y;
        }
        this.f12868v = objR;
        this.f12869w = jVar;
        this.f12870x = cVar;
        this.f12871y = jVar2;
    }

    public o(o2.n1 n1Var, boolean[] zArr) {
        this.f12867u = 25;
        this.f12868v = n1Var;
        this.f12869w = zArr;
        int i = n1Var.f9178a;
        this.f12870x = new boolean[i];
        this.f12871y = new boolean[i];
    }
}
