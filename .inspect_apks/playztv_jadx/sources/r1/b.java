package r1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Objects;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
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
    public static final String f11245s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f11246t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f11247u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f11248v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f11249w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f11250x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f11251y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f11252z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f11253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f11254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f11255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f11256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f11257e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f11258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f11259h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f11260j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f11261k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f11262l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11263m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f11264n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f11265o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f11266p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f11267q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f11268r;

    static {
        new b("", null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f, 0);
        int i = b0.f11647a;
        f11245s = Integer.toString(0, 36);
        f11246t = Integer.toString(17, 36);
        f11247u = Integer.toString(1, 36);
        f11248v = Integer.toString(2, 36);
        f11249w = Integer.toString(3, 36);
        f11250x = Integer.toString(18, 36);
        f11251y = Integer.toString(4, 36);
        f11252z = Integer.toString(5, 36);
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

    public b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i10, float f4, int i11, int i12, float f10, float f11, float f12, boolean z2, int i13, int i14, float f13, int i15) {
        if (charSequence == null) {
            bitmap.getClass();
        } else {
            s1.d.b(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f11253a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f11253a = charSequence.toString();
        } else {
            this.f11253a = null;
        }
        this.f11254b = alignment;
        this.f11255c = alignment2;
        this.f11256d = bitmap;
        this.f11257e = f;
        this.f = i;
        this.f11258g = i10;
        this.f11259h = f4;
        this.i = i11;
        this.f11260j = f11;
        this.f11261k = f12;
        this.f11262l = z2;
        this.f11263m = i13;
        this.f11264n = i12;
        this.f11265o = f10;
        this.f11266p = i14;
        this.f11267q = f13;
        this.f11268r = i15;
    }

    public final a a() {
        a aVar = new a();
        aVar.f11229a = this.f11253a;
        aVar.f11230b = this.f11256d;
        aVar.f11231c = this.f11254b;
        aVar.f11232d = this.f11255c;
        aVar.f11233e = this.f11257e;
        aVar.f = this.f;
        aVar.f11234g = this.f11258g;
        aVar.f11235h = this.f11259h;
        aVar.i = this.i;
        aVar.f11236j = this.f11264n;
        aVar.f11237k = this.f11265o;
        aVar.f11238l = this.f11260j;
        aVar.f11239m = this.f11261k;
        aVar.f11240n = this.f11262l;
        aVar.f11241o = this.f11263m;
        aVar.f11242p = this.f11266p;
        aVar.f11243q = this.f11267q;
        aVar.f11244r = this.f11268r;
        return aVar;
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f11253a;
        if (charSequence != null) {
            bundle.putCharSequence(f11245s, charSequence);
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                String str = d.f11274a;
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (g gVar : (g[]) spanned.getSpans(0, spanned.length(), g.class)) {
                    gVar.getClass();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(g.f11279c, gVar.f11281a);
                    bundle2.putInt(g.f11280d, gVar.f11282b);
                    arrayList.add(d.a(spanned, gVar, 1, bundle2));
                }
                for (h hVar : (h[]) spanned.getSpans(0, spanned.length(), h.class)) {
                    hVar.getClass();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(h.f11283d, hVar.f11285a);
                    bundle3.putInt(h.f11284e, hVar.f11286b);
                    bundle3.putInt(h.f, hVar.f11287c);
                    arrayList.add(d.a(spanned, hVar, 2, bundle3));
                }
                for (e eVar : (e[]) spanned.getSpans(0, spanned.length(), e.class)) {
                    arrayList.add(d.a(spanned, eVar, 3, null));
                }
                for (i iVar : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
                    iVar.getClass();
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(i.f11288b, iVar.f11289a);
                    arrayList.add(d.a(spanned, iVar, 4, bundle4));
                }
                if (!arrayList.isEmpty()) {
                    bundle.putParcelableArrayList(f11246t, arrayList);
                }
            }
        }
        bundle.putSerializable(f11247u, this.f11254b);
        bundle.putSerializable(f11248v, this.f11255c);
        bundle.putFloat(f11251y, this.f11257e);
        bundle.putInt(f11252z, this.f);
        bundle.putInt(A, this.f11258g);
        bundle.putFloat(B, this.f11259h);
        bundle.putInt(C, this.i);
        bundle.putInt(D, this.f11264n);
        bundle.putFloat(E, this.f11265o);
        bundle.putFloat(F, this.f11260j);
        bundle.putFloat(G, this.f11261k);
        bundle.putBoolean(I, this.f11262l);
        bundle.putInt(H, this.f11263m);
        bundle.putInt(J, this.f11266p);
        bundle.putFloat(K, this.f11267q);
        bundle.putInt(L, this.f11268r);
        return bundle;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            Bitmap bitmap2 = bVar.f11256d;
            if (TextUtils.equals(this.f11253a, bVar.f11253a) && this.f11254b == bVar.f11254b && this.f11255c == bVar.f11255c && ((bitmap = this.f11256d) != null ? !(bitmap2 == null || !bitmap.sameAs(bitmap2)) : bitmap2 == null) && this.f11257e == bVar.f11257e && this.f == bVar.f && this.f11258g == bVar.f11258g && this.f11259h == bVar.f11259h && this.i == bVar.i && this.f11260j == bVar.f11260j && this.f11261k == bVar.f11261k && this.f11262l == bVar.f11262l && this.f11263m == bVar.f11263m && this.f11264n == bVar.f11264n && this.f11265o == bVar.f11265o && this.f11266p == bVar.f11266p && this.f11267q == bVar.f11267q && this.f11268r == bVar.f11268r) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f11253a, this.f11254b, this.f11255c, this.f11256d, Float.valueOf(this.f11257e), Integer.valueOf(this.f), Integer.valueOf(this.f11258g), Float.valueOf(this.f11259h), Integer.valueOf(this.i), Float.valueOf(this.f11260j), Float.valueOf(this.f11261k), Boolean.valueOf(this.f11262l), Integer.valueOf(this.f11263m), Integer.valueOf(this.f11264n), Float.valueOf(this.f11265o), Integer.valueOf(this.f11266p), Float.valueOf(this.f11267q), Integer.valueOf(this.f11268r));
    }
}
