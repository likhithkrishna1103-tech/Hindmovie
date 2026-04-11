package androidx.fragment.app;

import android.content.ContentProviderClient;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {
    public e.g A;
    public e.g B;
    public ArrayDeque C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public q0 L;
    public final e M;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1311b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f1313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f1314e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c.c0 f1315g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h4.z f1319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArrayList f1320m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d0 f1321n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d0 f1322o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d0 f1323p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d0 f1324q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g0 f1325r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1326s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public z f1327t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ga.b f1328u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public v f1329v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public v f1330w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h0 f1331x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final q9.e f1332y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public e.g f1333z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1310a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ub.o f1312c = new ub.o(3);
    public final c0 f = new c0(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f0 f1316h = new f0(this);
    public final AtomicInteger i = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f1317j = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f1318k = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.d0] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.d0] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.d0] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.d0] */
    public n0() {
        Collections.synchronizedMap(new HashMap());
        this.f1319l = new h4.z(this);
        this.f1320m = new CopyOnWriteArrayList();
        final int i = 0;
        this.f1321n = new p0.a(this) { // from class: androidx.fragment.app.d0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f1264b;

            {
                this.f1264b = this;
            }

            @Override // p0.a
            public final void accept(Object obj) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        Configuration configuration = (Configuration) obj;
                        n0 n0Var = this.f1264b;
                        if (n0Var.I()) {
                            n0Var.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        n0 n0Var2 = this.f1264b;
                        if (n0Var2.I() && num.intValue() == 80) {
                            n0Var2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        e0.f fVar = (e0.f) obj;
                        n0 n0Var3 = this.f1264b;
                        if (n0Var3.I()) {
                            boolean z2 = fVar.f4245a;
                            n0Var3.m(false);
                        }
                        break;
                    default:
                        e0.s sVar = (e0.s) obj;
                        n0 n0Var4 = this.f1264b;
                        if (n0Var4.I()) {
                            boolean z10 = sVar.f4275a;
                            n0Var4.r(false);
                        }
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f1322o = new p0.a(this) { // from class: androidx.fragment.app.d0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f1264b;

            {
                this.f1264b = this;
            }

            @Override // p0.a
            public final void accept(Object obj) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        Configuration configuration = (Configuration) obj;
                        n0 n0Var = this.f1264b;
                        if (n0Var.I()) {
                            n0Var.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        n0 n0Var2 = this.f1264b;
                        if (n0Var2.I() && num.intValue() == 80) {
                            n0Var2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        e0.f fVar = (e0.f) obj;
                        n0 n0Var3 = this.f1264b;
                        if (n0Var3.I()) {
                            boolean z2 = fVar.f4245a;
                            n0Var3.m(false);
                        }
                        break;
                    default:
                        e0.s sVar = (e0.s) obj;
                        n0 n0Var4 = this.f1264b;
                        if (n0Var4.I()) {
                            boolean z10 = sVar.f4275a;
                            n0Var4.r(false);
                        }
                        break;
                }
            }
        };
        final int i11 = 2;
        this.f1323p = new p0.a(this) { // from class: androidx.fragment.app.d0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f1264b;

            {
                this.f1264b = this;
            }

            @Override // p0.a
            public final void accept(Object obj) {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        Configuration configuration = (Configuration) obj;
                        n0 n0Var = this.f1264b;
                        if (n0Var.I()) {
                            n0Var.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        n0 n0Var2 = this.f1264b;
                        if (n0Var2.I() && num.intValue() == 80) {
                            n0Var2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        e0.f fVar = (e0.f) obj;
                        n0 n0Var3 = this.f1264b;
                        if (n0Var3.I()) {
                            boolean z2 = fVar.f4245a;
                            n0Var3.m(false);
                        }
                        break;
                    default:
                        e0.s sVar = (e0.s) obj;
                        n0 n0Var4 = this.f1264b;
                        if (n0Var4.I()) {
                            boolean z10 = sVar.f4275a;
                            n0Var4.r(false);
                        }
                        break;
                }
            }
        };
        final int i12 = 3;
        this.f1324q = new p0.a(this) { // from class: androidx.fragment.app.d0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f1264b;

            {
                this.f1264b = this;
            }

            @Override // p0.a
            public final void accept(Object obj) {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        Configuration configuration = (Configuration) obj;
                        n0 n0Var = this.f1264b;
                        if (n0Var.I()) {
                            n0Var.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        n0 n0Var2 = this.f1264b;
                        if (n0Var2.I() && num.intValue() == 80) {
                            n0Var2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        e0.f fVar = (e0.f) obj;
                        n0 n0Var3 = this.f1264b;
                        if (n0Var3.I()) {
                            boolean z2 = fVar.f4245a;
                            n0Var3.m(false);
                        }
                        break;
                    default:
                        e0.s sVar = (e0.s) obj;
                        n0 n0Var4 = this.f1264b;
                        if (n0Var4.I()) {
                            boolean z10 = sVar.f4275a;
                            n0Var4.r(false);
                        }
                        break;
                }
            }
        };
        this.f1325r = new g0(this);
        this.f1326s = -1;
        this.f1331x = new h0(this);
        this.f1332y = new q9.e(i12);
        this.C = new ArrayDeque();
        this.M = new e(2, this);
    }

    public static boolean G(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean H(v vVar) {
        vVar.getClass();
        ArrayList arrayListU = vVar.O.f1312c.u();
        int size = arrayListU.size();
        boolean zH = false;
        int i = 0;
        while (i < size) {
            Object obj = arrayListU.get(i);
            i++;
            v vVar2 = (v) obj;
            if (vVar2 != null) {
                zH = H(vVar2);
            }
            if (zH) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(v vVar) {
        if (vVar == null) {
            return true;
        }
        if (vVar.X) {
            return vVar.M == null || J(vVar.P);
        }
        return false;
    }

    public static boolean K(v vVar) {
        if (vVar == null) {
            return true;
        }
        n0 n0Var = vVar.M;
        return vVar.equals(n0Var.f1330w) && K(n0Var.f1329v);
    }

    public static void a0(v vVar) {
        if (G(2)) {
            Log.v("FragmentManager", "show: " + vVar);
        }
        if (vVar.T) {
            vVar.T = false;
            vVar.f1382e0 = !vVar.f1382e0;
        }
    }

    public final v A(int i) {
        ub.o oVar = this.f1312c;
        ArrayList arrayList = (ArrayList) oVar.f12868v;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            v vVar = (v) arrayList.get(size);
            if (vVar != null && vVar.Q == i) {
                return vVar;
            }
        }
        for (u0 u0Var : ((HashMap) oVar.f12869w).values()) {
            if (u0Var != null) {
                v vVar2 = u0Var.f1374c;
                if (vVar2.Q == i) {
                    return vVar2;
                }
            }
        }
        return null;
    }

    public final v B(String str) {
        ub.o oVar = this.f1312c;
        ArrayList arrayList = (ArrayList) oVar.f12868v;
        if (str != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                v vVar = (v) arrayList.get(size);
                if (vVar != null && str.equals(vVar.S)) {
                    return vVar;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (u0 u0Var : ((HashMap) oVar.f12869w).values()) {
            if (u0Var != null) {
                v vVar2 = u0Var.f1374c;
                if (str.equals(vVar2.S)) {
                    return vVar2;
                }
            }
        }
        return null;
    }

    public final ViewGroup C(v vVar) {
        ViewGroup viewGroup = vVar.Z;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (vVar.R <= 0 || !this.f1328u.w()) {
            return null;
        }
        View viewV = this.f1328u.v(vVar.R);
        if (viewV instanceof ViewGroup) {
            return (ViewGroup) viewV;
        }
        return null;
    }

    public final h0 D() {
        v vVar = this.f1329v;
        return vVar != null ? vVar.M.D() : this.f1331x;
    }

    public final q9.e E() {
        v vVar = this.f1329v;
        return vVar != null ? vVar.M.E() : this.f1332y;
    }

    public final void F(v vVar) {
        if (G(2)) {
            Log.v("FragmentManager", "hide: " + vVar);
        }
        if (vVar.T) {
            return;
        }
        vVar.T = true;
        vVar.f1382e0 = true ^ vVar.f1382e0;
        Z(vVar);
    }

    public final boolean I() {
        v vVar = this.f1329v;
        if (vVar == null) {
            return true;
        }
        return vVar.p() && this.f1329v.l().I();
    }

    public final boolean L() {
        return this.E || this.F;
    }

    public final void M(int i, boolean z2) {
        z zVar;
        if (this.f1327t == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || i != this.f1326s) {
            this.f1326s = i;
            ub.o oVar = this.f1312c;
            HashMap map = (HashMap) oVar.f12869w;
            ArrayList arrayList = (ArrayList) oVar.f12868v;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                u0 u0Var = (u0) map.get(((v) obj).f1398z);
                if (u0Var != null) {
                    u0Var.k();
                }
            }
            for (u0 u0Var2 : map.values()) {
                if (u0Var2 != null) {
                    u0Var2.k();
                    v vVar = u0Var2.f1374c;
                    if (vVar.G && !vVar.r()) {
                        oVar.K(u0Var2);
                    }
                }
            }
            ArrayList arrayListT = oVar.t();
            int size2 = arrayListT.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj2 = arrayListT.get(i11);
                i11++;
                u0 u0Var3 = (u0) obj2;
                v vVar2 = u0Var3.f1374c;
                if (vVar2.f1379b0) {
                    if (this.f1311b) {
                        this.H = true;
                    } else {
                        vVar2.f1379b0 = false;
                        u0Var3.k();
                    }
                }
            }
            if (this.D && (zVar = this.f1327t) != null && this.f1326s == 7) {
                zVar.f1426y.invalidateOptionsMenu();
                this.D = false;
            }
        }
    }

    public final void N() {
        if (this.f1327t == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.L.i = false;
        for (v vVar : this.f1312c.y()) {
            if (vVar != null) {
                vVar.O.N();
            }
        }
    }

    public final boolean O() {
        return P(-1, 0);
    }

    public final boolean P(int i, int i10) {
        x(false);
        w(true);
        v vVar = this.f1330w;
        if (vVar != null && i < 0 && vVar.i().O()) {
            return true;
        }
        boolean zQ = Q(this.I, this.J, i, i10);
        if (zQ) {
            this.f1311b = true;
            try {
                S(this.I, this.J);
            } finally {
                d();
            }
        }
        c0();
        boolean z2 = this.H;
        ub.o oVar = this.f1312c;
        if (z2) {
            this.H = false;
            ArrayList arrayListT = oVar.t();
            int size = arrayListT.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayListT.get(i11);
                i11++;
                u0 u0Var = (u0) obj;
                v vVar2 = u0Var.f1374c;
                if (vVar2.f1379b0) {
                    if (this.f1311b) {
                        this.H = true;
                    } else {
                        vVar2.f1379b0 = false;
                        u0Var.k();
                    }
                }
            }
        }
        ((HashMap) oVar.f12869w).values().removeAll(Collections.singleton(null));
        return zQ;
    }

    public final boolean Q(ArrayList arrayList, ArrayList arrayList2, int i, int i10) {
        boolean z2 = (i10 & 1) != 0;
        ArrayList arrayList3 = this.f1313d;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (i < 0) {
                size = z2 ? 0 : this.f1313d.size() - 1;
            } else {
                int size2 = this.f1313d.size() - 1;
                while (size2 >= 0) {
                    a aVar = (a) this.f1313d.get(size2);
                    if (i >= 0 && i == aVar.f1241s) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    size = size2;
                } else if (z2) {
                    size = size2;
                    while (size > 0) {
                        a aVar2 = (a) this.f1313d.get(size - 1);
                        if (i < 0 || i != aVar2.f1241s) {
                            break;
                        }
                        size--;
                    }
                } else if (size2 != this.f1313d.size() - 1) {
                    size = size2 + 1;
                }
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.f1313d.size() - 1; size3 >= size; size3--) {
            arrayList.add((a) this.f1313d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void R(v vVar) {
        if (G(2)) {
            Log.v("FragmentManager", "remove: " + vVar + " nesting=" + vVar.L);
        }
        boolean zR = vVar.r();
        if (vVar.U && zR) {
            return;
        }
        ub.o oVar = this.f1312c;
        synchronized (((ArrayList) oVar.f12868v)) {
            ((ArrayList) oVar.f12868v).remove(vVar);
        }
        vVar.F = false;
        if (H(vVar)) {
            this.D = true;
        }
        vVar.G = true;
        Z(vVar);
    }

    public final void S(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (i < size) {
            if (!((a) arrayList.get(i)).f1238p) {
                if (i10 != i) {
                    z(arrayList, arrayList2, i10, i);
                }
                i10 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i10 < size && ((Boolean) arrayList2.get(i10)).booleanValue() && !((a) arrayList.get(i10)).f1238p) {
                        i10++;
                    }
                }
                z(arrayList, arrayList2, i, i10);
                i = i10 - 1;
            }
            i++;
        }
        if (i10 != size) {
            z(arrayList, arrayList2, i10, size);
        }
    }

    public final void T(Parcelable parcelable) {
        h4.z zVar;
        int i;
        boolean z2;
        int i10;
        u0 u0Var;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f1327t.f1423v.getClassLoader());
                this.f1318k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f1327t.f1423v.getClassLoader());
                arrayList.add((s0) bundle.getParcelable("state"));
            }
        }
        ub.o oVar = this.f1312c;
        HashMap map = (HashMap) oVar.f12870x;
        HashMap map2 = (HashMap) oVar.f12869w;
        map.clear();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            s0 s0Var = (s0) obj;
            map.put(s0Var.f1356v, s0Var);
        }
        o0 o0Var = (o0) bundle3.getParcelable("state");
        if (o0Var == null) {
            return;
        }
        map2.clear();
        ArrayList arrayList2 = o0Var.f1335u;
        int size2 = arrayList2.size();
        int i12 = 0;
        while (true) {
            zVar = this.f1319l;
            i = 2;
            if (i12 >= size2) {
                break;
            }
            Object obj2 = arrayList2.get(i12);
            i12++;
            s0 s0Var2 = (s0) ((HashMap) oVar.f12870x).remove((String) obj2);
            if (s0Var2 != null) {
                v vVar = (v) this.L.f1345d.get(s0Var2.f1356v);
                if (vVar != null) {
                    if (G(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + vVar);
                    }
                    u0Var = new u0(zVar, oVar, vVar, s0Var2);
                } else {
                    u0Var = new u0(this.f1319l, this.f1312c, this.f1327t.f1423v.getClassLoader(), D(), s0Var2);
                }
                v vVar2 = u0Var.f1374c;
                vVar2.M = this;
                if (G(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + vVar2.f1398z + "): " + vVar2);
                }
                u0Var.m(this.f1327t.f1423v.getClassLoader());
                oVar.J(u0Var);
                u0Var.f1376e = this.f1326s;
            }
        }
        q0 q0Var = this.L;
        q0Var.getClass();
        ArrayList arrayList3 = new ArrayList(q0Var.f1345d.values());
        int size3 = arrayList3.size();
        int i13 = 0;
        while (true) {
            z2 = true;
            if (i13 >= size3) {
                break;
            }
            Object obj3 = arrayList3.get(i13);
            i13++;
            v vVar3 = (v) obj3;
            if (map2.get(vVar3.f1398z) == null) {
                if (G(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + vVar3 + " that was not found in the set of active Fragments " + o0Var.f1335u);
                }
                this.L.f(vVar3);
                vVar3.M = this;
                u0 u0Var2 = new u0(zVar, oVar, vVar3);
                u0Var2.f1376e = 1;
                u0Var2.k();
                vVar3.G = true;
                u0Var2.k();
            }
        }
        ArrayList arrayList4 = o0Var.f1336v;
        ((ArrayList) oVar.f12868v).clear();
        if (arrayList4 != null) {
            int size4 = arrayList4.size();
            int i14 = 0;
            while (i14 < size4) {
                Object obj4 = arrayList4.get(i14);
                i14++;
                String str3 = (String) obj4;
                v vVarL = oVar.l(str3);
                if (vVarL == null) {
                    throw new IllegalStateException(e6.j.n("No instantiated fragment for (", str3, ")"));
                }
                if (G(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + vVarL);
                }
                oVar.c(vVarL);
            }
        }
        if (o0Var.f1337w != null) {
            this.f1313d = new ArrayList(o0Var.f1337w.length);
            int i15 = 0;
            while (true) {
                b[] bVarArr = o0Var.f1337w;
                if (i15 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i15];
                ArrayList arrayList5 = bVar.f1248v;
                a aVar = new a(this);
                int[] iArr = bVar.f1247u;
                int i16 = 0;
                int i17 = 0;
                while (i16 < iArr.length) {
                    v0 v0Var = new v0();
                    int i18 = i16 + 1;
                    int i19 = i;
                    v0Var.f1399a = iArr[i16];
                    if (G(i19)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i17 + " base fragment #" + iArr[i18]);
                    }
                    v0Var.f1405h = androidx.lifecycle.n.values()[bVar.f1249w[i17]];
                    v0Var.i = androidx.lifecycle.n.values()[bVar.f1250x[i17]];
                    int i20 = i16 + 2;
                    v0Var.f1401c = iArr[i18] != 0 ? z2 : false;
                    int i21 = iArr[i20];
                    v0Var.f1402d = i21;
                    int i22 = iArr[i16 + 3];
                    v0Var.f1403e = i22;
                    int i23 = i16 + 5;
                    int i24 = iArr[i16 + 4];
                    v0Var.f = i24;
                    i16 += 6;
                    int[] iArr2 = iArr;
                    int i25 = iArr2[i23];
                    v0Var.f1404g = i25;
                    aVar.f1226b = i21;
                    aVar.f1227c = i22;
                    aVar.f1228d = i24;
                    aVar.f1229e = i25;
                    aVar.b(v0Var);
                    i17++;
                    i = i19;
                    iArr = iArr2;
                    z2 = true;
                }
                int i26 = i;
                aVar.f = bVar.f1251y;
                aVar.i = bVar.f1252z;
                aVar.f1230g = true;
                aVar.f1232j = bVar.B;
                aVar.f1233k = bVar.C;
                aVar.f1234l = bVar.D;
                aVar.f1235m = bVar.E;
                aVar.f1236n = bVar.F;
                aVar.f1237o = bVar.G;
                aVar.f1238p = bVar.H;
                aVar.f1241s = bVar.A;
                for (int i27 = 0; i27 < arrayList5.size(); i27++) {
                    String str4 = (String) arrayList5.get(i27);
                    if (str4 != null) {
                        ((v0) aVar.f1225a.get(i27)).f1400b = oVar.l(str4);
                    }
                }
                aVar.c(1);
                if (G(i26)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i15 + " (index " + aVar.f1241s + "): " + aVar);
                    PrintWriter printWriter = new PrintWriter(new x0());
                    aVar.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1313d.add(aVar);
                i15++;
                i = i26;
                z2 = true;
            }
            i10 = 0;
        } else {
            i10 = 0;
            this.f1313d = null;
        }
        this.i.set(o0Var.f1338x);
        String str5 = o0Var.f1339y;
        if (str5 != null) {
            v vVarL2 = oVar.l(str5);
            this.f1330w = vVarL2;
            q(vVarL2);
        }
        ArrayList arrayList6 = o0Var.f1340z;
        if (arrayList6 != null) {
            while (i10 < arrayList6.size()) {
                this.f1317j.put((String) arrayList6.get(i10), (c) o0Var.A.get(i10));
                i10++;
            }
        }
        this.C = new ArrayDeque(o0Var.B);
    }

    public final Bundle U() {
        int i;
        ArrayList arrayList;
        b[] bVarArr;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            j jVar = (j) it.next();
            if (jVar.f1291e) {
                if (G(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                jVar.f1291e = false;
                jVar.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((j) it2.next()).e();
        }
        x(true);
        this.E = true;
        this.L.i = true;
        ub.o oVar = this.f1312c;
        oVar.getClass();
        HashMap map = (HashMap) oVar.f12869w;
        ArrayList arrayList2 = new ArrayList(map.size());
        Iterator it3 = map.values().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            u0 u0Var = (u0) it3.next();
            if (u0Var != null) {
                v vVar = u0Var.f1374c;
                s0 s0Var = new s0(vVar);
                if (vVar.f1393u <= -1 || s0Var.G != null) {
                    s0Var.G = vVar.f1394v;
                } else {
                    Bundle bundle2 = new Bundle();
                    vVar.A(bundle2);
                    vVar.f1389m0.h(bundle2);
                    bundle2.putParcelable("android:support:fragments", vVar.O.U());
                    u0Var.f1372a.U(false);
                    Bundle bundle3 = bundle2.isEmpty() ? null : bundle2;
                    if (vVar.f1378a0 != null) {
                        u0Var.o();
                    }
                    if (vVar.f1395w != null) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putSparseParcelableArray("android:view_state", vVar.f1395w);
                    }
                    if (vVar.f1396x != null) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putBundle("android:view_registry_state", vVar.f1396x);
                    }
                    if (!vVar.f1380c0) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putBoolean("android:user_visible_hint", vVar.f1380c0);
                    }
                    s0Var.G = bundle3;
                    if (vVar.C != null) {
                        if (bundle3 == null) {
                            s0Var.G = new Bundle();
                        }
                        s0Var.G.putString("android:target_state", vVar.C);
                        int i10 = vVar.D;
                        if (i10 != 0) {
                            s0Var.G.putInt("android:target_req_state", i10);
                        }
                    }
                }
                arrayList2.add(vVar.f1398z);
                if (G(2)) {
                    Log.v("FragmentManager", "Saved state of " + vVar + ": " + vVar.f1394v);
                }
            }
        }
        ub.o oVar2 = this.f1312c;
        oVar2.getClass();
        ArrayList arrayList3 = new ArrayList(((HashMap) oVar2.f12870x).values());
        if (!arrayList3.isEmpty()) {
            ub.o oVar3 = this.f1312c;
            synchronized (((ArrayList) oVar3.f12868v)) {
                try {
                    if (((ArrayList) oVar3.f12868v).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) oVar3.f12868v).size());
                        ArrayList arrayList4 = (ArrayList) oVar3.f12868v;
                        int size2 = arrayList4.size();
                        int i11 = 0;
                        while (i11 < size2) {
                            Object obj = arrayList4.get(i11);
                            i11++;
                            v vVar2 = (v) obj;
                            arrayList.add(vVar2.f1398z);
                            if (G(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + vVar2.f1398z + "): " + vVar2);
                            }
                        }
                    }
                } finally {
                }
            }
            ArrayList arrayList5 = this.f1313d;
            if (arrayList5 == null || (size = arrayList5.size()) <= 0) {
                bVarArr = null;
            } else {
                bVarArr = new b[size];
                for (int i12 = 0; i12 < size; i12++) {
                    bVarArr[i12] = new b((a) this.f1313d.get(i12));
                    if (G(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i12 + ": " + this.f1313d.get(i12));
                    }
                }
            }
            o0 o0Var = new o0();
            o0Var.f1339y = null;
            ArrayList arrayList6 = new ArrayList();
            o0Var.f1340z = arrayList6;
            ArrayList arrayList7 = new ArrayList();
            o0Var.A = arrayList7;
            o0Var.f1335u = arrayList2;
            o0Var.f1336v = arrayList;
            o0Var.f1337w = bVarArr;
            o0Var.f1338x = this.i.get();
            v vVar3 = this.f1330w;
            if (vVar3 != null) {
                o0Var.f1339y = vVar3.f1398z;
            }
            arrayList6.addAll(this.f1317j.keySet());
            arrayList7.addAll(this.f1317j.values());
            o0Var.B = new ArrayList(this.C);
            bundle.putParcelable("state", o0Var);
            for (String str : this.f1318k.keySet()) {
                bundle.putBundle(l4.a.m("result_", str), (Bundle) this.f1318k.get(str));
            }
            int size3 = arrayList3.size();
            while (i < size3) {
                Object obj2 = arrayList3.get(i);
                i++;
                s0 s0Var2 = (s0) obj2;
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("state", s0Var2);
                bundle.putBundle("fragment_" + s0Var2.f1356v, bundle4);
            }
        } else if (G(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void V() {
        synchronized (this.f1310a) {
            try {
                if (this.f1310a.size() == 1) {
                    this.f1327t.f1424w.removeCallbacks(this.M);
                    this.f1327t.f1424w.post(this.M);
                    c0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void W(v vVar, boolean z2) {
        ViewGroup viewGroupC = C(vVar);
        if (viewGroupC == null || !(viewGroupC instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupC).setDrawDisappearingViewsLast(!z2);
    }

    public final void X(v vVar, androidx.lifecycle.n nVar) {
        if (vVar.equals(this.f1312c.l(vVar.f1398z)) && (vVar.N == null || vVar.M == this)) {
            vVar.f1385h0 = nVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + vVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void Y(v vVar) {
        if (vVar != null) {
            if (!vVar.equals(this.f1312c.l(vVar.f1398z)) || (vVar.N != null && vVar.M != this)) {
                throw new IllegalArgumentException("Fragment " + vVar + " is not an active fragment of FragmentManager " + this);
            }
        }
        v vVar2 = this.f1330w;
        this.f1330w = vVar;
        q(vVar2);
        q(this.f1330w);
    }

    public final void Z(v vVar) {
        ViewGroup viewGroupC = C(vVar);
        if (viewGroupC != null) {
            t tVar = vVar.f1381d0;
            if ((tVar == null ? 0 : tVar.f1365e) + (tVar == null ? 0 : tVar.f1364d) + (tVar == null ? 0 : tVar.f1363c) + (tVar == null ? 0 : tVar.f1362b) > 0) {
                if (viewGroupC.getTag(i1.b.visible_removing_fragment_view_tag) == null) {
                    viewGroupC.setTag(i1.b.visible_removing_fragment_view_tag, vVar);
                }
                v vVar2 = (v) viewGroupC.getTag(i1.b.visible_removing_fragment_view_tag);
                t tVar2 = vVar.f1381d0;
                boolean z2 = tVar2 != null ? tVar2.f1361a : false;
                if (vVar2.f1381d0 == null) {
                    return;
                }
                vVar2.g().f1361a = z2;
            }
        }
    }

    public final u0 a(v vVar) {
        String str = vVar.f1384g0;
        if (str != null) {
            j1.c.c(vVar, str);
        }
        if (G(2)) {
            Log.v("FragmentManager", "add: " + vVar);
        }
        u0 u0VarF = f(vVar);
        vVar.M = this;
        ub.o oVar = this.f1312c;
        oVar.J(u0VarF);
        if (!vVar.U) {
            oVar.c(vVar);
            vVar.G = false;
            if (vVar.f1378a0 == null) {
                vVar.f1382e0 = false;
            }
            if (H(vVar)) {
                this.D = true;
            }
        }
        return u0VarF;
    }

    public final void b(z zVar, ga.b bVar, v vVar) {
        if (this.f1327t != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1327t = zVar;
        this.f1328u = bVar;
        this.f1329v = vVar;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1320m;
        if (vVar != null) {
            copyOnWriteArrayList.add(new i0(vVar));
        } else if (zVar != null) {
            copyOnWriteArrayList.add(zVar);
        }
        if (this.f1329v != null) {
            c0();
        }
        if (zVar != null) {
            c.c0 c0VarJ = zVar.f1426y.j();
            this.f1315g = c0VarJ;
            c0VarJ.a(this.f1316h, vVar != null ? vVar : zVar);
        }
        if (vVar != null) {
            q0 q0Var = vVar.M.L;
            HashMap map = q0Var.f1346e;
            q0 q0Var2 = (q0) map.get(vVar.f1398z);
            if (q0Var2 == null) {
                q0Var2 = new q0(q0Var.f1347g);
                map.put(vVar.f1398z, q0Var2);
            }
            this.L = q0Var2;
        } else if (zVar != null) {
            this.L = (q0) new a7.b(zVar.f1426y.e(), q0.f1344j).s(q0.class);
        } else {
            this.L = new q0(false);
        }
        this.L.i = L();
        this.f1312c.f12871y = this.L;
        z zVar2 = this.f1327t;
        if (zVar2 != null && vVar == null) {
            n.s sVarA = zVar2.a();
            sVarA.f("android:support:fragments", new e0(0, this));
            Bundle bundleC = sVarA.c("android:support:fragments");
            if (bundleC != null) {
                T(bundleC);
            }
        }
        z zVar3 = this.f1327t;
        if (zVar3 != null) {
            c.k kVar = zVar3.f1426y.C;
            String strM = l4.a.m("FragmentManager:", vVar != null ? l4.a.o(new StringBuilder(), vVar.f1398z, ":") : "");
            this.f1333z = kVar.d(e6.j.m(strM, "StartActivityForResult"), new j0(3), new u5.c(3, this));
            this.A = kVar.d(e6.j.m(strM, "StartIntentSenderForResult"), new j0(0), new u5.d(2, this));
            this.B = kVar.d(e6.j.m(strM, "RequestPermissions"), new j0(1), new rc.b(2, this));
        }
        z zVar4 = this.f1327t;
        if (zVar4 != null) {
            zVar4.f1426y.h(this.f1321n);
        }
        z zVar5 = this.f1327t;
        if (zVar5 != null) {
            h.j jVar = zVar5.f1426y;
            jVar.getClass();
            d0 d0Var = this.f1322o;
            be.h.e(d0Var, "listener");
            jVar.E.add(d0Var);
        }
        z zVar6 = this.f1327t;
        if (zVar6 != null) {
            h.j jVar2 = zVar6.f1426y;
            jVar2.getClass();
            d0 d0Var2 = this.f1323p;
            be.h.e(d0Var2, "listener");
            jVar2.G.add(d0Var2);
        }
        z zVar7 = this.f1327t;
        if (zVar7 != null) {
            h.j jVar3 = zVar7.f1426y;
            jVar3.getClass();
            d0 d0Var3 = this.f1324q;
            be.h.e(d0Var3, "listener");
            jVar3.H.add(d0Var3);
        }
        z zVar8 = this.f1327t;
        if (zVar8 == null || vVar != null) {
            return;
        }
        h.j jVar4 = zVar8.f1426y;
        jVar4.getClass();
        g0 g0Var = this.f1325r;
        be.h.e(g0Var, "provider");
        kc.b bVar2 = jVar4.f2183w;
        ((CopyOnWriteArrayList) bVar2.f7621w).add(g0Var);
        ((Runnable) bVar2.f7620v).run();
    }

    public final void b0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new x0());
        z zVar = this.f1327t;
        if (zVar == null) {
            try {
                u("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw illegalStateException;
            }
        }
        try {
            zVar.f1426y.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw illegalStateException;
        }
    }

    public final void c(v vVar) {
        if (G(2)) {
            Log.v("FragmentManager", "attach: " + vVar);
        }
        if (vVar.U) {
            vVar.U = false;
            if (vVar.F) {
                return;
            }
            this.f1312c.c(vVar);
            if (G(2)) {
                Log.v("FragmentManager", "add from attach: " + vVar);
            }
            if (H(vVar)) {
                this.D = true;
            }
        }
    }

    public final void c0() {
        synchronized (this.f1310a) {
            try {
                if (!this.f1310a.isEmpty()) {
                    this.f1316h.b(true);
                    return;
                }
                f0 f0Var = this.f1316h;
                ArrayList arrayList = this.f1313d;
                f0Var.b((arrayList != null ? arrayList.size() : 0) > 0 && K(this.f1329v));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        this.f1311b = false;
        this.J.clear();
        this.I.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        ArrayList arrayListT = this.f1312c.t();
        int size = arrayListT.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListT.get(i);
            i++;
            ViewGroup viewGroup = ((u0) obj).f1374c.Z;
            if (viewGroup != null) {
                hashSet.add(j.f(viewGroup, E()));
            }
        }
        return hashSet;
    }

    public final u0 f(v vVar) {
        String str = vVar.f1398z;
        ub.o oVar = this.f1312c;
        u0 u0Var = (u0) ((HashMap) oVar.f12869w).get(str);
        if (u0Var != null) {
            return u0Var;
        }
        u0 u0Var2 = new u0(this.f1319l, oVar, vVar);
        u0Var2.m(this.f1327t.f1423v.getClassLoader());
        u0Var2.f1376e = this.f1326s;
        return u0Var2;
    }

    public final void g(v vVar) {
        if (G(2)) {
            Log.v("FragmentManager", "detach: " + vVar);
        }
        if (vVar.U) {
            return;
        }
        vVar.U = true;
        if (vVar.F) {
            if (G(2)) {
                Log.v("FragmentManager", "remove from detach: " + vVar);
            }
            ub.o oVar = this.f1312c;
            synchronized (((ArrayList) oVar.f12868v)) {
                ((ArrayList) oVar.f12868v).remove(vVar);
            }
            vVar.F = false;
            if (H(vVar)) {
                this.D = true;
            }
            Z(vVar);
        }
    }

    public final void h(boolean z2, Configuration configuration) {
        if (z2 && this.f1327t != null) {
            b0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (v vVar : this.f1312c.y()) {
            if (vVar != null) {
                vVar.onConfigurationChanged(configuration);
                if (z2) {
                    vVar.O.h(true, configuration);
                }
            }
        }
    }

    public final boolean i() {
        if (this.f1326s >= 1) {
            for (v vVar : this.f1312c.y()) {
                if (vVar != null) {
                    if (!vVar.T ? vVar.O.i() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean j() {
        if (this.f1326s < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z2 = false;
        for (v vVar : this.f1312c.y()) {
            if (vVar != null && J(vVar)) {
                if (!vVar.T ? vVar.O.j() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(vVar);
                    z2 = true;
                }
            }
        }
        if (this.f1314e != null) {
            for (int i = 0; i < this.f1314e.size(); i++) {
                v vVar2 = (v) this.f1314e.get(i);
                if (arrayList == null || !arrayList.contains(vVar2)) {
                    vVar2.getClass();
                }
            }
        }
        this.f1314e = arrayList;
        return z2;
    }

    public final void k() {
        boolean z2;
        this.G = true;
        x(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((j) it.next()).e();
        }
        z zVar = this.f1327t;
        ub.o oVar = this.f1312c;
        if (zVar != null) {
            z2 = ((q0) oVar.f12871y).f1348h;
        } else {
            z2 = l4.a.v(zVar.f1423v) ? !r1.isChangingConfigurations() : true;
        }
        int i = 0;
        if (z2) {
            Iterator it2 = this.f1317j.values().iterator();
            while (it2.hasNext()) {
                ArrayList arrayList = ((c) it2.next()).f1255u;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    String str = (String) obj;
                    q0 q0Var = (q0) oVar.f12871y;
                    q0Var.getClass();
                    if (G(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    q0Var.e(str);
                }
            }
        }
        t(-1);
        z zVar2 = this.f1327t;
        if (zVar2 != null) {
            h.j jVar = zVar2.f1426y;
            jVar.getClass();
            d0 d0Var = this.f1322o;
            be.h.e(d0Var, "listener");
            jVar.E.remove(d0Var);
        }
        z zVar3 = this.f1327t;
        if (zVar3 != null) {
            h.j jVar2 = zVar3.f1426y;
            jVar2.getClass();
            d0 d0Var2 = this.f1321n;
            be.h.e(d0Var2, "listener");
            jVar2.D.remove(d0Var2);
        }
        z zVar4 = this.f1327t;
        if (zVar4 != null) {
            h.j jVar3 = zVar4.f1426y;
            jVar3.getClass();
            d0 d0Var3 = this.f1323p;
            be.h.e(d0Var3, "listener");
            jVar3.G.remove(d0Var3);
        }
        z zVar5 = this.f1327t;
        if (zVar5 != null) {
            h.j jVar4 = zVar5.f1426y;
            jVar4.getClass();
            d0 d0Var4 = this.f1324q;
            be.h.e(d0Var4, "listener");
            jVar4.H.remove(d0Var4);
        }
        z zVar6 = this.f1327t;
        if (zVar6 != null) {
            h.j jVar5 = zVar6.f1426y;
            jVar5.getClass();
            g0 g0Var = this.f1325r;
            be.h.e(g0Var, "provider");
            kc.b bVar = jVar5.f2183w;
            ((CopyOnWriteArrayList) bVar.f7621w).remove(g0Var);
            if (((HashMap) bVar.f7622x).remove(g0Var) != null) {
                throw new ClassCastException();
            }
            ((Runnable) bVar.f7620v).run();
        }
        this.f1327t = null;
        this.f1328u = null;
        this.f1329v = null;
        if (this.f1315g != null) {
            f0 f0Var = this.f1316h;
            ArrayList arrayList2 = f0Var.f1273a;
            CopyOnWriteArrayList copyOnWriteArrayList = f0Var.f1275c;
            Iterator it3 = copyOnWriteArrayList.iterator();
            be.h.d(it3, "iterator(...)");
            while (it3.hasNext()) {
                AutoCloseable autoCloseable = (AutoCloseable) it3.next();
                if (autoCloseable instanceof AutoCloseable) {
                    autoCloseable.close();
                } else if (autoCloseable instanceof ExecutorService) {
                    aa.c0.x((ExecutorService) autoCloseable);
                } else if (autoCloseable instanceof TypedArray) {
                    ((TypedArray) autoCloseable).recycle();
                } else if (autoCloseable instanceof MediaMetadataRetriever) {
                    ((MediaMetadataRetriever) autoCloseable).release();
                } else if (autoCloseable instanceof MediaDrm) {
                    ((MediaDrm) autoCloseable).release();
                } else if (autoCloseable instanceof DrmManagerClient) {
                    ((DrmManagerClient) autoCloseable).release();
                } else {
                    if (!(autoCloseable instanceof ContentProviderClient)) {
                        throw new IllegalArgumentException();
                    }
                    ((ContentProviderClient) autoCloseable).release();
                }
            }
            copyOnWriteArrayList.clear();
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((c.z) obj2).a();
            }
            arrayList2.clear();
            this.f1315g = null;
        }
        e.g gVar = this.f1333z;
        if (gVar != null) {
            gVar.b();
            this.A.b();
            this.B.b();
        }
    }

    public final void l(boolean z2) {
        if (z2 && this.f1327t != null) {
            b0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (v vVar : this.f1312c.y()) {
            if (vVar != null) {
                vVar.Y = true;
                if (z2) {
                    vVar.O.l(true);
                }
            }
        }
    }

    public final void m(boolean z2) {
        if (z2 && this.f1327t != null) {
            b0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (v vVar : this.f1312c.y()) {
            if (vVar != null && z2) {
                vVar.O.m(true);
            }
        }
    }

    public final void n() {
        ArrayList arrayListU = this.f1312c.u();
        int size = arrayListU.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListU.get(i);
            i++;
            v vVar = (v) obj;
            if (vVar != null) {
                vVar.q();
                vVar.O.n();
            }
        }
    }

    public final boolean o() {
        if (this.f1326s >= 1) {
            for (v vVar : this.f1312c.y()) {
                if (vVar != null) {
                    if (!vVar.T ? vVar.O.o() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void p() {
        if (this.f1326s < 1) {
            return;
        }
        for (v vVar : this.f1312c.y()) {
            if (vVar != null && !vVar.T) {
                vVar.O.p();
            }
        }
    }

    public final void q(v vVar) {
        if (vVar != null) {
            if (vVar.equals(this.f1312c.l(vVar.f1398z))) {
                vVar.M.getClass();
                boolean zK = K(vVar);
                Boolean bool = vVar.E;
                if (bool == null || bool.booleanValue() != zK) {
                    vVar.E = Boolean.valueOf(zK);
                    n0 n0Var = vVar.O;
                    n0Var.c0();
                    n0Var.q(n0Var.f1330w);
                }
            }
        }
    }

    public final void r(boolean z2) {
        if (z2 && this.f1327t != null) {
            b0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (v vVar : this.f1312c.y()) {
            if (vVar != null && z2) {
                vVar.O.r(true);
            }
        }
    }

    public final boolean s() {
        if (this.f1326s < 1) {
            return false;
        }
        boolean z2 = false;
        for (v vVar : this.f1312c.y()) {
            if (vVar != null && J(vVar)) {
                if (!vVar.T ? vVar.O.s() : false) {
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public final void t(int i) {
        try {
            this.f1311b = true;
            for (u0 u0Var : ((HashMap) this.f1312c.f12869w).values()) {
                if (u0Var != null) {
                    u0Var.f1376e = i;
                }
            }
            M(i, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((j) it.next()).e();
            }
            this.f1311b = false;
            x(true);
        } catch (Throwable th) {
            this.f1311b = false;
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        v vVar = this.f1329v;
        if (vVar != null) {
            sb2.append(vVar.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f1329v)));
            sb2.append("}");
        } else {
            z zVar = this.f1327t;
            if (zVar != null) {
                sb2.append(zVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f1327t)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2;
        String strM = e6.j.m(str, "    ");
        ub.o oVar = this.f1312c;
        ArrayList arrayList = (ArrayList) oVar.f12868v;
        String strM2 = e6.j.m(str, "    ");
        HashMap map = (HashMap) oVar.f12869w;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (u0 u0Var : map.values()) {
                printWriter.print(str);
                if (u0Var != null) {
                    v vVar = u0Var.f1374c;
                    printWriter.println(vVar);
                    vVar.getClass();
                    printWriter.print(strM2);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(vVar.Q));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(vVar.R));
                    printWriter.print(" mTag=");
                    printWriter.println(vVar.S);
                    printWriter.print(strM2);
                    printWriter.print("mState=");
                    printWriter.print(vVar.f1393u);
                    printWriter.print(" mWho=");
                    printWriter.print(vVar.f1398z);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(vVar.L);
                    printWriter.print(strM2);
                    printWriter.print("mAdded=");
                    printWriter.print(vVar.F);
                    printWriter.print(" mRemoving=");
                    printWriter.print(vVar.G);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(vVar.H);
                    printWriter.print(" mInLayout=");
                    printWriter.println(vVar.I);
                    printWriter.print(strM2);
                    printWriter.print("mHidden=");
                    printWriter.print(vVar.T);
                    printWriter.print(" mDetached=");
                    printWriter.print(vVar.U);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(vVar.X);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(strM2);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(vVar.V);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(vVar.f1380c0);
                    if (vVar.M != null) {
                        printWriter.print(strM2);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(vVar.M);
                    }
                    if (vVar.N != null) {
                        printWriter.print(strM2);
                        printWriter.print("mHost=");
                        printWriter.println(vVar.N);
                    }
                    if (vVar.P != null) {
                        printWriter.print(strM2);
                        printWriter.print("mParentFragment=");
                        printWriter.println(vVar.P);
                    }
                    if (vVar.A != null) {
                        printWriter.print(strM2);
                        printWriter.print("mArguments=");
                        printWriter.println(vVar.A);
                    }
                    if (vVar.f1394v != null) {
                        printWriter.print(strM2);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(vVar.f1394v);
                    }
                    if (vVar.f1395w != null) {
                        printWriter.print(strM2);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(vVar.f1395w);
                    }
                    if (vVar.f1396x != null) {
                        printWriter.print(strM2);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(vVar.f1396x);
                    }
                    Object objL = vVar.B;
                    if (objL == null) {
                        n0 n0Var = vVar.M;
                        objL = (n0Var == null || (str2 = vVar.C) == null) ? null : n0Var.f1312c.l(str2);
                    }
                    if (objL != null) {
                        printWriter.print(strM2);
                        printWriter.print("mTarget=");
                        printWriter.print(objL);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(vVar.D);
                    }
                    printWriter.print(strM2);
                    printWriter.print("mPopDirection=");
                    t tVar = vVar.f1381d0;
                    printWriter.println(tVar == null ? false : tVar.f1361a);
                    t tVar2 = vVar.f1381d0;
                    if ((tVar2 == null ? 0 : tVar2.f1362b) != 0) {
                        printWriter.print(strM2);
                        printWriter.print("getEnterAnim=");
                        t tVar3 = vVar.f1381d0;
                        printWriter.println(tVar3 == null ? 0 : tVar3.f1362b);
                    }
                    t tVar4 = vVar.f1381d0;
                    if ((tVar4 == null ? 0 : tVar4.f1363c) != 0) {
                        printWriter.print(strM2);
                        printWriter.print("getExitAnim=");
                        t tVar5 = vVar.f1381d0;
                        printWriter.println(tVar5 == null ? 0 : tVar5.f1363c);
                    }
                    t tVar6 = vVar.f1381d0;
                    if ((tVar6 == null ? 0 : tVar6.f1364d) != 0) {
                        printWriter.print(strM2);
                        printWriter.print("getPopEnterAnim=");
                        t tVar7 = vVar.f1381d0;
                        printWriter.println(tVar7 == null ? 0 : tVar7.f1364d);
                    }
                    t tVar8 = vVar.f1381d0;
                    if ((tVar8 == null ? 0 : tVar8.f1365e) != 0) {
                        printWriter.print(strM2);
                        printWriter.print("getPopExitAnim=");
                        t tVar9 = vVar.f1381d0;
                        printWriter.println(tVar9 == null ? 0 : tVar9.f1365e);
                    }
                    if (vVar.Z != null) {
                        printWriter.print(strM2);
                        printWriter.print("mContainer=");
                        printWriter.println(vVar.Z);
                    }
                    if (vVar.f1378a0 != null) {
                        printWriter.print(strM2);
                        printWriter.print("mView=");
                        printWriter.println(vVar.f1378a0);
                    }
                    if (vVar.j() != null) {
                        s.j jVar = ((o1.a) new a7.b(vVar.e(), o1.a.f9049e).s(o1.a.class)).f9050d;
                        if (jVar.f11638w > 0) {
                            printWriter.print(strM2);
                            printWriter.println("Loaders:");
                            if (jVar.f11638w > 0) {
                                if (jVar.f11637v[0] != null) {
                                    throw new ClassCastException();
                                }
                                printWriter.print(strM2);
                                printWriter.print("  #");
                                printWriter.print(jVar.f11636u[0]);
                                printWriter.print(": ");
                                throw null;
                            }
                        }
                    }
                    printWriter.print(strM2);
                    printWriter.println("Child " + vVar.O + ":");
                    vVar.O.u(e6.j.m(strM2, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                v vVar2 = (v) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(vVar2.toString());
            }
        }
        ArrayList arrayList2 = this.f1314e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                v vVar3 = (v) this.f1314e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(vVar3.toString());
            }
        }
        ArrayList arrayList3 = this.f1313d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = (a) this.f1313d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.f(strM, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.f1310a) {
            try {
                int size4 = this.f1310a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size4; i12++) {
                        Object obj = (l0) this.f1310a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1327t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1328u);
        if (this.f1329v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1329v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1326s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public final void v(l0 l0Var, boolean z2) {
        if (!z2) {
            if (this.f1327t == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (L()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f1310a) {
            try {
                if (this.f1327t == null) {
                    if (!z2) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f1310a.add(l0Var);
                    V();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z2) {
        if (this.f1311b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1327t == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f1327t.f1424w.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z2 && L()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.I == null) {
            this.I = new ArrayList();
            this.J = new ArrayList();
        }
    }

    public final boolean x(boolean z2) {
        boolean zA;
        w(z2);
        boolean z10 = false;
        while (true) {
            ArrayList arrayList = this.I;
            ArrayList arrayList2 = this.J;
            synchronized (this.f1310a) {
                if (this.f1310a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.f1310a.size();
                        zA = false;
                        for (int i = 0; i < size; i++) {
                            zA |= ((l0) this.f1310a.get(i)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!zA) {
                break;
            }
            this.f1311b = true;
            try {
                S(this.I, this.J);
                d();
                z10 = true;
            } catch (Throwable th) {
                d();
                throw th;
            }
        }
        c0();
        if (this.H) {
            this.H = false;
            ArrayList arrayListT = this.f1312c.t();
            int size2 = arrayListT.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj = arrayListT.get(i10);
                i10++;
                u0 u0Var = (u0) obj;
                v vVar = u0Var.f1374c;
                if (vVar.f1379b0) {
                    if (this.f1311b) {
                        this.H = true;
                    } else {
                        vVar.f1379b0 = false;
                        u0Var.k();
                    }
                }
            }
        }
        ((HashMap) this.f1312c.f12869w).values().removeAll(Collections.singleton(null));
        return z10;
    }

    public final void y(a aVar, boolean z2) {
        if (z2 && (this.f1327t == null || this.G)) {
            return;
        }
        w(z2);
        aVar.a(this.I, this.J);
        this.f1311b = true;
        try {
            S(this.I, this.J);
            d();
            c0();
            boolean z10 = this.H;
            ub.o oVar = this.f1312c;
            if (z10) {
                this.H = false;
                ArrayList arrayListT = oVar.t();
                int size = arrayListT.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayListT.get(i);
                    i++;
                    u0 u0Var = (u0) obj;
                    v vVar = u0Var.f1374c;
                    if (vVar.f1379b0) {
                        if (this.f1311b) {
                            this.H = true;
                        } else {
                            vVar.f1379b0 = false;
                            u0Var.k();
                        }
                    }
                }
            }
            ((HashMap) oVar.f12869w).values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x022b A[PHI: r14
      0x022b: PHI (r14v23 int) = (r14v22 int), (r14v24 int) binds: [B:103:0x021b, B:108:0x0227] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(java.util.ArrayList r24, java.util.ArrayList r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 1276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n0.z(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }
}
