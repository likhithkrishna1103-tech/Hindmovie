package g4;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4948a = 0;

    static {
        s1.b0.I(0);
        s1.b0.I(1);
        s1.b0.I(2);
        s1.b0.I(3);
        s1.b0.I(4);
        s1.b0.I(5);
        s1.b0.I(6);
        s1.b0.I(7);
        s1.b0.I(8);
    }

    public static aa.c1 a(List list) {
        if (list.isEmpty()) {
            aa.h0 h0Var = aa.j0.f690v;
            return aa.c1.f650y;
        }
        if (list.size() > 0) {
            list.get(0).getClass();
            throw new ClassCastException();
        }
        aa.g0 g0VarN = aa.j0.n();
        if (list.size() <= 0) {
            return g0VarN.g();
        }
        list.get(0).getClass();
        throw new ClassCastException();
    }
}
