package m5;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f3.a f8322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f8323e;
    public f3.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f8324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f8325h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f8326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f8327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint.Cap f8328l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint.Join f8329m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f8330n;

    @Override // m5.j
    public final boolean a() {
        return this.f.m() || this.f8322d.m();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    @Override // m5.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int[] r7) {
        /*
            r6 = this;
            f3.a r0 = r6.f
            boolean r1 = r0.m()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.f3937y
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r7, r4)
            int r4 = r0.f3935w
            if (r1 == r4) goto L1e
            r0.f3935w = r1
            r0 = r2
            goto L1f
        L1e:
            r0 = r3
        L1f:
            f3.a r1 = r6.f8322d
            boolean r4 = r1.m()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r1.f3937y
            android.content.res.ColorStateList r4 = (android.content.res.ColorStateList) r4
            int r5 = r4.getDefaultColor()
            int r7 = r4.getColorForState(r7, r5)
            int r4 = r1.f3935w
            if (r7 == r4) goto L3a
            r1.f3935w = r7
            goto L3b
        L3a:
            r2 = r3
        L3b:
            r7 = r0 | r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.h.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f8325h;
    }

    public int getFillColor() {
        return this.f.f3935w;
    }

    public float getStrokeAlpha() {
        return this.f8324g;
    }

    public int getStrokeColor() {
        return this.f8322d.f3935w;
    }

    public float getStrokeWidth() {
        return this.f8323e;
    }

    public float getTrimPathEnd() {
        return this.f8326j;
    }

    public float getTrimPathOffset() {
        return this.f8327k;
    }

    public float getTrimPathStart() {
        return this.i;
    }

    public void setFillAlpha(float f) {
        this.f8325h = f;
    }

    public void setFillColor(int i) {
        this.f.f3935w = i;
    }

    public void setStrokeAlpha(float f) {
        this.f8324g = f;
    }

    public void setStrokeColor(int i) {
        this.f8322d.f3935w = i;
    }

    public void setStrokeWidth(float f) {
        this.f8323e = f;
    }

    public void setTrimPathEnd(float f) {
        this.f8326j = f;
    }

    public void setTrimPathOffset(float f) {
        this.f8327k = f;
    }

    public void setTrimPathStart(float f) {
        this.i = f;
    }
}
