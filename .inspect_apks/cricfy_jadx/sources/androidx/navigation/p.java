package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.fragment.app.i0;
import androidx.lifecycle.t0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f1379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f1380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f1381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f1382e;
    public Parcelable[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1383g;
    public androidx.navigation.fragment.e i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f1385j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayDeque f1384h = new ArrayDeque();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b0 f1386k = new b0();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArrayList f1387l = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final androidx.lifecycle.r f1388m = new androidx.lifecycle.q() { // from class: androidx.navigation.NavController$1
        @Override // androidx.lifecycle.q
        public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.m mVar) {
            androidx.lifecycle.n nVar;
            p pVar = this.f1320v;
            if (pVar.f1381d != null) {
                for (f fVar : pVar.f1384h) {
                    fVar.getClass();
                    switch (e.f1329a[mVar.ordinal()]) {
                        case 1:
                        case 2:
                            nVar = androidx.lifecycle.n.f1181x;
                            break;
                        case 3:
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            nVar = androidx.lifecycle.n.f1182y;
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            nVar = androidx.lifecycle.n.f1183z;
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            nVar = androidx.lifecycle.n.f1179v;
                            break;
                        default:
                            throw new IllegalArgumentException("Unexpected event value " + mVar);
                    }
                    fVar.B = nVar;
                    fVar.b();
                }
            }
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i0 f1389n = new i0(1, this);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1390o = true;

    public p(Context context) {
        this.f1378a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                this.f1379b = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        b0 b0Var = this.f1386k;
        b0Var.a(new o(b0Var));
        b0 b0Var2 = this.f1386k;
        Context baseContext = this.f1378a;
        b bVar = new b();
        bVar.f1321a = baseContext;
        while (true) {
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
            if (baseContext instanceof Activity) {
                bVar.f1322b = (Activity) baseContext;
                break;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
        }
        b0Var2.a(bVar);
    }

    public final boolean a() {
        ArrayDeque<f> arrayDeque;
        l lVar;
        do {
            arrayDeque = this.f1384h;
            if (arrayDeque.isEmpty() || !(((f) arrayDeque.peekLast()).f1331w instanceof n)) {
                break;
            }
        } while (f(((f) arrayDeque.peekLast()).f1331w.f1371x, true));
        if (arrayDeque.isEmpty()) {
            return false;
        }
        l lVar2 = ((f) arrayDeque.peekLast()).f1331w;
        if (lVar2 instanceof c) {
            Iterator itDescendingIterator = arrayDeque.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                lVar = ((f) itDescendingIterator.next()).f1331w;
                if (!(lVar instanceof n) && !(lVar instanceof c)) {
                    break;
                }
            }
            lVar = null;
        } else {
            lVar = null;
        }
        HashMap map = new HashMap();
        Iterator itDescendingIterator2 = arrayDeque.descendingIterator();
        while (itDescendingIterator2.hasNext()) {
            f fVar = (f) itDescendingIterator2.next();
            androidx.lifecycle.n nVar = fVar.C;
            l lVar3 = fVar.f1331w;
            androidx.lifecycle.n nVar2 = androidx.lifecycle.n.f1183z;
            if (lVar2 != null && lVar3.f1371x == lVar2.f1371x) {
                if (nVar != nVar2) {
                    map.put(fVar, nVar2);
                }
                lVar2 = lVar2.f1370w;
            } else if (lVar == null || lVar3.f1371x != lVar.f1371x) {
                fVar.C = androidx.lifecycle.n.f1181x;
                fVar.b();
            } else {
                androidx.lifecycle.n nVar3 = androidx.lifecycle.n.f1182y;
                if (nVar == nVar2) {
                    fVar.C = nVar3;
                    fVar.b();
                } else if (nVar != nVar3) {
                    map.put(fVar, nVar3);
                }
                lVar = lVar.f1370w;
            }
        }
        for (f fVar2 : arrayDeque) {
            androidx.lifecycle.n nVar4 = (androidx.lifecycle.n) map.get(fVar2);
            if (nVar4 != null) {
                fVar2.C = nVar4;
                fVar2.b();
            } else {
                fVar2.b();
            }
        }
        f fVar3 = (f) arrayDeque.peekLast();
        Iterator it = this.f1387l.iterator();
        if (!it.hasNext()) {
            return true;
        }
        if (it.next() != null) {
            throw new ClassCastException();
        }
        l lVar4 = fVar3.f1331w;
        throw null;
    }

    public final l b(int i) {
        n nVar = this.f1381d;
        if (nVar == null) {
            return null;
        }
        if (nVar.f1371x == i) {
            return nVar;
        }
        ArrayDeque arrayDeque = this.f1384h;
        l lVar = arrayDeque.isEmpty() ? this.f1381d : ((f) arrayDeque.getLast()).f1331w;
        return (lVar instanceof n ? (n) lVar : lVar.f1370w).g(i, true);
    }

    public final l c() {
        ArrayDeque arrayDeque = this.f1384h;
        f fVar = arrayDeque.isEmpty() ? null : (f) arrayDeque.getLast();
        if (fVar != null) {
            return fVar.f1331w;
        }
        return null;
    }

    public final void d(l lVar, Bundle bundle, r rVar) {
        int i;
        boolean zF = (rVar == null || (i = rVar.f1394a) == -1) ? false : f(i, rVar.f1395b);
        a0 a0VarC = this.f1386k.c(lVar.f1369v);
        Bundle bundleA = lVar.a(bundle);
        l lVarB = a0VarC.b(lVar, bundleA, rVar);
        if (lVarB != null) {
            boolean z10 = lVarB instanceof c;
            ArrayDeque arrayDeque = this.f1384h;
            if (!z10) {
                while (!arrayDeque.isEmpty() && (((f) arrayDeque.peekLast()).f1331w instanceof c) && f(((f) arrayDeque.peekLast()).f1331w.f1371x, true)) {
                }
            }
            ArrayDeque arrayDeque2 = new ArrayDeque();
            if (lVar instanceof n) {
                l lVar2 = lVarB;
                while (true) {
                    n nVar = lVar2.f1370w;
                    if (nVar != null) {
                        arrayDeque2.addFirst(new f(this.f1378a, nVar, bundleA, this.i, this.f1385j));
                        if (!arrayDeque.isEmpty() && ((f) arrayDeque.getLast()).f1331w == nVar) {
                            f(nVar.f1371x, true);
                        }
                    }
                    if (nVar == null || nVar == lVar) {
                        break;
                    } else {
                        lVar2 = nVar;
                    }
                }
            }
            l lVar3 = arrayDeque2.isEmpty() ? lVarB : ((f) arrayDeque2.getFirst()).f1331w;
            while (lVar3 != null && b(lVar3.f1371x) == null) {
                n nVar2 = lVar3.f1370w;
                if (nVar2 != null) {
                    arrayDeque2.addFirst(new f(this.f1378a, nVar2, bundleA, this.i, this.f1385j));
                }
                lVar3 = nVar2;
            }
            l lVar4 = arrayDeque2.isEmpty() ? lVarB : ((f) arrayDeque2.getLast()).f1331w;
            while (!arrayDeque.isEmpty() && (((f) arrayDeque.getLast()).f1331w instanceof n) && ((n) ((f) arrayDeque.getLast()).f1331w).g(lVar4.f1371x, false) == null && f(((f) arrayDeque.getLast()).f1331w.f1371x, true)) {
            }
            arrayDeque.addAll(arrayDeque2);
            if (arrayDeque.isEmpty() || ((f) arrayDeque.getFirst()).f1331w != this.f1381d) {
                arrayDeque.addFirst(new f(this.f1378a, this.f1381d, bundleA, this.i, this.f1385j));
            }
            arrayDeque.add(new f(this.f1378a, lVarB, lVarB.a(bundleA), this.i, this.f1385j));
        }
        h();
        if (zF || lVarB != null) {
            a();
        }
    }

    public final void e() {
        if (!this.f1384h.isEmpty() && f(c().f1371x, true)) {
            a();
        }
    }

    public final boolean f(int i, boolean z10) {
        ArrayDeque arrayDeque = this.f1384h;
        boolean z11 = false;
        if (arrayDeque.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator itDescendingIterator = arrayDeque.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            l lVar = ((f) itDescendingIterator.next()).f1331w;
            a0 a0VarC = this.f1386k.c(lVar.f1369v);
            if (z10 || lVar.f1371x != i) {
                arrayList.add(a0VarC);
            }
            if (lVar.f1371x == i) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    if (!((a0) obj).e()) {
                        break;
                    }
                    f fVar = (f) arrayDeque.removeLast();
                    if (fVar.f1333y.f1200c.compareTo(androidx.lifecycle.n.f1181x) >= 0) {
                        fVar.C = androidx.lifecycle.n.f1179v;
                        fVar.b();
                    }
                    h hVar = this.f1385j;
                    if (hVar != null) {
                        t0 t0Var = (t0) hVar.f1354d.remove(fVar.A);
                        if (t0Var != null) {
                            t0Var.a();
                        }
                    }
                    z11 = true;
                }
                h();
                return z11;
            }
        }
        Log.i("NavController", "Ignoring popBackStack to destination " + l.b(this.f1378a, i) + " as it was not found on the current back stack");
        return false;
    }

    public final void g(int i, Bundle bundle) {
        Activity activity;
        Intent intent;
        k kVarC;
        String strB;
        n nVar;
        l lVarG;
        n nVar2;
        ArrayList<String> stringArrayList;
        q qVar = this.f1380c;
        b0 b0Var = this.f1386k;
        Context context = this.f1378a;
        if (qVar == null) {
            q qVar2 = new q();
            qVar2.f1392a = context;
            qVar2.f1393b = b0Var;
            this.f1380c = qVar2;
        }
        n nVarC = this.f1380c.c(i);
        n nVar3 = this.f1381d;
        if (nVar3 != null) {
            f(nVar3.f1371x, true);
        }
        this.f1381d = nVarC;
        Bundle bundle2 = this.f1382e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            int size = stringArrayList.size();
            int i10 = 0;
            while (i10 < size) {
                String str = stringArrayList.get(i10);
                i10++;
                String str2 = str;
                a0 a0VarC = b0Var.c(str2);
                Bundle bundle3 = this.f1382e.getBundle(str2);
                if (bundle3 != null) {
                    a0VarC.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f;
        ArrayDeque arrayDeque = this.f1384h;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                g gVar = (g) parcelable;
                l lVarB = b(gVar.f1350w);
                if (lVarB == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + l.b(context, gVar.f1350w) + " cannot be found from the current destination " + c());
                }
                Bundle bundle4 = gVar.f1351x;
                if (bundle4 != null) {
                    bundle4.setClassLoader(context.getClassLoader());
                }
                arrayDeque.add(new f(this.f1378a, lVarB, bundle4, this.i, this.f1385j, gVar.f1349v, gVar.f1352y));
            }
            h();
            this.f = null;
        }
        if (this.f1381d == null || !arrayDeque.isEmpty()) {
            a();
            return;
        }
        if (!this.f1383g && (activity = this.f1379b) != null && (intent = activity.getIntent()) != null) {
            Bundle extras = intent.getExtras();
            int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
            Bundle bundle5 = new Bundle();
            Bundle bundle6 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
            if (bundle6 != null) {
                bundle5.putAll(bundle6);
            }
            if ((intArray == null || intArray.length == 0) && intent.getData() != null && (kVarC = this.f1381d.c(new androidx.emoji2.text.v(intent))) != null) {
                l lVar = kVarC.f1364v;
                ArrayDeque arrayDeque2 = new ArrayDeque();
                l lVar2 = lVar;
                while (true) {
                    n nVar4 = lVar2.f1370w;
                    if (nVar4 == null || nVar4.E != lVar2.f1371x) {
                        arrayDeque2.addFirst(lVar2);
                    }
                    if (nVar4 == null) {
                        break;
                    } else {
                        lVar2 = nVar4;
                    }
                }
                intArray = new int[arrayDeque2.size()];
                Iterator it = arrayDeque2.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    intArray[i11] = ((l) it.next()).f1371x;
                    i11++;
                }
                bundle5.putAll(lVar.a(kVarC.f1365w));
            }
            if (intArray != null && intArray.length != 0) {
                n nVar5 = this.f1381d;
                int i12 = 0;
                while (true) {
                    if (i12 >= intArray.length) {
                        strB = null;
                        break;
                    }
                    int i13 = intArray[i12];
                    if (i12 == 0) {
                        lVarG = this.f1381d;
                        if (lVarG.f1371x != i13) {
                            lVarG = null;
                        }
                    } else {
                        lVarG = nVar5.g(i13, true);
                    }
                    if (lVarG == null) {
                        strB = l.b(context, i13);
                        break;
                    }
                    if (i12 != intArray.length - 1) {
                        while (true) {
                            nVar2 = (n) lVarG;
                            if (!(nVar2.g(nVar2.E, true) instanceof n)) {
                                break;
                            } else {
                                lVarG = nVar2.g(nVar2.E, true);
                            }
                        }
                        nVar5 = nVar2;
                    }
                    i12++;
                }
                if (strB == null) {
                    bundle5.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                    int flags = intent.getFlags();
                    int i14 = 268435456 & flags;
                    if (i14 != 0 && (flags & 32768) == 0) {
                        intent.addFlags(32768);
                        h0.t tVar = new h0.t(context);
                        ComponentName component = intent.getComponent();
                        if (component == null) {
                            component = intent.resolveActivity(((Context) tVar.f5471x).getPackageManager());
                        }
                        if (component != null) {
                            tVar.a(component);
                        }
                        tVar.f5470w.add(intent);
                        tVar.b();
                        activity.finish();
                        activity.overridePendingTransition(0, 0);
                        return;
                    }
                    if (i14 != 0) {
                        if (!arrayDeque.isEmpty()) {
                            f(this.f1381d.f1371x, true);
                        }
                        int i15 = 0;
                        while (i15 < intArray.length) {
                            int i16 = i15 + 1;
                            int i17 = intArray[i15];
                            l lVarB2 = b(i17);
                            if (lVarB2 == null) {
                                throw new IllegalStateException("Deep Linking failed: destination " + l.b(context, i17) + " cannot be found from the current destination " + c());
                            }
                            r rVar = new r();
                            rVar.f1394a = -1;
                            rVar.f1395b = false;
                            d(lVarB2, bundle5, rVar);
                            i15 = i16;
                        }
                        return;
                    }
                    n nVar6 = this.f1381d;
                    int i18 = 0;
                    while (i18 < intArray.length) {
                        int i19 = intArray[i18];
                        l lVarG2 = i18 == 0 ? this.f1381d : nVar6.g(i19, true);
                        if (lVarG2 == null) {
                            throw new IllegalStateException("Deep Linking failed: destination " + l.b(context, i19) + " cannot be found in graph " + nVar6);
                        }
                        if (i18 != intArray.length - 1) {
                            while (true) {
                                nVar = (n) lVarG2;
                                if (!(nVar.g(nVar.E, true) instanceof n)) {
                                    break;
                                } else {
                                    lVarG2 = nVar.g(nVar.E, true);
                                }
                            }
                            nVar6 = nVar;
                        } else {
                            Bundle bundleA = lVarG2.a(bundle5);
                            int i20 = this.f1381d.f1371x;
                            r rVar2 = new r();
                            rVar2.f1394a = i20;
                            rVar2.f1395b = true;
                            d(lVarG2, bundleA, rVar2);
                        }
                        i18++;
                    }
                    this.f1383g = true;
                    return;
                }
                Log.i("NavController", "Could not find destination " + strB + " in the navigation graph, ignoring the deep link from " + intent);
            }
        }
        d(this.f1381d, bundle, null);
    }

    public final void h() {
        boolean z10 = false;
        if (this.f1390o) {
            Iterator it = this.f1384h.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!(((f) it.next()).f1331w instanceof n)) {
                    i++;
                }
            }
            if (i > 1) {
                z10 = true;
            }
        }
        this.f1389n.c(z10);
    }
}
