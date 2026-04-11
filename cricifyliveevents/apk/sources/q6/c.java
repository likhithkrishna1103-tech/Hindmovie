package q6;

import android.view.animation.Interpolator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nb.w f10393a = nb.w.I("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa", "rx", "ry");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final nb.w f10394b = nb.w.I("k");

    public static void a(m6.b bVar, g6.i iVar) {
        Float fValueOf = Float.valueOf(0.0f);
        List list = (List) bVar.f307w;
        if (list.isEmpty()) {
            list.add(new t6.a(iVar, fValueOf, fValueOf, (Interpolator) null, 0.0f, Float.valueOf(iVar.f5096m)));
        } else if (((t6.a) list.get(0)).f11932b == null) {
            list.set(0, new t6.a(iVar, fValueOf, fValueOf, (Interpolator) null, 0.0f, Float.valueOf(iVar.f5096m)));
        }
    }

    public static boolean b(m6.b bVar) {
        if (bVar != null) {
            return bVar.Y0() && ((Float) ((t6.a) ((List) bVar.f307w).get(0)).f11932b).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m6.e c(r6.b r27, g6.i r28) {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.c.c(r6.b, g6.i):m6.e");
    }
}
