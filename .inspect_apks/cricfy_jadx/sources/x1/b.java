package x1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Objects;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f14241s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f14242t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f14243u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f14244v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f14245w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f14246x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f14247y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f14248z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f14249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f14250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f14251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f14252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f14253e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f14255h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f14256j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f14257k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f14258l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f14259m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f14260n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f14261o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f14262p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f14263q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f14264r;

    static {
        new b("", null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f, 0);
        int i = a0.f14551a;
        f14241s = Integer.toString(0, 36);
        f14242t = Integer.toString(17, 36);
        f14243u = Integer.toString(1, 36);
        f14244v = Integer.toString(2, 36);
        f14245w = Integer.toString(3, 36);
        f14246x = Integer.toString(18, 36);
        f14247y = Integer.toString(4, 36);
        f14248z = Integer.toString(5, 36);
        A = Integer.toString(6, 36);
        B = Integer.toString(7, 36);
        C = Integer.toString(8, 36);
        D = Integer.toString(9, 36);
        E = Integer.toString(10, 36);
        F = Integer.toString(11, 36);
        G = Integer.toString(12, 36);
        H = Integer.toString(13, 36);
        I = Integer.toString(14, 36);
        J = Integer.toString(15, 36);
        K = Integer.toString(16, 36);
        L = Integer.toString(19, 36);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i10, float f10, int i11, int i12, float f11, float f12, float f13, boolean z10, int i13, int i14, float f14, int i15) {
        if (charSequence == null) {
            bitmap.getClass();
        } else {
            y1.d.b(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f14249a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f14249a = charSequence.toString();
        } else {
            this.f14249a = null;
        }
        this.f14250b = alignment;
        this.f14251c = alignment2;
        this.f14252d = bitmap;
        this.f14253e = f;
        this.f = i;
        this.f14254g = i10;
        this.f14255h = f10;
        this.i = i11;
        this.f14256j = f12;
        this.f14257k = f13;
        this.f14258l = z10;
        this.f14259m = i13;
        this.f14260n = i12;
        this.f14261o = f11;
        this.f14262p = i14;
        this.f14263q = f14;
        this.f14264r = i15;
    }

    public final a a() {
        a aVar = new a();
        aVar.f14225a = this.f14249a;
        aVar.f14226b = this.f14252d;
        aVar.f14227c = this.f14250b;
        aVar.f14228d = this.f14251c;
        aVar.f14229e = this.f14253e;
        aVar.f = this.f;
        aVar.f14230g = this.f14254g;
        aVar.f14231h = this.f14255h;
        aVar.i = this.i;
        aVar.f14232j = this.f14260n;
        aVar.f14233k = this.f14261o;
        aVar.f14234l = this.f14256j;
        aVar.f14235m = this.f14257k;
        aVar.f14236n = this.f14258l;
        aVar.f14237o = this.f14259m;
        aVar.f14238p = this.f14262p;
        aVar.f14239q = this.f14263q;
        aVar.f14240r = this.f14264r;
        return aVar;
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f14249a;
        if (charSequence != null) {
            bundle.putCharSequence(f14241s, charSequence);
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                String str = d.f14270a;
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (g gVar : (g[]) spanned.getSpans(0, spanned.length(), g.class)) {
                    gVar.getClass();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(g.f14275c, gVar.f14277a);
                    bundle2.putInt(g.f14276d, gVar.f14278b);
                    arrayList.add(d.a(spanned, gVar, 1, bundle2));
                }
                for (h hVar : (h[]) spanned.getSpans(0, spanned.length(), h.class)) {
                    hVar.getClass();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(h.f14279d, hVar.f14281a);
                    bundle3.putInt(h.f14280e, hVar.f14282b);
                    bundle3.putInt(h.f, hVar.f14283c);
                    arrayList.add(d.a(spanned, hVar, 2, bundle3));
                }
                for (e eVar : (e[]) spanned.getSpans(0, spanned.length(), e.class)) {
                    arrayList.add(d.a(spanned, eVar, 3, null));
                }
                for (i iVar : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
                    iVar.getClass();
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(i.f14284b, iVar.f14285a);
                    arrayList.add(d.a(spanned, iVar, 4, bundle4));
                }
                if (!arrayList.isEmpty()) {
                    bundle.putParcelableArrayList(f14242t, arrayList);
                }
            }
        }
        bundle.putSerializable(f14243u, this.f14250b);
        bundle.putSerializable(f14244v, this.f14251c);
        bundle.putFloat(f14247y, this.f14253e);
        bundle.putInt(f14248z, this.f);
        bundle.putInt(A, this.f14254g);
        bundle.putFloat(B, this.f14255h);
        bundle.putInt(C, this.i);
        bundle.putInt(D, this.f14260n);
        bundle.putFloat(E, this.f14261o);
        bundle.putFloat(F, this.f14256j);
        bundle.putFloat(G, this.f14257k);
        bundle.putBoolean(I, this.f14258l);
        bundle.putInt(H, this.f14259m);
        bundle.putInt(J, this.f14262p);
        bundle.putFloat(K, this.f14263q);
        bundle.putInt(L, this.f14264r);
        return bundle;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            Bitmap bitmap2 = bVar.f14252d;
            if (TextUtils.equals(this.f14249a, bVar.f14249a) && this.f14250b == bVar.f14250b && this.f14251c == bVar.f14251c && ((bitmap = this.f14252d) != null ? !(bitmap2 == null || !bitmap.sameAs(bitmap2)) : bitmap2 == null) && this.f14253e == bVar.f14253e && this.f == bVar.f && this.f14254g == bVar.f14254g && this.f14255h == bVar.f14255h && this.i == bVar.i && this.f14256j == bVar.f14256j && this.f14257k == bVar.f14257k && this.f14258l == bVar.f14258l && this.f14259m == bVar.f14259m && this.f14260n == bVar.f14260n && this.f14261o == bVar.f14261o && this.f14262p == bVar.f14262p && this.f14263q == bVar.f14263q && this.f14264r == bVar.f14264r) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f14249a, this.f14250b, this.f14251c, this.f14252d, Float.valueOf(this.f14253e), Integer.valueOf(this.f), Integer.valueOf(this.f14254g), Float.valueOf(this.f14255h), Integer.valueOf(this.i), Float.valueOf(this.f14256j), Float.valueOf(this.f14257k), Boolean.valueOf(this.f14258l), Integer.valueOf(this.f14259m), Integer.valueOf(this.f14260n), Float.valueOf(this.f14261o), Integer.valueOf(this.f14262p), Float.valueOf(this.f14263q), Integer.valueOf(this.f14264r));
    }
}
