package nc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.fragment.app.r0;
import androidx.fragment.app.u0;
import androidx.fragment.app.z0;
import androidx.media3.ui.PlayerView;
import c.b0;
import com.google.android.gms.internal.measurement.d1;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.v9;
import com.google.android.gms.internal.measurement.w3;
import com.google.android.gms.internal.measurement.w5;
import f9.f0;
import f9.f1;
import f9.r1;
import f9.w0;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static p f9068e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f9072d;

    public /* synthetic */ p(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f9069a = obj;
        this.f9070b = obj2;
        this.f9071c = obj3;
        this.f9072d = obj4;
    }

    public static synchronized p p() {
        try {
            if (f9068e == null) {
                f9068e = new p(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9068e;
    }

    public static p s(LayoutInflater layoutInflater) {
        View viewL;
        View viewInflate = layoutInflater.inflate(q5.l.layout_floating_player, (ViewGroup) null, false);
        int i = q5.k.player_view;
        PlayerView playerView = (PlayerView) android.support.v4.media.session.b.l(viewInflate, i);
        if (playerView != null) {
            i = q5.k.progress;
            ProgressBar progressBar = (ProgressBar) android.support.v4.media.session.b.l(viewInflate, i);
            if (progressBar != null && (viewL = android.support.v4.media.session.b.l(viewInflate, (i = q5.k.swipe_binding))) != null) {
                return new p((RelativeLayout) viewInflate, playerView, progressBar, l7.a.k(viewL));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static void x(p pVar, of.k kVar, of.k kVar2, int i) {
        p6.c cVar;
        if ((i & 1) != 0) {
            kVar = null;
        }
        if ((i & 4) != 0) {
            kVar2 = null;
        }
        pVar.getClass();
        TimeZone timeZone = lf.f.f7964a;
        boolean zIsShutdown = ((ThreadPoolExecutor) pVar.h()).isShutdown();
        synchronized (pVar) {
            if (kVar2 != null) {
                try {
                    kVar2.f9813w.decrementAndGet();
                    if (!((ArrayDeque) pVar.f9070b).remove(kVar2)) {
                        throw new IllegalStateException("Call wasn't in-flight!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (kVar != null) {
                ((ArrayDeque) pVar.f9072d).add(kVar);
                of.k kVarJ = pVar.j(((kf.q) kVar.f9814x.f9818w.f2035b).f7518d);
                if (kVarJ != null) {
                    kVar.f9813w = kVarJ.f9813w;
                }
            }
            if (kVar2 != null && (zIsShutdown || ((ArrayDeque) pVar.f9070b).isEmpty())) {
                ((ArrayDeque) pVar.f9071c).isEmpty();
            }
            int i10 = 28;
            if (zIsShutdown) {
                List listR0 = sd.j.r0((ArrayDeque) pVar.f9072d);
                ((ArrayDeque) pVar.f9072d).clear();
                cVar = new p6.c(i10, listR0);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayDeque) pVar.f9072d).iterator();
                ge.i.d(it, "iterator(...)");
                while (it.hasNext()) {
                    of.k kVar3 = (of.k) it.next();
                    if (((ArrayDeque) pVar.f9070b).size() >= 64) {
                        break;
                    }
                    if (kVar3.f9813w.get() < 5) {
                        it.remove();
                        kVar3.f9813w.incrementAndGet();
                        arrayList.add(kVar3);
                        ((ArrayDeque) pVar.f9070b).add(kVar3);
                    }
                }
                cVar = new p6.c(i10, arrayList);
            }
        }
        int size = ((List) cVar.f10035w).size();
        for (int i11 = 0; i11 < size; i11++) {
            of.k kVar4 = (of.k) ((List) cVar.f10035w).get(i11);
            if (kVar4 != kVar) {
                of.n nVar = kVar4.f9814x;
            }
            if (zIsShutdown) {
                kVar4.getClass();
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(null);
                kVar4.f9814x.i(interruptedIOException);
                kVar4.f9812v.j(interruptedIOException);
            } else {
                ExecutorService executorServiceH = pVar.h();
                kVar4.getClass();
                of.n nVar2 = kVar4.f9814x;
                ge.i.e(nVar2.f9817v.f7548a, "<this>");
                try {
                    try {
                        ((ThreadPoolExecutor) executorServiceH).execute(kVar4);
                    } catch (RejectedExecutionException e9) {
                        InterruptedIOException interruptedIOException2 = new InterruptedIOException("executor rejected");
                        interruptedIOException2.initCause(e9);
                        kVar4.f9814x.i(interruptedIOException2);
                        kVar4.f9812v.j(interruptedIOException2);
                        p pVar2 = nVar2.f9817v.f7548a;
                        pVar2.getClass();
                        x(pVar2, null, kVar4, 3);
                    }
                } catch (Throwable th2) {
                    p pVar3 = nVar2.f9817v.f7548a;
                    pVar3.getClass();
                    x(pVar3, null, kVar4, 3);
                    throw th2;
                }
            }
        }
    }

    public static void y(long j4, HashMap map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j4) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    public k2.b A(List list) {
        k2.b bVar;
        HashMap map = (HashMap) this.f9071c;
        ArrayList arrayListD = d(list);
        if (arrayListD.size() < 2) {
            return (k2.b) ua.q.k(arrayListD, null);
        }
        Collections.sort(arrayListD, new g4.d(2));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i10 = ((k2.b) arrayListD.get(0)).f6829c;
        int i11 = 0;
        while (true) {
            if (i11 >= arrayListD.size()) {
                break;
            }
            k2.b bVar2 = (k2.b) arrayListD.get(i11);
            if (i10 == bVar2.f6829c) {
                arrayList.add(new Pair(bVar2.f6828b, Integer.valueOf(bVar2.f6830d)));
                i11++;
            } else if (arrayList.size() == 1) {
                return (k2.b) arrayListD.get(0);
            }
        }
        k2.b bVar3 = (k2.b) map.get(arrayList);
        if (bVar3 != null) {
            return bVar3;
        }
        List listSubList = arrayListD.subList(0, arrayList.size());
        int i12 = 0;
        for (int i13 = 0; i13 < listSubList.size(); i13++) {
            i12 += ((k2.b) listSubList.get(i13)).f6830d;
        }
        int iNextInt = ((Random) this.f9072d).nextInt(i12);
        int i14 = 0;
        while (true) {
            if (i >= listSubList.size()) {
                bVar = (k2.b) ua.q.l(listSubList);
                break;
            }
            bVar = (k2.b) listSubList.get(i);
            i14 += bVar.f6830d;
            if (iNextInt < i14) {
                break;
            }
            i++;
        }
        map.put(arrayList, bVar);
        return bVar;
    }

    public Bundle B(String str, Bundle bundle) {
        HashMap map = (HashMap) this.f9071c;
        return bundle != null ? (Bundle) map.put(str, bundle) : (Bundle) map.remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00fe A[Catch: NumberFormatException | JSONException -> 0x010b, NumberFormatException | JSONException -> 0x010b, TRY_LEAVE, TryCatch #0 {NumberFormatException | JSONException -> 0x010b, blocks: (B:10:0x0031, B:24:0x0065, B:24:0x0065, B:26:0x0072, B:26:0x0072, B:28:0x0084, B:28:0x0084, B:29:0x008d, B:29:0x008d, B:51:0x00fe, B:51:0x00fe, B:33:0x009a, B:33:0x009a, B:35:0x00a7, B:35:0x00a7, B:37:0x00b9, B:37:0x00b9, B:38:0x00c2, B:38:0x00c2, B:42:0x00ce, B:42:0x00ce, B:46:0x00de, B:46:0x00de, B:50:0x00f2, B:50:0x00f2), top: B:63:0x0031, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle C() {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.p.C():android.os.Bundle");
    }

    public com.google.android.gms.internal.measurement.n D(b6.f fVar, w3... w3VarArr) {
        com.google.android.gms.internal.measurement.n nVarX = com.google.android.gms.internal.measurement.n.f2536b;
        for (w3 w3Var : w3VarArr) {
            nVarX = t1.x(w3Var);
            n5.a.c0((b6.f) this.f9071c);
            if ((nVarX instanceof com.google.android.gms.internal.measurement.o) || (nVarX instanceof com.google.android.gms.internal.measurement.m)) {
                nVarX = ((com.google.android.gms.internal.measurement.t) this.f9069a).c(fVar, nVarX);
            }
        }
        return nVarX;
    }

    public void E(Bundle bundle) {
        String str = (String) this.f9069a;
        f1 f1Var = (f1) this.f9072d;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        SharedPreferences sharedPreferencesQ1 = f1Var.q1();
        r1 r1Var = (r1) f1Var.f307w;
        SharedPreferences.Editor editorEdit = sharedPreferencesQ1.edit();
        if (bundle2.size() == 0) {
            editorEdit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        q8.a();
                        if (r1Var.f4366y.w1(null, f0.R0)) {
                            if (obj instanceof String) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "l");
                            } else if (obj instanceof int[]) {
                                jSONObject.put("v", Arrays.toString((int[]) obj));
                                jSONObject.put("t", "ia");
                            } else if (obj instanceof long[]) {
                                jSONObject.put("v", Arrays.toString((long[]) obj));
                                jSONObject.put("t", "la");
                            } else if (obj instanceof Double) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "d");
                            } else {
                                w0 w0Var = r1Var.A;
                                r1.g(w0Var);
                                w0Var.B.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            }
                            jSONArray.put(jSONObject);
                        } else {
                            jSONObject.put("v", obj.toString());
                            if (obj instanceof String) {
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("t", "l");
                            } else if (obj instanceof Double) {
                                jSONObject.put("t", "d");
                            } else {
                                w0 w0Var2 = r1Var.A;
                                r1.g(w0Var2);
                                w0Var2.B.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            }
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e9) {
                        w0 w0Var3 = r1Var.A;
                        r1.g(w0Var3);
                        w0Var3.B.b(e9, "Cannot serialize bundle value to SharedPreferences");
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.f9071c = bundle2;
    }

    public void a(androidx.fragment.app.y yVar) {
        if (((ArrayList) this.f9069a).contains(yVar)) {
            throw new IllegalStateException("Fragment already added: " + yVar);
        }
        synchronized (((ArrayList) this.f9069a)) {
            ((ArrayList) this.f9069a).add(yVar);
        }
        yVar.G = true;
    }

    public void b(o4.d dVar) {
        if (((LinkedHashSet) this.f9072d).add(dVar)) {
            ((o4.e) this.f9070b).a(this, dVar, -1);
        }
    }

    public void c(o4.h hVar, int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException(l0.e.g(i, "Unsupported priority value: ").toString());
        }
        if (((LinkedHashSet) this.f9072d).add(hVar)) {
            ((o4.e) this.f9070b).a(this, hVar, i);
        }
    }

    public ArrayList d(List list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = (HashMap) this.f9069a;
        y(jElapsedRealtime, map);
        HashMap map2 = (HashMap) this.f9070b;
        y(jElapsedRealtime, map2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            k2.b bVar = (k2.b) list.get(i);
            if (!map.containsKey(bVar.f6828b) && !map2.containsKey(Integer.valueOf(bVar.f6829c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((v.k) this.f9070b).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                e(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public void f(o4.d dVar, o4.b bVar) {
        o4.e eVar = (o4.e) this.f9070b;
        eVar.getClass();
        if (eVar.f9495g != 0) {
            return;
        }
        b0 b0VarC = eVar.c(-1);
        eVar.f = b0VarC;
        eVar.f9495g = -1;
        eVar.f9496h = dVar;
        if (bVar != null) {
            if (b0VarC != null) {
                b0VarC.f1934d.getClass();
            }
            se.x xVar = eVar.f9490a;
            o4.g gVar = new o4.g(bVar);
            xVar.getClass();
            xVar.e(null, gVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(xd.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f9072d
            d1.h0 r0 = (d1.h0) r0
            boolean r1 = r7 instanceof d1.j
            if (r1 == 0) goto L17
            r1 = r7
            d1.j r1 = (d1.j) r1
            int r2 = r1.B
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.B = r2
            goto L1c
        L17:
            d1.j r1 = new d1.j
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f3252z
            int r2 = r1.B
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            nc.p r0 = r1.f3251y
            com.bumptech.glide.c.C(r7)
            goto L64
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            nc.p r0 = r1.f3251y
            com.bumptech.glide.c.C(r7)
            goto L74
        L3c:
            com.bumptech.glide.c.C(r7)
            java.lang.Object r7 = r6.f9071c
            java.util.List r7 = (java.util.List) r7
            wd.a r2 = wd.a.f14143v
            if (r7 == 0) goto L67
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4e
            goto L67
        L4e:
            d1.s0 r7 = r0.h()
            d1.m r4 = new d1.m
            r5 = 0
            r4.<init>(r0, r6, r5)
            r1.f3251y = r6
            r1.B = r3
            java.lang.Object r7 = r7.b(r4, r1)
            if (r7 != r2) goto L63
            goto L72
        L63:
            r0 = r6
        L64:
            d1.d r7 = (d1.d) r7
            goto L76
        L67:
            r1.f3251y = r6
            r1.B = r4
            r7 = 0
            java.lang.Object r7 = d1.h0.g(r0, r7, r1)
            if (r7 != r2) goto L73
        L72:
            return r2
        L73:
            r0 = r6
        L74:
            d1.d r7 = (d1.d) r7
        L76:
            java.lang.Object r0 = r0.f9072d
            d1.h0 r0 = (d1.h0) r0
            p6.d r0 = r0.f3241h
            r0.v(r7)
            rd.l r7 = rd.l.f11003a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.p.g(xd.c):java.lang.Object");
    }

    public synchronized ExecutorService h() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            if (((ThreadPoolExecutor) this.f9069a) == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                String str = lf.f.f7965b + " Dispatcher";
                ge.i.e(str, "name");
                this.f9069a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new lf.e(str, false));
            }
            threadPoolExecutor = (ThreadPoolExecutor) this.f9069a;
            ge.i.b(threadPoolExecutor);
        } catch (Throwable th) {
            throw th;
        }
        return threadPoolExecutor;
    }

    public androidx.fragment.app.y i(String str) {
        z0 z0Var = (z0) ((HashMap) this.f9070b).get(str);
        if (z0Var != null) {
            return z0Var.f1129c;
        }
        return null;
    }

    public of.k j(String str) {
        Iterator it = ((ArrayDeque) this.f9070b).iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            of.k kVar = (of.k) it.next();
            if (ge.i.a(((kf.q) kVar.f9814x.f9818w.f2035b).f7518d, str)) {
                return kVar;
            }
        }
        Iterator it2 = ((ArrayDeque) this.f9072d).iterator();
        ge.i.d(it2, "iterator(...)");
        while (it2.hasNext()) {
            of.k kVar2 = (of.k) it2.next();
            if (ge.i.a(((kf.q) kVar2.f9814x.f9818w.f2035b).f7518d, str)) {
                return kVar2;
            }
        }
        return null;
    }

    public androidx.fragment.app.y k(String str) {
        for (z0 z0Var : ((HashMap) this.f9070b).values()) {
            if (z0Var != null) {
                androidx.fragment.app.y yVarK = z0Var.f1129c;
                if (!str.equals(yVarK.A)) {
                    yVarK = yVarK.P.f1046c.k(str);
                }
                if (yVarK != null) {
                    return yVarK;
                }
            }
        }
        return null;
    }

    public m.e l(m.a aVar) {
        ArrayList arrayList = (ArrayList) this.f9071c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m.e eVar = (m.e) arrayList.get(i);
            if (eVar != null && eVar.f7977b == aVar) {
                return eVar;
            }
        }
        m.e eVar2 = new m.e((Context) this.f9070b, aVar);
        arrayList.add(eVar2);
        return eVar2;
    }

    public ArrayList m() {
        ArrayList arrayList = new ArrayList();
        for (z0 z0Var : ((HashMap) this.f9070b).values()) {
            if (z0Var != null) {
                arrayList.add(z0Var);
            }
        }
        return arrayList;
    }

    public ArrayList n() {
        ArrayList arrayList = new ArrayList();
        for (z0 z0Var : ((HashMap) this.f9070b).values()) {
            if (z0Var != null) {
                arrayList.add(z0Var.f1129c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public List o() {
        ArrayList arrayList;
        if (((ArrayList) this.f9069a).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.f9069a)) {
            arrayList = new ArrayList((ArrayList) this.f9069a);
        }
        return arrayList;
    }

    public boolean q(Context context) {
        if (((Boolean) this.f9071c) == null) {
            this.f9071c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!((Boolean) this.f9070b).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f9071c).booleanValue();
    }

    public boolean r(Context context) {
        if (((Boolean) this.f9070b) == null) {
            this.f9070b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!((Boolean) this.f9070b).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f9070b).booleanValue();
    }

    public void t(z0 z0Var) {
        androidx.fragment.app.y yVar = z0Var.f1129c;
        String str = yVar.A;
        HashMap map = (HashMap) this.f9070b;
        if (map.get(str) != null) {
            return;
        }
        map.put(yVar.A, z0Var);
        if (yVar.X) {
            if (yVar.W) {
                ((u0) this.f9072d).c(yVar);
            } else {
                ((u0) this.f9072d).f(yVar);
            }
            yVar.X = false;
        }
        if (r0.J(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + yVar);
        }
    }

    public void u(z0 z0Var) {
        HashMap map = (HashMap) this.f9070b;
        androidx.fragment.app.y yVar = z0Var.f1129c;
        if (yVar.W) {
            ((u0) this.f9072d).f(yVar);
        }
        if (map.get(yVar.A) == z0Var && ((z0) map.put(yVar.A, null)) != null && r0.J(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + yVar);
        }
    }

    public boolean v(m.a aVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f9069a).onActionItemClicked(l(aVar), new n.r((Context) this.f9070b, (n0.a) menuItem));
    }

    public boolean w(m.a aVar, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f9069a;
        m.e eVarL = l(aVar);
        v.k kVar = (v.k) this.f9072d;
        Menu zVar = (Menu) kVar.get(menu);
        if (zVar == null) {
            zVar = new n.z((Context) this.f9070b, (n.k) menu);
            kVar.put(menu, zVar);
        }
        return callback.onCreateActionMode(eVarL, zVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [xe.a] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [xe.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object z(xd.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof d1.e1
            if (r0 == 0) goto L13
            r0 = r8
            d1.e1 r0 = (d1.e1) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            d1.e1 r0 = new d1.e1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.A
            int r1 = r0.C
            r2 = 2
            r3 = 1
            rd.l r4 = rd.l.f11003a
            r5 = 0
            wd.a r6 = wd.a.f14143v
            if (r1 == 0) goto L43
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L33
            xe.a r1 = r0.f3225z
            nc.p r0 = r0.f3224y
            com.bumptech.glide.c.C(r8)     // Catch: java.lang.Throwable -> L31
            goto L80
        L31:
            r8 = move-exception
            goto L8b
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3b:
            xe.a r1 = r0.f3225z
            nc.p r3 = r0.f3224y
            com.bumptech.glide.c.C(r8)
            goto L64
        L43:
            com.bumptech.glide.c.C(r8)
            java.lang.Object r8 = r7.f9070b
            pe.n r8 = (pe.n) r8
            boolean r8 = r8.L()
            if (r8 == 0) goto L51
            return r4
        L51:
            java.lang.Object r8 = r7.f9069a
            xe.c r8 = (xe.c) r8
            r0.f3224y = r7
            r0.f3225z = r8
            r0.C = r3
            java.lang.Object r1 = r8.g(r0)
            if (r1 != r6) goto L62
            goto L7e
        L62:
            r3 = r7
            r1 = r8
        L64:
            java.lang.Object r8 = r3.f9070b     // Catch: java.lang.Throwable -> L31
            pe.n r8 = (pe.n) r8     // Catch: java.lang.Throwable -> L31
            boolean r8 = r8.L()     // Catch: java.lang.Throwable -> L31
            if (r8 == 0) goto L72
            r1.a(r5)
            return r4
        L72:
            r0.f3224y = r3     // Catch: java.lang.Throwable -> L31
            r0.f3225z = r1     // Catch: java.lang.Throwable -> L31
            r0.C = r2     // Catch: java.lang.Throwable -> L31
            java.lang.Object r8 = r3.g(r0)     // Catch: java.lang.Throwable -> L31
            if (r8 != r6) goto L7f
        L7e:
            return r6
        L7f:
            r0 = r3
        L80:
            java.lang.Object r8 = r0.f9070b     // Catch: java.lang.Throwable -> L31
            pe.n r8 = (pe.n) r8     // Catch: java.lang.Throwable -> L31
            r8.N(r4)     // Catch: java.lang.Throwable -> L31
            r1.a(r5)
            return r4
        L8b:
            r1.a(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.p.z(xd.c):java.lang.Object");
    }

    public p(f1 f1Var, String str) {
        this.f9072d = f1Var;
        o8.u.d(str);
        this.f9069a = str;
        this.f9070b = new Bundle();
    }

    public p(int i) {
        switch (i) {
            case 2:
                this.f9069a = new ArrayList();
                this.f9070b = new HashMap();
                this.f9071c = new HashMap();
                break;
            case 3:
                com.google.android.gms.internal.measurement.t tVar = new com.google.android.gms.internal.measurement.t(0);
                this.f9069a = tVar;
                b6.f fVar = new b6.f((b6.f) null, tVar);
                this.f9071c = fVar;
                this.f9070b = fVar.w();
                w5 w5Var = new w5(1);
                this.f9072d = w5Var;
                fVar.y("require", new v9(w5Var));
                ((HashMap) w5Var.f2709a).put("internal.platform", d1.f2362a);
                fVar.y("runtime.counter", new com.google.android.gms.internal.measurement.g(Double.valueOf(0.0d)));
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
            default:
                this.f9069a = null;
                this.f9070b = null;
                this.f9071c = null;
                this.f9072d = new ArrayDeque();
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f9069a = new s0.d(10);
                this.f9070b = new v.k(0);
                this.f9071c = new ArrayList();
                this.f9072d = new HashSet();
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                Random random = new Random();
                this.f9071c = new HashMap();
                this.f9072d = random;
                this.f9069a = new HashMap();
                this.f9070b = new HashMap();
                break;
            case 9:
                this.f9072d = new ArrayDeque();
                this.f9070b = new ArrayDeque();
                this.f9071c = new ArrayDeque();
                break;
        }
    }
}
