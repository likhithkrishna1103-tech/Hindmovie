package androidx.fragment.app;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f915e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f917h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f921m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f922n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f923o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f924p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final r0 f925q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f926r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f927s;

    public a(r0 r0Var) {
        r0Var.G();
        c0 c0Var = r0Var.f1062u;
        if (c0Var != null) {
            c0Var.f952x.getClassLoader();
        }
        this.f911a = new ArrayList();
        this.f917h = true;
        this.f924p = false;
        this.f927s = -1;
        this.f925q = r0Var;
    }

    @Override // androidx.fragment.app.p0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (r0.J(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f916g) {
            return true;
        }
        r0 r0Var = this.f925q;
        if (r0Var.f1047d == null) {
            r0Var.f1047d = new ArrayList();
        }
        r0Var.f1047d.add(this);
        return true;
    }

    public final void b(a1 a1Var) {
        this.f911a.add(a1Var);
        a1Var.f933d = this.f912b;
        a1Var.f934e = this.f913c;
        a1Var.f = this.f914d;
        a1Var.f935g = this.f915e;
    }

    public final void c(String str) {
        if (!this.f917h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f916g = true;
        this.i = str;
    }

    public final void d(int i) {
        if (this.f916g) {
            if (r0.J(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            ArrayList arrayList = this.f911a;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                a1 a1Var = (a1) arrayList.get(i10);
                y yVar = a1Var.f931b;
                if (yVar != null) {
                    yVar.M += i;
                    if (r0.J(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + a1Var.f931b + " to " + a1Var.f931b.M);
                    }
                }
            }
        }
    }

    public final int e(boolean z10) {
        if (this.f926r) {
            throw new IllegalStateException("commit already called");
        }
        if (r0.J(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new c1());
            g("  ", printWriter, true);
            printWriter.close();
        }
        this.f926r = true;
        boolean z11 = this.f916g;
        r0 r0Var = this.f925q;
        if (z11) {
            this.f927s = r0Var.i.getAndIncrement();
        } else {
            this.f927s = -1;
        }
        r0Var.y(this, z10);
        return this.f927s;
    }

    public final void f(int i, y yVar, String str, int i10) {
        String str2 = yVar.f1109h0;
        if (str2 != null) {
            p1.c.c(yVar, str2);
        }
        Class<?> cls = yVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = yVar.T;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + yVar + ": was " + yVar.T + " now " + str);
            }
            yVar.T = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + yVar + " with tag " + str + " to container view with no id");
            }
            int i11 = yVar.R;
            if (i11 != 0 && i11 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + yVar + ": was " + yVar.R + " now " + i);
            }
            yVar.R = i;
            yVar.S = i;
        }
        b(new a1(i10, yVar));
        yVar.N = this.f925q;
    }

    public final void g(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f927s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f926r);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.f912b != 0 || this.f913c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f912b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f913c));
            }
            if (this.f914d != 0 || this.f915e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f914d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f915e));
            }
            if (this.f918j != 0 || this.f919k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f918j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f919k);
            }
            if (this.f920l != 0 || this.f921m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f920l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f921m);
            }
        }
        ArrayList arrayList = this.f911a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a1 a1Var = (a1) arrayList.get(i);
            switch (a1Var.f930a) {
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
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    str2 = "HIDE";
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    str2 = "SHOW";
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    str2 = "DETACH";
                    break;
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                    str2 = "ATTACH";
                    break;
                case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + a1Var.f930a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(a1Var.f931b);
            if (z10) {
                if (a1Var.f933d != 0 || a1Var.f934e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(a1Var.f933d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(a1Var.f934e));
                }
                if (a1Var.f != 0 || a1Var.f935g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(a1Var.f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(a1Var.f935g));
                }
            }
        }
    }

    public final void h(y yVar) {
        r0 r0Var = yVar.N;
        if (r0Var == null || r0Var == this.f925q) {
            b(new a1(3, yVar));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + yVar.toString() + " is already attached to a FragmentManager.");
    }

    public final void i(y yVar, androidx.lifecycle.n nVar) {
        r0 r0Var = yVar.N;
        r0 r0Var2 = this.f925q;
        if (r0Var != r0Var2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + r0Var2);
        }
        if (nVar == androidx.lifecycle.n.f1180w && yVar.f1118v > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + nVar + " after the Fragment has been created");
        }
        if (nVar == androidx.lifecycle.n.f1179v) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + nVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        a1 a1Var = new a1();
        a1Var.f930a = 10;
        a1Var.f931b = yVar;
        a1Var.f932c = false;
        a1Var.f936h = yVar.f1110i0;
        a1Var.i = nVar;
        b(a1Var);
    }

    public final void j(y yVar) {
        r0 r0Var = yVar.N;
        if (r0Var == null || r0Var == this.f925q) {
            b(new a1(8, yVar));
            return;
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + yVar.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f927s >= 0) {
            sb.append(" #");
            sb.append(this.f927s);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }
}
