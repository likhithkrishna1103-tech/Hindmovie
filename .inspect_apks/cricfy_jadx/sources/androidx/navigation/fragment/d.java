package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.k0;
import androidx.fragment.app.q0;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;
import androidx.navigation.a0;
import androidx.navigation.l;
import androidx.navigation.r;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f1341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f1343d = new ArrayDeque();

    public d(Context context, r0 r0Var, int i) {
        this.f1340a = context;
        this.f1341b = r0Var;
        this.f1342c = i;
    }

    public static String f(int i, int i10) {
        return i + "-" + i10;
    }

    @Override // androidx.navigation.a0
    public final l a() {
        return new c(this);
    }

    @Override // androidx.navigation.a0
    public final l b(l lVar, Bundle bundle, r rVar) {
        c cVar = (c) lVar;
        r0 r0Var = this.f1341b;
        if (r0Var.O()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String str = cVar.D;
        if (str == null) {
            throw new IllegalStateException("Fragment class was not set");
        }
        char cCharAt = str.charAt(0);
        Context context = this.f1340a;
        if (cCharAt == '.') {
            str = context.getPackageName() + str;
        }
        k0 k0VarG = r0Var.G();
        context.getClassLoader();
        y yVarA = k0VarG.a(str);
        yVarA.N(bundle);
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(r0Var);
        int i = rVar != null ? 0 : -1;
        int i10 = rVar != null ? 0 : -1;
        if (i != -1 || i10 != -1) {
            if (i == -1) {
                i = 0;
            }
            if (i10 == -1) {
                i10 = 0;
            }
            aVar.f912b = i;
            aVar.f913c = i10;
            aVar.f914d = 0;
            aVar.f915e = 0;
        }
        int i11 = this.f1342c;
        if (i11 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        aVar.f(i11, yVarA, null, 2);
        aVar.j(yVarA);
        int i12 = cVar.f1371x;
        ArrayDeque arrayDeque = this.f1343d;
        if (!arrayDeque.isEmpty()) {
            aVar.c(f(arrayDeque.size() + 1, i12));
        }
        aVar.f924p = true;
        aVar.e(false);
        arrayDeque.add(Integer.valueOf(i12));
        return cVar;
    }

    @Override // androidx.navigation.a0
    public final void c(Bundle bundle) {
        int[] intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds");
        if (intArray != null) {
            ArrayDeque arrayDeque = this.f1343d;
            arrayDeque.clear();
            for (int i : intArray) {
                arrayDeque.add(Integer.valueOf(i));
            }
        }
    }

    @Override // androidx.navigation.a0
    public final Bundle d() {
        Bundle bundle = new Bundle();
        ArrayDeque arrayDeque = this.f1343d;
        int[] iArr = new int[arrayDeque.size()];
        Iterator it = arrayDeque.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    @Override // androidx.navigation.a0
    public final boolean e() {
        ArrayDeque arrayDeque = this.f1343d;
        if (arrayDeque.isEmpty()) {
            return false;
        }
        r0 r0Var = this.f1341b;
        if (r0Var.O()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        r0Var.y(new q0(r0Var, f(arrayDeque.size(), ((Integer) arrayDeque.peekLast()).intValue()), -1), false);
        arrayDeque.removeLast();
        return true;
    }
}
