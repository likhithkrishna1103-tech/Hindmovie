package h5;

import aa.l0;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f5896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5897e;
    public l0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f5898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f5899h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f5900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f5901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint.Cap f5902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint.Join f5903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f5904n;

    @Override // h5.m
    public final boolean a() {
        return this.f.l() || this.f5896d.l();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    @Override // h5.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int[] r7) {
        /*
            r6 = this;
            aa.l0 r0 = r6.f
            boolean r1 = r0.l()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.f707x
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r7, r4)
            int r4 = r0.f705v
            if (r1 == r4) goto L1e
            r0.f705v = r1
            r0 = r2
            goto L1f
        L1e:
            r0 = r3
        L1f:
            aa.l0 r1 = r6.f5896d
            boolean r4 = r1.l()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r1.f707x
            android.content.res.ColorStateList r4 = (android.content.res.ColorStateList) r4
            int r5 = r4.getDefaultColor()
            int r7 = r4.getColorForState(r7, r5)
            int r4 = r1.f705v
            if (r7 == r4) goto L3a
            r1.f705v = r7
            goto L3b
        L3a:
            r2 = r3
        L3b:
            r7 = r0 | r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.k.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f5899h;
    }

    public int getFillColor() {
        return this.f.f705v;
    }

    public float getStrokeAlpha() {
        return this.f5898g;
    }

    public int getStrokeColor() {
        return this.f5896d.f705v;
    }

    public float getStrokeWidth() {
        return this.f5897e;
    }

    public float getTrimPathEnd() {
        return this.f5900j;
    }

    public float getTrimPathOffset() {
        return this.f5901k;
    }

    public float getTrimPathStart() {
        return this.i;
    }

    public void setFillAlpha(float f) {
        this.f5899h = f;
    }

    public void setFillColor(int i) {
        this.f.f705v = i;
    }

    public void setStrokeAlpha(float f) {
        this.f5898g = f;
    }

    public void setStrokeColor(int i) {
        this.f5896d.f705v = i;
    }

    public void setStrokeWidth(float f) {
        this.f5897e = f;
    }

    public void setTrimPathEnd(float f) {
        this.f5900j = f;
    }

    public void setTrimPathOffset(float f) {
        this.f5901k = f;
    }

    public void setTrimPathStart(float f) {
        this.i = f;
    }
}
