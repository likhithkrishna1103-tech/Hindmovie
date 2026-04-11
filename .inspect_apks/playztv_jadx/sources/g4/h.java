package g4;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f5023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f5024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f5025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f5026o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f5027p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f5028q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f5029r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f5030s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f5031t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f5032u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f5033v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f5034w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f5035x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f5036y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f5037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f5038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1.s0 f5039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1.s0 f5040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f5041e;
    public final Bundle f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h1 f5042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final aa.j0 f5043h;
    public final aa.j0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MediaSession.Token f5044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final aa.j0 f5045k;

    static {
        int i = s1.b0.f11647a;
        f5023l = Integer.toString(0, 36);
        f5024m = Integer.toString(1, 36);
        f5025n = Integer.toString(2, 36);
        f5026o = Integer.toString(9, 36);
        f5027p = Integer.toString(14, 36);
        f5028q = Integer.toString(13, 36);
        f5029r = Integer.toString(3, 36);
        f5030s = Integer.toString(4, 36);
        f5031t = Integer.toString(5, 36);
        f5032u = Integer.toString(6, 36);
        f5033v = Integer.toString(11, 36);
        f5034w = Integer.toString(7, 36);
        f5035x = Integer.toString(8, 36);
        Integer.toString(10, 36);
        f5036y = Integer.toString(12, 36);
    }

    public h(k kVar, aa.j0 j0Var, aa.j0 j0Var2, aa.j0 j0Var3, n1 n1Var, p1.s0 s0Var, p1.s0 s0Var2, Bundle bundle, Bundle bundle2, h1 h1Var, MediaSession.Token token) {
        this.f5037a = kVar;
        this.f5043h = j0Var;
        this.i = j0Var2;
        this.f5045k = j0Var3;
        this.f5038b = n1Var;
        this.f5039c = s0Var;
        this.f5040d = s0Var2;
        this.f5041e = bundle;
        this.f = bundle2;
        this.f5042g = h1Var;
        this.f5044j = token;
    }

    public final Bundle a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(f5023l, 1008000300);
        bundle.putBinder(f5024m, this.f5037a.asBinder());
        bundle.putParcelable(f5025n, null);
        aa.j0 j0Var = this.f5043h;
        boolean zIsEmpty = j0Var.isEmpty();
        String str = f5026o;
        if (!zIsEmpty) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(j0Var.size());
            Iterator<E> it = j0Var.iterator();
            if (it.hasNext()) {
                l4.a.t(it.next());
                throw null;
            }
            bundle.putParcelableArrayList(str, arrayList);
        }
        aa.j0 j0Var2 = this.i;
        if (!j0Var2.isEmpty()) {
            if (i >= 7) {
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(j0Var2.size());
                Iterator<E> it2 = j0Var2.iterator();
                if (it2.hasNext()) {
                    l4.a.t(it2.next());
                    throw null;
                }
                bundle.putParcelableArrayList(f5027p, arrayList2);
            } else {
                aa.c1 c1VarA = a.a(j0Var2);
                ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>(c1VarA.f652x);
                aa.h0 h0VarListIterator = c1VarA.listIterator(0);
                if (h0VarListIterator.hasNext()) {
                    l4.a.t(h0VarListIterator.next());
                    throw null;
                }
                bundle.putParcelableArrayList(str, arrayList3);
            }
        }
        aa.j0 j0Var3 = this.f5045k;
        if (!j0Var3.isEmpty()) {
            ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>(j0Var3.size());
            Iterator<E> it3 = j0Var3.iterator();
            if (it3.hasNext()) {
                l4.a.t(it3.next());
                throw null;
            }
            bundle.putParcelableArrayList(f5028q, arrayList4);
        }
        n1 n1Var = this.f5038b;
        n1Var.getClass();
        Bundle bundle2 = new Bundle();
        ArrayList<? extends Parcelable> arrayList5 = new ArrayList<>();
        aa.q1 it4 = n1Var.f5141a.iterator();
        while (it4.hasNext()) {
            m1 m1Var = (m1) it4.next();
            m1Var.getClass();
            Bundle bundle3 = new Bundle();
            bundle3.putInt(m1.f, m1Var.f5134a);
            bundle3.putString(m1.f5132g, m1Var.f5135b);
            bundle3.putBundle(m1.f5133h, m1Var.f5136c);
            arrayList5.add(bundle3);
        }
        bundle2.putParcelableArrayList(n1.f5140b, arrayList5);
        bundle.putBundle(f5029r, bundle2);
        String str2 = f5030s;
        p1.s0 s0Var = this.f5039c;
        bundle.putBundle(str2, s0Var.b());
        String str3 = f5031t;
        p1.s0 s0Var2 = this.f5040d;
        bundle.putBundle(str3, s0Var2.b());
        bundle.putBundle(f5032u, this.f5041e);
        bundle.putBundle(f5033v, this.f);
        bundle.putBundle(f5034w, this.f5042g.e(z7.a.n(s0Var, s0Var2), false, false).f(i));
        bundle.putInt(f5035x, 5);
        MediaSession.Token token = this.f5044j;
        if (token != null) {
            bundle.putParcelable(f5036y, token);
        }
        return bundle;
    }
}
