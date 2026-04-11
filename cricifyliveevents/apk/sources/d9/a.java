package d9;

import android.os.Bundle;
import android.os.SystemClock;
import f9.f3;
import f9.j3;
import f9.n2;
import f9.p1;
import f9.r1;
import f9.s4;
import f9.u4;
import f9.w0;
import f9.x2;
import f9.y;
import f9.z1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import o8.u;
import v.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1 f3558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x2 f3559b;

    public a(r1 r1Var) {
        u.g(r1Var);
        this.f3558a = r1Var;
        x2 x2Var = r1Var.H;
        r1.f(x2Var);
        this.f3559b = x2Var;
    }

    @Override // f9.y2
    public final long a() {
        u4 u4Var = this.f3558a.D;
        r1.e(u4Var);
        return u4Var.j2();
    }

    @Override // f9.y2
    public final void b(String str, String str2, Bundle bundle) {
        x2 x2Var = this.f3558a.H;
        r1.f(x2Var);
        x2Var.A1(str, str2, bundle);
    }

    @Override // f9.y2
    public final String c() {
        j3 j3Var = ((r1) this.f3559b.f307w).G;
        r1.f(j3Var);
        f3 f3Var = j3Var.f4242y;
        if (f3Var != null) {
            return f3Var.f4175a;
        }
        return null;
    }

    @Override // f9.y2
    public final String d() {
        j3 j3Var = ((r1) this.f3559b.f307w).G;
        r1.f(j3Var);
        f3 f3Var = j3Var.f4242y;
        if (f3Var != null) {
            return f3Var.f4176b;
        }
        return null;
    }

    @Override // f9.y2
    public final List e(String str, String str2) {
        x2 x2Var = this.f3559b;
        r1 r1Var = (r1) x2Var.f307w;
        p1 p1Var = r1Var.B;
        w0 w0Var = r1Var.A;
        r1.g(p1Var);
        if (p1Var.s1()) {
            r1.g(w0Var);
            w0Var.B.a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (jb.b.i()) {
            r1.g(w0Var);
            w0Var.B.a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        p1 p1Var2 = r1Var.B;
        r1.g(p1Var2);
        p1Var2.w1(atomicReference, 5000L, "get conditional user properties", new z1(x2Var, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return u4.c2(list);
        }
        r1.g(w0Var);
        w0Var.B.b(null, "Timed out waiting for get conditional user properties");
        return new ArrayList();
    }

    @Override // f9.y2
    public final void f(Bundle bundle) {
        x2 x2Var = this.f3559b;
        ((r1) x2Var.f307w).F.getClass();
        x2Var.z1(bundle, System.currentTimeMillis());
    }

    @Override // f9.y2
    public final int g(String str) {
        x2 x2Var = this.f3559b;
        x2Var.getClass();
        u.d(str);
        ((r1) x2Var.f307w).getClass();
        return 25;
    }

    @Override // f9.y2
    public final String h() {
        return (String) this.f3559b.C.get();
    }

    @Override // f9.y2
    public final void i(String str) {
        r1 r1Var = this.f3558a;
        y yVar = r1Var.I;
        r1.d(yVar);
        r1Var.F.getClass();
        yVar.o1(str, SystemClock.elapsedRealtime());
    }

    @Override // f9.y2
    public final String j() {
        return this.f3559b.B1();
    }

    @Override // f9.y2
    public final void k(String str, String str2, Bundle bundle) {
        x2 x2Var = this.f3559b;
        ((r1) x2Var.f307w).F.getClass();
        x2Var.r1(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    @Override // f9.y2
    public final Map l(String str, String str2, boolean z10) {
        x2 x2Var = this.f3559b;
        r1 r1Var = (r1) x2Var.f307w;
        p1 p1Var = r1Var.B;
        w0 w0Var = r1Var.A;
        r1.g(p1Var);
        if (p1Var.s1()) {
            r1.g(w0Var);
            w0Var.B.a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if (jb.b.i()) {
            r1.g(w0Var);
            w0Var.B.a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        p1 p1Var2 = r1Var.B;
        r1.g(p1Var2);
        p1Var2.w1(atomicReference, 5000L, "get user properties", new n2(x2Var, atomicReference, str, str2, z10));
        List<s4> list = (List) atomicReference.get();
        if (list == null) {
            r1.g(w0Var);
            w0Var.B.b(Boolean.valueOf(z10), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.EMPTY_MAP;
        }
        e eVar = new e(list.size());
        for (s4 s4Var : list) {
            Object objA = s4Var.a();
            if (objA != null) {
                eVar.put(s4Var.f4404w, objA);
            }
        }
        return eVar;
    }

    @Override // f9.y2
    public final void m(String str) {
        r1 r1Var = this.f3558a;
        y yVar = r1Var.I;
        r1.d(yVar);
        r1Var.F.getClass();
        yVar.n1(str, SystemClock.elapsedRealtime());
    }
}
