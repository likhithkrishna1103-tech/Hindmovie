package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.k0;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;
import androidx.lifecycle.q;
import androidx.navigation.a0;
import androidx.navigation.l;
import androidx.navigation.r;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f1336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1337c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f1338d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f1339e = new DialogFragmentNavigator$1();

    public b(Context context, r0 r0Var) {
        this.f1335a = context;
        this.f1336b = r0Var;
    }

    @Override // androidx.navigation.a0
    public final l a() {
        return new a(this);
    }

    @Override // androidx.navigation.a0
    public final l b(l lVar, Bundle bundle, r rVar) {
        a aVar = (a) lVar;
        r0 r0Var = this.f1336b;
        if (r0Var.O()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String str = aVar.D;
        if (str == null) {
            throw new IllegalStateException("DialogFragment class was not set");
        }
        char cCharAt = str.charAt(0);
        Context context = this.f1335a;
        if (cCharAt == '.') {
            str = context.getPackageName() + str;
        }
        k0 k0VarG = r0Var.G();
        context.getClassLoader();
        y yVarA = k0VarG.a(str);
        if (!androidx.fragment.app.q.class.isAssignableFrom(yVarA.getClass())) {
            StringBuilder sb = new StringBuilder("Dialog destination ");
            String str2 = aVar.D;
            if (str2 != null) {
                throw new IllegalArgumentException(q4.a.q(sb, str2, " is not an instance of DialogFragment"));
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }
        androidx.fragment.app.q qVar = (androidx.fragment.app.q) yVarA;
        qVar.N(bundle);
        qVar.f1111j0.a(this.f1339e);
        StringBuilder sb2 = new StringBuilder("androidx-nav-fragment:navigator:dialog:");
        int i = this.f1337c;
        this.f1337c = i + 1;
        sb2.append(i);
        qVar.U(r0Var, sb2.toString());
        return aVar;
    }

    @Override // androidx.navigation.a0
    public final void c(Bundle bundle) {
        this.f1337c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
        for (int i = 0; i < this.f1337c; i++) {
            androidx.fragment.app.q qVar = (androidx.fragment.app.q) this.f1336b.E("androidx-nav-fragment:navigator:dialog:" + i);
            if (qVar != null) {
                qVar.f1111j0.a(this.f1339e);
            } else {
                this.f1338d.add("androidx-nav-fragment:navigator:dialog:" + i);
            }
        }
    }

    @Override // androidx.navigation.a0
    public final Bundle d() {
        if (this.f1337c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.f1337c);
        return bundle;
    }

    @Override // androidx.navigation.a0
    public final boolean e() {
        if (this.f1337c == 0) {
            return false;
        }
        r0 r0Var = this.f1336b;
        if (r0Var.O()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        StringBuilder sb = new StringBuilder("androidx-nav-fragment:navigator:dialog:");
        int i = this.f1337c - 1;
        this.f1337c = i;
        sb.append(i);
        y yVarE = r0Var.E(sb.toString());
        if (yVarE != null) {
            yVarE.f1111j0.f(this.f1339e);
            ((androidx.fragment.app.q) yVarE).R(false, false);
        }
        return true;
    }
}
