package j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int N = 0;
    public boolean B;
    public androidx.fragment.app.e C;
    public long D;
    public long E;
    public h5.c F;
    public b G;
    public boolean H;
    public b I;
    public com.bumptech.glide.c J;
    public boolean M;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f6648u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Rect f6649v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f6650w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f6651x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6653z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6652y = 255;
    public int A = -1;
    public int K = -1;
    public int L = -1;

    public e(b bVar, Resources resources) {
        i(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0288, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0281, code lost:
    
        r5.onStateChange(r5.getState());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j.e c(android.content.Context r25, android.content.res.Resources r26, android.content.res.XmlResourceParser r27, android.util.AttributeSet r28, android.content.res.Resources.Theme r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 679
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.e.c(android.content.Context, android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):j.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f6653z = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f6650w
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L36
            long r9 = r13.D
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L38
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f6652y
            r3.setAlpha(r9)
            r13.D = r6
            goto L38
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            j.b r10 = r13.f6648u
            int r10 = r10.f6641y
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f6652y
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L39
        L36:
            r13.D = r6
        L38:
            r3 = r8
        L39:
            android.graphics.drawable.Drawable r9 = r13.f6651x
            if (r9 == 0) goto L61
            long r10 = r13.E
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L63
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L50
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f6651x = r0
            r13.E = r6
            goto L63
        L50:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            j.b r4 = r13.f6648u
            int r4 = r4.f6642z
            int r3 = r3 / r4
            int r4 = r13.f6652y
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L64
        L61:
            r13.E = r6
        L63:
            r0 = r3
        L64:
            if (r14 == 0) goto L70
            if (r0 == 0) goto L70
            androidx.fragment.app.e r14 = r13.C
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j.e.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        b(theme);
        onStateChange(getState());
    }

    public final void b(Resources.Theme theme) {
        b bVar = this.f6648u;
        if (theme == null) {
            bVar.getClass();
            return;
        }
        bVar.c();
        int i = bVar.f6625h;
        Drawable[] drawableArr = bVar.f6624g;
        for (int i10 = 0; i10 < i; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable != null && drawable.canApplyTheme()) {
                drawableArr[i10].applyTheme(theme);
                bVar.f6623e |= drawableArr[i10].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            bVar.f6620b = resources;
            int i11 = resources.getDisplayMetrics().densityDpi;
            if (i11 == 0) {
                i11 = 160;
            }
            int i12 = bVar.f6621c;
            bVar.f6621c = i11;
            if (i12 != i11) {
                bVar.f6629m = false;
                bVar.f6626j = false;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.f6648u.canApplyTheme();
    }

    public final void d(Drawable drawable) {
        if (this.F == null) {
            this.F = new h5.c();
        }
        h5.c cVar = this.F;
        cVar.f5880v = drawable.getCallback();
        drawable.setCallback(cVar);
        try {
            if (this.f6648u.f6641y <= 0 && this.f6653z) {
                drawable.setAlpha(this.f6652y);
            }
            b bVar = this.f6648u;
            if (bVar.C) {
                drawable.setColorFilter(bVar.B);
            } else {
                if (bVar.F) {
                    drawable.setTintList(bVar.D);
                }
                b bVar2 = this.f6648u;
                if (bVar2.G) {
                    drawable.setTintMode(bVar2.E);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f6648u.f6639w);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setAutoMirrored(this.f6648u.A);
            Rect rect = this.f6649v;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
            h5.c cVar2 = this.F;
            Drawable.Callback callback = (Drawable.Callback) cVar2.f5880v;
            cVar2.f5880v = null;
            drawable.setCallback(callback);
        } catch (Throwable th) {
            h5.c cVar3 = this.F;
            Drawable.Callback callback2 = (Drawable.Callback) cVar3.f5880v;
            cVar3.f5880v = null;
            drawable.setCallback(callback2);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f6651x;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final void e() {
        boolean z2;
        Drawable drawable = this.f6651x;
        boolean z10 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f6651x = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f6650w;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f6653z) {
                this.f6650w.setAlpha(this.f6652y);
            }
        }
        if (this.E != 0) {
            this.E = 0L;
            z2 = true;
        }
        if (this.D != 0) {
            this.D = 0L;
        } else {
            z10 = z2;
        }
        if (z10) {
            invalidateSelf();
        }
    }

    public final Drawable f() {
        if (!this.B && super.mutate() == this) {
            b bVar = new b(this.I, this, null);
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            i(bVar);
            this.B = true;
        }
        return this;
    }

    public final Drawable g() {
        if (!this.H) {
            f();
            b bVar = this.G;
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.H = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6652y;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f6648u.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z2;
        b bVar = this.f6648u;
        if (!bVar.f6637u) {
            bVar.c();
            bVar.f6637u = true;
            int i = bVar.f6625h;
            Drawable[] drawableArr = bVar.f6624g;
            int i10 = 0;
            while (true) {
                if (i10 >= i) {
                    bVar.f6638v = true;
                    z2 = true;
                    break;
                }
                if (drawableArr[i10].getConstantState() == null) {
                    bVar.f6638v = false;
                    z2 = false;
                    break;
                }
                i10++;
            }
        } else {
            z2 = bVar.f6638v;
        }
        if (!z2) {
            return null;
        }
        this.f6648u.f6622d = getChangingConfigurations();
        return this.f6648u;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f6650w;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f6649v;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        b bVar = this.f6648u;
        if (bVar.f6628l) {
            if (!bVar.f6629m) {
                bVar.b();
            }
            return bVar.f6631o;
        }
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        b bVar = this.f6648u;
        if (bVar.f6628l) {
            if (!bVar.f6629m) {
                bVar.b();
            }
            return bVar.f6630n;
        }
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        b bVar = this.f6648u;
        if (bVar.f6628l) {
            if (!bVar.f6629m) {
                bVar.b();
            }
            return bVar.f6633q;
        }
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        b bVar = this.f6648u;
        if (bVar.f6628l) {
            if (!bVar.f6629m) {
                bVar.b();
            }
            return bVar.f6632p;
        }
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f6650w;
        if (drawable != null && drawable.isVisible()) {
            b bVar = this.f6648u;
            if (bVar.f6634r) {
                return bVar.f6635s;
            }
            bVar.c();
            int i = bVar.f6625h;
            Drawable[] drawableArr = bVar.f6624g;
            opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i10 = 1; i10 < i; i10++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i10].getOpacity());
            }
            bVar.f6635s = opacity;
            bVar.f6634r = true;
        }
        return opacity;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        b bVar = this.f6648u;
        Rect rect2 = null;
        boolean padding = false;
        if (!bVar.i) {
            Rect rect3 = bVar.f6627k;
            if (rect3 != null || bVar.f6626j) {
                rect2 = rect3;
            } else {
                bVar.c();
                Rect rect4 = new Rect();
                int i = bVar.f6625h;
                Drawable[] drawableArr = bVar.f6624g;
                for (int i10 = 0; i10 < i; i10++) {
                    if (drawableArr[i10].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i11 = rect4.left;
                        if (i11 > rect2.left) {
                            rect2.left = i11;
                        }
                        int i12 = rect4.top;
                        if (i12 > rect2.top) {
                            rect2.top = i12;
                        }
                        int i13 = rect4.right;
                        if (i13 > rect2.right) {
                            rect2.right = i13;
                        }
                        int i14 = rect4.bottom;
                        if (i14 > rect2.bottom) {
                            rect2.bottom = i14;
                        }
                    }
                }
                bVar.f6626j = true;
                bVar.f6627k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                padding = true;
            }
        } else {
            Drawable drawable = this.f6650w;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.f6648u.A && getLayoutDirection() == 1) {
            int i15 = rect.left;
            rect.left = rect.right;
            rect.right = i15;
        }
        return padding;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(int r10) {
        /*
            r9 = this;
            int r0 = r9.A
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            j.b r0 = r9.f6648u
            int r0 = r0.f6642z
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f6651x
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f6650w
            if (r0 == 0) goto L29
            r9.f6651x = r0
            j.b r0 = r9.f6648u
            int r0 = r0.f6642z
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.E = r0
            goto L35
        L29:
            r9.f6651x = r4
            r9.E = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f6650w
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            j.b r0 = r9.f6648u
            int r1 = r0.f6625h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.d(r10)
            r9.f6650w = r0
            r9.A = r10
            if (r0 == 0) goto L5a
            j.b r10 = r9.f6648u
            int r10 = r10.f6641y
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.D = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f6650w = r4
            r10 = -1
            r9.A = r10
        L5a:
            long r0 = r9.D
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L67
            long r1 = r9.E
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L7a
        L67:
            androidx.fragment.app.e r10 = r9.C
            if (r10 != 0) goto L74
            androidx.fragment.app.e r10 = new androidx.fragment.app.e
            r1 = 7
            r10.<init>(r1, r9)
            r9.C = r10
            goto L77
        L74:
            r9.unscheduleSelf(r10)
        L77:
            r9.a(r0)
        L7a:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.e.h(int):boolean");
    }

    public final void i(b bVar) {
        this.f6648u = bVar;
        int i = this.A;
        if (i >= 0) {
            Drawable drawableD = bVar.d(i);
            this.f6650w = drawableD;
            if (drawableD != null) {
                d(drawableD);
            }
        }
        this.f6651x = null;
        this.G = bVar;
        this.I = bVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        b bVar = this.f6648u;
        if (bVar != null) {
            bVar.f6634r = false;
            bVar.f6636t = false;
        }
        if (drawable != this.f6650w || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f6648u.A;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    public final boolean j(boolean z2, boolean z10) {
        boolean visible = super.setVisible(z2, z10);
        Drawable drawable = this.f6651x;
        if (drawable != null) {
            drawable.setVisible(z2, z10);
        }
        Drawable drawable2 = this.f6650w;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z10);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        e();
        com.bumptech.glide.c cVar = this.J;
        if (cVar != null) {
            cVar.w();
            this.J = null;
            h(this.K);
            this.K = -1;
            this.L = -1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.M) {
            g();
            b bVar = this.I;
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.M = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f6651x;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f6650w;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        b bVar = this.f6648u;
        int i10 = this.A;
        int i11 = bVar.f6625h;
        Drawable[] drawableArr = bVar.f6624g;
        boolean z2 = false;
        for (int i12 = 0; i12 < i11; i12++) {
            Drawable drawable = drawableArr[i12];
            if (drawable != null) {
                boolean layoutDirection = drawable.setLayoutDirection(i);
                if (i12 == i10) {
                    z2 = layoutDirection;
                }
            }
        }
        bVar.f6640x = i;
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.f6651x;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f6650w;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d3  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStateChange(int[] r15) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.e.onStateChange(int[]):boolean");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        if (drawable != this.f6650w || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f6653z && this.f6652y == i) {
            return;
        }
        this.f6653z = true;
        this.f6652y = i;
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            if (this.D == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z2) {
        b bVar = this.f6648u;
        if (bVar.A != z2) {
            bVar.A = z2;
            Drawable drawable = this.f6650w;
            if (drawable != null) {
                drawable.setAutoMirrored(z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        b bVar = this.f6648u;
        bVar.C = true;
        if (bVar.B != colorFilter) {
            bVar.B = colorFilter;
            Drawable drawable = this.f6650w;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z2) {
        b bVar = this.f6648u;
        if (bVar.f6639w != z2) {
            bVar.f6639w = z2;
            Drawable drawable = this.f6650w;
            if (drawable != null) {
                drawable.setDither(z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f4) {
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            drawable.setHotspot(f, f4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i10, int i11, int i12) {
        Rect rect = this.f6649v;
        if (rect == null) {
            this.f6649v = new Rect(i, i10, i11, i12);
        } else {
            rect.set(i, i10, i11, i12);
        }
        Drawable drawable = this.f6650w;
        if (drawable != null) {
            drawable.setHotspotBounds(i, i10, i11, i12);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        b bVar = this.f6648u;
        bVar.F = true;
        if (bVar.D != colorStateList) {
            bVar.D = colorStateList;
            this.f6650w.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f6648u;
        bVar.G = true;
        if (bVar.E != mode) {
            bVar.E = mode;
            this.f6650w.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z10) {
        boolean zJ = j(z2, z10);
        com.bumptech.glide.c cVar = this.J;
        if (cVar != null && (zJ || z10)) {
            if (z2) {
                cVar.v();
                return zJ;
            }
            jumpToCurrentState();
        }
        return zJ;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f6650w || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
