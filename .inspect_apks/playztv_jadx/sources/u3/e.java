package u3;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final boolean[] A;
    public static final int[] B;
    public static final int[] C;
    public static final int[] D;
    public static final int[] E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f12721v = c(2, 2, 2, 0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f12722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f12723x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f12724y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f12725z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12726a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpannableStringBuilder f12727b = new SpannableStringBuilder();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12730e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12732h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12736m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12737n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12738o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12739p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12740q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12741r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12742s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12743t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12744u;

    static {
        int iC = c(0, 0, 0, 0);
        f12722w = iC;
        int iC2 = c(0, 0, 0, 3);
        f12723x = new int[]{0, 0, 0, 0, 0, 2, 0};
        f12724y = new int[]{0, 0, 0, 0, 0, 0, 2};
        f12725z = new int[]{3, 3, 3, 3, 3, 3, 1};
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
            s1.d.c(r4, r0)
            s1.d.c(r5, r0)
            s1.d.c(r6, r0)
            s1.d.c(r7, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: u3.e.c(int, int, int, int):int");
    }

    public final void a(char c9) {
        SpannableStringBuilder spannableStringBuilder = this.f12727b;
        if (c9 != '\n') {
            spannableStringBuilder.append(c9);
            return;
        }
        SpannableString spannableStringB = b();
        ArrayList arrayList = this.f12726a;
        arrayList.add(spannableStringB);
        spannableStringBuilder.clear();
        if (this.f12738o != -1) {
            this.f12738o = 0;
        }
        if (this.f12739p != -1) {
            this.f12739p = 0;
        }
        if (this.f12740q != -1) {
            this.f12740q = 0;
        }
        if (this.f12742s != -1) {
            this.f12742s = 0;
        }
        while (true) {
            if (arrayList.size() < this.f12733j && arrayList.size() < 15) {
                this.f12744u = arrayList.size();
                return;
            }
            arrayList.remove(0);
        }
    }

    public final SpannableString b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f12727b);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.f12738o != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f12738o, length, 33);
            }
            if (this.f12739p != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f12739p, length, 33);
            }
            if (this.f12740q != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f12741r), this.f12740q, length, 33);
            }
            if (this.f12742s != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f12743t), this.f12742s, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final void d() {
        this.f12726a.clear();
        this.f12727b.clear();
        this.f12738o = -1;
        this.f12739p = -1;
        this.f12740q = -1;
        this.f12742s = -1;
        this.f12744u = 0;
        this.f12728c = false;
        this.f12729d = false;
        this.f12730e = 4;
        this.f = false;
        this.f12731g = 0;
        this.f12732h = 0;
        this.i = 0;
        this.f12733j = 15;
        this.f12734k = 0;
        this.f12735l = 0;
        this.f12736m = 0;
        int i = f12722w;
        this.f12737n = i;
        this.f12741r = f12721v;
        this.f12743t = i;
    }

    public final void e(boolean z2, boolean z10) {
        int i = this.f12738o;
        SpannableStringBuilder spannableStringBuilder = this.f12727b;
        if (i != -1) {
            if (!z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f12738o, spannableStringBuilder.length(), 33);
                this.f12738o = -1;
            }
        } else if (z2) {
            this.f12738o = spannableStringBuilder.length();
        }
        if (this.f12739p == -1) {
            if (z10) {
                this.f12739p = spannableStringBuilder.length();
            }
        } else {
            if (z10) {
                return;
            }
            spannableStringBuilder.setSpan(new UnderlineSpan(), this.f12739p, spannableStringBuilder.length(), 33);
            this.f12739p = -1;
        }
    }

    public final void f(int i, int i10) {
        int i11 = this.f12740q;
        SpannableStringBuilder spannableStringBuilder = this.f12727b;
        if (i11 != -1 && this.f12741r != i) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f12741r), this.f12740q, spannableStringBuilder.length(), 33);
        }
        if (i != f12721v) {
            this.f12740q = spannableStringBuilder.length();
            this.f12741r = i;
        }
        if (this.f12742s != -1 && this.f12743t != i10) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f12743t), this.f12742s, spannableStringBuilder.length(), 33);
        }
        if (i10 != f12722w) {
            this.f12742s = spannableStringBuilder.length();
            this.f12743t = i10;
        }
    }
}
