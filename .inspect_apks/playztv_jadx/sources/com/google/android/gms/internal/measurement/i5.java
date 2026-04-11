package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i5 implements Cloneable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j5 f3051u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public j5 f3052v;

    public i5(j5 j5Var) {
        this.f3051u = j5Var;
        if (j5Var.m()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f3052v = (j5) j5Var.e(4);
    }

    public static void b(int i, List list) {
        String strJ = e6.j.j(list.size() - i, "Element at index ", " is null.");
        for (int size = list.size() - 1; size >= i; size--) {
            list.remove(size);
        }
        throw new NullPointerException(strJ);
    }

    public final i5 a(j5 j5Var) {
        j5 j5Var2 = this.f3051u;
        if (j5Var2.equals(j5Var)) {
            return this;
        }
        if (!this.f3052v.m()) {
            j5 j5Var3 = (j5) j5Var2.e(4);
            j5 j5Var4 = this.f3052v;
            h6 h6Var = h6.f3037c;
            h6Var.getClass();
            h6Var.a(j5Var3.getClass()).f(j5Var3, j5Var4);
            this.f3052v = j5Var3;
        }
        j5 j5Var5 = this.f3052v;
        h6 h6Var2 = h6.f3037c;
        h6Var2.getClass();
        h6Var2.a(j5Var5.getClass()).f(j5Var5, j5Var);
        return this;
    }

    public final j5 c() {
        j5 j5VarD = d();
        if (j5.h(j5VarD, true)) {
            return j5VarD;
        }
        throw new a2.y0("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final /* synthetic */ Object clone() {
        i5 i5Var = (i5) this.f3051u.e(5);
        i5Var.f3052v = d();
        return i5Var;
    }

    public final j5 d() {
        if (!this.f3052v.m()) {
            return this.f3052v;
        }
        j5 j5Var = this.f3052v;
        j5Var.getClass();
        h6 h6Var = h6.f3037c;
        h6Var.getClass();
        h6Var.a(j5Var.getClass()).d(j5Var);
        j5Var.l();
        return this.f3052v;
    }

    public final void e() {
        if (this.f3052v.m()) {
            return;
        }
        j5 j5Var = (j5) this.f3051u.e(4);
        j5 j5Var2 = this.f3052v;
        h6 h6Var = h6.f3037c;
        h6Var.getClass();
        h6Var.a(j5Var.getClass()).f(j5Var, j5Var2);
        this.f3052v = j5Var;
    }

    public final void f(byte[] bArr, int i, d5 d5Var) throws r5 {
        if (!this.f3052v.m()) {
            j5 j5Var = (j5) this.f3051u.e(4);
            j5 j5Var2 = this.f3052v;
            h6 h6Var = h6.f3037c;
            h6Var.getClass();
            h6Var.a(j5Var.getClass()).f(j5Var, j5Var2);
            this.f3052v = j5Var;
        }
        try {
            h6 h6Var2 = h6.f3037c;
            j5 j5Var3 = this.f3052v;
            h6Var2.getClass();
            j6 j6VarA = h6Var2.a(j5Var3.getClass());
            j5 j5Var4 = this.f3052v;
            y4 y4Var = new y4();
            d5Var.getClass();
            j6VarA.h(j5Var4, bArr, 0, i, y4Var);
        } catch (r5 e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
        } catch (IndexOutOfBoundsException unused) {
            throw r5.d();
        }
    }
}
