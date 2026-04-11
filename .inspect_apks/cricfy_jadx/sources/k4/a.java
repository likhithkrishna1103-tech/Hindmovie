package k4;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6903a = 0;

    static {
        y1.a0.I(0);
        y1.a0.I(1);
        y1.a0.I(2);
        y1.a0.I(3);
        y1.a0.I(4);
        y1.a0.I(5);
        y1.a0.I(6);
        y1.a0.I(7);
        y1.a0.I(8);
    }

    public static ua.z0 a(List list) {
        if (list.isEmpty()) {
            ua.g0 g0Var = ua.i0.f12341w;
            return ua.z0.f12413z;
        }
        if (list.size() > 0) {
            list.get(0).getClass();
            throw new ClassCastException();
        }
        ua.f0 f0VarJ = ua.i0.j();
        if (list.size() <= 0) {
            return f0VarJ.g();
        }
        list.get(0).getClass();
        throw new ClassCastException();
    }
}
