package y3;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final boolean[] A;
    public static final int[] B;
    public static final int[] C;
    public static final int[] D;
    public static final int[] E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f14797v = c(2, 2, 2, 0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f14798w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f14799x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f14800y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f14801z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f14802a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpannableStringBuilder f14803b = new SpannableStringBuilder();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14806e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14808h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14813n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f14818s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14819t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14820u;

    static {
        int iC = c(0, 0, 0, 0);
        f14798w = iC;
        int iC2 = c(0, 0, 0, 3);
        f14799x = new int[]{0, 0, 0, 0, 0, 2, 0};
        f14800y = new int[]{0, 0, 0, 0, 0, 0, 2};
        f14801z = new int[]{3, 3, 3, 3, 3, 3, 1};
        A = new boolean[]{false, false, false, true, true, true, false};
        B = new int[]{iC, iC2, iC, iC, iC2, iC, iC};
        C = new int[]{0, 1, 2, 3, 4, 3, 4};
        D = new int[]{0, 0, 0, 0, 0, 3, 3};
        E = new int[]{iC, iC, iC, iC, iC, iC2, iC2};
    }

    public e() {
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int r4, int r5, int r6, int r7) {
        /*
            r0 = 4
            y1.d.c(r4, r0)
            y1.d.c(r5, r0)
            y1.d.c(r6, r0)
            y1.d.c(r7, r0)
            r0 = 1
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            if (r7 == 0) goto L1b
            if (r7 == r0) goto L1b
            r3 = 2
            if (r7 == r3) goto L1f
            r3 = 3
            if (r7 == r3) goto L1d
        L1b:
            r7 = r1
            goto L21
        L1d:
            r7 = r2
            goto L21
        L1f:
            r7 = 127(0x7f, float:1.78E-43)
        L21:
            if (r4 <= r0) goto L25
            r4 = r1
            goto L26
        L25:
            r4 = r2
        L26:
            if (r5 <= r0) goto L2a
            r5 = r1
            goto L2b
        L2a:
            r5 = r2
        L2b:
            if (r6 <= r0) goto L2e
            goto L2f
        L2e:
            r1 = r2
        L2f:
            int r4 = android.graphics.Color.argb(r7, r4, r5, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.e.c(int, int, int, int):int");
    }

    public final void a(char c9) {
        SpannableStringBuilder spannableStringBuilder = this.f14803b;
        if (c9 != '\n') {
            spannableStringBuilder.append(c9);
            return;
        }
        SpannableString spannableStringB = b();
        ArrayList arrayList = this.f14802a;
        arrayList.add(spannableStringB);
        spannableStringBuilder.clear();
        if (this.f14814o != -1) {
            this.f14814o = 0;
        }
        if (this.f14815p != -1) {
            this.f14815p = 0;
        }
        if (this.f14816q != -1) {
            this.f14816q = 0;
        }
        if (this.f14818s != -1) {
            this.f14818s = 0;
        }
        while (true) {
            if (arrayList.size() < this.f14809j && arrayList.size() < 15) {
                this.f14820u = arrayList.size();
                return;
            }
            arrayList.remove(0);
        }
    }

    public final SpannableString b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f14803b);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.f14814o != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f14814o, length, 33);
            }
            if (this.f14815p != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f14815p, length, 33);
            }
            if (this.f14816q != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f14817r), this.f14816q, length, 33);
            }
            if (this.f14818s != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f14819t), this.f14818s, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final void d() {
        this.f14802a.clear();
        this.f14803b.clear();
        this.f14814o = -1;
        this.f14815p = -1;
        this.f14816q = -1;
        this.f14818s = -1;
        this.f14820u = 0;
        this.f14804c = false;
        this.f14805d = false;
        this.f14806e = 4;
        this.f = false;
        this.f14807g = 0;
        this.f14808h = 0;
        this.i = 0;
        this.f14809j = 15;
        this.f14810k = 0;
        this.f14811l = 0;
        this.f14812m = 0;
        int i = f14798w;
        this.f14813n = i;
        this.f14817r = f14797v;
        this.f14819t = i;
    }

    public final void e(boolean z10, boolean z11) {
        int i = this.f14814o;
        SpannableStringBuilder spannableStringBuilder = this.f14803b;
        if (i != -1) {
            if (!z10) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f14814o, spannableStringBuilder.length(), 33);
                this.f14814o = -1;
            }
        } else if (z10) {
            this.f14814o = spannableStringBuilder.length();
        }
        if (this.f14815p == -1) {
            if (z11) {
                this.f14815p = spannableStringBuilder.length();
            }
        } else {
            if (z11) {
                return;
            }
            spannableStringBuilder.setSpan(new UnderlineSpan(), this.f14815p, spannableStringBuilder.length(), 33);
            this.f14815p = -1;
        }
    }

    public final void f(int i, int i10) {
        int i11 = this.f14816q;
        SpannableStringBuilder spannableStringBuilder = this.f14803b;
        if (i11 != -1 && this.f14817r != i) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f14817r), this.f14816q, spannableStringBuilder.length(), 33);
        }
        if (i != f14797v) {
            this.f14816q = spannableStringBuilder.length();
            this.f14817r = i;
        }
        if (this.f14818s != -1 && this.f14819t != i10) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f14819t), this.f14818s, spannableStringBuilder.length(), 33);
        }
        if (i10 != f14798w) {
            this.f14818s = spannableStringBuilder.length();
            this.f14819t = i10;
        }
    }
}
