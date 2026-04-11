package k4;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f7012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7013m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7014n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7015o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f7016p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f7017q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f7018r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f7019s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f7020t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7021u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f7022v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f7023w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f7024x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f7025y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f7026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1 f7027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v1.s0 f7028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v1.s0 f7029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f7030e;
    public final Bundle f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f1 f7031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ua.i0 f7032h;
    public final ua.i0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MediaSession.Token f7033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ua.i0 f7034k;

    static {
        int i = y1.a0.f14551a;
        f7012l = Integer.toString(0, 36);
        f7013m = Integer.toString(1, 36);
        f7014n = Integer.toString(2, 36);
        f7015o = Integer.toString(9, 36);
        f7016p = Integer.toString(14, 36);
        f7017q = Integer.toString(13, 36);
        f7018r = Integer.toString(3, 36);
        f7019s = Integer.toString(4, 36);
        f7020t = Integer.toString(5, 36);
        f7021u = Integer.toString(6, 36);
        f7022v = Integer.toString(11, 36);
        f7023w = Integer.toString(7, 36);
        f7024x = Integer.toString(8, 36);
        Integer.toString(10, 36);
        f7025y = Integer.toString(12, 36);
    }

    public h(k kVar, ua.i0 i0Var, ua.i0 i0Var2, ua.i0 i0Var3, l1 l1Var, v1.s0 s0Var, v1.s0 s0Var2, Bundle bundle, Bundle bundle2, f1 f1Var, MediaSession.Token token) {
        this.f7026a = kVar;
        this.f7032h = i0Var;
        this.i = i0Var2;
        this.f7034k = i0Var3;
        this.f7027b = l1Var;
        this.f7028c = s0Var;
        this.f7029d = s0Var2;
        this.f7030e = bundle;
        this.f = bundle2;
        this.f7031g = f1Var;
        this.f7033j = token;
    }

    public final Bundle a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(f7012l, 1008000300);
        d1 d1Var = (d1) this.f7026a;
        d1Var.getClass();
        bundle.putBinder(f7013m, d1Var);
        bundle.putParcelable(f7014n, null);
        ua.i0 i0Var = this.f7032h;
        boolean zIsEmpty = i0Var.isEmpty();
        String str = f7015o;
        if (!zIsEmpty) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(i0Var.size());
            Iterator<E> it = i0Var.iterator();
            if (it.hasNext()) {
                q4.a.u(it.next());
                throw null;
            }
            bundle.putParcelableArrayList(str, arrayList);
        }
        ua.i0 i0Var2 = this.i;
        if (!i0Var2.isEmpty()) {
            if (i >= 7) {
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(i0Var2.size());
                Iterator<E> it2 = i0Var2.iterator();
                if (it2.hasNext()) {
                    q4.a.u(it2.next());
                    throw null;
                }
                bundle.putParcelableArrayList(f7016p, arrayList2);
            } else {
                ua.z0 z0VarA = a.a(i0Var2);
                ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>(z0VarA.f12415y);
                ua.g0 g0VarListIterator = z0VarA.listIterator(0);
                if (g0VarListIterator.hasNext()) {
                    q4.a.u(g0VarListIterator.next());
                    throw null;
                }
                bundle.putParcelableArrayList(str, arrayList3);
            }
        }
        ua.i0 i0Var3 = this.f7034k;
        if (!i0Var3.isEmpty()) {
            ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>(i0Var3.size());
            Iterator<E> it3 = i0Var3.iterator();
            if (it3.hasNext()) {
                q4.a.u(it3.next());
                throw null;
            }
            bundle.putParcelableArrayList(f7017q, arrayList4);
        }
        l1 l1Var = this.f7027b;
        l1Var.getClass();
        Bundle bundle2 = new Bundle();
        ArrayList<? extends Parcelable> arrayList5 = new ArrayList<>();
        ua.n1 it4 = l1Var.f7076a.iterator();
        while (it4.hasNext()) {
            k1 k1Var = (k1) it4.next();
            k1Var.getClass();
            Bundle bundle3 = new Bundle();
            bundle3.putInt(k1.f, k1Var.f7055a);
            bundle3.putString(k1.f7053g, k1Var.f7056b);
            bundle3.putBundle(k1.f7054h, k1Var.f7057c);
            arrayList5.add(bundle3);
        }
        bundle2.putParcelableArrayList(l1.f7075b, arrayList5);
        bundle.putBundle(f7018r, bundle2);
        String str2 = f7019s;
        v1.s0 s0Var = this.f7028c;
        bundle.putBundle(str2, s0Var.b());
        String str3 = f7020t;
        v1.s0 s0Var2 = this.f7029d;
        bundle.putBundle(str3, s0Var2.b());
        bundle.putBundle(f7021u, this.f7030e);
        bundle.putBundle(f7022v, this.f);
        bundle.putBundle(f7023w, this.f7031g.e(ab.b.q(s0Var, s0Var2), false, false).f(i));
        bundle.putInt(f7024x, 5);
        MediaSession.Token token = this.f7033j;
        if (token != null) {
            bundle.putParcelable(f7025y, token);
        }
        return bundle;
    }
}
