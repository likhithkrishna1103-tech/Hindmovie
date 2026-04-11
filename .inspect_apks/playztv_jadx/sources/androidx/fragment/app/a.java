package androidx.fragment.app;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1229e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1231h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f1233k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1234l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f1235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f1236n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f1237o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1238p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final n0 f1239q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1240r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1241s;

    public a(n0 n0Var) {
        n0Var.D();
        z zVar = n0Var.f1327t;
        if (zVar != null) {
            zVar.f1423v.getClassLoader();
        }
        this.f1225a = new ArrayList();
        this.f1231h = true;
        this.f1238p = false;
        this.f1241s = -1;
        this.f1239q = n0Var;
    }

    @Override // androidx.fragment.app.l0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (n0.G(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1230g) {
            return true;
        }
        n0 n0Var = this.f1239q;
        if (n0Var.f1313d == null) {
            n0Var.f1313d = new ArrayList();
        }
        n0Var.f1313d.add(this);
        return true;
    }

    public final void b(v0 v0Var) {
        this.f1225a.add(v0Var);
        v0Var.f1402d = this.f1226b;
        v0Var.f1403e = this.f1227c;
        v0Var.f = this.f1228d;
        v0Var.f1404g = this.f1229e;
    }

    public final void c(int i) {
        if (this.f1230g) {
            if (n0.G(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            ArrayList arrayList = this.f1225a;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                v0 v0Var = (v0) arrayList.get(i10);
                v vVar = v0Var.f1400b;
                if (vVar != null) {
                    vVar.L += i;
                    if (n0.G(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + v0Var.f1400b + " to " + v0Var.f1400b.L);
                    }
                }
            }
        }
    }

    public final int d(boolean z2) {
        if (this.f1240r) {
            throw new IllegalStateException("commit already called");
        }
        if (n0.G(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new x0());
            f("  ", printWriter, true);
            printWriter.close();
        }
        this.f1240r = true;
        boolean z10 = this.f1230g;
        n0 n0Var = this.f1239q;
        if (z10) {
            this.f1241s = n0Var.i.getAndIncrement();
        } else {
            this.f1241s = -1;
        }
        n0Var.v(this, z2);
        return this.f1241s;
    }

    public final void e(int i, v vVar, String str, int i10) {
        String str2 = vVar.f1384g0;
        if (str2 != null) {
            j1.c.c(vVar, str2);
        }
        Class<?> cls = vVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = vVar.S;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + vVar + ": was " + vVar.S + " now " + str);
            }
            vVar.S = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + vVar + " with tag " + str + " to container view with no id");
            }
            int i11 = vVar.Q;
            if (i11 != 0 && i11 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + vVar + ": was " + vVar.Q + " now " + i);
            }
            vVar.Q = i;
            vVar.R = i;
        }
        b(new v0(i10, vVar));
        vVar.M = this.f1239q;
    }

    public final void f(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1241s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1240r);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.f1226b != 0 || this.f1227c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1226b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1227c));
            }
            if (this.f1228d != 0 || this.f1229e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1228d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1229e));
            }
            if (this.f1232j != 0 || this.f1233k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1232j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1233k);
            }
            if (this.f1234l != 0 || this.f1235m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1234l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1235m);
            }
        }
        ArrayList arrayList = this.f1225a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            v0 v0Var = (v0) arrayList.get(i);
            switch (v0Var.f1399a) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    str2 = "HIDE";
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    str2 = "SHOW";
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    str2 = "DETACH";
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + v0Var.f1399a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(v0Var.f1400b);
            if (z2) {
                if (v0Var.f1402d != 0 || v0Var.f1403e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(v0Var.f1402d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(v0Var.f1403e));
                }
                if (v0Var.f != 0 || v0Var.f1404g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(v0Var.f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(v0Var.f1404g));
                }
            }
        }
    }

    public final void g(v vVar) {
        n0 n0Var = vVar.M;
        if (n0Var == null || n0Var == this.f1239q) {
            b(new v0(3, vVar));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + vVar.toString() + " is already attached to a FragmentManager.");
    }

    public final void h(v vVar, androidx.lifecycle.n nVar) {
        n0 n0Var = vVar.M;
        n0 n0Var2 = this.f1239q;
        if (n0Var != n0Var2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + n0Var2);
        }
        if (nVar == androidx.lifecycle.n.f1483v && vVar.f1393u > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + nVar + " after the Fragment has been created");
        }
        if (nVar == androidx.lifecycle.n.f1482u) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + nVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        v0 v0Var = new v0();
        v0Var.f1399a = 10;
        v0Var.f1400b = vVar;
        v0Var.f1401c = false;
        v0Var.f1405h = vVar.f1385h0;
        v0Var.i = nVar;
        b(v0Var);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1241s >= 0) {
            sb2.append(" #");
            sb2.append(this.f1241s);
        }
        if (this.i != null) {
            sb2.append(" ");
            sb2.append(this.i);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
