package com.google.android.material.datepicker;

import android.view.View;
import java.util.NoSuchElementException;
import t0.p1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements t0.o, u3.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2875v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2876w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2877x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2878y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f2879z;

    @Override // u3.c
    public int a() {
        return -1;
    }

    @Override // u3.c
    public int b() {
        return this.f2875v;
    }

    @Override // u3.c
    public int c() {
        y1.t tVar = (y1.t) this.f2879z;
        int i = this.f2876w;
        if (i == 8) {
            return tVar.x();
        }
        if (i == 16) {
            return tVar.D();
        }
        int i10 = this.f2877x;
        this.f2877x = i10 + 1;
        if (i10 % 2 != 0) {
            return this.f2878y & 15;
        }
        int iX = tVar.x();
        this.f2878y = iX;
        return (iX & 240) >> 4;
    }

    public long d() {
        int i = this.f2877x;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = (long[]) this.f2879z;
        int i10 = this.f2875v;
        long j4 = jArr[i10];
        this.f2875v = this.f2878y & (i10 + 1);
        this.f2877x = i - 1;
        return j4;
    }

    @Override // t0.o
    public p1 k(View view, p1 p1Var) {
        View view2 = (View) this.f2879z;
        l0.c cVarF = p1Var.f11791a.f(519);
        int i = this.f2875v;
        if (i >= 0) {
            view2.getLayoutParams().height = i + cVarF.f7603b;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(this.f2876w + cVarF.f7602a, this.f2877x + cVarF.f7603b, this.f2878y + cVarF.f7604c, view2.getPaddingBottom());
        return p1Var;
    }
}
