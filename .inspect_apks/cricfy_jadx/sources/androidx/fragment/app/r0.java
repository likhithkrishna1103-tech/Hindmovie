package androidx.fragment.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.z3;
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
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {
    public e.g A;
    public e.g B;
    public e.g C;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public ArrayList J;
    public ArrayList K;
    public ArrayList L;
    public u0 M;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1045b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f1047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f1048e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c.f0 f1049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i0 f1050h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g0 f1056o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final g0 f1057p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g0 f1058q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g0 f1059r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c0 f1062u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public z3 f1063v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public y f1064w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public y f1065x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final o8.j f1067z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1044a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nc.p f1046c = new nc.p(2);
    public final f0 f = new f0(this);
    public final AtomicInteger i = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f1051j = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f1052k = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f1053l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l4.c0 f1054m = new l4.c0(this);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList f1055n = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j0 f1060s = new j0(this);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1061t = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final k0 f1066y = new k0(this);
    public ArrayDeque D = new ArrayDeque();
    public final m N = new m(2, this);

    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.g0] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.g0] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.g0] */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.fragment.app.g0] */
    public r0() {
        final int i = 0;
        this.f1050h = new i0(i, this);
        this.f1056o = new s0.a(this) { // from class: androidx.fragment.app.g0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f991b;

            {
                this.f991b = this;
            }

            @Override // s0.a
            public final void accept(Object obj) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        Configuration configuration = (Configuration) obj;
                        r0 r0Var = this.f991b;
                        if (r0Var.L()) {
                            r0Var.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        r0 r0Var2 = this.f991b;
                        if (r0Var2.L() && num.intValue() == 80) {
                            r0Var2.m(false);
                            break;
                        }
                        break;
                    case 2:
                        h0.f fVar = (h0.f) obj;
                        r0 r0Var3 = this.f991b;
                        if (r0Var3.L()) {
                            boolean z10 = fVar.f5438a;
                            r0Var3.n(false);
                        }
                        break;
                    default:
                        h0.s sVar = (h0.s) obj;
                        r0 r0Var4 = this.f991b;
                        if (r0Var4.L()) {
                            boolean z11 = sVar.f5468a;
                            r0Var4.s(false);
                        }
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f1057p = new s0.a(this) { // from class: androidx.fragment.app.g0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f991b;

            {
                this.f991b = this;
            }

            @Override // s0.a
            public final void accept(Object obj) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        Configuration configuration = (Configuration) obj;
                        r0 r0Var = this.f991b;
                        if (r0Var.L()) {
                            r0Var.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        r0 r0Var2 = this.f991b;
                        if (r0Var2.L() && num.intValue() == 80) {
                            r0Var2.m(false);
                            break;
                        }
                        break;
                    case 2:
                        h0.f fVar = (h0.f) obj;
                        r0 r0Var3 = this.f991b;
                        if (r0Var3.L()) {
                            boolean z10 = fVar.f5438a;
                            r0Var3.n(false);
                        }
                        break;
                    default:
                        h0.s sVar = (h0.s) obj;
                        r0 r0Var4 = this.f991b;
                        if (r0Var4.L()) {
                            boolean z11 = sVar.f5468a;
                            r0Var4.s(false);
                        }
                        break;
                }
            }
        };
        final int i11 = 2;
        this.f1058q = new s0.a(this) { // from class: androidx.fragment.app.g0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f991b;

            {
                this.f991b = this;
            }

            @Override // s0.a
            public final void accept(Object obj) {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        Configuration configuration = (Configuration) obj;
                        r0 r0Var = this.f991b;
                        if (r0Var.L()) {
                            r0Var.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        r0 r0Var2 = this.f991b;
                        if (r0Var2.L() && num.intValue() == 80) {
                            r0Var2.m(false);
                            break;
                        }
                        break;
                    case 2:
                        h0.f fVar = (h0.f) obj;
                        r0 r0Var3 = this.f991b;
                        if (r0Var3.L()) {
                            boolean z10 = fVar.f5438a;
                            r0Var3.n(false);
                        }
                        break;
                    default:
                        h0.s sVar = (h0.s) obj;
                        r0 r0Var4 = this.f991b;
                        if (r0Var4.L()) {
                            boolean z11 = sVar.f5468a;
                            r0Var4.s(false);
                        }
                        break;
                }
            }
        };
        final int i12 = 3;
        this.f1059r = new s0.a(this) { // from class: androidx.fragment.app.g0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f991b;

            {
                this.f991b = this;
            }

            @Override // s0.a
            public final void accept(Object obj) {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        Configuration configuration = (Configuration) obj;
                        r0 r0Var = this.f991b;
                        if (r0Var.L()) {
                            r0Var.h(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        r0 r0Var2 = this.f991b;
                        if (r0Var2.L() && num.intValue() == 80) {
                            r0Var2.m(false);
                            break;
                        }
                        break;
                    case 2:
                        h0.f fVar = (h0.f) obj;
                        r0 r0Var3 = this.f991b;
                        if (r0Var3.L()) {
                            boolean z10 = fVar.f5438a;
                            r0Var3.n(false);
                        }
                        break;
                    default:
                        h0.s sVar = (h0.s) obj;
                        r0 r0Var4 = this.f991b;
                        if (r0Var4.L()) {
                            boolean z11 = sVar.f5468a;
                            r0Var4.s(false);
                        }
                        break;
                }
            }
        };
        this.f1067z = new o8.j(i12);
    }

    public static boolean J(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean K(y yVar) {
        yVar.getClass();
        ArrayList arrayListN = yVar.P.f1046c.n();
        int size = arrayListN.size();
        boolean zK = false;
        int i = 0;
        while (i < size) {
            Object obj = arrayListN.get(i);
            i++;
            y yVar2 = (y) obj;
            if (yVar2 != null) {
                zK = K(yVar2);
            }
            if (zK) {
                return true;
            }
        }
        return false;
    }

    public static boolean M(y yVar) {
        if (yVar == null) {
            return true;
        }
        if (yVar.Y) {
            return yVar.N == null || M(yVar.Q);
        }
        return false;
    }

    public static boolean N(y yVar) {
        if (yVar == null) {
            return true;
        }
        r0 r0Var = yVar.N;
        return yVar.equals(r0Var.f1065x) && N(r0Var.f1064w);
    }

    public static void e0(y yVar) {
        if (J(2)) {
            Log.v("FragmentManager", "show: " + yVar);
        }
        if (yVar.U) {
            yVar.U = false;
            yVar.f1107f0 = !yVar.f1107f0;
        }
    }

    public final boolean A(boolean z10) {
        boolean zA;
        z(z10);
        boolean z11 = false;
        while (true) {
            ArrayList arrayList = this.J;
            ArrayList arrayList2 = this.K;
            synchronized (this.f1044a) {
                if (this.f1044a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.f1044a.size();
                        zA = false;
                        for (int i = 0; i < size; i++) {
                            zA |= ((p0) this.f1044a.get(i)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!zA) {
                h0();
                v();
                ((HashMap) this.f1046c.f9070b).values().removeAll(Collections.singleton(null));
                return z11;
            }
            z11 = true;
            this.f1045b = true;
            try {
                V(this.J, this.K);
            } finally {
                d();
            }
        }
    }

    public final void B(a aVar, boolean z10) {
        if (z10 && (this.f1062u == null || this.H)) {
            return;
        }
        z(z10);
        aVar.a(this.J, this.K);
        this.f1045b = true;
        try {
            V(this.J, this.K);
            d();
            h0();
            v();
            ((HashMap) this.f1046c.f9070b).values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x022b A[PHI: r14
      0x022b: PHI (r14v24 int) = (r14v23 int), (r14v25 int) binds: [B:103:0x021b, B:108:0x0227] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(java.util.ArrayList r24, java.util.ArrayList r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 1324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.r0.C(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final y D(int i) {
        nc.p pVar = this.f1046c;
        ArrayList arrayList = (ArrayList) pVar.f9069a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            y yVar = (y) arrayList.get(size);
            if (yVar != null && yVar.R == i) {
                return yVar;
            }
        }
        for (z0 z0Var : ((HashMap) pVar.f9070b).values()) {
            if (z0Var != null) {
                y yVar2 = z0Var.f1129c;
                if (yVar2.R == i) {
                    return yVar2;
                }
            }
        }
        return null;
    }

    public final y E(String str) {
        nc.p pVar = this.f1046c;
        ArrayList arrayList = (ArrayList) pVar.f9069a;
        if (str != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                y yVar = (y) arrayList.get(size);
                if (yVar != null && str.equals(yVar.T)) {
                    return yVar;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (z0 z0Var : ((HashMap) pVar.f9070b).values()) {
            if (z0Var != null) {
                y yVar2 = z0Var.f1129c;
                if (str.equals(yVar2.T)) {
                    return yVar2;
                }
            }
        }
        return null;
    }

    public final ViewGroup F(y yVar) {
        ViewGroup viewGroup = yVar.f1102a0;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (yVar.S <= 0 || !this.f1063v.q()) {
            return null;
        }
        View viewP = this.f1063v.p(yVar.S);
        if (viewP instanceof ViewGroup) {
            return (ViewGroup) viewP;
        }
        return null;
    }

    public final k0 G() {
        y yVar = this.f1064w;
        return yVar != null ? yVar.N.G() : this.f1066y;
    }

    public final o8.j H() {
        y yVar = this.f1064w;
        return yVar != null ? yVar.N.H() : this.f1067z;
    }

    public final void I(y yVar) {
        if (J(2)) {
            Log.v("FragmentManager", "hide: " + yVar);
        }
        if (yVar.U) {
            return;
        }
        yVar.U = true;
        yVar.f1107f0 = true ^ yVar.f1107f0;
        d0(yVar);
    }

    public final boolean L() {
        y yVar = this.f1064w;
        if (yVar == null) {
            return true;
        }
        return yVar.p() && this.f1064w.l().L();
    }

    public final boolean O() {
        return this.F || this.G;
    }

    public final void P(int i, boolean z10) {
        c0 c0Var;
        if (this.f1062u == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i != this.f1061t) {
            this.f1061t = i;
            nc.p pVar = this.f1046c;
            HashMap map = (HashMap) pVar.f9070b;
            ArrayList arrayList = (ArrayList) pVar.f9069a;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                z0 z0Var = (z0) map.get(((y) obj).A);
                if (z0Var != null) {
                    z0Var.k();
                }
            }
            for (z0 z0Var2 : map.values()) {
                if (z0Var2 != null) {
                    z0Var2.k();
                    y yVar = z0Var2.f1129c;
                    if (yVar.H && !yVar.r()) {
                        pVar.u(z0Var2);
                    }
                }
            }
            f0();
            if (this.E && (c0Var = this.f1062u) != null && this.f1061t == 7) {
                c0Var.A.invalidateOptionsMenu();
                this.E = false;
            }
        }
    }

    public final void Q() {
        if (this.f1062u == null) {
            return;
        }
        this.F = false;
        this.G = false;
        this.M.i = false;
        for (y yVar : this.f1046c.o()) {
            if (yVar != null) {
                yVar.P.Q();
            }
        }
    }

    public final boolean R() {
        return S(-1, 0);
    }

    public final boolean S(int i, int i10) {
        A(false);
        z(true);
        y yVar = this.f1065x;
        if (yVar != null && i < 0 && yVar.i().R()) {
            return true;
        }
        boolean zT = T(this.J, this.K, null, i, i10);
        if (zT) {
            this.f1045b = true;
            try {
                V(this.J, this.K);
            } finally {
                d();
            }
        }
        h0();
        v();
        ((HashMap) this.f1046c.f9070b).values().removeAll(Collections.singleton(null));
        return zT;
    }

    public final boolean T(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i10) {
        boolean z10 = (i10 & 1) != 0;
        ArrayList arrayList3 = this.f1047d;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (str != null || i >= 0) {
                int size2 = this.f1047d.size() - 1;
                while (size2 >= 0) {
                    a aVar = (a) this.f1047d.get(size2);
                    if ((str != null && str.equals(aVar.i)) || (i >= 0 && i == aVar.f927s)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    size = size2;
                } else if (z10) {
                    size = size2;
                    while (size > 0) {
                        a aVar2 = (a) this.f1047d.get(size - 1);
                        if ((str == null || !str.equals(aVar2.i)) && (i < 0 || i != aVar2.f927s)) {
                            break;
                        }
                        size--;
                    }
                } else if (size2 != this.f1047d.size() - 1) {
                    size = size2 + 1;
                }
            } else {
                size = z10 ? 0 : this.f1047d.size() - 1;
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.f1047d.size() - 1; size3 >= size; size3--) {
            arrayList.add((a) this.f1047d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void U(y yVar) {
        if (J(2)) {
            Log.v("FragmentManager", "remove: " + yVar + " nesting=" + yVar.M);
        }
        boolean zR = yVar.r();
        if (yVar.V && zR) {
            return;
        }
        nc.p pVar = this.f1046c;
        synchronized (((ArrayList) pVar.f9069a)) {
            ((ArrayList) pVar.f9069a).remove(yVar);
        }
        yVar.G = false;
        if (K(yVar)) {
            this.E = true;
        }
        yVar.H = true;
        d0(yVar);
    }

    public final void V(ArrayList arrayList, ArrayList arrayList2) {
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
            if (!((a) arrayList.get(i)).f924p) {
                if (i10 != i) {
                    C(arrayList, arrayList2, i10, i);
                }
                i10 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i10 < size && ((Boolean) arrayList2.get(i10)).booleanValue() && !((a) arrayList.get(i10)).f924p) {
                        i10++;
                    }
                }
                C(arrayList, arrayList2, i, i10);
                i = i10 - 1;
            }
            i++;
        }
        if (i10 != size) {
            C(arrayList, arrayList2, i10, size);
        }
    }

    public final void W(Bundle bundle) {
        l4.c0 c0Var;
        int i;
        int i10;
        Bundle bundle2;
        z0 z0Var;
        Bundle bundle3;
        Bundle bundle4;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle4 = bundle.getBundle(str)) != null) {
                bundle4.setClassLoader(this.f1062u.f952x.getClassLoader());
                this.f1052k.put(str.substring(7), bundle4);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle3 = bundle.getBundle(str2)) != null) {
                bundle3.setClassLoader(this.f1062u.f952x.getClassLoader());
                map.put(str2.substring(9), bundle3);
            }
        }
        nc.p pVar = this.f1046c;
        HashMap map2 = (HashMap) pVar.f9071c;
        HashMap map3 = (HashMap) pVar.f9070b;
        map2.clear();
        map2.putAll(map);
        s0 s0Var = (s0) bundle.getParcelable("state");
        if (s0Var == null) {
            return;
        }
        map3.clear();
        ArrayList arrayList = s0Var.f1069v;
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            c0Var = this.f1054m;
            if (i11 >= size) {
                break;
            }
            Object obj = arrayList.get(i11);
            i11++;
            Bundle bundleB = pVar.B((String) obj, null);
            if (bundleB != null) {
                y yVar = (y) this.M.f1078d.get(((x0) bundleB.getParcelable("state")).f1097w);
                if (yVar != null) {
                    if (J(2)) {
                        i10 = 2;
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + yVar);
                    } else {
                        i10 = 2;
                    }
                    z0Var = new z0(c0Var, pVar, yVar, bundleB);
                    bundle2 = bundleB;
                } else {
                    i10 = 2;
                    bundle2 = bundleB;
                    z0Var = new z0(this.f1054m, this.f1046c, this.f1062u.f952x.getClassLoader(), G(), bundleB);
                }
                y yVar2 = z0Var.f1129c;
                yVar2.f1119w = bundle2;
                yVar2.N = this;
                if (J(i10)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + yVar2.A + "): " + yVar2);
                }
                z0Var.m(this.f1062u.f952x.getClassLoader());
                pVar.t(z0Var);
                z0Var.f1131e = this.f1061t;
            }
        }
        u0 u0Var = this.M;
        u0Var.getClass();
        ArrayList arrayList2 = new ArrayList(u0Var.f1078d.values());
        int size2 = arrayList2.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList2.get(i12);
            i12++;
            y yVar3 = (y) obj2;
            if (map3.get(yVar3.A) == null) {
                if (J(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + yVar3 + " that was not found in the set of active Fragments " + s0Var.f1069v);
                }
                this.M.f(yVar3);
                yVar3.N = this;
                z0 z0Var2 = new z0(c0Var, pVar, yVar3);
                z0Var2.f1131e = 1;
                z0Var2.k();
                yVar3.H = true;
                z0Var2.k();
            }
        }
        ArrayList arrayList3 = s0Var.f1070w;
        ((ArrayList) pVar.f9069a).clear();
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            int i13 = 0;
            while (i13 < size3) {
                Object obj3 = arrayList3.get(i13);
                i13++;
                String str3 = (String) obj3;
                y yVarI = pVar.i(str3);
                if (yVarI == null) {
                    throw new IllegalStateException(l0.e.k("No instantiated fragment for (", str3, ")"));
                }
                if (J(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + yVarI);
                }
                pVar.a(yVarI);
            }
        }
        if (s0Var.f1071x != null) {
            this.f1047d = new ArrayList(s0Var.f1071x.length);
            int i14 = 0;
            while (true) {
                b[] bVarArr = s0Var.f1071x;
                if (i14 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i14];
                ArrayList arrayList4 = bVar.f938w;
                a aVar = new a(this);
                int[] iArr = bVar.f937v;
                int i15 = 0;
                int i16 = 0;
                while (i15 < iArr.length) {
                    a1 a1Var = new a1();
                    int i17 = i15 + 1;
                    a1Var.f930a = iArr[i15];
                    if (J(2)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i16 + " base fragment #" + iArr[i17]);
                    }
                    a1Var.f936h = androidx.lifecycle.n.values()[bVar.f939x[i16]];
                    a1Var.i = androidx.lifecycle.n.values()[bVar.f940y[i16]];
                    int i18 = i15 + 2;
                    a1Var.f932c = iArr[i17] != 0;
                    int i19 = iArr[i18];
                    a1Var.f933d = i19;
                    int i20 = iArr[i15 + 3];
                    a1Var.f934e = i20;
                    int i21 = i15 + 5;
                    int i22 = iArr[i15 + 4];
                    a1Var.f = i22;
                    i15 += 6;
                    int[] iArr2 = iArr;
                    int i23 = iArr2[i21];
                    a1Var.f935g = i23;
                    aVar.f912b = i19;
                    aVar.f913c = i20;
                    aVar.f914d = i22;
                    aVar.f915e = i23;
                    aVar.b(a1Var);
                    i16++;
                    iArr = iArr2;
                }
                aVar.f = bVar.f941z;
                aVar.i = bVar.A;
                aVar.f916g = true;
                aVar.f918j = bVar.C;
                aVar.f919k = bVar.D;
                aVar.f920l = bVar.E;
                aVar.f921m = bVar.F;
                aVar.f922n = bVar.G;
                aVar.f923o = bVar.H;
                aVar.f924p = bVar.I;
                aVar.f927s = bVar.B;
                for (int i24 = 0; i24 < arrayList4.size(); i24++) {
                    String str4 = (String) arrayList4.get(i24);
                    if (str4 != null) {
                        ((a1) aVar.f911a.get(i24)).f931b = pVar.i(str4);
                    }
                }
                aVar.d(1);
                if (J(2)) {
                    StringBuilder sbM = l0.e.m(i14, "restoreAllState: back stack #", " (index ");
                    sbM.append(aVar.f927s);
                    sbM.append("): ");
                    sbM.append(aVar);
                    Log.v("FragmentManager", sbM.toString());
                    PrintWriter printWriter = new PrintWriter(new c1());
                    aVar.g("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1047d.add(aVar);
                i14++;
            }
            i = 0;
        } else {
            i = 0;
            this.f1047d = null;
        }
        this.i.set(s0Var.f1072y);
        String str5 = s0Var.f1073z;
        if (str5 != null) {
            y yVarI2 = pVar.i(str5);
            this.f1065x = yVarI2;
            r(yVarI2);
        }
        ArrayList arrayList5 = s0Var.A;
        if (arrayList5 != null) {
            for (int i25 = i; i25 < arrayList5.size(); i25++) {
                this.f1051j.put((String) arrayList5.get(i25), (c) s0Var.B.get(i25));
            }
        }
        this.D = new ArrayDeque(s0Var.C);
    }

    public final Bundle X() {
        int i;
        ArrayList arrayList;
        b[] bVarArr;
        int size;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            l lVar = (l) it.next();
            if (lVar.f1018e) {
                if (J(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                lVar.f1018e = false;
                lVar.c();
            }
        }
        x();
        A(true);
        this.F = true;
        this.M.i = true;
        nc.p pVar = this.f1046c;
        pVar.getClass();
        HashMap map = (HashMap) pVar.f9070b;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (z0 z0Var : map.values()) {
            if (z0Var != null) {
                y yVar = z0Var.f1129c;
                String str = yVar.A;
                Bundle bundle3 = new Bundle();
                y yVar2 = z0Var.f1129c;
                if (yVar2.f1118v == -1 && (bundle = yVar2.f1119w) != null) {
                    bundle3.putAll(bundle);
                }
                bundle3.putParcelable("state", new x0(yVar2));
                if (yVar2.f1118v > -1) {
                    Bundle bundle4 = new Bundle();
                    yVar2.D(bundle4);
                    if (!bundle4.isEmpty()) {
                        bundle3.putBundle("savedInstanceState", bundle4);
                    }
                    z0Var.f1127a.F(false);
                    Bundle bundle5 = new Bundle();
                    yVar2.f1115n0.f(bundle5);
                    if (!bundle5.isEmpty()) {
                        bundle3.putBundle("registryState", bundle5);
                    }
                    Bundle bundleX = yVar2.P.X();
                    if (!bundleX.isEmpty()) {
                        bundle3.putBundle("childFragmentManager", bundleX);
                    }
                    if (yVar2.f1103b0 != null) {
                        z0Var.o();
                    }
                    SparseArray<? extends Parcelable> sparseArray = yVar2.f1120x;
                    if (sparseArray != null) {
                        bundle3.putSparseParcelableArray("viewState", sparseArray);
                    }
                    Bundle bundle6 = yVar2.f1121y;
                    if (bundle6 != null) {
                        bundle3.putBundle("viewRegistryState", bundle6);
                    }
                }
                Bundle bundle7 = yVar2.B;
                if (bundle7 != null) {
                    bundle3.putBundle("arguments", bundle7);
                }
                pVar.B(str, bundle3);
                arrayList2.add(yVar.A);
                if (J(2)) {
                    Log.v("FragmentManager", "Saved state of " + yVar + ": " + yVar.f1119w);
                }
            }
        }
        HashMap map2 = (HashMap) this.f1046c.f9071c;
        if (!map2.isEmpty()) {
            nc.p pVar2 = this.f1046c;
            synchronized (((ArrayList) pVar2.f9069a)) {
                try {
                    if (((ArrayList) pVar2.f9069a).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) pVar2.f9069a).size());
                        ArrayList arrayList3 = (ArrayList) pVar2.f9069a;
                        int size2 = arrayList3.size();
                        int i10 = 0;
                        while (i10 < size2) {
                            Object obj = arrayList3.get(i10);
                            i10++;
                            y yVar3 = (y) obj;
                            arrayList.add(yVar3.A);
                            if (J(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + yVar3.A + "): " + yVar3);
                            }
                        }
                    }
                } finally {
                }
            }
            ArrayList arrayList4 = this.f1047d;
            if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
                bVarArr = null;
            } else {
                bVarArr = new b[size];
                for (i = 0; i < size; i++) {
                    bVarArr[i] = new b((a) this.f1047d.get(i));
                    if (J(2)) {
                        StringBuilder sbM = l0.e.m(i, "saveAllState: adding back stack #", ": ");
                        sbM.append(this.f1047d.get(i));
                        Log.v("FragmentManager", sbM.toString());
                    }
                }
            }
            s0 s0Var = new s0();
            s0Var.f1073z = null;
            ArrayList arrayList5 = new ArrayList();
            s0Var.A = arrayList5;
            ArrayList arrayList6 = new ArrayList();
            s0Var.B = arrayList6;
            s0Var.f1069v = arrayList2;
            s0Var.f1070w = arrayList;
            s0Var.f1071x = bVarArr;
            s0Var.f1072y = this.i.get();
            y yVar4 = this.f1065x;
            if (yVar4 != null) {
                s0Var.f1073z = yVar4.A;
            }
            arrayList5.addAll(this.f1051j.keySet());
            arrayList6.addAll(this.f1051j.values());
            s0Var.C = new ArrayList(this.D);
            bundle2.putParcelable("state", s0Var);
            for (String str2 : this.f1052k.keySet()) {
                bundle2.putBundle(q4.a.n("result_", str2), (Bundle) this.f1052k.get(str2));
            }
            for (String str3 : map2.keySet()) {
                bundle2.putBundle(q4.a.n("fragment_", str3), (Bundle) map2.get(str3));
            }
        } else if (J(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle2;
        }
        return bundle2;
    }

    public final void Y() {
        synchronized (this.f1044a) {
            try {
                if (this.f1044a.size() == 1) {
                    this.f1062u.f953y.removeCallbacks(this.N);
                    this.f1062u.f953y.post(this.N);
                    h0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void Z(y yVar, boolean z10) {
        ViewGroup viewGroupF = F(yVar);
        if (viewGroupF == null || !(viewGroupF instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupF).setDrawDisappearingViewsLast(!z10);
    }

    public final z0 a(y yVar) {
        String str = yVar.f1109h0;
        if (str != null) {
            p1.c.c(yVar, str);
        }
        if (J(2)) {
            Log.v("FragmentManager", "add: " + yVar);
        }
        z0 z0VarF = f(yVar);
        yVar.N = this;
        nc.p pVar = this.f1046c;
        pVar.t(z0VarF);
        if (!yVar.V) {
            pVar.a(yVar);
            yVar.H = false;
            if (yVar.f1103b0 == null) {
                yVar.f1107f0 = false;
            }
            if (K(yVar)) {
                this.E = true;
            }
        }
        return z0VarF;
    }

    public final void a0(h.j jVar, final w0 w0Var) {
        final androidx.lifecycle.u uVar = jVar.f5437v;
        if (uVar.f1200c == androidx.lifecycle.n.f1179v) {
            return;
        }
        androidx.lifecycle.q qVar = new androidx.lifecycle.q() { // from class: androidx.fragment.app.FragmentManager$6
            @Override // androidx.lifecycle.q
            public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.m mVar) {
                Bundle bundle;
                r0 r0Var = this.f910x;
                Map map = r0Var.f1052k;
                if (mVar == androidx.lifecycle.m.ON_START && (bundle = (Bundle) map.get("ad_closed")) != null) {
                    w0Var.e(bundle);
                    map.remove("ad_closed");
                    if (r0.J(2)) {
                        Log.v("FragmentManager", "Clearing fragment result with key ad_closed");
                    }
                }
                if (mVar == androidx.lifecycle.m.ON_DESTROY) {
                    uVar.f(this);
                    r0Var.f1053l.remove("ad_closed");
                }
            }
        };
        o0 o0Var = (o0) this.f1053l.put("ad_closed", new o0(uVar, w0Var, qVar));
        if (o0Var != null) {
            o0Var.f1027v.f(o0Var.f1029x);
        }
        if (J(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key ad_closed lifecycleOwner " + uVar + " and listener " + w0Var);
        }
        uVar.a(qVar);
    }

    public final void b(c0 c0Var, z3 z3Var, y yVar) {
        if (this.f1062u != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1062u = c0Var;
        this.f1063v = z3Var;
        this.f1064w = yVar;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1055n;
        if (yVar != null) {
            copyOnWriteArrayList.add(new l0(yVar));
        } else if (c0Var != null) {
            copyOnWriteArrayList.add(c0Var);
        }
        if (this.f1064w != null) {
            h0();
        }
        if (c0Var != null) {
            c.f0 f0VarJ = c0Var.A.j();
            this.f1049g = f0VarJ;
            f0VarJ.a(this.f1050h, yVar != null ? yVar : c0Var);
        }
        if (yVar != null) {
            u0 u0Var = yVar.N.M;
            HashMap map = u0Var.f1079e;
            u0 u0Var2 = (u0) map.get(yVar.A);
            if (u0Var2 == null) {
                u0Var2 = new u0(u0Var.f1080g);
                map.put(yVar.A, u0Var2);
            }
            this.M = u0Var2;
        } else if (c0Var != null) {
            this.M = (u0) new androidx.emoji2.text.v(c0Var.A.e(), u0.f1077j).r(u0.class);
        } else {
            this.M = new u0(false);
        }
        this.M.i = O();
        this.f1046c.f9072d = this.M;
        c0 c0Var2 = this.f1062u;
        if (c0Var2 != null && yVar == null) {
            b5.e eVarA = c0Var2.a();
            eVarA.f("android:support:fragments", new h0(0, this));
            Bundle bundleC = eVarA.c("android:support:fragments");
            if (bundleC != null) {
                W(bundleC);
            }
        }
        c0 c0Var3 = this.f1062u;
        if (c0Var3 != null) {
            c.l lVar = c0Var3.A.D;
            String strN = q4.a.n("FragmentManager:", yVar != null ? q4.a.q(new StringBuilder(), yVar.A, ":") : "");
            this.A = lVar.d(l0.e.j(strN, "StartActivityForResult"), new m0(3), new p6.d(2, this));
            this.B = lVar.d(l0.e.j(strN, "StartIntentSenderForResult"), new m0(0), new pc.c(this));
            this.C = lVar.d(l0.e.j(strN, "RequestPermissions"), new m0(1), new p6.c(3, this));
        }
        c0 c0Var4 = this.f1062u;
        if (c0Var4 != null) {
            c0Var4.A.h(this.f1056o);
        }
        c0 c0Var5 = this.f1062u;
        if (c0Var5 != null) {
            h.j jVar = c0Var5.A;
            jVar.getClass();
            g0 g0Var = this.f1057p;
            ge.i.e(g0Var, "listener");
            jVar.F.add(g0Var);
        }
        c0 c0Var6 = this.f1062u;
        if (c0Var6 != null) {
            h.j jVar2 = c0Var6.A;
            jVar2.getClass();
            g0 g0Var2 = this.f1058q;
            ge.i.e(g0Var2, "listener");
            jVar2.H.add(g0Var2);
        }
        c0 c0Var7 = this.f1062u;
        if (c0Var7 != null) {
            h.j jVar3 = c0Var7.A;
            jVar3.getClass();
            g0 g0Var3 = this.f1059r;
            ge.i.e(g0Var3, "listener");
            jVar3.I.add(g0Var3);
        }
        c0 c0Var8 = this.f1062u;
        if (c0Var8 == null || yVar != null) {
            return;
        }
        h.j jVar4 = c0Var8.A;
        jVar4.getClass();
        j0 j0Var = this.f1060s;
        ge.i.e(j0Var, "provider");
        l7.a aVar = jVar4.f1976x;
        ((CopyOnWriteArrayList) aVar.f7867x).add(j0Var);
        ((Runnable) aVar.f7866w).run();
    }

    public final void b0(y yVar, androidx.lifecycle.n nVar) {
        if (yVar.equals(this.f1046c.i(yVar.A)) && (yVar.O == null || yVar.N == this)) {
            yVar.f1110i0 = nVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + yVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void c(y yVar) {
        if (J(2)) {
            Log.v("FragmentManager", "attach: " + yVar);
        }
        if (yVar.V) {
            yVar.V = false;
            if (yVar.G) {
                return;
            }
            this.f1046c.a(yVar);
            if (J(2)) {
                Log.v("FragmentManager", "add from attach: " + yVar);
            }
            if (K(yVar)) {
                this.E = true;
            }
        }
    }

    public final void c0(y yVar) {
        if (yVar != null) {
            if (!yVar.equals(this.f1046c.i(yVar.A)) || (yVar.O != null && yVar.N != this)) {
                throw new IllegalArgumentException("Fragment " + yVar + " is not an active fragment of FragmentManager " + this);
            }
        }
        y yVar2 = this.f1065x;
        this.f1065x = yVar;
        r(yVar2);
        r(this.f1065x);
    }

    public final void d() {
        this.f1045b = false;
        this.K.clear();
        this.J.clear();
    }

    public final void d0(y yVar) {
        ViewGroup viewGroupF = F(yVar);
        if (viewGroupF != null) {
            w wVar = yVar.f1106e0;
            if ((wVar == null ? 0 : wVar.f1091e) + (wVar == null ? 0 : wVar.f1090d) + (wVar == null ? 0 : wVar.f1089c) + (wVar == null ? 0 : wVar.f1088b) > 0) {
                if (viewGroupF.getTag(o1.b.visible_removing_fragment_view_tag) == null) {
                    viewGroupF.setTag(o1.b.visible_removing_fragment_view_tag, yVar);
                }
                y yVar2 = (y) viewGroupF.getTag(o1.b.visible_removing_fragment_view_tag);
                w wVar2 = yVar.f1106e0;
                boolean z10 = wVar2 != null ? wVar2.f1087a : false;
                if (yVar2.f1106e0 == null) {
                    return;
                }
                yVar2.g().f1087a = z10;
            }
        }
    }

    public final HashSet e() {
        l lVar;
        HashSet hashSet = new HashSet();
        ArrayList arrayListM = this.f1046c.m();
        int size = arrayListM.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListM.get(i);
            i++;
            ViewGroup viewGroup = ((z0) obj).f1129c.f1102a0;
            if (viewGroup != null) {
                ge.i.e(H(), "factory");
                Object tag = viewGroup.getTag(o1.b.special_effects_controller_view_tag);
                if (tag instanceof l) {
                    lVar = (l) tag;
                } else {
                    lVar = new l(viewGroup);
                    viewGroup.setTag(o1.b.special_effects_controller_view_tag, lVar);
                }
                hashSet.add(lVar);
            }
        }
        return hashSet;
    }

    public final z0 f(y yVar) {
        String str = yVar.A;
        nc.p pVar = this.f1046c;
        z0 z0Var = (z0) ((HashMap) pVar.f9070b).get(str);
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(this.f1054m, pVar, yVar);
        z0Var2.m(this.f1062u.f952x.getClassLoader());
        z0Var2.f1131e = this.f1061t;
        return z0Var2;
    }

    public final void f0() {
        ArrayList arrayListM = this.f1046c.m();
        int size = arrayListM.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListM.get(i);
            i++;
            z0 z0Var = (z0) obj;
            y yVar = z0Var.f1129c;
            if (yVar.f1104c0) {
                if (this.f1045b) {
                    this.I = true;
                } else {
                    yVar.f1104c0 = false;
                    z0Var.k();
                }
            }
        }
    }

    public final void g(y yVar) {
        if (J(2)) {
            Log.v("FragmentManager", "detach: " + yVar);
        }
        if (yVar.V) {
            return;
        }
        yVar.V = true;
        if (yVar.G) {
            if (J(2)) {
                Log.v("FragmentManager", "remove from detach: " + yVar);
            }
            nc.p pVar = this.f1046c;
            synchronized (((ArrayList) pVar.f9069a)) {
                ((ArrayList) pVar.f9069a).remove(yVar);
            }
            yVar.G = false;
            if (K(yVar)) {
                this.E = true;
            }
            d0(yVar);
        }
    }

    public final void g0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new c1());
        c0 c0Var = this.f1062u;
        if (c0Var == null) {
            try {
                w("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e9) {
                Log.e("FragmentManager", "Failed dumping state", e9);
                throw illegalStateException;
            }
        }
        try {
            c0Var.A.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e10) {
            Log.e("FragmentManager", "Failed dumping state", e10);
            throw illegalStateException;
        }
    }

    public final void h(boolean z10, Configuration configuration) {
        if (z10 && this.f1062u != null) {
            g0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (y yVar : this.f1046c.o()) {
            if (yVar != null) {
                yVar.onConfigurationChanged(configuration);
                if (z10) {
                    yVar.P.h(true, configuration);
                }
            }
        }
    }

    public final void h0() {
        synchronized (this.f1044a) {
            try {
                if (!this.f1044a.isEmpty()) {
                    this.f1050h.c(true);
                    return;
                }
                i0 i0Var = this.f1050h;
                ArrayList arrayList = this.f1047d;
                i0Var.c((arrayList != null ? arrayList.size() : 0) > 0 && N(this.f1064w));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i() {
        if (this.f1061t >= 1) {
            for (y yVar : this.f1046c.o()) {
                if (yVar != null) {
                    if (!yVar.U ? yVar.P.i() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void j() {
        this.F = false;
        this.G = false;
        this.M.i = false;
        u(1);
    }

    public final boolean k() {
        if (this.f1061t < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z10 = false;
        for (y yVar : this.f1046c.o()) {
            if (yVar != null && M(yVar)) {
                if (!yVar.U ? yVar.P.k() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(yVar);
                    z10 = true;
                }
            }
        }
        if (this.f1048e != null) {
            for (int i = 0; i < this.f1048e.size(); i++) {
                y yVar2 = (y) this.f1048e.get(i);
                if (arrayList == null || !arrayList.contains(yVar2)) {
                    yVar2.getClass();
                }
            }
        }
        this.f1048e = arrayList;
        return z10;
    }

    public final void l() {
        boolean z10;
        this.H = true;
        A(true);
        x();
        c0 c0Var = this.f1062u;
        nc.p pVar = this.f1046c;
        if (c0Var != null) {
            z10 = ((u0) pVar.f9072d).f1081h;
        } else {
            z10 = q4.a.v(c0Var.f952x) ? !r1.isChangingConfigurations() : true;
        }
        if (z10) {
            Iterator it = this.f1051j.values().iterator();
            while (it.hasNext()) {
                ArrayList arrayList = ((c) it.next()).f949v;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    String str = (String) obj;
                    u0 u0Var = (u0) pVar.f9072d;
                    u0Var.getClass();
                    if (J(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    u0Var.e(str);
                }
            }
        }
        u(-1);
        c0 c0Var2 = this.f1062u;
        if (c0Var2 != null) {
            h.j jVar = c0Var2.A;
            jVar.getClass();
            g0 g0Var = this.f1057p;
            ge.i.e(g0Var, "listener");
            jVar.F.remove(g0Var);
        }
        c0 c0Var3 = this.f1062u;
        if (c0Var3 != null) {
            h.j jVar2 = c0Var3.A;
            jVar2.getClass();
            g0 g0Var2 = this.f1056o;
            ge.i.e(g0Var2, "listener");
            jVar2.E.remove(g0Var2);
        }
        c0 c0Var4 = this.f1062u;
        if (c0Var4 != null) {
            h.j jVar3 = c0Var4.A;
            jVar3.getClass();
            g0 g0Var3 = this.f1058q;
            ge.i.e(g0Var3, "listener");
            jVar3.H.remove(g0Var3);
        }
        c0 c0Var5 = this.f1062u;
        if (c0Var5 != null) {
            h.j jVar4 = c0Var5.A;
            jVar4.getClass();
            g0 g0Var4 = this.f1059r;
            ge.i.e(g0Var4, "listener");
            jVar4.I.remove(g0Var4);
        }
        c0 c0Var6 = this.f1062u;
        if ((c0Var6 != null) && this.f1064w == null) {
            h.j jVar5 = c0Var6.A;
            jVar5.getClass();
            j0 j0Var = this.f1060s;
            ge.i.e(j0Var, "provider");
            l7.a aVar = jVar5.f1976x;
            ((CopyOnWriteArrayList) aVar.f7867x).remove(j0Var);
            if (((HashMap) aVar.f7868y).remove(j0Var) != null) {
                throw new ClassCastException();
            }
            ((Runnable) aVar.f7866w).run();
        }
        this.f1062u = null;
        this.f1063v = null;
        this.f1064w = null;
        if (this.f1049g != null) {
            this.f1050h.b();
            this.f1049g = null;
        }
        e.g gVar = this.A;
        if (gVar != null) {
            gVar.b();
            this.B.b();
            this.C.b();
        }
    }

    public final void m(boolean z10) {
        if (z10 && this.f1062u != null) {
            g0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (y yVar : this.f1046c.o()) {
            if (yVar != null) {
                yVar.Z = true;
                if (z10) {
                    yVar.P.m(true);
                }
            }
        }
    }

    public final void n(boolean z10) {
        if (z10 && this.f1062u != null) {
            g0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (y yVar : this.f1046c.o()) {
            if (yVar != null && z10) {
                yVar.P.n(true);
            }
        }
    }

    public final void o() {
        ArrayList arrayListN = this.f1046c.n();
        int size = arrayListN.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListN.get(i);
            i++;
            y yVar = (y) obj;
            if (yVar != null) {
                yVar.q();
                yVar.P.o();
            }
        }
    }

    public final boolean p() {
        if (this.f1061t >= 1) {
            for (y yVar : this.f1046c.o()) {
                if (yVar != null) {
                    if (!yVar.U ? yVar.P.p() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void q() {
        if (this.f1061t < 1) {
            return;
        }
        for (y yVar : this.f1046c.o()) {
            if (yVar != null && !yVar.U) {
                yVar.P.q();
            }
        }
    }

    public final void r(y yVar) {
        if (yVar != null) {
            if (yVar.equals(this.f1046c.i(yVar.A))) {
                yVar.N.getClass();
                boolean zN = N(yVar);
                Boolean bool = yVar.F;
                if (bool == null || bool.booleanValue() != zN) {
                    yVar.F = Boolean.valueOf(zN);
                    yVar.C(zN);
                    r0 r0Var = yVar.P;
                    r0Var.h0();
                    r0Var.r(r0Var.f1065x);
                }
            }
        }
    }

    public final void s(boolean z10) {
        if (z10 && this.f1062u != null) {
            g0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (y yVar : this.f1046c.o()) {
            if (yVar != null && z10) {
                yVar.P.s(true);
            }
        }
    }

    public final boolean t() {
        if (this.f1061t < 1) {
            return false;
        }
        boolean z10 = false;
        for (y yVar : this.f1046c.o()) {
            if (yVar != null && M(yVar)) {
                if (!yVar.U ? yVar.P.t() : false) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        y yVar = this.f1064w;
        if (yVar != null) {
            sb.append(yVar.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f1064w)));
            sb.append("}");
        } else {
            c0 c0Var = this.f1062u;
            if (c0Var != null) {
                sb.append(c0Var.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f1062u)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(int i) {
        try {
            this.f1045b = true;
            for (z0 z0Var : ((HashMap) this.f1046c.f9070b).values()) {
                if (z0Var != null) {
                    z0Var.f1131e = i;
                }
            }
            P(i, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((l) it.next()).e();
            }
            this.f1045b = false;
            A(true);
        } catch (Throwable th) {
            this.f1045b = false;
            throw th;
        }
    }

    public final void v() {
        if (this.I) {
            this.I = false;
            f0();
        }
    }

    public final void w(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2;
        String strJ = l0.e.j(str, "    ");
        nc.p pVar = this.f1046c;
        ArrayList arrayList = (ArrayList) pVar.f9069a;
        String strJ2 = l0.e.j(str, "    ");
        HashMap map = (HashMap) pVar.f9070b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (z0 z0Var : map.values()) {
                printWriter.print(str);
                if (z0Var != null) {
                    y yVar = z0Var.f1129c;
                    printWriter.println(yVar);
                    yVar.getClass();
                    printWriter.print(strJ2);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(yVar.R));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(yVar.S));
                    printWriter.print(" mTag=");
                    printWriter.println(yVar.T);
                    printWriter.print(strJ2);
                    printWriter.print("mState=");
                    printWriter.print(yVar.f1118v);
                    printWriter.print(" mWho=");
                    printWriter.print(yVar.A);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(yVar.M);
                    printWriter.print(strJ2);
                    printWriter.print("mAdded=");
                    printWriter.print(yVar.G);
                    printWriter.print(" mRemoving=");
                    printWriter.print(yVar.H);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(yVar.I);
                    printWriter.print(" mInLayout=");
                    printWriter.println(yVar.J);
                    printWriter.print(strJ2);
                    printWriter.print("mHidden=");
                    printWriter.print(yVar.U);
                    printWriter.print(" mDetached=");
                    printWriter.print(yVar.V);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(yVar.Y);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(strJ2);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(yVar.W);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(yVar.f1105d0);
                    if (yVar.N != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(yVar.N);
                    }
                    if (yVar.O != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mHost=");
                        printWriter.println(yVar.O);
                    }
                    if (yVar.Q != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mParentFragment=");
                        printWriter.println(yVar.Q);
                    }
                    if (yVar.B != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mArguments=");
                        printWriter.println(yVar.B);
                    }
                    if (yVar.f1119w != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(yVar.f1119w);
                    }
                    if (yVar.f1120x != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(yVar.f1120x);
                    }
                    if (yVar.f1121y != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(yVar.f1121y);
                    }
                    Object objI = yVar.C;
                    if (objI == null) {
                        r0 r0Var = yVar.N;
                        objI = (r0Var == null || (str2 = yVar.D) == null) ? null : r0Var.f1046c.i(str2);
                    }
                    if (objI != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mTarget=");
                        printWriter.print(objI);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(yVar.E);
                    }
                    printWriter.print(strJ2);
                    printWriter.print("mPopDirection=");
                    w wVar = yVar.f1106e0;
                    printWriter.println(wVar == null ? false : wVar.f1087a);
                    w wVar2 = yVar.f1106e0;
                    if ((wVar2 == null ? 0 : wVar2.f1088b) != 0) {
                        printWriter.print(strJ2);
                        printWriter.print("getEnterAnim=");
                        w wVar3 = yVar.f1106e0;
                        printWriter.println(wVar3 == null ? 0 : wVar3.f1088b);
                    }
                    w wVar4 = yVar.f1106e0;
                    if ((wVar4 == null ? 0 : wVar4.f1089c) != 0) {
                        printWriter.print(strJ2);
                        printWriter.print("getExitAnim=");
                        w wVar5 = yVar.f1106e0;
                        printWriter.println(wVar5 == null ? 0 : wVar5.f1089c);
                    }
                    w wVar6 = yVar.f1106e0;
                    if ((wVar6 == null ? 0 : wVar6.f1090d) != 0) {
                        printWriter.print(strJ2);
                        printWriter.print("getPopEnterAnim=");
                        w wVar7 = yVar.f1106e0;
                        printWriter.println(wVar7 == null ? 0 : wVar7.f1090d);
                    }
                    w wVar8 = yVar.f1106e0;
                    if ((wVar8 == null ? 0 : wVar8.f1091e) != 0) {
                        printWriter.print(strJ2);
                        printWriter.print("getPopExitAnim=");
                        w wVar9 = yVar.f1106e0;
                        printWriter.println(wVar9 == null ? 0 : wVar9.f1091e);
                    }
                    if (yVar.f1102a0 != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mContainer=");
                        printWriter.println(yVar.f1102a0);
                    }
                    if (yVar.f1103b0 != null) {
                        printWriter.print(strJ2);
                        printWriter.print("mView=");
                        printWriter.println(yVar.f1103b0);
                    }
                    if (yVar.j() != null) {
                        v.l lVar = ((u1.a) new androidx.emoji2.text.v(yVar.e(), u1.a.f12065e).r(u1.a.class)).f12066d;
                        if (lVar.e() > 0) {
                            printWriter.print(strJ2);
                            printWriter.println("Loaders:");
                            if (lVar.e() > 0) {
                                if (lVar.f(0) != null) {
                                    throw new ClassCastException();
                                }
                                printWriter.print(strJ2);
                                printWriter.print("  #");
                                if (lVar.f12543v) {
                                    v.i.a(lVar);
                                }
                                printWriter.print(lVar.f12544w[0]);
                                printWriter.print(": ");
                                throw null;
                            }
                        }
                    }
                    printWriter.print(strJ2);
                    printWriter.println("Child " + yVar.P + ":");
                    yVar.P.w(l0.e.j(strJ2, "  "), fileDescriptor, printWriter, strArr);
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
                y yVar2 = (y) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(yVar2.toString());
            }
        }
        ArrayList arrayList2 = this.f1048e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                y yVar3 = (y) this.f1048e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(yVar3.toString());
            }
        }
        ArrayList arrayList3 = this.f1047d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = (a) this.f1047d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.g(strJ, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.f1044a) {
            try {
                int size4 = this.f1044a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size4; i12++) {
                        Object obj = (p0) this.f1044a.get(i12);
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
        printWriter.println(this.f1062u);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1063v);
        if (this.f1064w != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1064w);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1061t);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.F);
        printWriter.print(" mStopped=");
        printWriter.print(this.G);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.H);
        if (this.E) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.E);
        }
    }

    public final void x() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((l) it.next()).e();
        }
    }

    public final void y(p0 p0Var, boolean z10) {
        if (!z10) {
            if (this.f1062u == null) {
                if (!this.H) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (O()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f1044a) {
            try {
                if (this.f1062u == null) {
                    if (!z10) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f1044a.add(p0Var);
                    Y();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(boolean z10) {
        if (this.f1045b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1062u == null) {
            if (!this.H) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f1062u.f953y.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10 && O()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.J == null) {
            this.J = new ArrayList();
            this.K = new ArrayList();
        }
    }
}
